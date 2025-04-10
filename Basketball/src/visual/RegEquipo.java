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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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

import logico.Equipo;
import logico.Juego;
import logico.Jugador;
import logico.SerieNacional;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class RegEquipo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtNombre;
	private JPanel photoPanel;
	private JLabel photoLabel;
	private JLabel imageDisplayLabel;
	private File selectedFile = null;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblAnoFund;
	private JLabel ldlPais;
	private JComboBox<String> cmbxPais;
	private JLabel lblFoto;
	private JPanel panel;
	private JButton selectImageButton;
	private JSpinner spnAnoFund;
	private JTextField txtEntrenador;
	private JTextField txtDueno;
	private JLabel lblEntrenador;
	private JLabel lblDueno;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEquipo dialog = new RegEquipo(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEquipo(Equipo aux) {
		setResizable(false);
		setModal(true);
		setTitle("Registrar Equipo");
		setBounds(100, 100, 504, 460);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblId = new JLabel("Id:");
			lblId.setBounds(66, 17, 16, 16);
		}
		{
			txtId = new JTextField();
			txtId.setBounds(88, 13, 388, 22);
			txtId.setEditable(false);
			txtId.setText("EQ-"+SerieNacional.getInstance().getGeneradorEquipo());
			txtId.setColumns(10);
		}
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(31, 43, 50, 16);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(89, 40, 178, 22);
			txtNombre.setColumns(10);
		}
		{
			lblAnoFund = new JLabel("A\u00F1o de fundaci\u00F3n:");
			lblAnoFund.setBounds(277, 42, 105, 16);
		}
		{
			ldlPais = new JLabel("Pa\u00EDs:");
			ldlPais.setBounds(56, 69, 28, 16);
		}
		{
			cmbxPais = new JComboBox();
			cmbxPais.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Afganist\u00E1n", "Albania", "Alemania", "Andorra", "Angola", "Antigua y Barbuda", "Arabia Saudita", "Argelia", "Argentina", "Armenia", "Australia", "Austria", "Azerbaiy\u00E1n", "Bahamas", "Banglad\u00E9s", "Barbados", "Bar\u00E9in", "B\u00E9lgica", "Belice", "Ben\u00EDn", "Bielorrusia", "Birmania", "Bolivia", "Bosnia y Herzegovina", "Botsuana", "Brasil", "Brun\u00E9i", "Bulgaria", "Burkina Faso", "Burundi", "But\u00E1n", "Cabo Verde", "Camboya", "Camer\u00FAn", "Canad\u00E1", "Catar", "Chad", "Chile", "China", "Chipre", "Colombia", "Comoras", "Corea del Norte", "Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dinamarca", "Dominica", "Ecuador", "Egipto", "El Salvador", "Emiratos \u00C1rabes Unidos", "Eritrea", "Eslovaquia", "Eslovenia", "Espa\u00F1a", "Estados Unidos", "Estonia", "Esuatini", "Etiop\u00EDa", "Filipinas", "Finlandia", "Fiyi", "Francia", "Gab\u00F3n", "Gambia", "Georgia", "Ghana", "Granada", "Grecia", "Guatemala", "Guinea", "Guinea-Bis\u00E1u", "Guinea Ecuatorial", "Guyana", "Hait\u00ED", "Honduras", "Hungr\u00EDa", "India", "Indonesia", "Irak", "Ir\u00E1n", "Irlanda", "Islandia", "Islas Marshall", "Islas Salom\u00F3n", "Israel", "Italia", "Jamaica", "Jap\u00F3n", "Jordania", "Kazajist\u00E1n", "Kenia", "Kirguist\u00E1n", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "L\u00EDbano", "Liberia", "Libia", "Liechtenstein", "Lituania", "Luxemburgo", "Macedonia del Norte", "Madagascar", "Malasia", "Malaui", "Maldivas", "Mal\u00ED", "Malta", "Marruecos", "Mauricio", "Mauritania", "M\u00E9xico", "Micronesia", "Moldavia", "M\u00F3naco", "Mongolia", "Montenegro", "Mozambique", "Namibia", "Nauru", "Nepal", "Nicaragua", "N\u00EDger", "Nigeria", "Noruega", "Nueva Zelanda", "Om\u00E1n", "Pa\u00EDses Bajos", "Pakist\u00E1n", "Palaos", "Palestina", "Panam\u00E1", "Pap\u00FAa Nueva Guinea", "Paraguay", "Per\u00FA", "Polonia", "Portugal", "Reino Unido", "Rep\u00FAblica Centroafricana", "Rep\u00FAblica Checa", "Rep\u00FAblica del Congo", "Rep\u00FAblica Democr\u00E1tica del Congo", "Rep\u00FAblica Dominicana", "Ruanda", "Rumania", "Rusia", "Samoa", "San Crist\u00F3bal y Nieves", "San Marino", "San Vicente y las Granadinas", "Santa Luc\u00EDa", "Santo Tom\u00E9 y Pr\u00EDncipe", "Senegal", "Serbia", "Seychelles", "Sierra Leona", "Singapur", "Siria", "Somalia", "Sri Lanka", "Sud\u00E1frica", "Sud\u00E1n", "Sud\u00E1n del Sur", "Suecia", "Suiza", "Surinam", "Tailandia", "Tanzania", "Tayikist\u00E1n", "Timor Oriental", "Togo", "Tonga", "Trinidad y Tobago", "T\u00FAnez", "Turkmenist\u00E1n", "Turqu\u00EDa", "Tuvalu", "Ucrania", "Uganda", "Uruguay", "Uzbekist\u00E1n", "Vanuatu", "Vaticano", "Venezuela", "Vietnam", "Yemen", "Yibuti", "Zambia", "Zimbabue"}));
			cmbxPais.setBounds(89, 66, 387, 22);
		}

		photoPanel = new JPanel();
		photoPanel.setBounds(241, 141, 235, 223);
		photoPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
		
		photoLabel = new JLabel("Arrastra una imagen aqu\u00ED", SwingConstants.CENTER);
		photoLabel.setBounds(0, 75, 230, 15);
		photoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		photoLabel.setPreferredSize(new Dimension(150, 150));
		photoLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		selectImageButton = new JButton("Seleccionar imagen");
		selectImageButton.setFont(new Font("Tahoma", Font.ITALIC, 13));
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
			panel = new JPanel();
			panel.setBounds(11, 141, 225, 223);
			panel.setBackground(Color.WHITE);
			panel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
			panel.setLayout(null);
			
			imageDisplayLabel = new JLabel("No hay imagen seleccionada", SwingConstants.CENTER);
			imageDisplayLabel.setBounds(10, 10, 205, 203);
			imageDisplayLabel.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(imageDisplayLabel);
		}
		photoPanel.setLayout(null);

		photoPanel.add(photoLabel);
		photoPanel.add(selectImageButton);
		
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
			spnAnoFund = new JSpinner();
			spnAnoFund.setModel(new SpinnerNumberModel(new Integer(2000), null, null, new Integer(1)));
			spnAnoFund.setBounds(386, 40, 90, 22);
		}
		
		txtEntrenador = new JTextField();
		txtEntrenador.setBounds(90, 92, 153, 22);
		txtEntrenador.setColumns(10);
		
		lblEntrenador = new JLabel("Entrenador:");
		lblEntrenador.setBounds(14, 95, 68, 16);
		
		lblDueno = new JLabel("Due\u00F1o:");
		lblDueno.setBounds(259, 95, 50, 16);
		
		txtDueno = new JTextField();
		txtDueno.setBounds(305, 92, 171, 22);
		txtDueno.setColumns(10);
		contentPanel.setLayout(null);
		contentPanel.add(lblId);
		contentPanel.add(txtId);
		contentPanel.add(lblNombre);
		contentPanel.add(txtNombre);
		contentPanel.add(lblAnoFund);
		contentPanel.add(ldlPais);
		contentPanel.add(cmbxPais);
		contentPanel.add(panel);
		contentPanel.add(photoPanel);
		contentPanel.add(lblFoto);
		contentPanel.add(spnAnoFund);
		contentPanel.add(txtEntrenador);
		contentPanel.add(lblEntrenador);
		contentPanel.add(lblDueno);
		contentPanel.add(txtDueno);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				if (aux != null)
					okButton.setText("Modificar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (aux == null) {
							if (datosCompletos())
							{
							    String pais = cmbxPais.getSelectedItem() != null ? 
							        cmbxPais.getSelectedItem().toString() : "Seleccionar";
							    
							    ArrayList<Juego> misJuegos = new ArrayList<Juego>();
							    ArrayList<Jugador> misJugadores = new ArrayList<Jugador>();
							    
							    File fotoGuardada = null;
					            if (selectedFile != null) {
					                fotoGuardada = copiarImagenADirectorioApp(selectedFile, txtId.getText());
					            }
							    
							    Equipo equipo = new Equipo(txtId.getText(),
							                             txtNombre.getText(),
							                             txtEntrenador.getText(),
							                             pais,
							                             Integer.parseInt(spnAnoFund.getValue().toString()),
							                             txtDueno.getText(),
							                             fotoGuardada,
							                             misJuegos,
							                             misJugadores);
							    
							    SerieNacional.getInstance().guardarEquipo(equipo);
							    ListadoEquipos.loadAll(null);
							    OperacionExitosa operacion = new OperacionExitosa();
							    operacion.setVisible(true);
							    operacion.setModal(true);
							    clean();
							}
							else
							{
								OperacionFallida operacion = new OperacionFallida("Rellene todos los campos.");
							    operacion.setVisible(true);
							    operacion.setModal(true);
							}
						} else {
							
							if (selectedFile != null && !selectedFile.equals(aux.getFoto())) {
				                File fotoGuardada = copiarImagenADirectorioApp(selectedFile, aux.getId());
				                aux.setFoto(fotoGuardada);
				            }
							
						    aux.setNombre(txtNombre.getText());
						    aux.setEntrenador(txtEntrenador.getText());
						    aux.setPais(cmbxPais.getSelectedItem() != null ? 
						        cmbxPais.getSelectedItem().toString() : "Seleccionar");
						    aux.setAnoFundacion(Integer.parseInt(spnAnoFund.getValue().toString()));
						    aux.setDueno(txtDueno.getText());
						    
						    SerieNacional.getInstance().modificarEquipo(aux);
						    ListadoEquipos.loadAll(null);
						    OperacionExitosa operacion = new OperacionExitosa();
						    operacion.setVisible(true);
						    operacion.setModal(true);
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
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 13));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadEquipo(aux);
	}
	
	/**
	 * Actualiza el texto del bot�n seg�n si hay imagen seleccionada o no
	 */
	private void updateButtonText() {
		if (selectedFile != null) {
			selectImageButton.setText("Cambiar imagen");
		} else {
			selectImageButton.setText("Seleccionar imagen");
		}
	}
	
	/**
	 * Muestra un di�logo para seleccionar una imagen
	 */
	private void selectImage() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Seleccionar imagen");
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Archivos de imagen", "jpg", "jpeg", "png", "gif", "bmp");
		fileChooser.setFileFilter(filter);
		
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			displayImage(selectedFile);
			updateButtonText();
		}
	}
	
	/**
	 * Muestra la imagen seleccionada
	 */
	private void displayImage(File file) {
		try {
			ImageIcon icon = new ImageIcon(file.getPath());

			if (icon.getIconWidth() > 200 || icon.getIconHeight() > 200) {
				Image img = icon.getImage();
				Image scaledImg = img.getScaledInstance(200, -1, Image.SCALE_SMOOTH);
				icon = new ImageIcon(scaledImg);
			}

			imageDisplayLabel.setIcon(icon);
			imageDisplayLabel.setText("");
			
			photoLabel.setIcon(null);
			photoLabel.setText("Arrastra una imagen aqu�");
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
	
	private File copiarImagenADirectorioApp(File archivoOriginal, String id) {
	    if (archivoOriginal == null) {
	        return null;
	    }
	    
	    try {
	        File dirImagenes = new File("rec/img/equipos");
	        if (!dirImagenes.exists()) {
	            dirImagenes.mkdirs();
	        }
	        
	        String nombreOriginal = archivoOriginal.getName();
	        String extension = "";
	        int i = nombreOriginal.lastIndexOf('.');
	        if (i > 0) {
	            extension = nombreOriginal.substring(i);
	        }
	        
	        String nuevoNombre = id + extension;
	        File destino = new File(dirImagenes, nuevoNombre);
	        
	        Files.copy(archivoOriginal.toPath(), destino.toPath(), 
	                  StandardCopyOption.REPLACE_EXISTING);
	                  
	        return destino;
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	private void loadEquipo(Equipo aux) {
	    if (aux != null) {
	        txtId.setText(aux.getId());
	        txtNombre.setText(aux.getNombre());
	        txtEntrenador.setText(aux.getEntrenador());	        
	        txtDueno.setText(aux.getDueno());
		    cmbxPais.setSelectedItem(aux.getPais());
		    spnAnoFund.setValue(aux.getAnoFundacion());
		    selectedFile = aux.getFoto();
		    
	        if (selectedFile != null)
	        {
	        	displayImage(selectedFile);
	        }
	        else
	        {
	        	imageDisplayLabel.setIcon(null);
	            imageDisplayLabel.setText("No hay imagen seleccionada");
	        }
	        
	        updateButtonText();
	    }
	}
	
	private void clean() {
	    SerieNacional.getInstance();
		txtId.setText("EQ-"+SerieNacional.getInstance().getGeneradorEquipo());
	    txtNombre.setText("");
	    txtEntrenador.setText("");
	    txtDueno.setText("");
	    cmbxPais.setSelectedItem("Seleccionar");
	    spnAnoFund.setValue(2000);
	    selectedFile = null;
	    imageDisplayLabel.setIcon(null);
	    imageDisplayLabel.setText("No hay imagen seleccionada");
	    updateButtonText();
	}
	
	private boolean datosCompletos() {
	    return !txtNombre.getText().trim().isEmpty()
	        && cmbxPais.getSelectedItem() != null
	        && !cmbxPais.getSelectedItem().toString().equals("Seleccionar")
	        && !txtEntrenador.getText().trim().isEmpty()
	        && !txtDueno.getText().trim().isEmpty();
	}
}
