package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ListadoUsuarios extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;
	private AbstractButton txtNombreUsuario;
	private AbstractButton txtTipoUsuario;

    
    public static void main(String[] args) {
        try {
            ListadoUsuarios dialog = new ListadoUsuarios();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public ListadoUsuarios() {
        setTitle("Listado de Usuarios");
        setBounds(100, 100, 611, 324);  
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

         contentPanel.setLayout(new BorderLayout());

         String[] columnas = {"Nombre de Usuario", "Tipo de Usuario"};
        modeloTabla = new DefaultTableModel(columnas, 0);

         tablaUsuarios = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

         JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

         JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();        
            }
        });
                
                        
                        JButton btnRegistrar = new JButton("Registrar");
                        buttonPane.add(btnRegistrar);
                        btnRegistrar.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                registrarUsuario();
                            }
                        });
        
                 
                JButton btnEliminar = new JButton("Eliminar");
                buttonPane.add(btnEliminar);
                btnEliminar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        eliminarUsuario();
                    }
                });
        buttonPane.add(btnVolver);
    }

   
    private void registrarUsuario() {
        txtNombreUsuario = null;
		String nombreUsuario = txtNombreUsuario.getText();
        txtTipoUsuario = null;
		String tipoUsuario = txtTipoUsuario.getText();

         if (nombreUsuario.isEmpty() || tipoUsuario.isEmpty()) {
            mostrarMensaje("Por favor, complete todos los campos.");
            return;
        }

         Object[] nuevoUsuario = {nombreUsuario, tipoUsuario};
        modeloTabla.addRow(nuevoUsuario);

         limpiarCampos();
    }

    private void limpiarCampos() {
		// TODO Auto-generated method stub
		
	}

	
    private void eliminarUsuario() {
        int filaSeleccionada = tablaUsuarios.getSelectedRow();

         if (filaSeleccionada == -1) {
            mostrarMensaje("Por favor, seleccione un usuario para eliminar.");
            return;
        }

         modeloTabla.removeRow(filaSeleccionada);
    }

    
    private void mostrarMensaje(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(this, mensaje);
    }
}