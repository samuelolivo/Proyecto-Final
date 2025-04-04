package visual;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListadoLesiones extends JFrame {

    private JTable tabla;
    private JTextField txtBusqueda;

    public ListadoLesiones() {
        setTitle("Listado de Lesiones");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] columnas = {"ID Lesión", "ID Jugador", "Tipo Lesión", "Fecha Recuperación"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        
        tabla = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabla);

        JPanel searchPanel = new JPanel(new BorderLayout());
        txtBusqueda = new JTextField();
        JButton btnBuscar = new JButton("Buscar");
        
        searchPanel.add(new JLabel("Buscar:"), BorderLayout.WEST);
        searchPanel.add(txtBusqueda, BorderLayout.CENTER);
        searchPanel.add(btnBuscar, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnDetalle = new JButton("Ver Detalle");
        JButton btnRegistrar = new JButton("Registrar Nueva");
        JButton btnVolver = new JButton("Volver");
        
        buttonPanel.add(btnDetalle);
        buttonPanel.add(btnRegistrar);
        buttonPanel.add(btnVolver);

        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListadoLesiones().setVisible(true);
        });
    }
}