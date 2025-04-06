package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import logico.Equipo;
import logico.Jugador;
import logico.SerieNacional;

public class ListadoJugadores extends JFrame {
   
    private static final long serialVersionUID = 1L;
    private JTable table;
    private static DefaultTableModel model;
    private static Object[] row;
    private Jugador jugadorSeleccionado = null;
    private JTextField searchField;
    private JButton volverBtn;
    private JButton modificarBtn;
    private JButton registrarBtn;
    private JPanel mainPanel;
    private JPanel searchPanel;
    private JScrollPane scrollPane;

    public ListadoJugadores(Equipo aux) {
        setResizable(false);
        setAlwaysOnTop(true);
        setTitle("Listado de Jugadores");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        searchPanel = new JPanel(new BorderLayout());
        searchField = new JTextField("Buscar...");
        searchField.setPreferredSize(new Dimension(200, 30));
        searchField.setEnabled(false);
        
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarTabla();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarTabla();
            }
            
            private void filtrarTabla() {
                String text = searchField.getText();
                if(text.equals("Buscar...") || text.isEmpty()) {
                    loadAll(aux, null);
                } else {
                    loadAll(aux, text);
                }
            }
        });

        searchField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent arg0) {
                if (searchField.getText().equals("Buscar...")) {
                    searchField.setEnabled(true);
                    searchField.setText("");
                    modificarBtn.setEnabled(false);
                    jugadorSeleccionado = null;
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (searchField.getText().equals("")) {
                    searchField.setEnabled(false);
                    searchField.setText("Buscar...");
                }
            }
        });
        
        searchPanel.add(new JLabel("Barra de búsqueda:   "), BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        
        String[] columnNames = {"Equipo", "Id", "Jugador", "Posición", "Número", "Estado de salud"};
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.setColumnIdentifiers(columnNames);
        
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = table.getSelectedRow();
                if(index != -1) {
                    String jugadorId = table.getValueAt(index, 1).toString();
                    jugadorSeleccionado = SerieNacional.getInstance().searchJugadorById(jugadorId, SerieNacional.getInstance().getMisJugadores());
                    modificarBtn.setEnabled(true);
                }
            }
        });
        
        scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
         
        JLabel label = new JLabel("");
        buttonPanel.add(label);

        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        Font boldFont = new Font("Tahoma", Font.BOLD, 13);
        
        registrarBtn = new JButton("Registrar");
        registrarBtn.setFont(boldFont);
        registrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarBtn.setEnabled(false);
                jugadorSeleccionado = null;
                RegJugador regJugador = new RegJugador(null);
                loadAll(aux, null);
                regJugador.setVisible(true);
                regJugador.setModal(true);                
            }
        });
        
        modificarBtn = new JButton("Modificar");
        modificarBtn.setEnabled(false);
        modificarBtn.setFont(boldFont);
        modificarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jugadorSeleccionado != null) {
                    RegJugador regJugador = new RegJugador(jugadorSeleccionado);
                    regJugador.setVisible(true);
                    regJugador.setModal(true);
                    loadAll(aux, null);
                }
            }
        });
        
        JButton consultarBtn = new JButton("Consultar");
        consultarBtn.setFont(boldFont);
        consultarBtn.setEnabled(false);
        buttonPanel.add(consultarBtn);
        buttonPanel.add(modificarBtn);
        buttonPanel.add(registrarBtn);
        
        volverBtn = new JButton("Volver");
        volverBtn.setFont(boldFont);
        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  
            }
        });
        buttonPanel.add(volverBtn);
        getContentPane().add(mainPanel);
        
        loadAll(aux, null);
    }

    public static void loadAll(Equipo aux, String filtro) {
        model.setRowCount(0);
        row = new Object[model.getColumnCount()];
        ArrayList<Jugador> jugadores;
        if (aux == null)
        	jugadores = SerieNacional.getInstance().getMisJugadores();
        else
        	jugadores = aux.getJugadores();
        
        for(Jugador jugador : jugadores) {
            if(filtro == null) {
                row[0] = (jugador.getEquipo() != null ? jugador.getEquipo().getNombre() : "null");
                row[1] = jugador.getId();
                row[2] = jugador.getNombre() + " " + jugador.getApellido();
                row[3] = jugador.getPosicion();
                row[4] = jugador.getNumero();
                row[5] = jugador.getEstadoSalud() ? "Activo" : "Lesionado";
                model.addRow(row);
            } else {
                if(jugador.getId().toLowerCase().contains(filtro.toLowerCase()) ||
                   jugador.getNombre().toLowerCase().contains(filtro.toLowerCase()) ||
                   jugador.getApellido().toLowerCase().contains(filtro.toLowerCase()) ||
                   jugador.getPosicion().toLowerCase().contains(filtro.toLowerCase()) ||
                   jugador.getEquipo().getNombre().toLowerCase().contains(filtro.toLowerCase())) {
                    
                    row[0] = (jugador.getEquipo() != null ? jugador.getEquipo().getNombre() : "null");
                    row[1] = jugador.getId();
                    row[2] = jugador.getNombre() + " " + jugador.getApellido();
                    row[3] = jugador.getPosicion();
                    row[4] = jugador.getNumero();
                    row[5] = jugador.getEstadoSalud() ? "Activo" : "Lesionado";
                    model.addRow(row);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListadoJugadores(null).setVisible(true);
        });
    }
}