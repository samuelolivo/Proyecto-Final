package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalVisual extends JFrame {
	private	boolean grafica=false;
	private boolean grafica2=false;
	private boolean grafica3=false;

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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonGrafico = new JButton("Graficar");
		botonGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grafica=true;
				grafica2=true;
				grafica3=true;
				repaint();
			}
		});
		botonGrafico.setBounds(990, 647, 89, 23);
		contentPane.add(botonGrafico);
	}
	//funcion grafico redondo

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(grafica) {
			
		}
	}
	//funcion grafico palos...
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		if(grafica2) {
			
		}
	}
	//funcion grafica barra...
	@Override
	public void paintAll(Graphics g) {
		super.paintAll(g);
		if(grafica3) {
			
		}
	}
	
	
}

