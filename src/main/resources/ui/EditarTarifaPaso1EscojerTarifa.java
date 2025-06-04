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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

//NOTA:
/* LA IDEA  CIAN, EN ESTA PANTALLA ES QUE PRIMERO SE ESCOJA LA CELDA QUE SE DESEA EDITAR PARA QUE ASI TE 
 * lleve ala pantalla de edicion de datos la pantalla editar ya esta creada se ocupa crear una tabla 
 * estatica para que no se pueda editar desde la misma tabla.
 * y que igual se guarden estos datos en la base de datos.
 * 
 */

public class EditarTarifaPaso1EscojerTarifa {

	JFrame frame;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarTarifaPaso1EscojerTarifa window = new EditarTarifaPaso1EscojerTarifa();
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
	public EditarTarifaPaso1EscojerTarifa() {
		try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 0); // Esquinas redondas
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
		panel_1.setBounds(0, 0, 1164, 95);
		panel_1.setBackground(new Color(0, 0, 0));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel(); //Borde gris
		panel_2.setBounds(0, 95, 1164, 26);
		panel_2.setBackground(new Color(55, 54, 48));
		panel.add(panel_2);
		panel_2.setLayout(null);

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

		JButton btntarifas = new JButton("<html>Tarifas &#8594;</html>"); //Botón superior tarifas
		btntarifas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aquí podrías abrir la ventana de Tarifas
				frame.dispose(); // Cierra la ventana actual del menú
				Tarifas conexion = new Tarifas();
				conexion.frame.setVisible(true); 	
				
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

		JLabel logo = new JLabel(""); //Logo
		logo.setBounds(0, 0, 170, 95);
		// CORRECCIÓN: Usar getResource para cargar la imagen
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/logo.png"));
        Image imagen2 = icon2.getImage().getScaledInstance(170, 95, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(imagen2));
		panel_1.add(logo);
		
		JLabel lblTarifas = new JLabel("Tarifas");
		lblTarifas.setForeground(new Color(255, 255, 255));
		lblTarifas.setFont(new Font("Dialog", Font.BOLD, 36));
		lblTarifas.setBounds(141, 31, 229, 33);
		panel_1.add(lblTarifas);
		
		JButton botonVolver = new JButton(""); // Boton para volver atrás
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(255, 255, 255));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setContentAreaFilled(true);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonVolver.setBounds(59, 131, 50, 50);
		ImageIcon icon42 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
        Image imagen42 = icon42.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonVolver.setIcon(new ImageIcon(imagen42));
		panel.add(botonVolver);
		
		JLabel lblNewLabel = new JLabel("Editar tarifa:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(107, 137, 246, 33);
		panel.add(lblNewLabel);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(50, 186, 125));
		btnEditar.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEditar.setBounds(105, 190, 155, 50);
		panel.add(btnEditar);
		
		//tabla con datos x,
		String[] columnNames = { "Tipo de Tarifa", "Precio", "Condiciones" };
		Object[][] data = {
		    { "Estándar", "$10", "Sin restricciones" },
		    { "Premium", "$20", "Acceso a todos los servicios" },
		    { "Económica", "$5", "Restringido en horarios" },
		};
		//configuracion de la tabla como fuentes de texto tamano color et
		table_1 = new JTable(data, columnNames);
		table_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		table_1.setRowHeight(25); 
		table_1.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16)); 
		table_1.getTableHeader().setBackground(new Color(55, 54, 48)); 
		table_1.getTableHeader().setForeground(Color.WHITE); 

		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(107, 250, 800, 300);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Para poder editar una celda de click encima de la celda que desea editar.\r\n");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setBounds(275, 213, 544, 13);
		panel.add(lblNewLabel_1);

		//boton de regresar accion:
		JButton meButton = new JButton("<html>Rentas &#8594;</html>"); //Botón superior rentas
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aquí podrías abrir la ventana de Rentas
				frame.dispose(); // Cierra la ventana actual del menú
				Tarifas conexion = new Tarifas();
				conexion.frame.setVisible(true); 	
			}
		});
		
	}
}
