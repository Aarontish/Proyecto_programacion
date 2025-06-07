package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

import Dao.HabitacionDAO;
import Dao.TipoHabitacionDAO;
import modelos.Habitaciones;
import modelos.TiposHabitacionn;

public class CrearHabitacion2 {

    public JFrame frame;
    private JTextField textFieldNumeroHabitacion;
    private JComboBox<String> comboBoxTipoHabitacion;
    private JComboBox<String> comboBoxEstado;

    private HabitacionDAO habitacionDAO;
    private TipoHabitacionDAO tipoHabitacionDAO;

    public CrearHabitacion2() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put("Button.arc", 90);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        habitacionDAO = new HabitacionDAO();
        tipoHabitacionDAO = new TipoHabitacionDAO();
        initialize();
        populateTipoHabitacionComboBox();
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
        Image portada3 = portada2.getScaledInstance(170, 95, Image.SCALE_SMOOTH);
        logo.setIcon(new ImageIcon(portada3));
        panel_1.add(logo);

        JLabel Titulo = new JLabel("Crear Habitación");
        Titulo.setForeground(new Color(255, 255, 255));
        Titulo.setFont(new Font("Jost* Medium", Font.PLAIN, 35));
        Titulo.setBounds(180, 11, 410, 73);
        panel_1.add(Titulo);

        JLabel menuTitulo1 = new JLabel("Crear nueva habitación");
        menuTitulo1.setBackground(new Color(255, 255, 255));
        menuTitulo1.setFont(new Font("Jost*", Font.BOLD, 34));
        menuTitulo1.setBounds(131, 126, 579, 56);
        panel.add(menuTitulo1);

        JButton botonVolver = new JButton("");
        botonVolver.setForeground(new Color(255, 255, 255));
        botonVolver.setBackground(new Color(255, 255, 255));
        botonVolver.setBorderPainted(false);
        botonVolver.setFocusPainted(false);
        botonVolver.setContentAreaFilled(true);
        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PanelHabitaciones1 conexion = new PanelHabitaciones1();
                conexion.frame.setVisible(true);
                frame.dispose();
            }
        });
        botonVolver.setBounds(60, 132, 36, 36);
        ImageIcon icon4 = new ImageIcon(getClass().getResource("/images/flecha_izquierda.png"));
        Image imagen4 = icon4.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
        botonVolver.setIcon(new ImageIcon(imagen4));
        panel.add(botonVolver);

        JLabel lblNumeroHabitacion = new JLabel("Número de Habitación:");
        lblNumeroHabitacion.setFont(new Font("Jost*", Font.BOLD, 24));
        lblNumeroHabitacion.setBounds(141, 193, 300, 40);
        panel.add(lblNumeroHabitacion);

        textFieldNumeroHabitacion = new JTextField();
        textFieldNumeroHabitacion.setBackground(new Color(192, 192, 192));
        textFieldNumeroHabitacion.setBounds(141, 244, 250, 40);
        panel.add(textFieldNumeroHabitacion);
        textFieldNumeroHabitacion.setColumns(10);

        JLabel lblTipoHabitacion = new JLabel("Tipo de Habitación:");
        lblTipoHabitacion.setFont(new Font("Jost*", Font.BOLD, 24));
        lblTipoHabitacion.setBounds(141, 295, 300, 40);
        panel.add(lblTipoHabitacion);

        comboBoxTipoHabitacion = new JComboBox<>();
        comboBoxTipoHabitacion.setBackground(new Color(192, 192, 192));
        comboBoxTipoHabitacion.setBounds(141, 346, 250, 40);
        panel.add(comboBoxTipoHabitacion);

        JLabel lblEstado = new JLabel("Estado Inicial:");
        lblEstado.setFont(new Font("Jost*", Font.BOLD, 24));
        lblEstado.setBounds(141, 397, 250, 40);
        panel.add(lblEstado);

        comboBoxEstado = new JComboBox<>();
        comboBoxEstado.setBackground(new Color(192, 192, 192));
        comboBoxEstado.setBounds(141, 448, 250, 40);
        comboBoxEstado.setModel(new DefaultComboBoxModel<>(new String[]{"Disponible", "Ocupada", "Mantenimiento"}));
        panel.add(comboBoxEstado);

        JButton btnCrearHabitacion = new JButton("Crear Habitación");
        btnCrearHabitacion.setFont(new Font("Inter", Font.BOLD | Font.ITALIC, 20));
        btnCrearHabitacion.setBackground(new Color(255, 214, 10));
        btnCrearHabitacion.setBounds(870, 580, 250, 40);
        btnCrearHabitacion.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        btnCrearHabitacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroHabitacionStr = textFieldNumeroHabitacion.getText().trim();
                String tipoHabitacionNombre = (String) comboBoxTipoHabitacion.getSelectedItem();
                String estado = (String) comboBoxEstado.getSelectedItem();

                if (numeroHabitacionStr.isEmpty() || tipoHabitacionNombre == null || tipoHabitacionNombre.isEmpty() || "Seleccione Tipo de Habitación".equals(tipoHabitacionNombre) || estado == null || estado.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Todos los campos son obligatorios.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int numeroHabitacion = Integer.parseInt(numeroHabitacionStr);

                    TiposHabitacionn tipoHabitacionSeleccionado = tipoHabitacionDAO.getTipoHabitacionByName(tipoHabitacionNombre);
                    if (tipoHabitacionSeleccionado == null) {
                        JOptionPane.showMessageDialog(frame, "Tipo de habitación seleccionado no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Habitaciones nuevaHabitacion = new Habitaciones(0, numeroHabitacion, tipoHabitacionSeleccionado.getIdTipoHabitacion(), estado);

                    if (habitacionDAO.createHabitacion(nuevaHabitacion)) {
                        JOptionPane.showMessageDialog(frame, "Habitación creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        textFieldNumeroHabitacion.setText("");
                        comboBoxTipoHabitacion.setSelectedIndex(0);
                        comboBoxEstado.setSelectedIndex(0);
                        frame.dispose();
                        PanelHabitaciones1 panelHabitacionesWindow = new PanelHabitaciones1();
                        panelHabitacionesWindow.frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Error al crear la habitación. El número de habitación podría ya existir o hay un problema en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "El número de habitación debe ser un número válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(btnCrearHabitacion);
    }

    private void populateTipoHabitacionComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Seleccione Tipo de Habitación");
        List<TiposHabitacionn> tipos = tipoHabitacionDAO.getAllTiposHabitacion();
        if (tipos != null) {
            for (TiposHabitacionn tipo : tipos) {
                model.addElement(tipo.getNombreTipo());
            }
        }
        comboBoxTipoHabitacion.setModel(model);
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
