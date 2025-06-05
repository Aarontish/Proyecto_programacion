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
import javax.swing.JTextField;
import javax.swing.JPasswordField; 
import javax.swing.JOptionPane;     
import javax.swing.SwingConstants; 
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;


import Dao.UsuarioDAO;          
import modelos.Usuario;         
import ui.Menu; 

public class Registro {
	/*En caso de que les salga un error solo cambien la letra registro por Registro, 
	 * por alguna razone el github no marca como mofidicacion el cambio de La r por la R mayuscula
	 */
    JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;
    private UsuarioDAO usuarioDAO; 
    private JPasswordField passwordField_1;

  
    

    public Registro() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 0); // Esquinas redondas
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        usuarioDAO = new UsuarioDAO(); // Inicializar el DAO aquí
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

        JPanel panel_1 = new JPanel(); // Borde negro
        panel_1.setBackground(new Color(0, 0, 0));
        panel_1.setBounds(0, 0, 1164, 95);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JPanel panel_2 = new JPanel(); // Borde gris
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
        JButton botonVolver = new JButton(""); // Boton para volver atrás
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(255, 255, 255));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setContentAreaFilled(true);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // Cierra la ventana actual del menú
				PantallaInicioORegistro conexion = new PantallaInicioORegistro();
				conexion.frame.setVisible(true); 
              
			}
		});
		botonVolver.setBounds(60, 132, 50, 50);
		ImageIcon f1 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
		Image f2 = f1.getImage();
		Image f3 = f2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonVolver.setIcon(new ImageIcon(f3));
		panel.add(botonVolver);
		
        JLabel Titulo = new JLabel("Registro/Iniciar sesión"); // Titulo
        Titulo.setForeground(new Color(255, 255, 255));
        Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
        Titulo.setBounds(180, 11, 410, 73);
        panel_1.add(Titulo);
        ImageIcon c1 = new ImageIcon(getClass().getResource("/images/usuario.png"));
        Image c2 = c1.getImage();
        Image c3 = c2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        ImageIcon e1 = new ImageIcon(getClass().getResource("/images/informacion.png"));
        Image e2 = e1.getImage();
        Image e3 = e2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);

        
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null); 
        loginPanel.setBackground(new Color(255, 255, 255));
        loginPanel.setBounds(380, 205, 400, 420);

        // Etiqueta de "Iniciar Sesión" (dentro del nuevo panel)
        JLabel loginTitle = new JLabel("Registro\r\n");
        loginTitle.setFont(new Font("Dialog", Font.BOLD, 32));
        loginTitle.setBounds(119, 10, 200, 40);
        loginPanel.add(loginTitle);

        // Campo de Usuario
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setFont(new Font("Jost*", Font.PLAIN, 18));
        userLabel.setBounds(50, 80, 100, 30);
        loginPanel.add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(50, 115, 300, 35);
        usernameField.setFont(new Font("Jost*", Font.PLAIN, 16));
        loginPanel.add(usernameField);

        // Campo de Contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setFont(new Font("Jost*", Font.PLAIN, 18));
        passwordLabel.setBounds(50, 160, 150, 30);
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(50, 195, 300, 35);
        passwordField.setFont(new Font("Jost*", Font.PLAIN, 16));
        loginPanel.add(passwordField);

        // Botón de Login (el que realmente enviará las credenciales)
        JButton doLoginButton = new JButton("Ingresar");
        doLoginButton.setBackground(new Color(255, 214, 10));
        doLoginButton.setForeground(new Color(0, 0, 0));
        doLoginButton.setFont(new Font("Jost*", Font.BOLD, 20));
        doLoginButton.setBounds(127, 348, 150, 45);
        doLoginButton.setFocusPainted(false);
        doLoginButton.setBorderPainted(false);
        doLoginButton.setContentAreaFilled(true);
        doLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        loginPanel.add(doLoginButton);


        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED); // Inicialmente en rojo para errores
        messageLabel.setFont(new Font("Jost*", Font.PLAIN, 14));
        messageLabel.setBounds(50, 300, 300, 20);
        loginPanel.add(messageLabel);

        panel.add(loginPanel);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setFont(new Font("Dialog", Font.PLAIN, 16));
        passwordField_1.setBounds(50, 279, 300, 35);
        loginPanel.add(passwordField_1);
        
        JLabel lblConfirmarContrasena = new JLabel("Confirmar contraseña:\r\n");
        lblConfirmarContrasena.setFont(new Font("Dialog", Font.PLAIN, 18));
        lblConfirmarContrasena.setBounds(50, 240, 269, 30);
        loginPanel.add(lblConfirmarContrasena);
    }
    

    // --- Lógica del Login ---
    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword()); // Obtiene la contraseña como String

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Por favor, ingresa usuario y contraseña.");
            return;
        }


        Usuario authenticatedUser = usuarioDAO.login(username, password);

        if (authenticatedUser != null) {
            messageLabel.setForeground(Color.GREEN);
            messageLabel.setText("¡Login exitoso!");
            JOptionPane.showMessageDialog(frame, "Bienvenido, " + authenticatedUser.getNombreUsuario() + "!", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);

            frame.dispose(); // Cierra la ventana actual del login
            Menu menuWindow = new Menu(); // Abre la ventana del menú principal
            menuWindow.frame.setVisible(true);

        } else {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Credenciales incorrectas. Intenta de nuevo.");
            JOptionPane.showMessageDialog(frame, "Credenciales incorrectas.", "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
    }
}
