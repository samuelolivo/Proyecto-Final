package visual;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class PsimulacionJuego extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	// Temporizador y control:P
	private int tiempoR;
	private int periodo = 1;
	private Timer temporizador;
	private boolean TemporizadorEjecucion = false;

	private JButton InicioPausaBoton;
	private JLabel TiempoLabel;
	private JLabel PeriodoLabel;
	private JTextField textField;

	public static void main(String[] args) {
		try {
			PsimulacionJuego dialog = new PsimulacionJuego();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PsimulacionJuego() {
		setResizable(false);
		setAlwaysOnTop(true);
		setModal(true);
		setBounds(100, 100, 1137, 819);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel labelEquipo = new JLabel("Equipo1:");
		labelEquipo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelEquipo.setBounds(450, 179, 130, 43);
		contentPanel.add(labelEquipo);

		JLabel lblEquipo2 = new JLabel("Equipo2:");
		lblEquipo2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEquipo2.setBounds(641, 179, 118, 43);
		contentPanel.add(lblEquipo2);

		JLabel lblPuntuacion1 = new JLabel("Puntuacion:");
		lblPuntuacion1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPuntuacion1.setBounds(460, 233, 89, 14);
		contentPanel.add(lblPuntuacion1);

		JLabel lblPuntuacion2 = new JLabel("Puntuacion:");
		lblPuntuacion2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPuntuacion2.setBounds(651, 233, 89, 14);
		contentPanel.add(lblPuntuacion2);

		TiempoLabel = new JLabel("15:00");
		TiempoLabel.setFont(new Font("Tahoma", Font.BOLD, 55));
		TiempoLabel.setBounds(504, 329, 329, 106);
		contentPanel.add(TiempoLabel);

		JLabel lblNewLabel_1 = new JLabel("  Periodo:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(568, 247, 55, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Faltas");
		lblNewLabel_2.setBounds(472, 450, 46, 14);
		contentPanel.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(480, 465, 26, 60);
		contentPanel.add(textField_1);

		JLabel label = new JLabel("Faltas");
		label.setBounds(693, 450, 46, 14);
		contentPanel.add(label);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		textField_2.setColumns(10);
		textField_2.setBounds(694, 465, 26, 60);
		contentPanel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(448, 258, 86, 60);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(641, 262, 86, 60);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("HOME");
		lblNewLabel_3.setBounds(472, 154, 46, 14);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("AWAY");
		lblNewLabel_4.setBounds(680, 154, 46, 14);
		contentPanel.add(lblNewLabel_4);

		//tiempo
		InicioPausaBoton = new JButton("Iniciar");
		InicioPausaBoton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		InicioPausaBoton.setBounds(540, 480, 133, 38);
		InicioPausaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TemporizadorEjecucion) {
					pausarTemporizador();
				} else {
					iniciarTemporizaor();
				}
			}
		});
		contentPanel.add(InicioPausaBoton);
		
		PeriodoLabel = new JLabel(" 1");
		PeriodoLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		PeriodoLabel.setBounds(578, 260, 34, 43);
		contentPanel.add(PeriodoLabel);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setBounds(12, 13, 102, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("1");
		btnNewButton_2.setBounds(51, 581, 89, 23);
		contentPanel.add(btnNewButton_2);
		
		JButton button = new JButton("2");
		button.setBounds(51, 548, 89, 23);
		contentPanel.add(button);
		
		JButton button_1 = new JButton("3");
		button_1.setBounds(51, 514, 89, 23);
		contentPanel.add(button_1);
		
		JButton btnRobo = new JButton("robo");
		btnRobo.setBounds(51, 480, 89, 23);
		contentPanel.add(btnRobo);
		
		JButton btnFalta = new JButton("falta");
		btnFalta.setBounds(51, 446, 89, 23);
		contentPanel.add(btnFalta);
		
		JButton btnAsistencia = new JButton("Asistencia");
		btnAsistencia.setBounds(51, 412, 89, 23);
		contentPanel.add(btnAsistencia);
		
		JButton btnTapones = new JButton("Tapones");
		btnTapones.setBounds(51, 378, 89, 23);
		contentPanel.add(btnTapones);
		
		JButton btnNewButton_3 = new JButton("Running");
		btnNewButton_3.setBounds(51, 345, 89, 23);
		contentPanel.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(126, 13, 138, 22);
		contentPanel.add(textField);
		textField.setColumns(10);
	}

	private void iniciarTemporizaor() {
		tiempoR = 15 * 60;
		TemporizadorEjecucion = true;
		InicioPausaBoton.setText("Pausar");

		temporizador = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tiempoR > 0) {
					tiempoR--;
					actualizarTiempoLabel();
					verificarPeriodo();
				} else {
					mostrarMensajePeriodo();
					temporizador.stop();
					TemporizadorEjecucion = false;
					InicioPausaBoton.setText("Iniciar");
				}
			}
		});
		temporizador.start();
	}

	private void pausarTemporizador() {
		temporizador.stop();
		TemporizadorEjecucion = false;
		InicioPausaBoton.setText("Reanudar");
	}

	private void actualizarTiempoLabel() {
		int minutos = tiempoR / 60;
		int segundos = tiempoR % 60;
		TiempoLabel.setText(String.format("%02d:%02d", minutos, segundos));
	}

	private void verificarPeriodo() {
		if ((tiempoR == 10 * 60 || tiempoR == 5 * 60 || tiempoR == 0) && periodo <= 4) {
			mostrarMensajePeriodo();
		}
	}

	private void mostrarMensajePeriodo() {
		JOptionPane.showMessageDialog(null, "Finalizó el periodo " + periodo);
		periodo++;

		if (periodo <= 4) {
			PeriodoLabel.setText(String.valueOf(periodo));
		} else {
			temporizador.stop();
			TemporizadorEjecucion = false;
			InicioPausaBoton.setText("Iniciar");
		}
	}
}