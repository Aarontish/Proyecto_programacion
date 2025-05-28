package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class TiposHabitacion {

    JFrame frame;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TiposHabitacion window = new TiposHabitacion();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TiposHabitacion() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 1180, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel(); //Borde negro
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(0, 0, 1164, 95);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel(); //Borde gris
        panel_2.setBackground(new Color(55, 54, 48));
        panel_2.setBounds(0, 95, 1164, 26);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JLabel logo = new JLabel(""); //Logo
        logo.setBounds(0, 0, 170, 95);
        ImageIcon portada1 = new ImageIcon(getClass().getResource("/images/logo.png"));
        Image portada2 = portada1.getImage();
        Image portada3 = portada2.getScaledInstance(170, 95,Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(portada3));
        panel_1.add(logo);
        
        JLabel Titulo = new JLabel("Tipos  de habitaciones:"); //Titulo
        Titulo.setForeground(new Color(255, 255, 255));
        Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
        Titulo.setBounds(180, 11, 410, 73);
        panel_1.add(Titulo);

        // Botón usuario - Estilo modificado para bordes cuadrados
        JButton botonSuperior1 = new JButton(""); 
        botonSuperior1.setBackground(new Color(0, 0, 0));
        botonSuperior1.setBorder(BorderFactory.createEmptyBorder()); // Sin borde
        botonSuperior1.setFocusPainted(false);
        botonSuperior1.setContentAreaFilled(true);
        botonSuperior1.setBounds(1098, 11, 56, 56);
        ImageIcon c1 = new ImageIcon(getClass().getResource("/images/usuario.png"));
        Image c2 = c1.getImage();
        Image c3 = c2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        botonSuperior1.setIcon(new ImageIcon(c3));
        panel_1.add(botonSuperior1);

        JButton botonSuperior2 = new JButton(""); 
        botonSuperior2.setBackground(new Color(0, 0, 0));
        botonSuperior2.setBorder(BorderFactory.createEmptyBorder()); // Sin borde
        botonSuperior2.setFocusPainted(false);
        botonSuperior2.setContentAreaFilled(true);
        botonSuperior2.setBounds(1032, 11, 56, 56);
        ImageIcon e1 = new ImageIcon(getClass().getResource("/images/informacion.png"));
        Image e2 = e1.getImage();
        Image e3 = e2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        botonSuperior2.setIcon(new ImageIcon(e3));
        panel_1.add(botonSuperior2);

        JButton botonVolver = new JButton(""); 
        botonVolver.setBackground(new Color(255, 255, 255));
        botonVolver.setBorder(BorderFactory.createEmptyBorder()); // Sin borde
        botonVolver.setFocusPainted(false);
        botonVolver.setContentAreaFilled(true);
        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Menu conexion = new Menu();
                conexion.frame.setVisible(true);     
            }
        });
        botonVolver.setBounds(60, 132, 50, 50);
        ImageIcon icon69 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
        Image imagen69 = icon69.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        botonVolver.setIcon(new ImageIcon(imagen69));
        panel.add(botonVolver);

        // Botones de la barra superior - Estilo modificado
        JButton btnTiposDeRentas = createFlatButton("<html>Tipos de habitaciones &#8594;</html>");
        btnTiposDeRentas.setBounds(1023, 0, 134, 23);
        panel_2.add(btnTiposDeRentas);

        JButton btnrentas = createFlatButton("<html>Rentas &#8594;</html>");
        btnrentas.setBounds(932, 0, 81, 23);
        panel_2.add(btnrentas);

        JButton btnclientes = createFlatButton("<html>Clientes &#8594;</html>");
        btnclientes.setBounds(841, 0, 81, 23);
        panel_2.add(btnclientes);

        JButton btnhabitaciones = createFlatButton("<html>Habitaciones &#8594;</html>");
        btnhabitaciones.setBounds(731, 0, 100, 23);
        panel_2.add(btnhabitaciones);

        JButton btntarifas = createFlatButton("<html>Tarifas &#8594;</html>");
        btntarifas.setBounds(649, 0, 72, 23);
        panel_2.add(btntarifas);

        // Paneles de habitaciones
        JPanel panel_3 = createRoomPanel("Estandar", "3", "/images/foto1.png", 131, 193);
        panel.add(panel_3);

        JPanel panel_2_1 = createRoomPanel("Familiar", "4", "/images/foto2.png", 461, 193);
        panel.add(panel_2_1);

        JPanel panel_1_1 = createRoomPanel("Suite", "5", "/images/foto3.png", 811, 193);
        panel.add(panel_1_1);

        // Botones inferiores
        JButton btnEliminar = createActionButton("Eliminar", new Color(239, 35, 60), 131, 131);
        panel.add(btnEliminar);

        JButton btnEditar = createActionButton("Editar", new Color(44, 196, 196), 265, 128);
        panel.add(btnEditar);

        JButton btnCrear = createActionButton("Crear tipo", Color.YELLOW, 399, 127);
        panel.add(btnCrear);
    }

    // Método auxiliar para crear botones planos
    private JButton createFlatButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(56, 54, 41));
        button.setBorder(BorderFactory.createEmptyBorder()); // Sin borde
        button.setFocusPainted(false);
        button.setContentAreaFilled(true);
        return button;
    }

    private JPanel createRoomPanel(String title, String count, String imagePath, int x, int y) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(152, 193, 217));
        panel.setBounds(x, y, 300, 440);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
        lblTitle.setBounds(86, 10, 135, 20);
        panel.add(lblTitle);

        JLabel lblImagen = new JLabel();
        lblImagen.setBounds(50, 39, 200, 200);
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image imagen = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        lblImagen.setIcon(new ImageIcon(imagen));
        panel.add(lblImagen);

        JLabel lblHabitaciones = new JLabel("Habitaciones:");
        lblHabitaciones.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
        lblHabitaciones.setBounds(86, 249, 135, 20);
        panel.add(lblHabitaciones);
        
        JLabel lblCount = new JLabel(count);
        lblCount.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
        lblCount.setBounds(138, 289, 40, 29);
        panel.add(lblCount);
        
        JButton btnDetalles = new JButton("Detalles");
        btnDetalles.setBackground(new Color(255, 230, 167));
        btnDetalles.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnDetalles.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde cuadrado
        btnDetalles.setBounds(86, 375, 124, 55);
        panel.add(btnDetalles);

        return panel;
    }

    private JButton createActionButton(String text, Color bgColor, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
        button.setBackground(bgColor);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde cuadrado
        button.setBounds(x, y, text.equals("Crear tipo") ? 154 : 124, 55);
        return button;
    }
}