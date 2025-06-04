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
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import Dao.ClienteDAO;
import modelos.Cliente;

import ui.TiposHabitacion;
import ui.Rentas;
import ui.PanelHabitaciones1;
import ui.Tarifas;
import ui.Menu;
import ui.CrearNuevoCliente;
import ui.EditarClienteFormulario;
import ui.ClientesEliminar; 

public class Clientes {

	public JFrame frame;
	private JTextField textFieldBuscar;
	private JTable tableClientes;
	private DefaultTableModel tableModel;
	private ClienteDAO clienteDAO;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					UIManager.put("Button.arc", 90);

					Clientes window = new Clientes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Clientes() {
		try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 90);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        clienteDAO = new ClienteDAO();
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
		ImageIcon icon12 = new ImageIcon(getClass().getResource("/images/logo.png"));
        Image imagen12 = icon12.getImage().getScaledInstance(170, 95, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(imagen12));
		panel_1.add(logo);

		JLabel Titulo = new JLabel("Clientes");
		Titulo.setForeground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
		Titulo.setBounds(180, 11, 410, 73);
		panel_1.add(Titulo);

		JLabel menuTitulo = new JLabel("Clientes:");
		menuTitulo.setFont(new Font("Jost*", Font.BOLD, 38));
		menuTitulo.setBounds(131, 126, 245, 56);
		panel.add(menuTitulo);

		JButton botonSuperior1 = new JButton("");
		botonSuperior1.setBackground(new Color(0, 0, 0));
		botonSuperior1.setBorderPainted(false);
		botonSuperior1.setFocusPainted(false);
		botonSuperior1.setContentAreaFilled(true);
		botonSuperior1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción para el botón de usuario superior
			}
		});
		botonSuperior1.setBounds(1098, 11, 56, 56);
		ImageIcon icon14 = new ImageIcon(getClass().getResource("/images/usuario.png"));
        Image imagen14 = icon14.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        botonSuperior1.setIcon(new ImageIcon(imagen14));
		panel_1.add(botonSuperior1);

		JButton botonSuperior2 = new JButton("");
		botonSuperior2.setBackground(new Color(0, 0, 0));
		botonSuperior2.setBorderPainted(false);
		botonSuperior2.setFocusPainted(false);
		botonSuperior2.setContentAreaFilled(true);
		botonSuperior2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Acción para el botón de información superior
			}
		});
		botonSuperior2.setBounds(1032, 11, 56, 56);
		ImageIcon icon13 = new ImageIcon(getClass().getResource("/images/informacion.png"));
        Image imagen13 = icon13.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        botonSuperior2.setIcon(new ImageIcon(imagen13));
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
				Menu menuWindow = new Menu();
				menuWindow.frame.setVisible(true);
			}
		});
		botonVolver.setBounds(60, 132, 36, 36);
		ImageIcon icon69 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
        Image imagen69 = icon69.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonVolver.setIcon(new ImageIcon(imagen69));
		panel.add(botonVolver);

		// --- BOTONES DE NAVEGACIÓN SUPERIOR ---
		JButton btnTiposDeHabitaciones = new JButton("<html>Tipos de habitaciones &#8594;</html>");
		btnTiposDeHabitaciones.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
		btnTiposDeHabitaciones.setForeground(new Color(255, 255, 255));
		btnTiposDeHabitaciones.setBackground(new Color(56, 54, 41));
		btnTiposDeHabitaciones.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnTiposDeHabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TiposHabitacion tiposHabitacionWindow = new TiposHabitacion();
				tiposHabitacionWindow.frame.setVisible(true);
			}
		});
		btnTiposDeHabitaciones.setBounds(1023, 0, 134, 23);
		btnTiposDeHabitaciones.setBorderPainted(false);
        btnTiposDeHabitaciones.setFocusPainted(false);
        btnTiposDeHabitaciones.setContentAreaFilled(true);
		panel_2.add(btnTiposDeHabitaciones);

		JButton btnrentas = new JButton("<html>Rentas &#8594;</html>");
		btnrentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Rentas rentasWindow = new Rentas();
				rentasWindow.frame.setVisible(true);
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

		JButton btnclientes = new JButton("<html>Clientes &#8594;</html>");
		btnclientes.setForeground(Color.WHITE);
		btnclientes.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
		btnclientes.setFocusPainted(false);
		btnclientes.setContentAreaFilled(true);
		btnclientes.setBorderPainted(false);
		btnclientes.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnclientes.setBackground(new Color(56, 54, 41));
		btnclientes.setBounds(841, 0, 81, 23);
		btnclientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Ya estás en Clientes
			}
		});
		panel_2.add(btnclientes);

		JButton btnhabitaciones = new JButton("<html>Habitaciones &#8594;</html>");
		btnhabitaciones.setForeground(Color.WHITE);
		btnhabitaciones.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
		btnhabitaciones.setFocusPainted(false);
		btnhabitaciones.setContentAreaFilled(true);
		btnhabitaciones.setBorderPainted(false);
		btnhabitaciones.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnhabitaciones.setBackground(new Color(56, 54, 41));
		btnhabitaciones.setBounds(731, 0, 100, 23);
		btnhabitaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PanelHabitaciones1 habitacionesWindow = new PanelHabitaciones1();
				habitacionesWindow.frame.setVisible(true);
			}
		});
		panel_2.add(btnhabitaciones);

		JButton btntarifas = new JButton("<html>Tarifas &#8594;</html>");
		btntarifas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Tarifas tarifasWindow = new Tarifas();
				tarifasWindow.frame.setVisible(true);
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

		// --- BARRA DE BÚSQUEDA ---
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtro = textFieldBuscar.getText().trim();
				// Si el filtro es el placeholder, no filtrar
				if (filtro.equals("BUSCAR")) {
					cargarDatosTabla(""); // Cargar todos los clientes
				} else {
					cargarDatosTabla(filtro); // Cargar clientes filtrados
				}
			}
		});
		btnBuscar.setBounds(720, 140, 40, 40);
		ImageIcon icon9 = new ImageIcon(getClass().getResource("/images/busqueda.png"));
        Image imagen9 = icon9.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		btnBuscar.setIcon(new ImageIcon(imagen9));
		btnBuscar.setBorderPainted(false);
		btnBuscar.setFocusPainted(false);
		btnBuscar.setContentAreaFilled(true);
		panel.add(btnBuscar);

		textFieldBuscar = new JTextField("BUSCAR");
		textFieldBuscar.setToolTipText("");
		textFieldBuscar.setBounds(770, 140, 290, 40);
		textFieldBuscar.setColumns(10);
		textFieldBuscar.setBackground(new Color(217, 217, 217));
        textFieldBuscar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
        textFieldBuscar.setForeground(Color.GRAY);
        final String placeholder = "BUSCAR";
        textFieldBuscar.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (textFieldBuscar.getText().equals(placeholder)) {
                    textFieldBuscar.setText("");
                    textFieldBuscar.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (textFieldBuscar.getText().isEmpty()) {
                    textFieldBuscar.setText(placeholder);
                    textFieldBuscar.setForeground(Color.GRAY);
                }
            }
        });
		panel.add(textFieldBuscar);

		// --- BOTONES DE ACCIÓN CRUD ---
		JButton btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.setBackground(new Color(239, 35, 60));
		btnEliminarCliente.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 24));
		btnEliminarCliente.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnEliminarCliente.setForeground(Color.WHITE);
		btnEliminarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableClientes.getSelectedRow();
				if (selectedRow >= 0) {
					int idCliente = (int) tableModel.getValueAt(selectedRow, 0);
					int confirm = JOptionPane.showConfirmDialog(frame, "¿Seguro de eliminar este cliente?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						if (clienteDAO.eliminarCliente(idCliente)) {
							JOptionPane.showMessageDialog(frame, "Cliente eliminado.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							cargarDatosTabla(""); // Recargar tabla
						} else {
							JOptionPane.showMessageDialog(frame, "Error al eliminar cliente.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Selecciona un cliente para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEliminarCliente.setBounds(131, 193, 245, 40);
		panel.add(btnEliminarCliente);

		JButton btnEditarCliente = new JButton("Editar Cliente");
		btnEditarCliente.setBackground(new Color(50, 186, 125));
		btnEditarCliente.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 24));
		btnEditarCliente.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnEditarCliente.setForeground(Color.WHITE);
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableClientes.getSelectedRow();
				if (selectedRow >= 0) {
					int idCliente = (int) tableModel.getValueAt(selectedRow, 0);
					frame.dispose();
					EditarClienteFormulario editarClienteWindow = new EditarClienteFormulario(idCliente);
					editarClienteWindow.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Selecciona un cliente para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEditarCliente.setBounds(388, 193, 245, 40);
		panel.add(btnEditarCliente);

		JButton btnCrearClienteNuevo = new JButton("Crear Cliente Nuevo");
		btnCrearClienteNuevo.setForeground(Color.DARK_GRAY);
		btnCrearClienteNuevo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		btnCrearClienteNuevo.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCrearClienteNuevo.setBackground(Color.YELLOW);
		btnCrearClienteNuevo.setBounds(645, 193, 280, 40);
		btnCrearClienteNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				CrearNuevoCliente crearClienteWindow = new CrearNuevoCliente();
				crearClienteWindow.frame.setVisible(true);
			}
		});
		panel.add(btnCrearClienteNuevo);

		// --- TABLA DE CLIENTES ---
		String[] columnNames = { "ID Cliente", "Nombre", "Apellido", "Teléfono", "Email", "Fecha Registro" };
		tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Las celdas no son editables directamente en la tabla
            }
        };
		tableClientes = new JTable(tableModel);
		tableClientes.setFont(new Font("Dialog", Font.PLAIN, 14));
		tableClientes.setRowHeight(25);
		tableClientes.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		tableClientes.getTableHeader().setBackground(new Color(55, 54, 48));
		tableClientes.getTableHeader().setForeground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(tableClientes);
		scrollPane.setBounds(131, 250, 950, 350);
		panel.add(scrollPane);

		cargarDatosTabla(""); // Cargar todos los clientes al inicio
	}

	private void cargarDatosTabla(String filtro) {
		tableModel.setRowCount(0); // Limpia la tabla

		List<Cliente> clientes;
		if (filtro != null && !filtro.isEmpty() && !filtro.equals("BUSCAR")) {
			// Obtener todos los clientes y luego filtrar en memoria (más simple para este caso)
			clientes = clienteDAO.obtenerTodosLosClientes();
			List<Cliente> clientesFiltrados = new java.util.ArrayList<>();
			for (Cliente c : clientes) {
				if (c.getNombre().toLowerCase().contains(filtro.toLowerCase()) ||
					c.getApellido().toLowerCase().contains(filtro.toLowerCase()) ||
					c.getEmail().toLowerCase().contains(filtro.toLowerCase()) ||
					c.getTelefono().toLowerCase().contains(filtro.toLowerCase())) {
					clientesFiltrados.add(c);
				}
			}
			clientes = clientesFiltrados;
		} else {
			clientes = clienteDAO.obtenerTodosLosClientes();
		}

		for (Cliente cliente : clientes) {
			tableModel.addRow(new Object[]{
				cliente.getIdCliente(),
				cliente.getNombre(),
				cliente.getApellido(),
				cliente.getTelefono(),
				cliente.getEmail(),
				cliente.getFechaRegistro()
			});
		}
	}

	public void dispose() {
		if (frame != null) {
			frame.dispose();
		}
	}

	public void setVisible(boolean b) {
		if (frame != null) {
			frame.setVisible(b);
		}
	}

	public JFrame getFrame() {
		return frame;
	}
}
