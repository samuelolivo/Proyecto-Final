package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListadoEquipos extends JFrame {
   
	private static final long serialVersionUID = 1L;

	public ListadoEquipos() {
        setTitle("Listado de Equipos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

         JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

         JPanel searchPanel = new JPanel(new BorderLayout());
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 30));
        searchPanel.add(new JLabel("Barra de b\u00FAsqueda "), BorderLayout.WEST);
        searchPanel.add(searchField, BorderLayout.CENTER);
        
         String[] columnNames = {"Id", "Equipo", "Efectividad", "Cant. Juegos"};
        Object[][] data = {};  
        
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        
         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton registrarBtn = new JButton("Registrar");
        JButton consultarBtn = new JButton("Consultar");
        JButton volverBtn = new JButton("Volver");
        
         Font boldFont = new Font(registrarBtn.getFont().getName(), Font.BOLD, registrarBtn.getFont().getSize());
        registrarBtn.setFont(boldFont);
        consultarBtn.setFont(boldFont);
        volverBtn.setFont(boldFont);
        
        buttonPanel.add(registrarBtn);
        buttonPanel.add(consultarBtn);
        buttonPanel.add(volverBtn);

         mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        
         volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  
             }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ListadoEquipos().setVisible(true);
        });
    }
}