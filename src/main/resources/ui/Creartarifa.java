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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import Dao.TarifaDAO;
import modelos.Tarifa;

import ui.TiposHabitacion;
import ui.Rentas;
import ui.Clientes;
import ui.PanelHabitaciones1;
import ui.Tarifas;
import ui.Menu;

public class Creartarifa {

	public JFrame frame;
	private JTextField textFieldNombreTarifa;
	private JTextField textFieldPrecioPorNoche;
	private JComboBox<String> comboBoxTipoTarifa;
	private JTextArea textAreaDescripcion;
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

		JLabel Titulo = new JLabel("Crear Tarifa");
		Titulo.setForeground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
		Titulo.setBounds(180, 11, 410, 73);
		panel_1.add(Titulo);

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
		botonVolver.setBounds(60, 132, 36, 36);
		ImageIcon icon69 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
        Image imagen69 = icon69.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
		botonVolver.setIcon(new ImageIcon(imagen69));
		panel.add(botonVolver);

		JLabel lblCrearTarifa = new JLabel("Crear tarifa");
		lblCrearTarifa.setFont(new Font("Jost*", Font.BOLD, 38));
		lblCrearTarifa.setBounds(131, 126, 400, 56);
		panel.add(lblCrearTarifa);

		JLabel lblNombreTarifa = new JLabel("Nombre:");
		lblNombreTarifa.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNombreTarifa.setBounds(100, 200, 300, 30);
		panel.add(lblNombreTarifa);

		textFieldNombreTarifa = new JTextField();
		textFieldNombreTarifa.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldNombreTarifa.setBounds(100, 240, 250, 35);
		panel.add(textFieldNombreTarifa);
		textFieldNombreTarifa.setColumns(10);

		JLabel lblTipoTarifa = new JLabel("Tipo:");
		lblTipoTarifa.setFont(new Font("Dialog", Font.BOLD, 24));
		lblTipoTarifa.setBounds(400, 200, 200, 30);
		panel.add(lblTipoTarifa);

		String[] tiposTarifa = {"Reembolsable", "No Reembolsable", "Corporativa", "Promocional"};
		comboBoxTipoTarifa = new JComboBox<>(tiposTarifa);
		comboBoxTipoTarifa.setFont(new Font("Dialog", Font.PLAIN, 16));
		comboBoxTipoTarifa.setBounds(400, 240, 250, 35);
		panel.add(comboBoxTipoTarifa);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Dialog", Font.BOLD, 24));
		lblDescripcion.setBounds(100, 300, 250, 30);
		panel.add(lblDescripcion);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setFont(new Font("Dialog", Font.PLAIN, 16));
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setWrapStyleWord(true);
		JScrollPane scrollPaneDescripcion = new JScrollPane(textAreaDescripcion);
		scrollPaneDescripcion.setBounds(100, 340, 250, 80);
		panel.add(scrollPaneDescripcion);

		JLabel lblPrecioPorNoche = new JLabel("Precio por noche:");
		lblPrecioPorNoche.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPrecioPorNoche.setBounds(400, 300, 250, 30);
		panel.add(lblPrecioPorNoche);

		textFieldPrecioPorNoche = new JTextField();
		textFieldPrecioPorNoche.setFont(new Font("Dialog", Font.PLAIN, 16));
		textFieldPrecioPorNoche.setBounds(400, 340, 250, 35);
		panel.add(textFieldPrecioPorNoche);
		textFieldPrecioPorNoche.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(239, 35, 60)); 
		btnCancelar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBounds(967, 517, 170, 50);
		btnCancelar.putClientProperty("FlatLaf.style", "arc: 0"); 
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Tarifas tarifasWindow = new Tarifas();
				tarifasWindow.frame.setVisible(true);
			}
		});
		panel.add(btnCancelar);

		JButton btnGuardarTarifa = new JButton("Crear");
		btnGuardarTarifa.setForeground(Color.DARK_GRAY);
		btnGuardarTarifa.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		btnGuardarTarifa.setBackground(Color.YELLOW); 
		btnGuardarTarifa.setBounds(967, 592, 170, 50);
		btnGuardarTarifa.putClientProperty("FlatLaf.style", "arc: 0"); 
		btnGuardarTarifa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreTarifa = textFieldNombreTarifa.getText().trim();
				String precioPorNocheStr = textFieldPrecioPorNoche.getText().trim();
				

				if (nombreTarifa.isEmpty() || precioPorNocheStr.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Los campos 'Nombre' y 'Precio por noche' son obligatorios.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
					return;
				}

				double precioPorNoche;
				try {
					precioPorNoche = Double.parseDouble(precioPorNocheStr);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Precio por noche debe ser un número válido.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (precioPorNoche < 0) {
					JOptionPane.showMessageDialog(frame, "Valores numéricos inválidos. Precio por noche no negativo.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
	
				Tarifa nuevaTarifa = new Tarifa(0, nombreTarifa, precioPorNoche, 0.0); 

				if (tarifaDAO.createTarifa(nuevaTarifa)) {
					JOptionPane.showMessageDialog(frame, "Tarifa creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					Tarifas tarifasWindow = new Tarifas();
					tarifasWindow.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Error al crear la tarifa.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnGuardarTarifa);
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