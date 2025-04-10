package visual;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import logico.Jugador;
import logico.SerieNacional;
import logico.User;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.Rectangle;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JTree;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PrincipalVisual extends JFrame {

    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu mnEquipo;
    private JMenu mnJugador;
    private JMenu mnCalendario;
    private JMenu mnSimulacion;
    private JMenuItem mntmListadoEquipo;
    private JMenuItem mntmRegEquipo;
    private JMenuItem mntmListadoJugador;
    private JMenuItem mntmRegJugador;
    private JMenuItem mntmListadoJuegos;
    private JMenuItem mntmIniciarSimulacion;
    private JMenu mnUsuario;
    private JMenuItem mntmRegUsuario;
    private JMenuItem mntmListadoUsuario;
    static Socket sfd = null;
    static DataInputStream EntradaSocket;
    static DataOutputStream SalidaSocket;
    
    // Referencias a las gr�ficas para poder refrescarlas
    private BarraWinrate gwin;
    private GraficaBarra grafica;
    private GraficaEfectividad ge;
    private JMenu mnOtros;
    private JMenuItem mntmmRespaldo;
    private JMenuItem mntmmRefrescarEstadisticas;

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
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FileOutputStream serieOut;
                ObjectOutputStream serieWrite;
                
                File directory = new File("rec/data");
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                
                try {            
                    serieOut = new FileOutputStream("rec/data/serie.dat");
                    serieWrite = new ObjectOutputStream(serieOut);
                    serieWrite.writeObject(SerieNacional.getInstance());
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
            }
        });
        

        setTitle("Serie Nacional de Basketball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        setLocationRelativeTo(null);
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        mnEquipo = new JMenu("  Equipos  ");
        menuBar.add(mnEquipo);
        
        mntmListadoEquipo = new JMenuItem("Listado");
        mntmListadoEquipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ListadoEquipos listado = new ListadoEquipos();
                listado.setVisible(true);
                listado.setModal(true);
            }
        });
        mnEquipo.add(mntmListadoEquipo);
        
        mntmRegEquipo = new JMenuItem("Registrar");
        mntmRegEquipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegEquipo registrar = new RegEquipo(null);
                registrar.setVisible(true);
                registrar.setModal(true);
            }
        });
        mnEquipo.add(mntmRegEquipo);
        mnJugador = new JMenu("  Jugadores  ");
        menuBar.add(mnJugador);
        
        mntmListadoJugador = new JMenuItem("Listado");
        mntmListadoJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListadoJugadores listado = new ListadoJugadores(null);
                listado.setVisible(true);
                listado.setModal(true);
            }
        });
        mnJugador.add(mntmListadoJugador);
        
        mntmRegJugador = new JMenuItem("Registrar");
        mntmRegJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegJugador registrar = new RegJugador(null);
                registrar.setVisible(true);
                registrar.setModal(true);              
            }
        });
        mnJugador.add(mntmRegJugador);
        
        mnCalendario = new JMenu("  Calendario de Juegos  ");
        menuBar.add(mnCalendario);
        mntmListadoJuegos = new JMenuItem("Listado");
        mntmListadoJuegos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ListadoJuegos listado = new ListadoJuegos(null);
                listado.setVisible(true);
                listado.setModal(true);
            }
        });
        mnCalendario.add(mntmListadoJuegos);
        
        mnSimulacion = new JMenu("  Simulacion de Juego  ");
        menuBar.add(mnSimulacion);
        
        mntmIniciarSimulacion = new JMenuItem("Iniciar");
        mntmIniciarSimulacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PsimulacionJuego simulacion = new PsimulacionJuego();
                simulacion.setVisible(true);
                simulacion.setModal(true); 
            }
        });
        mnSimulacion.add(mntmIniciarSimulacion);
        
        mnUsuario = new JMenu("  Usuarios  ");
        menuBar.add(mnUsuario);
        
        mntmRegUsuario = new JMenuItem("Registrar");
        mntmRegUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                RegUser usuario = new RegUser();
                usuario.setVisible(true);
                usuario.setModal(true);
            }
        });
        
        mntmListadoUsuario = new JMenuItem("Listado");
        mntmListadoUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ListadoUsuarios listado = new ListadoUsuarios();
                listado.setVisible(true);
                listado.setModal(true);
            }
        });
        mnUsuario.add(mntmListadoUsuario);
        mnUsuario.add(mntmRegUsuario);
        
        mnOtros = new JMenu("  Otros  ");
        menuBar.add(mnOtros);
        
        mntmmRespaldo = new JMenuItem("Respaldar");
        mntmmRespaldo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try
                {
                      sfd = new Socket("127.0.0.1",9000);
                      
                      File directory = new File("rec/data");
                        if (!directory.exists()) {
                            directory.mkdirs();
                        }
                        
                      DataInputStream aux = new DataInputStream(new FileInputStream(new File("rec/data/serie.dat")));
                      SalidaSocket = new DataOutputStream((sfd.getOutputStream()));
                      int unByte;
                      try
                      {
                        while ((unByte = aux.read()) != -1){
                            SalidaSocket.write(unByte);
                            SalidaSocket.flush();
                        }
                      }
                      catch (IOException ioe)
                      {
                        System.out.println("Error: "+ioe);
                      }
                    }
                    catch (UnknownHostException uhe)
                    {
                      System.out.println("No se puede acceder al servidor.");
                      System.exit(1);
                    }
                    catch (IOException ioe)
                    {
                      System.out.println("Comunicaci�n rechazada.");
                      System.exit(1);
                    }
        		OperacionExitosa operacion = new OperacionExitosa();
        		operacion.setVisible(true);
        		operacion.setModal(true);
                }
        });
        mnOtros.add(mntmmRespaldo);
        
        mntmmRefrescarEstadisticas = new JMenuItem("Refrescar Estad\u00EDsticas");
        mntmmRefrescarEstadisticas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		refrescarGraficas();
        	}
        });
        mnOtros.add(mntmmRefrescarEstadisticas);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        contentPane.add(panel);
        panel.setLayout(null);
        
             // Bara 2 win
             gwin = new BarraWinrate();
             gwin.setBounds(12, 458, 1228, 150);
             panel.add(gwin);
             
             // Bara 1 tops3
             grafica = new GraficaBarra();
             grafica.setBounds(12, 16, 667, 429);
             panel.add(grafica);
             
             // Bara 3 top10
             ge = new GraficaEfectividad();
             ge.setBounds(702, 13, 538, 429);
             panel.add(ge);
        
             User miUser = SerieNacional.getLoginUser();
             if (miUser != null)
             {
                 if(!miUser.getTipo().equals("Administrador"))
                 {
                     mnUsuario.setVisible(false);
                     mntmRegJugador.setVisible(false);
                     mntmRegEquipo.setVisible(false);
                     mntmRegUsuario.setVisible(false);
                     mntmListadoUsuario.setVisible(false);
                 }
            }
    }
    
    /**
     * M�todo para refrescar las gr�ficas
     */
    private void refrescarGraficas() {
        System.out.println("Refrescando gr�ficas de estad�sticas...");
        
        // Elimina los paneles actuales
        contentPane.removeAll();
        
        // Crea un nuevo panel
        JPanel panel = new JPanel();
        contentPane.add(panel);
        panel.setLayout(null);
        
        // Crea nuevas instancias de las gr�ficas
        gwin = new BarraWinrate();
        gwin.setBounds(12, 458, 1228, 150);
        panel.add(gwin);
        
        grafica = new GraficaBarra();
        grafica.setBounds(226, 16, 453, 429);
        panel.add(grafica);
        
        ge = new GraficaEfectividad();
        ge.setBounds(702, 13, 538, 429);
        panel.add(ge);
        
        // Actualiza la visualizaci�n
        panel.revalidate();
        panel.repaint();
        contentPane.revalidate();
        contentPane.repaint();
        
        System.out.println("Estad�sticas refrescadas con �xito");
    }
}