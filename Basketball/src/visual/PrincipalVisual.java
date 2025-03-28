package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class PrincipalVisual extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalVisual frame = new PrincipalVisual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalVisual() {
		setTitle("Serie Nacional de Basketball");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnJugador = new JMenu(" Jugadores ");
		menuBar.add(mnJugador);
		
		JMenuItem mntmJugLis = new JMenuItem("Listado");
		mnJugador.add(mntmJugLis);
		
		JMenuItem mntmNewJug = new JMenuItem("Agregar");
		mnJugador.add(mntmNewJug);
		
		JMenu mnEquipo = new JMenu(" Equipos ");
		menuBar.add(mnEquipo);
		
		JMenuItem mntmEquLis = new JMenuItem("Listado");
		mnEquipo.add(mntmEquLis);
		
		JMenuItem mntmNewEqu = new JMenuItem("Agregar");
		mnEquipo.add(mntmNewEqu);
		
		JMenu mnJuego = new JMenu(" Torneo ");
		menuBar.add(mnJuego);
		
		JMenuItem mntmCalendario = new JMenuItem("Calendario");
		mnJuego.add(mntmCalendario);
		
		JMenuItem mntmCrearTorneo = new JMenuItem("Crear");
		mnJuego.add(mntmCrearTorneo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
