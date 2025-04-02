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
import java.util.ArrayList;
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

import logico.Juego;
import logico.Jugador;
import logico.Lesion;
import logico.SerieNacional;

public class RegJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEquipoNombre;
	private JPanel photoPanel;
	private JLabel photoLabel;
	private JLabel imageDisplayLabel; // Etiqueta para mostrar la imagen en el panel izquierdo
	private File selectedFile = null;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblPosicion;
	private JComboBox cmbxPosicion;
	private JLabel lblPeso;
	private JSpinner spnPeso;
	private JLabel lblAltura;
	private JSpinner spnAltura;
	private JLabel lblFoto;
	private JPanel panel;
	private JLabel lblEquipo;
	private JButton btnSelJug;
	private JButton selectImageButton; // Botón unificado para seleccionar/cambiar imagen
	private JSpinner spnNumero;
	private JTextField txtIdEquipo;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegJugador dialog = new RegJugador(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegJugador(Jugador aux) {
		if (aux == null)
			setTitle("Registrar Jugador");
		else
			setTitle("Modificar Jugador");
		
		setBounds(100, 100, 508, 508);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblId = new JLabel("Id:");
			lblId.setBounds(59, 15, 16, 16);
		}
		{
			txtId = new JTextField();
			txtId.setBounds(84, 11, 394, 22);
			txtId.setEditable(false);
			txtId.setText("PL-"+SerieNacional.getInstance().getGeneradorJugador());
			txtId.setColumns(10);
		}
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(25, 41, 50, 16);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(84, 38, 154, 22);
			txtNombre.setColumns(10);
		}
		{
			lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(250, 41, 50, 16);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setBounds(305, 38, 173, 22);
			txtApellido.setColumns(10);
		}
		{
			lblPosicion = new JLabel("Posici\u00F3n:");
			lblPosicion.setBounds(25, 70, 59, 16);
		}
		{
			cmbxPosicion = new JComboBox();
			cmbxPosicion.setBounds(83, 67, 395, 22);
		}
		{
			lblPeso = new JLabel("Peso(kg):");
			lblPeso.setBounds(21, 97, 59, 16);
		}
		{
			spnPeso = new JSpinner();
			spnPeso.setBounds(83, 94, 66, 22);
		}
		// Crear el panel para la foto con soporte para drag and drop
		photoPanel = new JPanel();
		photoPanel.setBounds(243, 148, 235, 223);
		photoPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
		
		// Etiqueta para mostrar instrucciones
		photoLabel = new JLabel("Arrastra una imagen aqu\u00ED", SwingConstants.CENTER);
		photoLabel.setBounds(0, 75, 230, 15);
		photoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		photoLabel.setPreferredSize(new Dimension(150, 150));
		photoLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		// Botón unificado para seleccionar/cambiar imagen
		selectImageButton = new JButton("Seleccionar imagen");
		selectImageButton.setBounds(40, 114, 154, 25);
		selectImageButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		selectImageButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectImage();
			}
		});
		{
			lblAltura = new JLabel("Altura(cm):");
			lblAltura.setBounds(178, 97, 66, 16);
		}
		{
			spnAltura = new JSpinner();
			spnAltura.setBounds(249, 94, 66, 22);
		}
		{
			lblFoto = new JLabel("Foto del jugador:");
			lblFoto.setBounds(23, 127, 99, 16);
		}
		{
			// Configurar el panel izquierdo para mostrar la imagen
			panel = new JPanel();
			panel.setBounds(13, 148, 225, 223);
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
			lblEquipo = new JLabel("Equipo:");
			lblEquipo.setBounds(15, 393, 43, 16);
		}
		{
			btnSelJug = new JButton("Seleccionar");
			btnSelJug.setBounds(61, 389, 107, 25);
		}
		{
			txtEquipoNombre = new JTextField();
			txtEquipoNombre.setBounds(304, 390, 173, 22);
			txtEquipoNombre.setEditable(false);
			txtEquipoNombre.setColumns(10);
		}
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
		contentPanel.add(panel);
		contentPanel.add(photoPanel);
		contentPanel.add(lblEquipo);
		contentPanel.add(btnSelJug);
		contentPanel.add(txtEquipoNombre);
		contentPanel.add(lblFoto);
		{
			JLabel lblNumero = new JLabel("N\u00FAmero:");
			lblNumero.setBounds(346, 97, 66, 16);
			contentPanel.add(lblNumero);
		}
		
		spnNumero = new JSpinner();
		spnNumero.setBounds(403, 94, 75, 22);
		contentPanel.add(spnNumero);
		{
			txtIdEquipo = new JTextField();
			txtIdEquipo.setEditable(false);
			txtIdEquipo.setColumns(10);
			txtIdEquipo.setBounds(178, 390, 122, 22);
			contentPanel.add(txtIdEquipo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				if (aux != null)
					okButton.setText("Modificar");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (aux == null)
						{
							String posicion = cmbxPosicion.getSelectedItem() != null ? 
									cmbxPosicion.getSelectedItem().toString() :  "Seleccionar";
							
					                Jugador jug = new Jugador(txtId.getText(), 
					                						  txtNombre.getText(), 
					                						  txtApellido.getText(),
					                						  posicion,
					                						  Float.parseFloat(spnPeso.getValue().toString()), 
					                						  Float.parseFloat(spnAltura.getValue().toString()), 
					                						  Integer.parseInt(spnNumero.getValue().toString()), 
					                						  selectedFile, 
					                						  SerieNacional.getInstance().searchEquipoById(txtIdEquipo.getText(),
					                								  									   SerieNacional.getInstance().getMisEquipos()),
					                						  new ArrayList<Lesion>(),
					                						  new ArrayList<Juego>(),
					                						  true);				
					        SerieNacional.getInstance().guardarJugador(jug);
							clean();
						}
						else
						{
							aux.setNombre(txtNombre.getText());
							aux.setApellido(txtApellido.getText());
							aux.setPosicion(cmbxPosicion.getSelectedItem() != null ? 
									cmbxPosicion.getSelectedItem().toString() :  "Seleccionar");
							aux.setPesoKg(Float.parseFloat(spnPeso.getValue().toString()));
							aux.setAlturaCm(Float.parseFloat(spnAltura.getValue().toString()));
							aux.setNumero(Integer.parseInt(spnNumero.getValue().toString()));
							aux.setFoto(selectedFile);
							aux.setEquipo(SerieNacional.getInstance().searchEquipoById(txtIdEquipo.getText(), 
																					   SerieNacional.getInstance().getMisEquipos()));
							SerieNacional.getInstance().modificarJugador(aux);
						    //Lis.load(null);
						    dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				
				buttonPane.add(cancelButton);
			}
		}
		loadJugador(aux);
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
	
	private void loadJugador(Jugador aux) {
	    if (aux != null) {
	        txtId.setText(aux.getId());
	        txtNombre.setText(aux.getNombre());
	        txtApellido.setText(aux.getApellido());
	        spnPeso.setValue(aux.getPesoKg());
	        spnAltura.setValue(aux.getAlturaCm());
	        spnNumero.setValue(aux.getNumero());
	        selectedFile = aux.getFoto();
	        txtIdEquipo.setText(aux.getEquipo() != null ? aux.getEquipo().getId() : "");
	        txtEquipoNombre.setText(aux.getEquipo() != null ? aux.getEquipo().getNombre() : "");
	        cmbxPosicion.setSelectedItem(aux.getPosicion());
	    }
	}

	private void clean() {
	    txtId.setText("PL-"+SerieNacional.getInstance().getGeneradorJugador());
	    txtNombre.setText("");
	    txtApellido.setText("");
	    spnPeso.setValue(0f);
	    spnAltura.setValue(0f);
	    spnNumero.setValue(0);
	    selectedFile = null;
	    txtIdEquipo.setText("");
	    txtEquipoNombre.setText("");
	    cmbxPosicion.setSelectedItem("Seleccionar");
	}
}