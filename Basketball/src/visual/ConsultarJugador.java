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

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import logico.Jugador;
import logico.SerieNacional;

public class ConsultarJugador extends JDialog {
    private final JPanel contentPanel = new JPanel();
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JComboBox<String> cmbxPosicion;
    private JSpinner spnPeso;
    private JSpinner spnAltura;
    private JSpinner spnNumero;
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblPosicion;
    private JLabel lblPeso;
    private JLabel lblAltura;
    private JLabel lblFoto;
    private JPanel panel;
    private JButton cancelButton;
    private File selectedFile = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            ConsultarJugador dialog = new ConsultarJugador(null);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public ConsultarJugador(Jugador aux) {
        if (aux == null)
            setTitle("Consultar Jugador");
        else
            setTitle("Modificar Jugador");
        setBounds(100, 100, 521, 508);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // ID Label and TextField
        lblId = new JLabel("Id:");
        lblId.setBounds(59, 15, 16, 16);
        txtId = new JTextField();
        txtId.setBounds(84, 11, 394, 22);
        txtId.setEditable(false);
        SerieNacional.getInstance();
        txtId.setText("PL-" + SerieNacional.getGeneradorJugador());
        txtId.setColumns(10);

        // Nombre Label and TextField
        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(25, 41, 50, 16);
        txtNombre = new JTextField();
        txtNombre.setBounds(84, 38, 154, 22);
        txtNombre.setColumns(10);

        // Apellido Label and TextField
        lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(250, 41, 50, 16);
        txtApellido = new JTextField();
        txtApellido.setBounds(305, 38, 173, 22);
        txtApellido.setColumns(10);

        // Posición Label and ComboBox
        lblPosicion = new JLabel("Posición:");
        lblPosicion.setBounds(25, 70, 59, 16);
        cmbxPosicion = new JComboBox<String>();
        cmbxPosicion.setBounds(83, 67, 395, 22);

        // Peso Label and Spinner
        lblPeso = new JLabel("Peso(kg):");
        lblPeso.setBounds(21, 97, 59, 16);
        spnPeso = new JSpinner();
        spnPeso.setBounds(83, 94, 66, 22);

        // Altura Label and Spinner
        lblAltura = new JLabel("Altura(cm):");
        lblAltura.setBounds(178, 97, 66, 16);
        spnAltura = new JSpinner();
        spnAltura.setBounds(249, 94, 66, 22);

        // Número Label and Spinner
        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setBounds(346, 97, 66, 16);
        spnNumero = new JSpinner();
        spnNumero.setBounds(403, 94, 75, 22);

        // Foto del jugador Label and Panel
        lblFoto = new JLabel("Foto del jugador:");
        lblFoto.setBounds(23, 127, 99, 16);
        panel = new JPanel();
        panel.setBounds(25, 159, 225, 223);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        panel.setLayout(null);

        // Add components to contentPanel
        contentPanel.setLayout(null);
        contentPanel.add(lblId);
        contentPanel.add(txtId);
        contentPanel.add(lblNombre);
        contentPanel.add(txtNombre);
        contentPanel.add(lblApellido);
        contentPanel.add(txtApellido);
        contentPanel.add(lblPosicion);
        contentPanel.add(cmbxPosicion);
        contentPanel.add(lblPeso);
        contentPanel.add(spnPeso);
        contentPanel.add(lblAltura);
        contentPanel.add(spnAltura);
        contentPanel.add(lblNumero);
        contentPanel.add(spnNumero);
        contentPanel.add(panel);
        JLabel imageDisplayLabel = new JLabel("No hay imagen seleccionada", SwingConstants.CENTER);
        imageDisplayLabel.setBounds(0, 0, 220, 219);
        panel.add(imageDisplayLabel);
        imageDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(lblFoto);

        // Agregar botones para ver listado de lesiones y estadísticas
        JButton btnVerLesiones = new JButton("Ver Listado de Lesiones");
        btnVerLesiones.setBounds(265, 159, 200, 89); // Posición y tamaño del botón
        btnVerLesiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar el listado de lesiones
                System.out.println("Botón 'Ver Listado de Lesiones' presionado.");
            }
        });
        contentPanel.add(btnVerLesiones);

        JButton btnVerEstadisticas = new JButton("Ver Estadísticas");
        btnVerEstadisticas.setBounds(265, 293, 200, 89); // Posición y tamaño del botón
        btnVerEstadisticas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar las estadísticas
                System.out.println("Botón 'Ver Estadísticas' presionado.");
            }
        });
        contentPanel.add(btnVerEstadisticas);

        // Buttons Pane
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        AbstractButton okButton = null;
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

        loadJugador(aux);
    }

    private void loadJugador(Jugador aux) {
        if (aux != null) {
            txtId.setText(aux.getId());
            txtNombre.setText(aux.getNombre());
            txtApellido.setText(aux.getApellido());
            spnPeso.setValue(aux.getPesoKg());
            spnAltura.setValue(aux.getAlturaCm());
            spnNumero.setValue(aux.getNumero());
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
        txtId.setText("PL-" + SerieNacional.getGeneradorJugador());
        txtNombre.setText("");
        txtApellido.setText("");
        spnPeso.setValue(0f);
        spnAltura.setValue(0f);
        spnNumero.setValue(0);
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