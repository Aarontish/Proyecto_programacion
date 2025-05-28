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
import javax.swing.JPasswordField; // Importar JPasswordField
import javax.swing.JOptionPane;     // Importar JOptionPane para mensajes
import javax.swing.SwingConstants; // Importar SwingConstants
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

// !!! IMPORTACIONES CRUCIALES PARA EL BACKEND !!!
import Dao.UsuarioDAO;         // Importar tu DAO de Usuario
import modelos.Usuario;         // Importar tu clase modelo Usuario
// Asume que tu clase Menu está en el paquete default o donde la tengas.
// Si la mueves a un paquete (ej. 'vistas'), la importarías así:
// import vistas.Menu; // Esta línea no es necesaria si este Login.java no abre el menú directamente

public class Login {

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel; // Para mostrar mensajes de error/éxito
    private UsuarioDAO usuarioDAO; // Instancia de tu DAO de Usuario

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // Configurar el Look and Feel también aquí para el lanzamiento directo
                    UIManager.setLookAndFeel(new FlatLightLaf());
                    UIManager.put("Button.arc", 90);

                    Login window = new Login();
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
    public Login() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 90); // Esquinas redondas
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        usuarioDAO = new UsuarioDAO(); // Inicializar el DAO aquí
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
        // CORREGIDO: new ImageIcon(getClass().getResource("/images/logo.png"));
        ImageIcon portada1 = new ImageIcon(getClass().getResource("/images/logo.png"));
        Image portada2 = portada1.getImage();
        Image portada3 = portada2.getScaledInstance(170, 95, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(portada3));
        panel_1.add(logo);

        JLabel Titulo = new JLabel("Registro/Iniciar sesión"); // Titulo
        Titulo.setForeground(new Color(255, 255, 255));
        Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
        Titulo.setBounds(180, 11, 410, 73);
        panel_1.add(Titulo);

        JButton botonSuperior1 = new JButton(""); // Boton usuario esquina superior derecha
        botonSuperior1.setBackground(new Color(0, 0, 0));
        botonSuperior1.setBorderPainted(false);
        botonSuperior1.setFocusPainted(false);
        botonSuperior1.setContentAreaFilled(true);
        botonSuperior1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acciones para el botón superior de usuario (ej. abrir perfil)
            }
        });
        botonSuperior1.setBounds(1098, 11, 56, 56);
        // CORREGIDO: new ImageIcon(getClass().getResource("/images/usuario.png"));
        ImageIcon c1 = new ImageIcon(getClass().getResource("/images/usuario.png"));
        Image c2 = c1.getImage();
        Image c3 = c2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        botonSuperior1.setIcon(new ImageIcon(c3));
        panel_1.add(botonSuperior1);

        JButton botonSuperior2 = new JButton(""); // Boton información esquina superior derecha
        botonSuperior2.setBackground(new Color(0, 0, 0));
        botonSuperior2.setBorderPainted(false);
        botonSuperior2.setFocusPainted(false);
        botonSuperior2.setContentAreaFilled(true);
        botonSuperior2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Acciones para el botón superior de información
            }
        });
        botonSuperior2.setBounds(1032, 11, 56, 56);
        // CORREGIDO: new ImageIcon(getClass().getResource("/images/informacion.png"));
        ImageIcon e1 = new ImageIcon(getClass().getResource("/images/informacion.png"));
        Image e2 = e1.getImage();
        Image e3 = e2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        botonSuperior2.setIcon(new ImageIcon(e3));
        panel_1.add(botonSuperior2);

        // --- Panel para el formulario de Login (reemplaza los botones grandes de antes) ---
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null); // Usaremos un layout nulo para posicionar
        loginPanel.setBackground(new Color(255, 255, 255));
        loginPanel.setBounds(380, 205, 400, 350); // Posición y tamaño del panel de login

        // Etiqueta de "Iniciar Sesión" (dentro del nuevo panel)
        JLabel loginTitle = new JLabel("Iniciar Sesión");
        loginTitle.setFont(new Font("Jost*", Font.BOLD, 30));
        loginTitle.setBounds(100, 20, 200, 40);
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
        doLoginButton.setBounds(125, 250, 150, 45);
        doLoginButton.setFocusPainted(false);
        doLoginButton.setBorderPainted(false);
        doLoginButton.setContentAreaFilled(true);
        doLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cierra la ventana actual del menú
				Menu conexion = new Menu();
				conexion.frame.setVisible(true); 	
            }
        });
        loginPanel.add(doLoginButton);

        // Etiqueta para mensajes de error/éxito
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED); // Inicialmente en rojo para errores
        messageLabel.setFont(new Font("Jost*", Font.PLAIN, 14));
        messageLabel.setBounds(50, 300, 300, 20);
        loginPanel.add(messageLabel);

        panel.add(loginPanel); // Añade el panel de login al panel principal del frame

        // Opcional: Botón/enlace para registrarse (abre otra ventana de registro)
        JButton registerLinkButton = new JButton("¿No tienes cuenta? Regístrate aquí");
        registerLinkButton.setFont(new Font("Jost*", Font.PLAIN, 14));
        registerLinkButton.setBorderPainted(false);
        registerLinkButton.setContentAreaFilled(false);
        registerLinkButton.setForeground(Color.BLUE);
        registerLinkButton.setBounds(77, 320, 250, 20); // Posición debajo del mensaje
        registerLinkButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(frame, "Funcionalidad de registro pendiente. Abre la ventana de registro.");

        });
        loginPanel.add(registerLinkButton);
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

        Usuario authenticatedUser = usuarioDAO.validarUsuario(username, password);

        if (authenticatedUser != null) {
            messageLabel.setForeground(Color.GREEN);
            messageLabel.setText("¡Login exitoso!");
            JOptionPane.showMessageDialog(frame, "Bienvenido, " + authenticatedUser.getNombreUsuario() + "!");

        } else {
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("Credenciales incorrectas. Intenta de nuevo.");
            // Opcional: JOptionPane.showMessageDialog(frame, "Credenciales incorrectas.");
        }
    }
}
