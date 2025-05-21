import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		
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
		
		JLabel logo = new JLabel(""); //Logo
		logo.setBounds(0, 0, 170, 95);
		 ImageIcon portada1 =new ImageIcon("images/logo.png");
	        Image portada2= portada1.getImage();
	        Image portada3=portada2.getScaledInstance(170, 95,Image.SCALE_SMOOTH);
	        logo.setIcon(new ImageIcon(portada3));
		panel_1.add(logo);
		
		JLabel Titulo = new JLabel("Registro/Iniciar sesión"); //Titulo 
		Titulo.setForeground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
		Titulo.setBounds(180, 11, 410, 73);
		panel_1.add(Titulo);
		
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
		
		JButton botonLogin = new JButton(""); //Boton de login
		botonLogin.setBackground(new Color(255, 214, 10)); 
		botonLogin.setForeground(new Color(255, 255, 255));
		botonLogin.setBorderPainted(false);
		botonLogin.setFocusPainted(false);
		botonLogin.setContentAreaFilled(true);
		botonLogin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});

		botonLogin.setBounds(132, 205, 300, 250); //Fondo del boton 
		ImageIcon p1 = new ImageIcon("images/usuario.png");
		Image p2 = p1.getImage();
		Image p3 = p2.getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
		botonLogin.setIcon(new ImageIcon(p3));
		
		panel.add(botonLogin);
		
		JButton botonRegistro = new JButton(""); //Boton de registro
		botonRegistro.setForeground(new Color(0, 0, 0));
		botonRegistro.setBackground(new Color(0, 0, 0));
		botonLogin.setBorderPainted(false);
		botonLogin.setFocusPainted(false);
		botonLogin.setContentAreaFilled(true);
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonRegistro.setBounds(732, 205, 300, 250);
		ImageIcon d1 = new ImageIcon("images/usuario.png");
		Image d2 = d1.getImage();
		Image d3 = d2.getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
		botonRegistro.setIcon(new ImageIcon(d3));
		panel.add(botonRegistro);
		
		JLabel textoIniciarSesion = new JLabel("Iniciar Sesión"); //Texto iniciar sesión
		textoIniciarSesion.setFont(new Font("Jost*", Font.BOLD, 30));
		textoIniciarSesion.setBounds(188, 466, 188, 50);
		panel.add(textoIniciarSesion);
		
		JLabel textoRegistro = new JLabel("Registrarse"); // Texto registrarse
		textoRegistro.setFont(new Font("Jost*", Font.BOLD, 30));
		textoRegistro.setBounds(805, 466, 157, 50);
		panel.add(textoRegistro);

	}
}
