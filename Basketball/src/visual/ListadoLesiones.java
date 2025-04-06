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

import logico.Jugador;
import logico.Lesion;
import logico.SerieNacional;

public class ListadoLesiones extends JFrame {
   
    private static final long serialVersionUID = 1L;
    private JTable table;
    private static DefaultTableModel model;
    private static Object[] row;
    private Lesion lesionSeleccionada = null;
    private JTextField searchField;
    private JButton volverBtn;
    private JButton modificarBtn;
    private JButton registrarBtn;
    private JPanel mainPanel;
    private JPanel searchPanel;
    private JScrollPane scrollPane;

    public ListadoLesiones(Jugador aux) {
        setResizable(false);
        setAlwaysOnTop(true);
        setTitle("Listado de Lesiones");
        setSize(800, 500);
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
                    lesionSeleccionada = null;
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
        
        String[] columnNames = {"ID Lesión", "ID Jugador", "Tipo Lesión", "Fecha Lesión", "Fecha Recuperación", "Estado"};
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
                    String lesionId = table.getValueAt(index, 0).toString();
                    lesionSeleccionada = SerieNacional.getInstance().searchLesionById(lesionId, SerieNacional.getInstance().getMisJugadores());
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
                lesionSeleccionada = null;
                if (aux != null)
                {   
                	RegLesion regLesion = new RegLesion(aux, null);
		            regLesion.setVisible(true);
		            regLesion.setModal(true); 
                }
            }
        });
        
        if (aux == null)
        	registrarBtn.setVisible(false);
        else
        	registrarBtn.setVisible(true);
        
        modificarBtn = new JButton("Modificar");
        modificarBtn.setEnabled(false);
        modificarBtn.setFont(boldFont);
        modificarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lesionSeleccionada != null) {
                    RegLesion regLesion = new RegLesion(lesionSeleccionada.getJugador(), lesionSeleccionada);
                    regLesion.setVisible(true);
                    regLesion.setModal(true);
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

    public static void loadAll(Jugador aux, String filtro) {
        model.setRowCount(0);
        row = new Object[model.getColumnCount()];
        if (aux != null)
        {        
	        for(Lesion lesion : aux.getMisLesiones()) {
	            if(filtro == null) {
	                row[0] = lesion.getId();
	                row[1] = (lesion.getJugador() != null ? lesion.getJugador().getId() : "null");
	                row[2] = lesion.getTipoDeLesion();
	                row[3] = lesion.getFechaLes().toString();
	                row[4] = lesion.getFechaRecPrevista().toString();
	                row[5] = lesion.isEstado() ? "Activa" : "Recuperado";
	                model.addRow(row);
	            } else {
	                if(lesion.getId().toLowerCase().contains(filtro.toLowerCase()) ||
	                   (lesion.getJugador() != null && lesion.getJugador().getId().toLowerCase().contains(filtro.toLowerCase())) ||
	                   lesion.getTipoDeLesion().toLowerCase().contains(filtro.toLowerCase()) ||
	                   lesion.getFechaLes().toString().contains(filtro) ||
	                   lesion.getFechaRecPrevista().toString().contains(filtro)) {
	                    
	                    row[0] = lesion.getId();
	                    row[1] = (lesion.getJugador() != null ? lesion.getJugador().getId() : "null");
	                    row[2] = lesion.getTipoDeLesion();
	                    row[3] = lesion.getFechaLes().toString();
	                    row[4] = lesion.getFechaRecPrevista().toString();
	                    row[5] = lesion.isEstado() ? "Activa" : "Recuperado";
	                    model.addRow(row);
	                }
	            }
	        }
        }
        else
        {
	        for (Jugador jugador: SerieNacional.getInstance().getMisJugadores())
	        {
        		for(Lesion lesion : jugador.getMisLesiones()) {
		            if(filtro == null) {
		                row[0] = lesion.getId();
		                row[1] = (lesion.getJugador() != null ? lesion.getJugador().getId() : "null");
		                row[2] = lesion.getTipoDeLesion();
		                row[3] = lesion.getFechaLes().toString();
		                row[4] = lesion.getFechaRecPrevista().toString();
		                row[5] = lesion.isEstado() ? "Activa" : "Recuperado";
		                model.addRow(row);
		            } else {
		                if(lesion.getId().toLowerCase().contains(filtro.toLowerCase()) ||
		                   (lesion.getJugador() != null && lesion.getJugador().getId().toLowerCase().contains(filtro.toLowerCase())) ||
		                   lesion.getTipoDeLesion().toLowerCase().contains(filtro.toLowerCase()) ||
		                   lesion.getFechaLes().toString().contains(filtro) ||
		                   lesion.getFechaRecPrevista().toString().contains(filtro)) {
		                    
		                    row[0] = lesion.getId();
		                    row[1] = (lesion.getJugador() != null ? lesion.getJugador().getId() : "null");
		                    row[2] = lesion.getTipoDeLesion();
		                    row[3] = lesion.getFechaLes().toString();
		                    row[4] = lesion.getFechaRecPrevista().toString();
		                    row[5] = lesion.isEstado() ? "Activa" : "Recuperado";
		                    model.addRow(row);
		                }
		            }
		        }
	        }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListadoLesiones(null).setVisible(true);
        });
    }
}