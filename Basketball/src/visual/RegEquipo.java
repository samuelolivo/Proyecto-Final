package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class RegEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField textField_1;
	private JPanel photoPanel;
	private JLabel photoLabel;
	private JLabel imageDisplayLabel; // Etiqueta para mostrar la imagen en el panel izquierdo
	private File selectedFile = null;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblPosicion;
	private JComboBox comboBox;
	private JLabel lblFoto;
	private JPanel panel;
	private JButton selectImageButton; // Botón unificado para seleccionar/cambiar imagen
	private JSpinner spinner_2;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEquipo dialog = new RegEquipo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEquipo() {
		setTitle("Registrar Equipo");
		setBounds(100, 100, 507, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblId = new JLabel("Id:");
			lblId.setBounds(66, 17, 16, 16);
		}
		{
			txtId = new JTextField();
			txtId.setBounds(88, 13, 388, 22);
			txtId.setEditable(false);
			txtId.setText("EQ-");
			txtId.setColumns(10);
		}
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(31, 43, 50, 16);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(89, 40, 178, 22);
			textField_1.setColumns(10);
		}
		{
			lblApellido = new JLabel("A\u00F1o de fundaci\u00F3n:");
			lblApellido.setBounds(277, 42, 105, 16);
		}
		{
			lblPosicion = new JLabel("Ciudad:");
			lblPosicion.setBounds(38, 69, 46, 16);
		}
		{
			comboBox = new JComboBox();
			comboBox.setBounds(89, 66, 387, 22);
		}
		// Crear el panel para la foto con soporte para drag and drop
		photoPanel = new JPanel();
		photoPanel.setBounds(241, 141, 235, 223);
		photoPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
		
		// Etiqueta para mostrar instrucciones
		photoLabel = new JLabel("Arrastra una imagen aqu\u00ED", SwingConstants.CENTER);
		photoLabel.setBounds(0, 75, 230, 15);
		photoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		photoLabel.setPreferredSize(new Dimension(150, 150));
		photoLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		// Botón unificado para seleccionar/cambiar imagen
		selectImageButton = new JButton("Seleccionar imagen");
		selectImageButton.setBounds(39, 116, 157, 25);
		selectImageButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		selectImageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectImage();
			}
		});
		{
			lblFoto = new JLabel("Foto del emblema:");
			lblFoto.setBounds(21, 120, 113, 16);
		}
		{
			// Configurar el panel izquierdo para mostrar la imagen
			panel = new JPanel();
			panel.setBounds(11, 141, 225, 223);
			panel.setBackground(Color.WHITE);
			panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
			panel.setLayout(null);
			
			// Etiqueta para mostrar la imagen en el panel izquierdo
			imageDisplayLabel = new JLabel("No hay imagen seleccionada", SwingConstants.CENTER);
			imageDisplayLabel.setBounds(10, 10, 205, 203);
			imageDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(imageDisplayLabel);
		}
		photoPanel.setLayout(null);
		
		// Añadir componentes al panel de arrastrar y soltar
		photoPanel.add(photoLabel);
		photoPanel.add(selectImageButton);
		
		// Configurar el Drag and Drop
		new DropTarget(photoPanel, new DropTargetAdapter() {
			@Override
			public void drop(DropTargetDropEvent dtde) {
				try {
					dtde.acceptDrop(dtde.getDropAction());
					@SuppressWarnings("unchecked")
					List<File> files = (List<File>) dtde.getTransferable()
							.getTransferData(java.awt.datatransfer.DataFlavor.javaFileListFlavor);
					
					if (!files.isEmpty()) {
						File file = files.get(0);
						if (isImageFile(file)) {
							selectedFile = file;
							displayImage(file);
							// Actualizar el texto del botón
							updateButtonText();
						}
					}
					dtde.dropComplete(true);
				} catch (Exception e) {
					e.printStackTrace();
					dtde.dropComplete(false);
				}
			}
		});
		
		JLabel lblOHazClic = new JLabel("o haz clic para seleccionar...", SwingConstants.CENTER);
		lblOHazClic.setPreferredSize(new Dimension(150, 150));
		lblOHazClic.setFont(new Font("Arial", Font.PLAIN, 12));
		lblOHazClic.setAlignmentX(0.5f);
		lblOHazClic.setBounds(0, 88, 230, 15);
		photoPanel.add(lblOHazClic);
		{
			spinner_2 = new JSpinner();
			spinner_2.setBounds(386, 40, 90, 22);
		}
		
		textField = new JTextField();
		textField.setBounds(90, 92, 153, 22);
		textField.setColumns(10);
		
		JLabel lblEntrenador = new JLabel("Entrenador:");
		lblEntrenador.setBounds(14, 95, 68, 16);
		
		JLabel lblDueo = new JLabel("Due\u00F1o:");
		lblDueo.setBounds(259, 95, 50, 16);
		
		textField_2 = new JTextField();
		textField_2.setBounds(305, 92, 171, 22);
		textField_2.setColumns(10);
		contentPanel.setLayout(null);
		contentPanel.add(lblId);
		contentPanel.add(txtId);
		contentPanel.add(lblNombre);
		contentPanel.add(textField_1);
		contentPanel.add(lblApellido);
		contentPanel.add(lblPosicion);
		contentPanel.add(comboBox);
		contentPanel.add(panel);
		contentPanel.add(photoPanel);
		contentPanel.add(lblFoto);
		contentPanel.add(spinner_2);
		contentPanel.add(textField);
		contentPanel.add(lblEntrenador);
		contentPanel.add(lblDueo);
		contentPanel.add(textField_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	/**
	 * Actualiza el texto del botón según si hay imagen seleccionada o no
	 */
	private void updateButtonText() {
		if (selectedFile != null) {
			selectImageButton.setText("Cambiar imagen");
		} else {
			selectImageButton.setText("Seleccionar imagen");
		}
	}
	
	/**
	 * Muestra un diálogo para seleccionar una imagen
	 */
	private void selectImage() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Seleccionar imagen");
		
		// Filtro para archivos de imagen
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Archivos de imagen", "jpg", "jpeg", "png", "gif", "bmp");
		fileChooser.setFileFilter(filter);
		
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			displayImage(selectedFile);
			// Actualizar el texto del botón
			updateButtonText();
		}
	}
	
	/**
	 * Muestra la imagen seleccionada en el panel izquierdo
	 */
	private void displayImage(File file) {
		try {
			ImageIcon icon = new ImageIcon(file.getPath());
			
			// Redimensionar si es necesario para ajustar al panel
			if (icon.getIconWidth() > 200 || icon.getIconHeight() > 200) {
				Image img = icon.getImage();
				Image scaledImg = img.getScaledInstance(200, -1, Image.SCALE_SMOOTH);
				icon = new ImageIcon(scaledImg);
			}
			
			// Mostrar la imagen en el panel izquierdo
			imageDisplayLabel.setIcon(icon);
			imageDisplayLabel.setText(""); // Eliminar el texto
			
			// Mantener el panel derecho como área de arrastrar y soltar
			photoLabel.setIcon(null);
			photoLabel.setText("Arrastra una imagen aquí");
		} catch (Exception e) {
			e.printStackTrace();
			imageDisplayLabel.setIcon(null);
			imageDisplayLabel.setText("Error al cargar la imagen");
		}
	}
	
	/**
	 * Verifica si el archivo es una imagen
	 */
	private boolean isImageFile(File file) {
		String name = file.getName().toLowerCase();
		return name.endsWith(".jpg") || name.endsWith(".jpeg") || 
			   name.endsWith(".png") || name.endsWith(".gif") || 
			   name.endsWith(".bmp");
	}
}
