package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class RegLesion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtLe;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegLesion dialog = new RegLesion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegLesion() {
		setTitle("Registrar Lesion");
		setBounds(100, 100, 504, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Id:");
		label.setBounds(79, 20, 16, 16);
		contentPanel.add(label);
		
		txtLe = new JTextField();
		txtLe.setText("LE-");
		txtLe.setEditable(false);
		txtLe.setColumns(10);
		txtLe.setBounds(101, 13, 373, 22);
		contentPanel.add(txtLe);
		
		JLabel lblTipoDeLesin = new JLabel("Tipo de lesi\u00F3n:");
		lblTipoDeLesin.setBounds(10, 69, 90, 16);
		contentPanel.add(lblTipoDeLesin);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(101, 66, 373, 22);
		contentPanel.add(comboBox);
		
		JLabel lblDasDeReposo = new JLabel("D\u00EDas de reposo:");
		lblDasDeReposo.setBounds(10, 201, 90, 16);
		contentPanel.add(lblDasDeReposo);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(105, 198, 79, 22);
		contentPanel.add(spinner);
		
		JLabel lblFechaDeRecuperacin = new JLabel("Fecha de recuperaci\u00F3n:");
		lblFechaDeRecuperacin.setBounds(199, 201, 143, 16);
		contentPanel.add(lblFechaDeRecuperacin);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(101, 39, 373, 22);
		contentPanel.add(textField);
		
		JLabel label_1 = new JLabel("Jugador:");
		label_1.setBounds(44, 42, 52, 16);
		contentPanel.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(338, 198, 136, 22);
		contentPanel.add(textField_1);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(24, 98, 70, 16);
		contentPanel.add(lblDescripcin);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(101, 93, 373, 99);
		contentPanel.add(textArea);
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
