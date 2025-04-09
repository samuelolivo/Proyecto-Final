package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConsultaEstadistica extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    private JTextField txtCantJuegos;
    private JTextField txtTriples;
    private JTextField txtDobles;
    private JTextField txtNormales;
    private JTextField txtPuntosTot;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ConsultaEstadistica dialog = new ConsultaEstadistica();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ConsultaEstadistica() {
        setTitle("Consulta Estadísticas");
        setBounds(100, 100, 450, 350);  
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

         contentPanel.setLayout(null);

         JLabel lblCantJuegos = new JLabel("Cantidad de Juegos:");
        lblCantJuegos.setBounds(20, 20, 150, 16);
        contentPanel.add(lblCantJuegos);

        txtCantJuegos = new JTextField();
        txtCantJuegos.setBounds(180, 17, 100, 22);
        contentPanel.add(txtCantJuegos);

         JLabel lblTriples = new JLabel("Triples:");
        lblTriples.setBounds(20, 50, 150, 16);
        contentPanel.add(lblTriples);

        txtTriples = new JTextField();
        txtTriples.setBounds(180, 47, 100, 22);
        contentPanel.add(txtTriples);

         JLabel lblDobles = new JLabel("Dobles:");
        lblDobles.setBounds(20, 80, 150, 16);
        contentPanel.add(lblDobles);

        txtDobles = new JTextField();
        txtDobles.setBounds(180, 77, 100, 22);
        contentPanel.add(txtDobles);

         JLabel lblNormales = new JLabel("Normales:");
        lblNormales.setBounds(20, 110, 150, 16);
        contentPanel.add(lblNormales);

        txtNormales = new JTextField();
        txtNormales.setBounds(180, 107, 100, 22);
        contentPanel.add(txtNormales);

         JLabel lblPuntosTot = new JLabel("Puntos Totales:");
        lblPuntosTot.setBounds(20, 140, 150, 16);
        contentPanel.add(lblPuntosTot);

        txtPuntosTot = new JTextField();
        txtPuntosTot.setBounds(180, 137, 100, 22);
        contentPanel.add(txtPuntosTot);

         JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

         JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> guardarDatos());
        buttonPane.add(saveButton);

         JButton cancelButton = new JButton("Cerrar");
        cancelButton.addActionListener(e -> dispose());
        buttonPane.add(cancelButton);
    }

    /**
     * Método para guardar los datos ingresados.
     */
    private void guardarDatos() {
         System.out.println("Datos guardados:");
        System.out.println("Cantidad de Juegos: " + txtCantJuegos.getText());
        System.out.println("Triples: " + txtTriples.getText());
        System.out.println("Dobles: " + txtDobles.getText());
        System.out.println("Normales: " + txtNormales.getText());
        System.out.println("Puntos Totales: " + txtPuntosTot.getText());
    }
}