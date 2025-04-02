package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class PsimulacionJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PsimulacionJuego dialog = new PsimulacionJuego();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PsimulacionJuego() {
		setBounds(100, 100, 553, 449);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel labelEquipo = new JLabel("Equipo1:");
			labelEquipo.setFont(new Font("Tahoma", Font.PLAIN, 30));
			labelEquipo.setBounds(110, 33, 130, 43);
			contentPanel.add(labelEquipo);
		}
		{
			JLabel lblEquipo2 = new JLabel("Equipo2:");
			lblEquipo2.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblEquipo2.setBounds(301, 33, 118, 43);
			contentPanel.add(lblEquipo2);
		}
		{
			JLabel lblPuntuacion1 = new JLabel("Puntuacion:");
			lblPuntuacion1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPuntuacion1.setBounds(120, 87, 89, 14);
			contentPanel.add(lblPuntuacion1);
		}
		{
			JLabel lblPuntuacion2 = new JLabel("Puntuacion:");
			lblPuntuacion2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblPuntuacion2.setBounds(311, 87, 89, 14);
			contentPanel.add(lblPuntuacion2);
		}
		{
			JSpinner spinnerT1 = new JSpinner();
			spinnerT1.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
			spinnerT1.setBounds(130, 112, 48, 43);
			contentPanel.add(spinnerT1);
		}
		{
			JSpinner spinnerT2 = new JSpinner();
			spinnerT2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
			spinnerT2.setBounds(321, 112, 48, 43);
			contentPanel.add(spinnerT2);
		}
		{
			JLabel label_m = new JLabel("Tiempo Muerto");
			label_m.setBounds(120, 162, 89, 14);
			contentPanel.add(label_m);
		}
		{
			JLabel label = new JLabel("Tiempo Muerto");
			label.setBounds(301, 162, 99, 14);
			contentPanel.add(label);
		}
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		chckbxNewCheckBox.setBounds(116, 179, 26, 23);
		contentPanel.add(chckbxNewCheckBox);
		{
			JCheckBox checkBox = new JCheckBox("");
			checkBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
			checkBox.setBounds(144, 179, 26, 23);
			contentPanel.add(checkBox);
		}
		{
			JCheckBox checkBox = new JCheckBox("");
			checkBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
			checkBox.setBounds(172, 179, 26, 23);
			contentPanel.add(checkBox);
		}
		{
			JCheckBox checkBox = new JCheckBox("");
			checkBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
			checkBox.setBounds(301, 179, 26, 23);
			contentPanel.add(checkBox);
		}
		{
			JCheckBox checkBox = new JCheckBox("");
			checkBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
			checkBox.setBounds(329, 179, 26, 23);
			contentPanel.add(checkBox);
		}
		{
			JCheckBox checkBox = new JCheckBox("");
			checkBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
			checkBox.setBounds(357, 179, 26, 23);
			contentPanel.add(checkBox);
		}
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField.setBounds(241, 116, 26, 60);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("     3:45");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 55));
		lblNewLabel.setBounds(110, 209, 309, 84);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  Periodo:");
		lblNewLabel_1.setBounds(228, 101, 55, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Faltas");
		lblNewLabel_2.setBounds(108, 304, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(110, 319, 26, 60);
		contentPanel.add(textField_1);
		
		JLabel label = new JLabel("Faltas");
		label.setBounds(353, 304, 46, 14);
		contentPanel.add(label);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_2.setColumns(10);
		textField_2.setBounds(354, 319, 26, 60);
		contentPanel.add(textField_2);
	}
}
