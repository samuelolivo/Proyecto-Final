package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import logico.Jugador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //bara 1 tops3
        GraficaBarra grafica = new GraficaBarra();
        grafica.setBounds(307, 65, 453, 429);
        contentPane.add(grafica);
        
        JButton botonEquipos = new JButton("Equipos");
        botonEquipos.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        botonEquipos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        botonEquipos.setBounds(10, 76, 267, 111);
        contentPane.add(botonEquipos);
        
        JButton btnJugadores = new JButton("Jugadores");
        btnJugadores.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        btnJugadores.setBounds(10, 186, 267, 111);
        contentPane.add(btnJugadores);
        
        JButton btnSimulacion = new JButton("Simulacion de juego ");
        btnSimulacion.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
        btnSimulacion.setBounds(10, 294, 267, 111);
        contentPane.add(btnSimulacion);
        
        JButton btnCalendario = new JButton("Calendario de juegos");
        btnCalendario.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
        btnCalendario.setBounds(10, 402, 267, 111);
        contentPane.add(btnCalendario);
   
        //bara 2 win
        BarraWinrate gwin = new BarraWinrate();
        gwin.setBounds(138, 524, 1103, 150);
        contentPane.add(gwin);
        
        //bara 3 top10
        GraficaEfectividad ge = new GraficaEfectividad();
        ge.setBounds(770, 65, 538, 429);
        contentPane.add(ge);
        
    }
}



