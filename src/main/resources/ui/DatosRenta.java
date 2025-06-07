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
import java.time.format.DateTimeFormatter; // Para formatear fechas

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.SystemColor;

import com.formdev.flatlaf.FlatLightLaf;

import Dao.RentaDAO;
import Dao.HabitacionDAO;
import Dao.ClienteDAO;
import Dao.TipoHabitacionDAO; // Necesario para obtener el nombre del tipo de habitación

import modelos.modelorentas;
import modelos.Habitaciones;
import modelos.Cliente;
import modelos.TiposHabitacionn; // ✅ Correcto modelo
import ui.Menu;
import ui.Rentas;
import ui.TiposHabitacion;
import ui.Clientes;
import ui.PanelHabitaciones1;
import ui.Tarifas;
// Asumo que estas clases recibirán el ID de la renta
import ui.DatosRenta2; // Clase para liberar habitación
import ui.RentasModificarReserva; // Clase para modificar reserva

public class DatosRenta {

	JFrame frame;
	private JLabel menuTitulo; // ✅ Ahora correctamente declarado como atributo

	private JTextField searchField; 
    private int rentaId; 
    private RentaDAO rentaDAO;
    private HabitacionDAO habitacionDAO;
    private ClienteDAO clienteDAO;
    private TipoHabitacionDAO tipoHabitacionDAO;

    private JLabel lblNumeroHabitacion;
    private JLabel lblTipoHabitacion;
    private JLabel lblNumCamas;
    private JLabel lblOcupanteNombre;
    private JButton btnEstadoHabitacion;

	public DatosRenta(int rentalId) {
        this.rentaId = rentalId;
        this.rentaDAO = new RentaDAO();
        this.habitacionDAO = new HabitacionDAO();
        this.clienteDAO = new ClienteDAO();
        this.tipoHabitacionDAO = new TipoHabitacionDAO();
		initialize();
        loadRentalData();
	}

    public DatosRenta() {
        this(-1);
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

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 1164, 95);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(55, 54, 48));
		panel_2.setBounds(0, 95, 1164, 26);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(0, 0, 170, 95);
		ImageIcon portada1 = new ImageIcon(getClass().getResource("/images/logo.png"));
	    Image portada2 = portada1.getImage();
	    Image portada3 = portada2.getScaledInstance(170, 95,Image.SCALE_SMOOTH);
	    logo.setIcon(new ImageIcon(portada3));
		panel_1.add(logo);

		JLabel Titulo = new JLabel("Rentas");
		Titulo.setForeground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
		Titulo.setBounds(180, 11, 410, 73);
		panel_1.add(Titulo);

		menuTitulo = new JLabel("Detalles de la renta:"); // ✅ aquí corregido
		menuTitulo.setFont(new Font("Jost*", Font.BOLD, 38));
		menuTitulo.setBounds(131, 126, 475, 56);
		panel.add(menuTitulo);

		JButton botonSuperior1 = new JButton("");
		botonSuperior1.setBackground(new Color(0, 0, 0));
		botonSuperior1.setBorderPainted(false);
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
		botonSuperior2.setBorderPainted(false);
		botonSuperior2.setFocusPainted(false);
		botonSuperior2.setContentAreaFilled(true);
		botonSuperior2.setBounds(1032, 11, 56, 56);
		ImageIcon e1 = new ImageIcon(getClass().getResource("/images/informacion.png"));
		Image e2 = e1.getImage();
		Image e3 = e2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonSuperior2.setIcon(new ImageIcon(e3));
		panel_1.add(botonSuperior2);

		JButton botonVolver = new JButton("");
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(255, 255, 255));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setContentAreaFilled(true);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Rentas conexion = new Rentas();
				conexion.frame.setVisible(true);
			}
		});
		botonVolver.setBounds(60, 132, 50, 50);
		ImageIcon f1 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
		Image f2 = f1.getImage();
		Image f3 = f2.getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonVolver.setIcon(new ImageIcon(f3));
		panel.add(botonVolver);

		// botones de navegación se quedan igual
		// ...

		// omitiendo botones navegación inferior para no duplicar todo

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 187, 249));
		panel_3.setBounds(103, 228, 313, 422);
		panel.add(panel_3);
		panel_3.setLayout(null);

		// omitiendo detalles para no ser repetitivo

	}

    // ✅ Aquí los cambios importantes:
    private void loadRentalData() {
        if (rentaId == -1) {
            menuTitulo.setText("Error: No se encontró ID de renta.");
            return;
        }

        modelorentas renta = rentaDAO.getRentaById(rentaId); // ✅ Correcto tipo modelorentas

        if (renta != null) {
            menuTitulo.setText("Detalles de la renta: " + rentaId);

            Habitaciones habitacion = habitacionDAO.getHabitacionById(renta.getIdHabitacion());
            if (habitacion != null) {
                lblNumeroHabitacion.setText(habitacion.getNumero());
                lblNumCamas.setText(habitacion.getNumeroCamas() + " Camas");
                
                TiposHabitacionn tipoHabitacion = tipoHabitacionDAO.getTipoHabitacionById(habitacion.getIdTipoHabitacion()); // ✅ modelo correcto
                if (tipoHabitacion != null) {
                    lblTipoHabitacion.setText(tipoHabitacion.getNombreTipo()); // ✅ método correcto
                } else {
                    lblTipoHabitacion.setText("Tipo desconocido");
                }

                btnEstadoHabitacion.setText(habitacion.getEstado().toUpperCase());
                switch (habitacion.getEstado().toLowerCase()) {
                    case "disponible":
                        btnEstadoHabitacion.setBackground(new Color(50, 186, 124));
                        break;
                    case "ocupada":
                        btnEstadoHabitacion.setBackground(new Color(239, 35, 60));
                        break;
                    case "mantenimiento":
                        btnEstadoHabitacion.setBackground(SystemColor.activeCaptionBorder);
                        break;
                    default:
                        btnEstadoHabitacion.setBackground(new Color(0, 187, 249));
                        break;
                }
            } else {
                lblNumeroHabitacion.setText("Hab. no encontrada");
                lblTipoHabitacion.setText("N/A");
                lblNumCamas.setText("N/A");
                btnEstadoHabitacion.setText("ERROR");
                btnEstadoHabitacion.setBackground(Color.LIGHT_GRAY);
            }

            Cliente cliente = clienteDAO.obtenerClientePorId(renta.getIdCliente());
            if (cliente != null) {
                lblOcupanteNombre.setText(cliente.getNombre() + " " + cliente.getApellido());
            } else {
                lblOcupanteNombre.setText("Cliente no encontrado");
            }
        } else {
            menuTitulo.setText("Renta #" + rentaId + " no encontrada.");
            lblNumeroHabitacion.setText("N/A");
            lblTipoHabitacion.setText("N/A");
            lblNumCamas.setText("N/A");
            lblOcupanteNombre.setText("N/A");
            btnEstadoHabitacion.setText("ERROR");
            btnEstadoHabitacion.setBackground(Color.LIGHT_GRAY);
        }
    }
}
