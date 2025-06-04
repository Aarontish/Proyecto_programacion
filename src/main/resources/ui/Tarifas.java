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
import javax.swing.table.TableColumnModel;

import com.formdev.flatlaf.FlatLightLaf;

import Dao.TarifaDAO;
import modelos.Tarifa;

import ui.TiposHabitacion;
import ui.Rentas;
import ui.Clientes;
import ui.PanelHabitaciones1;
import ui.Menu;
import ui.Creartarifa; 
import ui.EditarTarifaFormulario; 

public class Tarifas {

	public JFrame frame;
	private JTextField textFieldBuscar;
	private JTable tableTarifas;
	private DefaultTableModel tableModel;
	private TarifaDAO tarifaDAO;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatLightLaf());
					UIManager.put("Button.arc", 90);

					Tarifas window = new Tarifas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tarifas() {
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

		JLabel Titulo = new JLabel("Tarifas");
		Titulo.setForeground(new Color(255, 255, 255));
		Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
		Titulo.setBounds(180, 11, 410, 73);
		panel_1.add(Titulo);

		JLabel menuTitulo = new JLabel("Tipos de tarifas:");
		menuTitulo.setFont(new Font("Jost*", Font.BOLD, 38));
		menuTitulo.setBounds(131, 126, 400, 56);
		panel.add(menuTitulo);

		JButton botonSuperior1 = new JButton("");
		botonSuperior1.setBackground(new Color(0, 0, 0));
		botonSuperior1.setBorderPainted(false);
		botonSuperior1.setFocusPainted(false);
		botonSuperior1.setContentAreaFilled(true);
		botonSuperior1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String filtro = textFieldBuscar.getText().trim();
				if (filtro.equals("BUSCAR")) {
					cargarDatosTabla(""); 
				} else {
					cargarDatosTabla(filtro); 
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

		JButton btnEliminarTarifa = new JButton("Eliminar");
		btnEliminarTarifa.setBackground(new Color(239, 35, 60));
		btnEliminarTarifa.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 24));
		btnEliminarTarifa.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnEliminarTarifa.setForeground(Color.WHITE);
		btnEliminarTarifa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableTarifas.getSelectedRow();
				if (selectedRow >= 0) {
					int idTarifa = (int) tableModel.getValueAt(selectedRow, 0);
					int confirm = JOptionPane.showConfirmDialog(frame, "¿Seguro de eliminar esta tarifa?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						if (tarifaDAO.deleteTarifa(idTarifa)) {
							JOptionPane.showMessageDialog(frame, "Tarifa eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							cargarDatosTabla("");
						} else {
							JOptionPane.showMessageDialog(frame, "Error al eliminar la tarifa.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Selecciona una tarifa para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEliminarTarifa.setBounds(131, 193, 150, 40);
		panel.add(btnEliminarTarifa);

		JButton btnEditarTarifa = new JButton("Editar");
		btnEditarTarifa.setBackground(new Color(50, 186, 125));
		btnEditarTarifa.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 24));
		btnEditarTarifa.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnEditarTarifa.setForeground(Color.WHITE);
		btnEditarTarifa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = tableTarifas.getSelectedRow();
				if (selectedRow >= 0) {
					int idTarifa = (int) tableModel.getValueAt(selectedRow, 0);
					frame.dispose();
					EditarTarifaFormulario editarTarifaWindow = new EditarTarifaFormulario(idTarifa);
					editarTarifaWindow.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Selecciona una tarifa para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnEditarTarifa.setBounds(291, 193, 150, 40);
		panel.add(btnEditarTarifa);

		JButton btnCrearTarifaNueva = new JButton("Crear");
		btnCrearTarifaNueva.setForeground(Color.DARK_GRAY);
		btnCrearTarifaNueva.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		btnCrearTarifaNueva.setBorder(BorderFactory.createLineBorder(Color.BLACK,0));
		btnCrearTarifaNueva.setBackground(Color.YELLOW);
		btnCrearTarifaNueva.setBounds(451, 193, 150, 40);
		btnCrearTarifaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Creartarifa crearTarifaWindow = new Creartarifa();
				crearTarifaWindow.frame.setVisible(true);
			}
		});
		panel.add(btnCrearTarifaNueva);

		String[] columnNames = { "ID Tarifa", "Tipo de Tarifa", "Precio", "Condiciones" }; 
		tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
		tableTarifas = new JTable(tableModel);
		tableTarifas.setFont(new Font("Dialog", Font.PLAIN, 14));
		tableTarifas.setRowHeight(25);
		tableTarifas.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 16));
		tableTarifas.getTableHeader().setBackground(new Color(55, 54, 48));
		tableTarifas.getTableHeader().setForeground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(tableTarifas);
		scrollPane.setBounds(131, 250, 950, 350);
		panel.add(scrollPane);

        TableColumnModel tcm = tableTarifas.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));

		cargarDatosTabla(""); 
	}

	private void cargarDatosTabla(String filtro) {
		tableModel.setRowCount(0);

		List<Tarifa> tarifas;
		if (filtro != null && !filtro.isEmpty() && !filtro.equals("BUSCAR")) {
			tarifas = tarifaDAO.getTarifasByTipoHabitacion(filtro);
		} else {
			tarifas = tarifaDAO.getAllTarifas();
		}

		for (Tarifa tarifa : tarifas) {
			String condiciones = "";
			switch (tarifa.getTipoHabitacion().toLowerCase()) {
				case "reembolsable":
					condiciones = "Cancelable";
					break;
				case "no reembolsable":
					condiciones = "No Cancelable";
					break;
				case "promocional":
					condiciones = "Solo temporada";
					break;
				case "corporativa":
					condiciones = "Empresa";
					break;
				default:
					if (tarifa.getDescuentoPorcentaje() > 0) {
						condiciones = "Con descuento: " + tarifa.getDescuentoPorcentaje() + "%";
					} else {
						condiciones = "Sin descuento";
					}
					break;
			}

			tableModel.addRow(new Object[]{
				tarifa.getIdTarifa(),
				tarifa.getTipoHabitacion(),
				String.format("$ %.2f MXN", tarifa.getPrecioBase()),
				condiciones
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
