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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelHabitaciones1 {

	JFrame frame;
	private JTextField textField;
	private String v3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelHabitaciones1 window = new PanelHabitaciones1();
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
	public PanelHabitaciones1() {
		
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
		ImageIcon icon423 = new ImageIcon(getClass().getResource("/images/logo.png"));
        Image imagen423 = icon423.getImage().getScaledInstance(170, 95, Image.SCALE_SMOOTH);
	        logo.setIcon(new ImageIcon(imagen423));
		panel_1.add(logo);
		
		JLabel Titulo = new JLabel("Panel de Habitaciones"); //Titulo 
		Titulo.setForeground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
		Titulo.setBounds(180, 11, 410, 73);
		panel_1.add(Titulo);
		
		JLabel menuTitulo = new JLabel("Habitaciones:"); //Texto menú
		menuTitulo.setFont(new Font("Jost*", Font.BOLD, 38));
		menuTitulo.setBounds(131, 126, 283, 56);
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
		ImageIcon icon69 = new ImageIcon(getClass().getResource("/images/usuario.png"));
        Image imagen69 = icon69.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		botonSuperior1.setIcon(new ImageIcon(imagen69));
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
		ImageIcon icon79 = new ImageIcon(getClass().getResource("/images/informacion.png"));
        Image imagen79 = icon79.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		botonSuperior2.setIcon(new ImageIcon(imagen79));
		panel_1.add(botonSuperior2);
		
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
		botonVolver.setBounds(60, 132, 50, 50);
		ImageIcon icon42 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
        Image imagen42 = icon42.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonVolver.setIcon(new ImageIcon(imagen42));
		panel.add(botonVolver);
		JButton btnHabitaciones = new JButton("<html>Rentas &#8594;</html>"); //Botón superior rentas
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aquí podrías abrir la ventana de Rentas
				frame.dispose(); // Cierra la ventana actual del menú
				Menu conexion = new Menu();
				conexion.frame.setVisible(true); 	
			}
		});
		
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
		btnclientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				Clientes conexion = new Clientes();
				conexion.frame.setVisible(true); 
			}
		});
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
		btnhabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				PanelHabitaciones1 conexion = new PanelHabitaciones1();
				conexion.frame.setVisible(true); 
			}
		});
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
		
		JButton btnBuscar = new JButton(""); //Boton para la barra de busqueda
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setBounds(720, 140, 40, 40);
		ImageIcon icon45 = new ImageIcon(getClass().getResource("/images/busqueda.png"));
        Image imagen56 = icon45.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        btnBuscar.setIcon(new ImageIcon(imagen56));
		btnBuscar.setBorderPainted(false);
		btnBuscar.setFocusPainted(false);
		btnBuscar.setContentAreaFilled(true);
		panel.add(btnBuscar);
		
		textField = new JTextField("BUSCAR"); //Texto de ejemplo
		textField.setToolTipText("");
		textField.setBounds(770, 140, 290, 40);
		textField.setColumns(10);
		textField.setBackground(new Color(217, 217, 217));
        textField.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
        textField.setForeground(Color.GRAY);
        final String placeholder = "BUSCAR"; //Borra el texto de ejemplo al escribir en el campo
        textField.addFocusListener(new FocusAdapter() {

            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
		panel.add(textField);	
		
		JButton btnEliminarCliente = new JButton("Eliminar habitacion"); //Botón prinicipal eliminar cliente
		btnEliminarCliente.setBackground(new Color(239, 35, 60));
		btnEliminarCliente.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 24));
		btnEliminarCliente.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnEliminarCliente.setForeground(Color.WHITE);
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				PanelHabitaciones2 conexion = new PanelHabitaciones2();
				conexion.frame.setVisible(true); 	
			}
		});
		btnEliminarCliente.setBounds(131, 193, 280, 40);
		panel.add(btnEliminarCliente);
		
		JButton btnCuartoA1 = new JButton("Cuarto A1"); //Botón Cuarto A1
		btnCuartoA1.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 14));
		btnCuartoA1.setBackground(new Color(0, 187, 249));
		btnCuartoA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				DetallesHabitacion1 conexion = new DetallesHabitacion1();
				conexion.frame.setVisible(true); 	
			}
		});
		
		btnCuartoA1.setBounds(131, 257, 150, 150);
		btnCuartoA1.setVerticalTextPosition(SwingConstants.BOTTOM); //Para poner texto debajo de la imagen dentro del botón
		btnCuartoA1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuartoA1.setHorizontalAlignment(SwingConstants.CENTER);
		btnCuartoA1.setVerticalAlignment(SwingConstants.CENTER);
		btnCuartoA1.setIconTextGap(1);
		btnCuartoA1.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
        Image imagen1 = icon1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        btnCuartoA1.setIcon(new ImageIcon(imagen1));
		panel.add(btnCuartoA1);
		
		JButton btnCuartoB1 = new JButton("Cuarto B1"); //Botón Cuarto B1
		btnCuartoB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCuartoB1.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 14));
		btnCuartoB1.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCuartoB1.setBackground(new Color(0, 187, 249));
		btnCuartoB1.setBounds(131, 455, 150, 150);
		btnCuartoB1.setVerticalTextPosition(SwingConstants.BOTTOM); //Para poner texto debajo de la imagen dentro del botón
		btnCuartoB1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuartoB1.setHorizontalAlignment(SwingConstants.CENTER);
		btnCuartoB1.setVerticalAlignment(SwingConstants.CENTER);
		btnCuartoB1.setIconTextGap(1);
		ImageIcon icon12 = new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
        Image imagen122 = icon1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        btnCuartoB1.setIcon(new ImageIcon(imagen1));
		panel.add(btnCuartoB1);
		
		JButton btnCuartoA2 = new JButton("Cuarto A2"); //Botón Cuarto A2
		btnCuartoA2.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 14));
		btnCuartoA2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCuartoA2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCuartoA2.setVerticalAlignment(SwingConstants.CENTER);
		btnCuartoA2.setIconTextGap(1);
		btnCuartoA2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuartoA2.setHorizontalAlignment(SwingConstants.CENTER);
		btnCuartoA2.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCuartoA2.setBackground(new Color(0, 187, 249));
		btnCuartoA2.setBounds(331, 257, 150, 150);
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
        Image imagen = icon1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        btnCuartoA2.setIcon(new ImageIcon(imagen1));
		panel.add(btnCuartoA2);
		
		JButton btnCuartoB2 = new JButton("Cuarto B2"); //Botón Cuarto B2
		btnCuartoB2.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 14));
		btnCuartoB2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCuartoB2.setVerticalAlignment(SwingConstants.CENTER);
		btnCuartoB2.setIconTextGap(1);
		btnCuartoB2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuartoB2.setHorizontalAlignment(SwingConstants.CENTER);
		btnCuartoB2.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCuartoB2.setBackground(new Color(0, 187, 249));
		btnCuartoB2.setBounds(331, 455, 150, 150);
		ImageIcon icon13 = new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
        Image imagen23 = icon1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        btnCuartoB2.setIcon(new ImageIcon(imagen1));
		panel.add(btnCuartoB2);
		
		JButton btnCuartoA3 = new JButton("Cuarto A3"); //Botón Cuarto A3
		btnCuartoA3.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 14));
		btnCuartoA3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCuartoA3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCuartoA3.setVerticalAlignment(SwingConstants.CENTER);
		btnCuartoA3.setIconTextGap(1);
		btnCuartoA3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuartoA3.setHorizontalAlignment(SwingConstants.CENTER);
		btnCuartoA3.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCuartoA3.setBackground(new Color(0, 187, 249));
		btnCuartoA3.setBounds(531, 257, 150, 150);
		ImageIcon icon44 = new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
        Image imagen44 = icon1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        btnCuartoA3.setIcon(new ImageIcon(imagen1));
		panel.add(btnCuartoA3);
		
		JButton btnCuartoA4 = new JButton("Cuarto A4"); //Botón Cuarto A4
		btnCuartoA4.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 14));
		btnCuartoA4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCuartoA4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCuartoA4.setVerticalAlignment(SwingConstants.CENTER);
		btnCuartoA4.setIconTextGap(1);
		btnCuartoA4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuartoA4.setHorizontalAlignment(SwingConstants.CENTER);
		btnCuartoA4.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCuartoA4.setBackground(new Color(0, 187, 249));
		btnCuartoA4.setBounds(731, 257, 150, 150);
		ImageIcon icon77 = new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
        Image imagen77 = icon1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        btnCuartoA4.setIcon(new ImageIcon(imagen1));
		panel.add(btnCuartoA4);
		
		JButton btnCuartoA5 = new JButton("Cuarto A5"); //Botón Cuarto A5
		btnCuartoA5.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 14));
		btnCuartoA5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCuartoA5.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCuartoA5.setVerticalAlignment(SwingConstants.CENTER);
		btnCuartoA5.setIconTextGap(1);
		btnCuartoA5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuartoA5.setHorizontalAlignment(SwingConstants.CENTER);
		btnCuartoA5.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCuartoA5.setBackground(new Color(0, 187, 249));
		btnCuartoA5.setBounds(931, 257, 150, 150);
		ImageIcon icon00 = new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
        Image imagen00 = icon1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        btnCuartoA5.setIcon(new ImageIcon(imagen1));
		panel.add(btnCuartoA5);
		
		JButton btnCuartoB3 = new JButton("Cuarto B3"); //Botón Cuarto B3
		btnCuartoB3.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 14));
		btnCuartoB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCuartoB3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCuartoB3.setVerticalAlignment(SwingConstants.CENTER);
		btnCuartoB3.setIconTextGap(1);
		btnCuartoB3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuartoB3.setHorizontalAlignment(SwingConstants.CENTER);
		btnCuartoB3.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCuartoB3.setBackground(new Color(0, 187, 249));
		btnCuartoB3.setBounds(531, 455, 150, 150);
		ImageIcon icon122 = new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
        Image imagen12 = icon12.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        btnCuartoB3.setIcon(new ImageIcon(imagen12));	
        panel.add(btnCuartoB3);
		
		JButton btnCuartoB4 = new JButton("Cuarto B4"); //Botón Cuarto B4
		btnCuartoB4.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 14));
		btnCuartoB4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCuartoB4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCuartoB4.setVerticalAlignment(SwingConstants.CENTER);
		btnCuartoB4.setIconTextGap(1);
		btnCuartoB4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuartoB4.setHorizontalAlignment(SwingConstants.CENTER);
		btnCuartoB4.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCuartoB4.setBackground(new Color(0, 187, 249));
		btnCuartoB4.setBounds(731, 455, 150, 150);
		ImageIcon icon11 = new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
        Image imagen11 = icon1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        btnCuartoB4.setIcon(new ImageIcon(imagen1));
		panel.add(btnCuartoB4);
		
		JButton btnCuartoB5 = new JButton("Cuarto B5"); //Botón Cuarto B5
		btnCuartoB5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCuartoB5.setFont(new Font("Jost*", Font.BOLD | Font.ITALIC, 14));
		btnCuartoB5.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCuartoB5.setVerticalAlignment(SwingConstants.CENTER);
		btnCuartoB5.setIconTextGap(1);
		btnCuartoB5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCuartoB5.setHorizontalAlignment(SwingConstants.CENTER);
		btnCuartoB5.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCuartoB5.setBackground(new Color(0, 187, 249));
		btnCuartoB5.setBounds(931, 455, 150, 150);
		ImageIcon icon99 = new ImageIcon(getClass().getResource("/images/cama_matrimonial2.png"));
        Image imagen99 = icon1.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        btnCuartoB5.setIcon(new ImageIcon(imagen1));
		panel.add(btnCuartoB5);
	}
}
