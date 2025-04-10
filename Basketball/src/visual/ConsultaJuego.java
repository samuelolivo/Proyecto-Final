package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConsultaJuego extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    private JTextField txtId;
    private JTextField txtEquipoCasa;
    private JTextField txtEquipoVisita;
    private JTextField txtMarcadorCasa;
    private JTextField txtMarcadorVisita;
    private JTextField txtGanador;

    /**
     *  
     */
    public static void main(String[] args) {
        try {
            ConsultaJuego dialog = new ConsultaJuego();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  
     */
    public ConsultaJuego() {
        setTitle("Consulta de Juego");
        setBounds(100, 100, 450, 350);  
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

         contentPanel.setLayout(null);

         JLabel lblId = new JLabel("ID:");
        lblId.setBounds(20, 20, 100, 16);
        contentPanel.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(180, 17, 150, 22);
        contentPanel.add(txtId);

         JLabel lblEquipoCasa = new JLabel("Equipo Local:");
        lblEquipoCasa.setBounds(20, 50, 100, 16);
        contentPanel.add(lblEquipoCasa);

        txtEquipoCasa = new JTextField();
        txtEquipoCasa.setBounds(180, 47, 150, 22);
        contentPanel.add(txtEquipoCasa);

         JLabel lblEquipoVisita = new JLabel("Equipo Visitante:");
        lblEquipoVisita.setBounds(20, 80, 100, 16);
        contentPanel.add(lblEquipoVisita);

        txtEquipoVisita = new JTextField();
        txtEquipoVisita.setBounds(180, 77, 150, 22);
        contentPanel.add(txtEquipoVisita);

         JLabel lblMarcadorCasa = new JLabel("Marcador Local:");
        lblMarcadorCasa.setBounds(20, 110, 100, 16);
        contentPanel.add(lblMarcadorCasa);

        txtMarcadorCasa = new JTextField();
        txtMarcadorCasa.setBounds(180, 107, 150, 22);
        contentPanel.add(txtMarcadorCasa);

         JLabel lblMarcadorVisita = new JLabel("Marcador Visitante:");
        lblMarcadorVisita.setBounds(20, 140, 150, 16);
        contentPanel.add(lblMarcadorVisita);

        txtMarcadorVisita = new JTextField();
        txtMarcadorVisita.setBounds(180, 137, 150, 22);
        contentPanel.add(txtMarcadorVisita);

         JLabel lblGanador = new JLabel("Ganador:");
        lblGanador.setBounds(20, 170, 100, 16);
        contentPanel.add(lblGanador);

        txtGanador = new JTextField();
        txtGanador.setBounds(180, 167, 150, 22);
        txtGanador.setEditable(false); // Solo lectura
        contentPanel.add(txtGanador);

         JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

         JButton btnSave = new JButton("Guardar");
        btnSave.addActionListener(e -> guardarDatos());
        buttonPane.add(btnSave);

         JButton btnCancel = new JButton("Cerrar");
        btnCancel.addActionListener(e -> dispose());
        buttonPane.add(btnCancel);
    }

    /**
     *   
     */
    private void guardarDatos() {
        String id = txtId.getText();
        String equipoCasa = txtEquipoCasa.getText();
        String equipoVisita = txtEquipoVisita.getText();
        int marcadorCasa = Integer.parseInt(txtMarcadorCasa.getText());
        int marcadorVisita = Integer.parseInt(txtMarcadorVisita.getText());

         String ganador = "";
        if (marcadorCasa > marcadorVisita) {
            ganador = equipoCasa;
        } else if (marcadorVisita > marcadorCasa) {
            ganador = equipoVisita;
        } else {
            ganador = "Empate";
        }

         txtGanador.setText(ganador);

         System.out.println("Datos guardados:");
        System.out.println("ID: " + id);
        System.out.println("Equipo Local: " + equipoCasa);
        System.out.println("Equipo Visitante: " + equipoVisita);
        System.out.println("Marcador Local: " + marcadorCasa);
        System.out.println("Marcador Visitante: " + marcadorVisita);
        System.out.println("Ganador: " + ganador);
    }
}