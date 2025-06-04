package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;

import Dao.ClienteDAO;
import modelos.Cliente;

// Importaciones para navegación
import ui.TiposHabitacion;
import ui.Rentas;
import ui.Clientes;
import ui.PanelHabitaciones1;
import ui.Tarifas;
import ui.Menu;

public class ClientesEliminar {

	public JFrame frame;
	private JTable tableClientes;
	private DefaultTableModel tableModel;
	private ClienteDAO clienteDAO;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					UIManager.put("Button.arc", 90);

					ClientesEliminar window = new ClientesEliminar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClientesEliminar() {
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
		panel_1.setBounds(0, 0, 1164, 95);
		panel_1.setBackground(new Color(0, 0, 0));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 95, 1164, 26);
		panel_2.setBackground(new Color(55, 54, 48));
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnTiposDeRentas = new JButton("<html>Tipos de habitaciones &#8594;</html>");
		btnTiposDeRentas.setFont(new Font("Jost* Medium", Font.PLAIN, 12));
		btnTiposDeRentas.setForeground(new Color(255, 255, 255));
		btnTiposDeRentas.setBackground(new Color(56, 54, 41));
		btnTiposDeRentas.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnTiposDeRentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TiposHabitacion tiposHabitacionWindow = new TiposHabitacion();
				tiposHabitacionWindow.frame.setVisible(true);
			}
		});
		btnTiposDeRentas.setBounds(1023, 0, 134, 23);
		btnTiposDeRentas.setBorderPainted(false);
        btnTiposDeRentas.setFocusPainted(false);
        btnTiposDeRentas.setContentAreaFilled(true);
		panel_2.add(btnTiposDeRentas);

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
				frame.dispose();
				Clientes clientesWindow = new Clientes();
				clientesWindow.frame.setVisible(true);
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

		JLabel logo = new JLabel("");
		logo.setBounds(0, 0, 170, 95);
		ImageIcon icon12 = new ImageIcon(getClass().getResource("/images/logo.png"));
        Image imagen12 = icon12.getImage().getScaledInstance(170, 95, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(imagen12));
		panel_1.add(logo);

		JLabel lblEliminarCliente = new JLabel("Eliminar Cliente");
		lblEliminarCliente.setForeground(new Color(255, 255, 255));
		lblEliminarCliente.setFont(new Font("Dialog", Font.BOLD, 36));
		lblEliminarCliente.setBounds(141, 31, 300, 33);
		panel_1.add(lblEliminarCliente);

		JButton botonVolver = new JButton("");
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(255, 255, 255));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setContentAreaFilled(true);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Clientes clientesWindow = new Clientes();
				clientesWindow.frame.setVisible(true);
			}
		});
		botonVolver.setBounds(59, 131, 50, 50);
		ImageIcon icon69 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
        Image imagen69 = icon69.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonVolver.setIcon(new ImageIcon(imagen69));
		panel.add(botonVolver);

		JLabel lblNewLabel = new JLabel("Selecciona el cliente a eliminar:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(107, 137, 500, 33);
		panel.add(lblNewLabel);

		String[] columnNames = { "ID Cliente", "Nombre", "Apellido", "Teléfono", "Email", "Fecha Registro" };
		tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
		tableClientes = new JTable(tableModel);
		tableClientes.setFont(new Font("Dialog", Font.PLAIN, 14));
		tableClientes.setRowHeight(25);
		tableClientes.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		tableClientes.getTableHeader().setBackground(new Color(55, 54, 48));
		tableClientes.getTableHeader().setForeground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(tableClientes);
		scrollPane.setBounds(107, 200, 800, 300);
		panel.add(scrollPane);

		cargarDatosTabla();

		JButton btnEliminarSeleccionado = new JButton("Eliminar Seleccionado");
		btnEliminarSeleccionado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableClientes.getSelectedRow();
				if (selectedRow >= 0) {
					int idCliente = (int) tableModel.getValueAt(selectedRow, 0);
					int confirm = JOptionPane.showConfirmDialog(frame, "¿Estás seguro de eliminar este cliente?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						if (clienteDAO.eliminarCliente(idCliente)) {
							JOptionPane.showMessageDialog(frame, "Cliente eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							cargarDatosTabla(); // Recargar la tabla después de eliminar
						} else {
							JOptionPane.showMessageDialog(frame, "Error al eliminar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Selecciona un cliente para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEliminarSeleccionado.setBackground(new Color(239, 35, 60));
		btnEliminarSeleccionado.setFont(new Font("Dialog", Font.BOLD, 20));
		btnEliminarSeleccionado.setForeground(Color.WHITE);
		btnEliminarSeleccionado.setBounds(400, 520, 250, 50);
		panel.add(btnEliminarSeleccionado);
	}

	private void cargarDatosTabla() {
		tableModel.setRowCount(0); // Limpia la tabla
		List<Cliente> clientes = clienteDAO.obtenerTodosLosClientes();
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
