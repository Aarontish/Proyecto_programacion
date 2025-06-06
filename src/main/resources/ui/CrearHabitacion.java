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

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JTextArea;

public class CrearHabitacion {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearHabitacion window = new CrearHabitacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearHabitacion() {
		
		try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 90); // Esquinas redondas
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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
        
        JLabel Titulo = new JLabel("Crear habitación"); //Titulo
        Titulo.setForeground(new Color(255, 255, 255));
        Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
        Titulo.setBounds(180, 11, 410, 73);
        panel_1.add(Titulo);
        
		JLabel menuTitulo1 = new JLabel("Crear tipo de habitación");
		menuTitulo1.setBackground(new Color(255, 255, 255));
		menuTitulo1.setFont(new Font("Jost*", Font.BOLD, 34));
		menuTitulo1.setBounds(131, 126, 579, 56);
		panel.add(menuTitulo1);
        
        JButton btntarifas = new JButton("<html>Tarifas &#8594;</html>"); //Botón superior tarifas
		btntarifas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aquí podrías abrir la ventana de Tarifas
				
			}
		});
		btntarifas.setForeground(Color.WHITE);
		btntarifas.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
		btntarifas.setFocusPainted(false);
		btntarifas.setContentAreaFilled(true);
		btntarifas.setBorderPainted(false);
		btntarifas.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btntarifas.setBackground(new Color(56, 54, 41));
		btntarifas.setBounds(649, 0, 72, 23);
		panel_2.add(btntarifas);
		
		JButton btnhabitaciones = new JButton("<html>Habitaciones &#8594;</html>"); //Botón superior habitaciones
		btnhabitaciones.setForeground(Color.WHITE);
		btnhabitaciones.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
		btnhabitaciones.setFocusPainted(false);
		btnhabitaciones.setContentAreaFilled(true);
		btnhabitaciones.setBorderPainted(false);
		btnhabitaciones.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnhabitaciones.setBackground(new Color(56, 54, 41));
		btnhabitaciones.setBounds(731, 0, 100, 23);
		panel_2.add(btnhabitaciones);
		
		JButton btnHabitaciones = new JButton("<html>Rentas &#8594;</html>"); //Botón superior rentas
		btnhabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aquí podrías abrir la ventana de Rentas
				frame.dispose(); // Cierra la ventana actual del menú
				PanelHabitaciones1 conexion = new PanelHabitaciones1();
				conexion.frame.setVisible(true); 	
			}
		});
		
		JButton btnclientes = new JButton("<html>Clientes &#8594;</html>"); //Botón superior clientes
		btnclientes.setForeground(Color.WHITE);
		btnclientes.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
		btnclientes.setFocusPainted(false);
		btnclientes.setContentAreaFilled(true);
		btnclientes.setBorderPainted(false);
		btnclientes.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnclientes.setBackground(new Color(56, 54, 41));
		btnclientes.setBounds(841, 0, 81, 23);
		panel_2.add(btnclientes);
		
		JButton btnClientes = new JButton("<html>Rentas &#8594;</html>"); //Botón superior rentas
		btnclientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aquí podrías abrir la ventana de Rentas
				frame.dispose(); // Cierra la ventana actual del menú
				Clientes conexion = new Clientes();
				conexion.frame.setVisible(true); 	
			}
		});
		
		JButton btnrentas = new JButton("<html>Rentas &#8594;</html>"); //Botón superior rentas
		btnrentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aquí podrías abrir la ventana de Rentas
				frame.dispose(); // Cierra la ventana actual del menú
				Rentas conexion = new Rentas();
				conexion.frame.setVisible(true); 	
			}
		});
		btnrentas.setForeground(Color.WHITE);
		btnrentas.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
		btnrentas.setFocusPainted(false);
		btnrentas.setContentAreaFilled(true);
		btnrentas.setBorderPainted(false);
		btnrentas.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnrentas.setBackground(new Color(56, 54, 41));
		btnrentas.setBounds(932, 0, 81, 23);
		panel_2.add(btnrentas);
		
		JButton btnTiposDeRentas = new JButton("<html>Tipos de habitaciones &#8594;</html>"); //Botón superior tipos de habitaciones
		btnTiposDeRentas.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
		btnTiposDeRentas.setForeground(new Color(255, 255, 255));
		btnTiposDeRentas.setBackground(new Color(56, 54, 41));
		btnTiposDeRentas.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnTiposDeRentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				TiposHabitacion conexion = new TiposHabitacion();
				conexion.frame.setVisible(true); 	
			}
		});
		btnTiposDeRentas.setBounds(1023, 0, 134, 23);
		btnTiposDeRentas.setBorderPainted(false);
        btnTiposDeRentas.setFocusPainted(false);
        btnTiposDeRentas.setContentAreaFilled(true);
		panel_2.add(btnTiposDeRentas);
		ImageIcon icon3 = new ImageIcon(getClass().getResource("/images/usuario.png"));
        Image imagen3 = icon3.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/informacion.png"));
        Image imagen2 = icon2.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);

		JButton botonVolver = new JButton(""); // Boton para volver atrás
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(255, 255, 255));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setContentAreaFilled(true);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				TiposHabitacion conexion = new TiposHabitacion();
				conexion.frame.setVisible(true); 	
			}
		});
		botonVolver.setBounds(60, 132, 36, 36);
		ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
        Image imagen4 = icon4.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        botonVolver.setIcon(new ImageIcon(imagen4));
		panel.add(botonVolver);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Jost*", Font.BOLD, 24));
		lblNewLabel.setBounds(141, 193, 250, 40);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(192, 192, 192));
		textField.setBounds(141, 244, 250, 40);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		lblNewLabel_1.setFont(new Font("Jost*", Font.BOLD, 24));
		lblNewLabel_1.setBounds(141, 295, 250, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Capacidad máxima:");
		lblNewLabel_2.setFont(new Font("Jost*", Font.BOLD, 24));
		lblNewLabel_2.setBounds(470, 193, 350, 40);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(192, 192, 192));
		textField_2.setBounds(470, 244, 250, 40);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Precio por noche:");
		lblNewLabel_3.setFont(new Font("Jost*", Font.BOLD, 24));
		lblNewLabel_3.setBounds(470, 295, 240, 40);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(192, 192, 192));
		textField_3.setBounds(470, 346, 250, 40);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBackground(new Color(192, 192, 192));
		textArea.setBounds(141, 364, 250, 100);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("Crear habitación");
		btnNewButton.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBackground(new Color(255, 214, 10));
		btnNewButton.setBounds(870, 580, 250, 40);
		btnNewButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		panel.add(btnNewButton);
	}
}
