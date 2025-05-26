package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JTextField;

public class datos_de_usuario {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					datos_de_usuario window = new datos_de_usuario();
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
	public datos_de_usuario() {
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
		// CORREGIDO: new ImageIcon(getClass().getResource("/images/logo.png"));
		ImageIcon portada1 = new ImageIcon(getClass().getResource("/images/logo.png"));
	    Image portada2 = portada1.getImage();
	    Image portada3 = portada2.getScaledInstance(170, 95,Image.SCALE_SMOOTH);
	    logo.setIcon(new ImageIcon(portada3));
		panel_1.add(logo);

		JLabel Titulo = new JLabel("Panel de clientes:"); //Titulo
		Titulo.setForeground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
		Titulo.setBounds(180, 11, 410, 73);
		panel_1.add(Titulo);

		JLabel menuTitulo = new JLabel("Datos de usuario:\r\n"); //Texto menú
		menuTitulo.setFont(new Font("Jost*", Font.BOLD, 38));
		menuTitulo.setBounds(131, 126, 441, 56);
		panel.add(menuTitulo);

		JButton botonSuperior1 = new JButton(""); //Boton usuario esquina superior derecha
		botonSuperior1.setBackground(new Color(0, 0, 0));
		botonSuperior1.setBorderPainted(false);
		botonSuperior1.setFocusPainted(false);
		botonSuperior1.setContentAreaFilled(true);
		botonSuperior1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonSuperior1.setBounds(1098, 11, 56, 56);
		// CORREGIDO: new ImageIcon(getClass().getResource("/images/usuario.png"));
		ImageIcon c1 = new ImageIcon(getClass().getResource("/images/usuario.png"));
		Image c2 = c1.getImage();
		Image c3 = c2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonSuperior1.setIcon(new ImageIcon(c3));
		panel_1.add(botonSuperior1);


		JButton botonSuperior2 = new JButton(""); //Boton información esquina superior derecha
		botonSuperior2.setBackground(new Color(0, 0, 0));
		botonSuperior2.setBorderPainted(false);
		botonSuperior2.setFocusPainted(false);
		botonSuperior2.setContentAreaFilled(true);
		botonSuperior2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonSuperior2.setBounds(1032, 11, 56, 56);
		// CORREGIDO: new ImageIcon(getClass().getResource("/images/informacion.png"));
		ImageIcon e1 = new ImageIcon(getClass().getResource("/images/informacion.png"));
		Image e2 = e1.getImage();
		Image e3 = e2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonSuperior2.setIcon(new ImageIcon(e3));
		panel_1.add(botonSuperior2);

		JButton botonVolver = new JButton(""); // Boton para volver atrás
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(255, 255, 255));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setContentAreaFilled(true);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				Clientes conexion = new Clientes();
				conexion.frame.setVisible(true); 	
			}
		});
		botonVolver.setBounds(60, 132, 50, 50);
		// CORREGIDO: new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
		ImageIcon f1 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
		Image f2 = f1.getImage();
		Image f3 = f2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonVolver.setIcon(new ImageIcon(f3));
		panel.add(botonVolver);

		JButton btnTiposDeRentas = new JButton("<html>Tipos de habitaciones &#8594;</html>"); //Botón superior tipos de habitaciones
		btnTiposDeRentas.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
		btnTiposDeRentas.setForeground(new Color(255, 255, 255));
		btnTiposDeRentas.setBackground(new Color(56, 54, 41));
		btnTiposDeRentas.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnTiposDeRentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTiposDeRentas.setBounds(1023, 0, 134, 23);
		btnTiposDeRentas.setBorderPainted(false);
        btnTiposDeRentas.setFocusPainted(false);
        btnTiposDeRentas.setContentAreaFilled(true);
		panel_2.add(btnTiposDeRentas);

		JButton btnrentas = new JButton("<html>Rentas &#8594;</html>"); //Botón superior rentas
		btnrentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		JButton btntarifas = new JButton("<html>Tarifas &#8594;</html>"); //Botón superior tarifas
		btntarifas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		// CORREGIDO: new ImageIcon(getClass().getResource("/images/busqueda.png"));
		ImageIcon u1 = new ImageIcon(getClass().getResource("/images/busqueda.png"));
		Image u2 = u1.getImage();
		Image u3 = u2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        final String placeholder = "BUSCAR";

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 187, 249));
		panel_3.setBounds(131, 193, 300, 440);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(45, 11, 200, 200);
		// CORREGIDO: new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/Images/usuario.png"));
        Image imagen1 = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(imagen1));
		panel_3.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID del cliente:\r\n");
		lblNewLabel_1.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(90, 222, 135, 20);
		panel_3.add(lblNewLabel_1);

		JLabel textoHabitacion = new JLabel("Nombre:");
		textoHabitacion.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 16));
		textoHabitacion.setBounds(120, 272, 145, 20);
		panel_3.add(textoHabitacion);

		JLabel lblNewLabel_3 = new JLabel("Correo:\r\n");
		lblNewLabel_3.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(120, 326, 60, 20);
		panel_3.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Telefono\r\n:");
		lblNewLabel_5.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(120, 368, 80, 20);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario#123\r\n");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(90, 252, 135, 20);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblJoseReyes = new JLabel("Jose reyes  verdugo");
		lblJoseReyes.setForeground(Color.WHITE);
		lblJoseReyes.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblJoseReyes.setBounds(75, 302, 160, 20);
		panel_3.add(lblJoseReyes);
		
		JLabel lblNewLabel_3_1 = new JLabel("Lobitodomado@yahoo.com");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3_1.setBounds(45, 353, 220, 20);
		panel_3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("624 420 6969");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3_1_1.setBounds(110, 398, 115, 20);
		panel_3.add(lblNewLabel_3_1_1);

		JButton btnHistorial = new JButton("Editar cliente");
		btnHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				Editar_datos_de_cliente conexion = new Editar_datos_de_cliente();
				conexion.frame.setVisible(true); 	
			}
		});
		btnHistorial.setBackground(new Color(50, 186, 124));
		btnHistorial.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 24));
		btnHistorial.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnHistorial.setBounds(856, 573, 270, 60);
		panel.add(btnHistorial);
		
		JLabel menuTitulo_1 = new JLabel("Historial de rentas:\r\n");
		menuTitulo_1.setFont(new Font("Dialog", Font.BOLD, 28));
		menuTitulo_1.setBounds(441, 192, 277, 56);
		panel.add(menuTitulo_1);
		
		JLabel menuTitulo_1_1_1 = new JLabel("Habitaciones rentadas:\r\n");
		menuTitulo_1_1_1.setFont(new Font("Dialog", Font.BOLD, 28));
		menuTitulo_1_1_1.setBounds(441, 408, 335, 56);
		panel.add(menuTitulo_1_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(441, 258, 308, 38);
		panel.add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Renta 14: dia 15 mayo 2024");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(lblNewLabel_2);
		
		JButton panel_4_1 = new JButton();
		panel_4_1.setBounds(441, 312, 308, 38);
		panel.add(panel_4_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Renta 14: dia 15 mayo 2024");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4_1.add(lblNewLabel_2_1);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setBounds(441, 360, 308, 38);
		panel.add(panel_4_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Renta 14: dia 15 mayo 2024");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4_1_1.add(lblNewLabel_2_1_1);
		
		JPanel panel_4_1_1_1 = new JPanel();
		panel_4_1_1_1.setBounds(441, 474, 308, 38);
		panel.add(panel_4_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Renta 14: habitacion normal\r\n");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JPanel panel_4_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1.setBounds(441, 529, 308, 38);
		panel.add(panel_4_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Renta 13: habitacion suit");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4_1_1_1_1.add(lblNewLabel_2_1_1_1_1);
		
		JPanel panel_4_1_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1_1.setBounds(441, 583, 308, 38);
		panel.add(panel_4_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Renta 12: habitacion suit");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4_1_1_1_1_1.add(lblNewLabel_2_1_1_1_1_1);
		
		JButton btnDescargarHistorial = new JButton("Descargar historial ");
		btnDescargarHistorial.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		btnDescargarHistorial.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnDescargarHistorial.setBackground(new Color(255, 214, 10));
		btnDescargarHistorial.setBounds(856, 474, 270, 60);
		panel.add(btnDescargarHistorial);
	}
}
