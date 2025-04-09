package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConsultaEstEquipo extends JDialog {
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
    private JTextField txtJuegosGanados;
    private JTextField txtJuegosPerdidos;
    private JTextField txtTorneosGanados;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ConsultaEstEquipo dialog = new ConsultaEstEquipo();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ConsultaEstEquipo() {
        setTitle("Consulta Estadísticas del Equipo");
        setBounds(100, 100, 450, 450);  
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

         JLabel lblJuegosGanados = new JLabel("Juegos Ganados:");
        lblJuegosGanados.setBounds(20, 170, 150, 16);
        contentPanel.add(lblJuegosGanados);

        txtJuegosGanados = new JTextField();
        txtJuegosGanados.setBounds(180, 167, 100, 22);
        contentPanel.add(txtJuegosGanados);

         JLabel lblJuegosPerdidos = new JLabel("Juegos Perdidos:");
        lblJuegosPerdidos.setBounds(20, 200, 150, 16);
        contentPanel.add(lblJuegosPerdidos);

        txtJuegosPerdidos = new JTextField();
        txtJuegosPerdidos.setBounds(180, 197, 100, 22);
        contentPanel.add(txtJuegosPerdidos);

         JLabel lblTorneosGanados = new JLabel("Torneos Ganados:");
        lblTorneosGanados.setBounds(20, 230, 150, 16);
        contentPanel.add(lblTorneosGanados);

        txtTorneosGanados = new JTextField();
        txtTorneosGanados.setBounds(180, 227, 100, 22);
        contentPanel.add(txtTorneosGanados);

         JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

         JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> {
             System.out.println("Datos guardados:");
            System.out.println("Cantidad de Juegos: " + txtCantJuegos.getText());
            System.out.println("Triples: " + txtTriples.getText());
            System.out.println("Dobles: " + txtDobles.getText());
            System.out.println("Normales: " + txtNormales.getText());
            System.out.println("Puntos Totales: " + txtPuntosTot.getText());
            System.out.println("Juegos Ganados: " + txtJuegosGanados.getText());
            System.out.println("Juegos Perdidos: " + txtJuegosPerdidos.getText());
            System.out.println("Torneos Ganados: " + txtTorneosGanados.getText());
        });
        buttonPane.add(saveButton);

         JButton cancelButton = new JButton("Cerrar");
        cancelButton.addActionListener(e -> dispose());
        buttonPane.add(cancelButton);
    }
}