package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import Dao.UsuarioDAO;
import modelos.Usuario;

public class PantallaInicioORegistro {

	JFrame frame;
	private UsuarioDAO usuarioDAO;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PantallaInicioORegistro() {
		try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 90);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        usuarioDAO = new UsuarioDAO();
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

		JPanel panel_1 = new JPanel(); // Borde negro superior
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 1164, 95);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel(); // Borde gris debajo del negro
		panel_2.setBackground(new Color(55, 54, 48));
		panel_2.setBounds(0, 95, 1164, 26);
		panel.add(panel_2);

		JLabel logo = new JLabel(""); // Logo
		logo.setBounds(0, 0, 170, 95);
		ImageIcon portada1 = new ImageIcon(getClass().getResource("/images/logo.png"));
		Image portada2 = portada1.getImage();
		Image portada3 = portada2.getScaledInstance(170, 95, Image.SCALE_SMOOTH);
		logo.setIcon(new ImageIcon(portada3));
		panel_1.add(logo);

		JLabel Titulo = new JLabel("Registro/Iniciar sesión"); // Titulo
		Titulo.setForeground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
		Titulo.setBounds(180, 11, 521, 73);
		panel_1.add(Titulo);
		
		
		JButton Iniciar_sesion = new JButton("\r\n");
		Iniciar_sesion.setBackground(new Color(255, 214, 10));
		Iniciar_sesion.setBounds(346, 193, 30, 30);
		ImageIcon icon121 = new ImageIcon(getClass().getResource("/images/usuario.png"));
        Image imagen121 = icon121.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Iniciar_sesion.setIcon(new ImageIcon(imagen121));
		Iniciar_sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				Login2 conexion = new Login2();
				conexion.frame.setVisible(true); 
			}
		});
		Iniciar_sesion.setBounds(87, 240, 350, 300);
		panel.add(Iniciar_sesion);
		
		JButton Registro = new JButton("");
		Registro.setBackground(new Color(0, 0, 0));
		ImageIcon icon23 = new ImageIcon(getClass().getResource("/images/usuario.png"));
        Image imagen23 = icon23.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        Registro.setIcon(new ImageIcon(imagen23));
		Registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose(); // Cierra la ventana actual del menú
				Registro conexion = new Registro();
				conexion.frame.setVisible(true); 
			}
		});
		Registro.setBounds(729, 240, 350, 300);
		panel.add(Registro);
		
		JLabel lblNewLabel = new JLabel("Iniciar sesión\r\n");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setBounds(176, 549, 200, 56);
		panel.add(lblNewLabel);
		
		JLabel lblRegistrarse = new JLabel("Registrarse\r\n");
		lblRegistrarse.setFont(new Font("Dialog", Font.BOLD, 25));
		lblRegistrarse.setBounds(839, 550, 209, 56);
		panel.add(lblRegistrarse);
	}
}
