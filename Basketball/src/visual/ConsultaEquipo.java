 package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import logico.Equipo;
import logico.Jugador;
import logico.SerieNacional;

public class ConsultaEquipo extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtEntrenador; // Nuevo campo para el entrenador
    private JTextField txtDueno;    // Nuevo campo para el dueño
    private JComboBox<String> cmbxCiudad; // Nuevo campo para la ciudad
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblAnoFund;
    private JLabel ldlCiudad;
    private JLabel lblEntrenador;
    private JLabel lblDueno;
    private JLabel lblFoto;
    private JPanel panel;
    private JButton cancelButton;
    private File selectedFile = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ConsultaEquipo dialog = new ConsultaEquipo(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ConsultaEquipo(Equipo aux) {
        if (aux == null)
            setTitle("Consultar Equipo");
        else
            setTitle("Modificar Equipo");
        setBounds(100, 100, 508, 508);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // ID Label and TextField
        lblId = new JLabel("Id:");
        lblId.setBounds(66, 17, 16, 16);
        txtId = new JTextField();
        txtId.setBounds(88, 13, 388, 22);
        txtId.setEditable(false);
        SerieNacional.getInstance();
        txtId.setText("EQ-" + SerieNacional.getGeneradorEquipo());
        txtId.setColumns(10);

        // Nombre Label and TextField
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(31, 43, 50, 16);
        txtNombre = new JTextField();
        txtNombre.setBounds(89, 40, 178, 22);
        txtNombre.setColumns(10);

        // Año de Fundación Label and Spinner
        lblAnoFund = new JLabel("Año de fundación:");
        lblAnoFund.setBounds(277, 42, 105, 16);
        JSpinner spnAnoFund = new JSpinner();
        spnAnoFund.setModel(new SpinnerNumberModel(new Integer(2000), null, null, new Integer(1)));
        spnAnoFund.setBounds(578, 40, 90, 22);

        // Ciudad Label and ComboBox
        ldlCiudad = new JLabel("Ciudad:");
        ldlCiudad.setBounds(38, 69, 46, 16);
        cmbxCiudad = new JComboBox<>();
        cmbxCiudad.setBounds(89, 66, 387, 22);

        // Entrenador Label and TextField
        lblEntrenador = new JLabel("Entrenador:");
        lblEntrenador.setBounds(14, 95, 68, 16);
        txtEntrenador = new JTextField();
        txtEntrenador.setBounds(90, 92, 153, 22);
        txtEntrenador.setColumns(10);

        // Dueño Label and TextField
        lblDueno = new JLabel("Dueño:");
        lblDueno.setBounds(259, 95, 50, 16);
        txtDueno = new JTextField();
        txtDueno.setBounds(305, 92, 171, 22);
        txtDueno.setColumns(10);

        // Foto del emblema Label and Panel
        lblFoto = new JLabel("Foto del emblema:");
        lblFoto.setBounds(21, 120, 113, 16);
        panel = new JPanel();
        panel.setBounds(11, 141, 225, 223);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        panel.setLayout(null);
        JLabel imageDisplayLabel = new JLabel("No hay imagen seleccionada", SwingConstants.CENTER);
        imageDisplayLabel.setBounds(10, 10, 205, 203);
        imageDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imageDisplayLabel);

        // Add components to contentPanel
        contentPanel.setLayout(null);
        contentPanel.add(lblId);
        contentPanel.add(txtId);
        contentPanel.add(lblNombre);
        contentPanel.add(txtNombre);
        contentPanel.add(lblAnoFund);
        contentPanel.add(spnAnoFund);
        contentPanel.add(ldlCiudad);
        contentPanel.add(cmbxCiudad);
        contentPanel.add(lblEntrenador);
        contentPanel.add(txtEntrenador);
        contentPanel.add(lblDueno);
        contentPanel.add(txtDueno);
        contentPanel.add(panel);
        contentPanel.add(lblFoto);

        // Buttons Pane
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        if (aux != null)
            okButton.setText("Modificar");

        // Cancelar Button
        cancelButton = new JButton("Volver");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);

        loadEquipo(aux);
    }

    private void loadEquipo(Equipo aux) {
        if (aux != null) {
            txtId.setText(aux.getId());
            txtNombre.setText(aux.getNombre());
            txtEntrenador.setText(aux.getEntrenador());
            txtDueno.setText(aux.getDueno());
            cmbxCiudad.setSelectedItem(aux.getCiudad());
            JSpinner spnAnoFund = null;
			spnAnoFund.setValue(aux.getAnoFundacion());
            selectedFile = aux.getFoto();
            if (selectedFile != null) {
                displayImage(selectedFile);
            } else {
                panel.removeAll();
                JLabel imageDisplayLabel = new JLabel("No hay imagen seleccionada", SwingConstants.CENTER);
                imageDisplayLabel.setBounds(10, 10, 205, 203);
                imageDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(imageDisplayLabel);
            }
        }
    }

    private void clean() {
        SerieNacional.getInstance();
        txtId.setText("EQ-" + SerieNacional.getGeneradorEquipo());
        txtNombre.setText("");
        txtEntrenador.setText("");
        txtDueno.setText("");
        cmbxCiudad.setSelectedItem("Seleccionar");
        JSpinner spnAnoFund = null;
		spnAnoFund.setValue(2000);
        selectedFile = null;
        panel.removeAll();
        JLabel imageDisplayLabel = new JLabel("No hay imagen seleccionada", SwingConstants.CENTER);
        imageDisplayLabel.setBounds(10, 10, 205, 203);
        imageDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imageDisplayLabel);
    }

    private void displayImage(File file) {
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            if (icon.getIconWidth() > 200 || icon.getIconHeight() > 200) {
                Image img = icon.getImage();
                Image scaledImg = img.getScaledInstance(200, -1, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImg);
            }
            panel.removeAll();
            JLabel imageDisplayLabel = new JLabel(icon);
            imageDisplayLabel.setBounds(10, 10, 205, 203);
            panel.add(imageDisplayLabel);
        } catch (Exception e) {
            e.printStackTrace();
            panel.removeAll();
            JLabel imageDisplayLabel = new JLabel("Error al cargar la imagen", SwingConstants.CENTER);
            imageDisplayLabel.setBounds(10, 10, 205, 203);
            panel.add(imageDisplayLabel);
        }
    }
}