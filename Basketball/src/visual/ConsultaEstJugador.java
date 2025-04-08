package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConsultaEstJugador extends JDialog {
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
    private JTextField txtRobos;
    private JTextField txtTapones;
    private JTextField txtAsistencias;
    private JTextField txtFaltas;
    private JTextField txtMVP;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ConsultaEstJugador dialog = new ConsultaEstJugador();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ConsultaEstJugador() {
        setTitle("Consulta Estadísticas del Jugador (Baloncesto)");
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

        JLabel lblRobos = new JLabel("Robos:");
        lblRobos.setBounds(20, 170, 150, 16);
        contentPanel.add(lblRobos);

        txtRobos = new JTextField();
        txtRobos.setBounds(180, 167, 100, 22);
        contentPanel.add(txtRobos);

        JLabel lblTapones = new JLabel("Tapones:");
        lblTapones.setBounds(20, 200, 150, 16);
        contentPanel.add(lblTapones);

        txtTapones = new JTextField();
        txtTapones.setBounds(180, 197, 100, 22);
        contentPanel.add(txtTapones);

        JLabel lblAsistencias = new JLabel("Asistencias:");
        lblAsistencias.setBounds(20, 230, 150, 16);
        contentPanel.add(lblAsistencias);

        txtAsistencias = new JTextField();
        txtAsistencias.setBounds(180, 227, 100, 22);
        contentPanel.add(txtAsistencias);

        JLabel lblFaltas = new JLabel("Faltas:");
        lblFaltas.setBounds(20, 260, 150, 16);
        contentPanel.add(lblFaltas);

        txtFaltas = new JTextField();
        txtFaltas.setBounds(180, 257, 100, 22);
        contentPanel.add(txtFaltas);

        JLabel lblMVP = new JLabel("Veces MVP:");
        lblMVP.setBounds(20, 290, 150, 16);
        contentPanel.add(lblMVP);

        txtMVP = new JTextField();
        txtMVP.setBounds(180, 287, 100, 22);
        contentPanel.add(txtMVP);

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
            System.out.println("Robos: " + txtRobos.getText());
            System.out.println("Tapones: " + txtTapones.getText());
            System.out.println("Asistencias: " + txtAsistencias.getText());
            System.out.println("Faltas: " + txtFaltas.getText());
            System.out.println("Veces MVP: " + txtMVP.getText());
        });
        buttonPane.add(saveButton);

        JButton cancelButton = new JButton("Cerrar");
        cancelButton.addActionListener(e -> dispose());
        buttonPane.add(cancelButton);
    }
}