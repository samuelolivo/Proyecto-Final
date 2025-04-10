package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.User;
import logico.SerieNacional;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtContra;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            FileInputStream serieIn;
	            FileOutputStream serieOut;
	            ObjectInputStream serieRead;
	            ObjectOutputStream serieWrite;
	            
	            File directory = new File("rec/data");
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }
	            
	            try {
	                serieIn = new FileInputStream("rec/data/serie.dat");
	                serieRead = new ObjectInputStream(serieIn);
	                SerieNacional temp = (SerieNacional)serieRead.readObject();
	                SerieNacional.setSerie(temp);
	                serieIn.close();
	                serieRead.close();
	            } catch (FileNotFoundException e) {
	                try {
	                    serieOut = new FileOutputStream("rec/data/serie.dat");
	                    serieWrite = new ObjectOutputStream(serieOut);
	                    User aux = new User("Administrador", "Admin", "Admin");
	                    SerieNacional.getInstance().regUser(aux);
	                    serieWrite.writeObject(SerieNacional.getInstance());
	                    serieOut.close();
	                    serieWrite.close();
	                } catch (FileNotFoundException e1) {
	                    e1.printStackTrace();
	                } catch (IOException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            } catch (ClassNotFoundException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	            
	            try {
	                Login frame = new Login();
	                frame.setVisible(true);
	                frame.setModal(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
	/**
	 * Create the frame.
	 */
	public Login() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 249, 217);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(14, 13, 57, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(14, 63, 105, 14);
		panel.add(lblContrasea);
		
		txtUser = new JTextField();
		txtUser.setBounds(14, 31, 191, 20);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		txtContra = new JPasswordField();
		txtContra.setBounds(14, 81, 191, 20);
		panel.add(txtContra);
		txtContra.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SerieNacional.getInstance().confirmLogin(txtUser.getText(),txtContra.getText())){
					PrincipalVisual frame = new PrincipalVisual();
					dispose();
					frame.setVisible(true);
				};
				
			}
		});
		btnLogin.setBounds(14, 117, 191, 23);
		panel.add(btnLogin);
	}
}
