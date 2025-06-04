package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import ui.TiposHabitacion; 
import ui.Rentas;
import ui.Clientes;
import ui.PanelHabitaciones1;
import ui.Tarifas;
import ui.Menu;

import Dao.TarifaDAO;
import modelos.Tarifa;

public class Creartarifa {

	public JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldPrecio;
	private JComboBox<String> comboBoxTipoTarifa;
    private TarifaDAO tarifaDAO;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					UIManager.put("Button.arc", 90);

					Creartarifa window = new Creartarifa();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Creartarifa() {
		try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 90);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tarifaDAO = new TarifaDAO();
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
				TiposHabitacion tiposHabitacionWindow = new TiposHabitacion(); // <-- Nombre de clase actualizado
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
		ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/logo.png"));
        Image imagen2 = icon2.getImage().getScaledInstance(170, 95, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(imagen2));
		panel_1.add(logo);

		JLabel lblTarifas = new JLabel("Crear Tarifa");
		lblTarifas.setForeground(new Color(255, 255, 255));
		lblTarifas.setFont(new Font("Dialog", Font.BOLD, 36));
		lblTarifas.setBounds(141, 31, 229, 33);
		panel_1.add(lblTarifas);

		JButton botonVolver = new JButton("");
		botonVolver.setForeground(new Color(255, 255, 255));
		botonVolver.setBackground(new Color(255, 255, 255));
		botonVolver.setBorderPainted(false);
		botonVolver.setFocusPainted(false);
		botonVolver.setContentAreaFilled(true);
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Tarifas tarifasWindow = new Tarifas();
				tarifasWindow.frame.setVisible(true);
			}
		});
		botonVolver.setBounds(59, 131, 50, 50);
		ImageIcon icon42 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
        Image imagen42 = icon42.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonVolver.setIcon(new ImageIcon(imagen42));
		panel.add(botonVolver);

		JLabel lblEditarTarifas = new JLabel("Crear tarifa:");
		lblEditarTarifas.setForeground(new Color(0, 0, 0));
		lblEditarTarifas.setFont(new Font("Dialog", Font.BOLD, 30));
		lblEditarTarifas.setBounds(108, 143, 289, 33);
		panel.add(lblEditarTarifas);

		JLabel lblNombre = new JLabel("Tipo de Tarifa:");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNombre.setBounds(108, 223, 289, 33);
		panel.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		textFieldNombre.setBounds(108, 266, 212, 33);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descuento (%):");
		lblDescripcion.setForeground(Color.BLACK);
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 30));
		lblDescripcion.setBounds(108, 323, 289, 33);
		panel.add(lblDescripcion);

		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setFont(new Font("Dialog", Font.BOLD, 16));
		textFieldDescripcion.setBounds(108, 374, 212, 33);
		panel.add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio Base:");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 30));
		lblPrecio.setBounds(440, 323, 289, 33);
		panel.add(lblPrecio);

		textFieldPrecio = new JTextField();
		textFieldPrecio.setFont(new Font("Dialog", Font.BOLD, 16));
		textFieldPrecio.setBounds(440, 366, 255, 33);
		panel.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBounds(967, 517, 170, 50);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Tarifas tarifasWindow = new Tarifas();
				tarifasWindow.frame.setVisible(true);
			}
		});
		panel.add(btnCancelar);

		JButton btnGuardarCambios = new JButton("Crear tarifa");
		btnGuardarCambios.setForeground(Color.WHITE);
		btnGuardarCambios.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		btnGuardarCambios.setBackground(new Color(255, 214, 10));
		btnGuardarCambios.setBounds(967, 592, 170, 50);
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoTarifa = textFieldNombre.getText().trim();
				String descuentoStr = textFieldDescripcion.getText().trim();
				String precioStr = textFieldPrecio.getText().trim();

				if (tipoTarifa.isEmpty() || precioStr.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Los campos 'Tipo de Tarifa' y 'Precio Base' son obligatorios.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
					return;
				}

				double precioBase;
				try {
					precioBase = Double.parseDouble(precioStr);
					if (precioBase <= 0) {
						JOptionPane.showMessageDialog(frame, "El 'Precio Base' debe ser un número positivo.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
						return;
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "El 'Precio Base' debe ser un número válido.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
					return;
				}

				double descuentoPorcentaje = 0.0;
				if (!descuentoStr.isEmpty()) {
					try {
						descuentoPorcentaje = Double.parseDouble(descuentoStr);
						if (descuentoPorcentaje < 0 || descuentoPorcentaje > 100) {
							JOptionPane.showMessageDialog(frame, "El 'Descuento' debe ser un número entre 0 y 100.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
							return;
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(frame, "El 'Descuento' debe ser un número válido.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}

				Tarifa nuevaTarifa = new Tarifa(0, tipoTarifa, precioBase, descuentoPorcentaje, null, null);

				if (tarifaDAO.createTarifa(nuevaTarifa)) {
					JOptionPane.showMessageDialog(frame, "Tarifa creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					Tarifas tarifasWindow = new Tarifas();
					tarifasWindow.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Error al crear la tarifa. Puede que el tipo de tarifa ya exista.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnGuardarCambios);
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
