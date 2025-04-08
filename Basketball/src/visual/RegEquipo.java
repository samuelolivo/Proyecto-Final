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

import logico.Equipo;
import logico.Juego;
import logico.Jugador;
import logico.SerieNacional;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpinnerNumberModel;

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
	private JLabel ldlCiudad;
	private JComboBox<String> cmbxCiudad;
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
		setAlwaysOnTop(true);
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
			SerieNacional.getInstance();
			txtId.setText("EQ-"+SerieNacional.getGeneradorEquipo());
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
			ldlCiudad = new JLabel("Ciudad:");
			ldlCiudad.setBounds(38, 69, 46, 16);
		}
		{
			cmbxCiudad = new JComboBox();
			cmbxCiudad.setBounds(89, 66, 387, 22);
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
		contentPanel.add(ldlCiudad);
		contentPanel.add(cmbxCiudad);
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
						    String ciudad = cmbxCiudad.getSelectedItem() != null ? 
						        cmbxCiudad.getSelectedItem().toString() : "Seleccionar";
						    
						    ArrayList<Juego> misJuegos = new ArrayList<Juego>();
						    ArrayList<Jugador> misJugadores = new ArrayList<Jugador>();
						    
						    Equipo equipo = new Equipo(txtId.getText(),
						                             txtNombre.getText(),
						                             txtEntrenador.getText(),
						                             ciudad,
						                             Integer.parseInt(spnAnoFund.getValue().toString()),
						                             txtDueno.getText(),
						                             selectedFile,
						                             misJuegos,
						                             misJugadores);
						    
						    SerieNacional.getInstance().guardarEquipo(equipo);
						    ListadoEquipos.loadAll(null);
						    clean();
						} else {
						    aux.setNombre(txtNombre.getText());
						    aux.setEntrenador(txtEntrenador.getText());
						    aux.setCiudad(cmbxCiudad.getSelectedItem() != null ? 
						        cmbxCiudad.getSelectedItem().toString() : "Seleccionar");
						    aux.setAnoFundacion(Integer.parseInt(spnAnoFund.getValue().toString()));
						    aux.setDueno(txtDueno.getText());
						    aux.setFoto(selectedFile);
						    
						    SerieNacional.getInstance().modificarEquipo(aux);
						    ListadoEquipos.loadAll(null);
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
	
	private void loadEquipo(Equipo aux) {
	    if (aux != null) {
	        txtId.setText(aux.getId());
	        txtNombre.setText(aux.getNombre());
	        txtEntrenador.setText(aux.getEntrenador());	        
	        txtDueno.setText(aux.getDueno());
		    cmbxCiudad.setSelectedItem(aux.getCiudad());
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
		txtId.setText("EQ-"+SerieNacional.getGeneradorEquipo());
	    txtNombre.setText("");
	    txtEntrenador.setText("");
	    txtDueno.setText("");
	    cmbxCiudad.setSelectedItem("Seleccionar");
	    spnAnoFund.setValue(2000);
	    selectedFile = null;
	    imageDisplayLabel.setIcon(null);
	    imageDisplayLabel.setText("No hay imagen seleccionada");
	    updateButtonText();
	}
}
