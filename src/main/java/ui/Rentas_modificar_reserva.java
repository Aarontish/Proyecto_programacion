package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Rentas_modificar_reserva {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rentas_modificar_reserva window = new Rentas_modificar_reserva();
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
	public Rentas_modificar_reserva() {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1164, 95);
		panel_1.setBackground(new Color(0, 0, 0));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 95, 1164, 26);
		panel_2.setBackground(new Color(55, 54, 48));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel logo = new JLabel(""); //Logo
		logo.setBounds(0, 0, 170, 95);
		 ImageIcon portada1 =new ImageIcon("images/logo.png");
	        Image portada2= portada1.getImage();
	        Image portada3=portada2.getScaledInstance(170, 95,Image.SCALE_SMOOTH);
	        logo.setIcon(new ImageIcon(portada3));
		panel_1.add(logo);
		
		JLabel Titulo = new JLabel("Rentas:\r\n"); //Titulo 
		Titulo.setForeground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
		Titulo.setBounds(180, 11, 410, 73);
		panel_1.add(Titulo);
		
		JLabel menuTitulo = new JLabel("modificar reserva:\r\n");
		menuTitulo.setBounds(131, 126, 335, 56);
		menuTitulo.setFont(new Font("Jost*", Font.BOLD, 38));
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
		ImageIcon c1 = new ImageIcon("images/usuario.png");
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
		ImageIcon e1 = new ImageIcon("images/informacion.png");
		Image e2 = e1.getImage();
		Image e3 = e2.getScaledInstance(36, 36, Image.SCALE_SMOOTH); 
		botonSuperior2.setIcon(new ImageIcon(e3));
		panel_1.add(botonSuperior2);
		
		JButton botonVolver = new JButton("");
		botonVolver.setBounds(60, 132, 50, 50);
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(255, 255, 255));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setContentAreaFilled(true);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				Datos_de_renta conexion = new Datos_de_renta();
				conexion.frame.setVisible(true); 	
			}
		});
		ImageIcon f1 = new ImageIcon("images/flecha_izquierda.png");
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
		ImageIcon u1 = new ImageIcon("images/busqueda.png");
		Image u2 = u1.getImage();
		Image u3 = u2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        final String placeholder = "BUSCAR";
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(79, 230, 439, 144);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(92, 89, 254, 45);
		panel_3.add(panel_5);
		panel_5.setBackground(Color.BLACK);
		panel_5.setLayout(null);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setLayout(null);
		panel_5_2.setBackground(Color.WHITE);
		panel_5_2.setBounds(10, 10, 234, 25);
		panel_5.add(panel_5_2);
		
		JLabel lblNewLabel = new JLabel("Dias de hospedaje: 4 dias\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 265, 29);
		panel_3.add(lblNewLabel);
		
		JLabel lblAumentar = new JLabel("Aumentar:\r\n");
		lblAumentar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAumentar.setBounds(10, 50, 265, 29);
		panel_3.add(lblAumentar);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton.setBounds(10, 89, 72, 45);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-\r\n");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_1.setBounds(357, 89, 72, 45);
		panel_3.add(btnNewButton_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(546, 230, 403, 127);
		panel.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblAgregarUnExtra = new JLabel("Agregar un extra:");
		lblAgregarUnExtra.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAgregarUnExtra.setBounds(21, 10, 265, 29);
		panel_3_1.add(lblAgregarUnExtra);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Desayuno extra", "", "Comida extra", "", "Cena extra", "", "Renta de consola", ""}));
		comboBox.setBounds(21, 76, 200, 41);
		panel_3_1.add(comboBox);
		
		JLabel lblExtra = new JLabel("Extra:\r\n");
		lblExtra.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblExtra.setBounds(21, 38, 265, 29);
		panel_3_1.add(lblExtra);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBounds(79, 425, 439, 144);
		panel.add(panel_3_2);
		
		JPanel panel_5_3 = new JPanel();
		panel_5_3.setLayout(null);
		panel_5_3.setBackground(Color.BLACK);
		panel_5_3.setBounds(92, 89, 254, 45);
		panel_3_2.add(panel_5_3);
		
		JPanel panel_5_2_1 = new JPanel();
		panel_5_2_1.setLayout(null);
		panel_5_2_1.setBackground(Color.WHITE);
		panel_5_2_1.setBounds(10, 10, 234, 25);
		panel_5_3.add(panel_5_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("Las habitaciones usadas son: 2\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 10, 336, 29);
		panel_3_2.add(lblNewLabel_2);
		
		JLabel lblAumentar_1 = new JLabel("Agregar mas:");
		lblAumentar_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAumentar_1.setBounds(10, 50, 265, 29);
		panel_3_2.add(lblAumentar_1);
		
		JButton btnNewButton_2 = new JButton("+");
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_2.setBounds(10, 89, 72, 45);
		panel_3_2.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("-");
		btnNewButton_2_1.setBackground(Color.RED);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewButton_2_1.setBounds(356, 89, 72, 45);
		panel_3_2.add(btnNewButton_2_1);
		
		JButton btnNewButton_3 = new JButton("Guardar cambios\r\n");
		btnNewButton_3.setBackground(new Color(50, 186, 124));
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_3.setBounds(189, 608, 211, 45);
		panel.add(btnNewButton_3);
		
		JButton btnEliminarCliente = new JButton("Eliminar Cliente"); //Botón prinicipal eliminar cliente
		btnEliminarCliente.setBackground(new Color(239, 35, 60));
		btnEliminarCliente.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 24));
		btnEliminarCliente.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnEliminarCliente.setForeground(Color.WHITE);
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
