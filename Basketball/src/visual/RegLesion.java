package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Jugador;
import logico.Lesion;
import logico.SerieNacional;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.TextArea;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;

public class RegLesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtFechaRec;
	private JTextField txtIdJugador;
	private JTextField txtNomJugador;
	private JComboBox<String> cmbxTipoLesion;
	private JSpinner spnDiasReposo;
	private LocalDate today;
	private LocalDate recuperacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegLesion dialog = new RegLesion(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegLesion(Jugador jug, Lesion aux) {
		today = LocalDate.now();
		recuperacion = today;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		setTitle("Registrar Lesion");
		if (aux != null)
			setTitle("Modificar Lesion");
		
		setBounds(100, 100, 504, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Id:");
		label.setBounds(79, 20, 16, 16);
		contentPanel.add(label);
		
		txtId = new JTextField();
		SerieNacional.getInstance();
		txtId.setText("LE-"+SerieNacional.getGeneradorLesion());
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(101, 13, 373, 22);
		contentPanel.add(txtId);
		
		JLabel lblTipoDeLesion = new JLabel("Tipo de lesi\u00F3n:");
		lblTipoDeLesion.setBounds(10, 69, 90, 16);
		contentPanel.add(lblTipoDeLesion);
		
		cmbxTipoLesion = new JComboBox<String>();
		cmbxTipoLesion.setBounds(101, 66, 373, 22);
		contentPanel.add(cmbxTipoLesion);
		
		JLabel lblDasDeReposo = new JLabel("D\u00EDas de reposo:");
		lblDasDeReposo.setBounds(10, 201, 90, 16);
		contentPanel.add(lblDasDeReposo);
		
		spnDiasReposo = new JSpinner();
		spnDiasReposo.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnDiasReposo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				recuperacion = today.plusDays((long) Integer.parseInt(spnDiasReposo.getValue().toString()));
				txtFechaRec.setText(recuperacion.format(formatter));
			}
		});
		spnDiasReposo.setBounds(105, 198, 79, 22);
		contentPanel.add(spnDiasReposo);
		JLabel lblFechaDeRecuperacin = new JLabel("Fecha de recuperaci\u00F3n:");
		lblFechaDeRecuperacin.setBounds(199, 201, 143, 16);
		contentPanel.add(lblFechaDeRecuperacin);
		
		JLabel label_1 = new JLabel("Jugador:");
		label_1.setBounds(44, 42, 52, 16);
		contentPanel.add(label_1);
		
		txtFechaRec = new JTextField();
		txtFechaRec.setEditable(false);
		txtFechaRec.setColumns(10);
		txtFechaRec.setBounds(338, 198, 136, 22);
		contentPanel.add(txtFechaRec);
		txtFechaRec.setText(recuperacion.format(formatter));
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(24, 98, 70, 16);
		contentPanel.add(lblDescripcin);
		
		TextArea txtDescripcion = new TextArea();
		txtDescripcion.setBounds(101, 93, 373, 99);
		contentPanel.add(txtDescripcion);
		
		txtIdJugador = new JTextField();
		txtIdJugador.setEditable(false);
		txtIdJugador.setColumns(10);
		txtIdJugador.setBounds(101, 39, 122, 22);
		contentPanel.add(txtIdJugador);
		
		txtNomJugador = new JTextField();
		txtNomJugador.setEditable(false);
		txtNomJugador.setColumns(10);
		txtNomJugador.setBounds(227, 39, 247, 22);
		contentPanel.add(txtNomJugador);
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
}
