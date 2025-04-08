package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ListadoJuegos extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    private JTable tablaJuegos;
    private DefaultTableModel modeloTabla;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ListadoJuegos dialog = new ListadoJuegos();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ListadoJuegos() {
        setTitle("Listado de Juegos");
        setBounds(100, 100, 800, 500);  
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

         contentPanel.setLayout(new BorderLayout());

         String[] columnas = {"ID", "Equipo de Casa", "Equipo de Visita", "Fecha del Juego", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);

         tablaJuegos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaJuegos);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

         JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

         JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();    
            }
        });
        
        JButton btnGenerar = new JButton("Generar");
        btnGenerar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        buttonPane.add(btnGenerar);
        buttonPane.add(btnVolver);
    }
