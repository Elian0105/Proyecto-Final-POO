package visual;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class PanelPlanesServicios extends JPanel {
	private JTable tablePlanes;
	private JTable tableServicios;
	private JButton btnPlanes;
	private JButton btnServicios;
	private JButton btnNuevoPlan;
	private JButton btnNuevoServicio;
	private JButton btnEliminar;
	private JScrollPane scrollPlanes;
	private JScrollPane scrollServicios;

	/**
	 * Create the panel.
	 */
	public PanelPlanesServicios() {
		setSize(1000, 650);
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Planes y servicios");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(30, 20, 400, 45);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Administra los planes y servicios disponibles de Altice.");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 70, 650, 25);
		add(lblNewLabel_1);

		btnPlanes = new JButton("Planes");
		btnPlanes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPlanes(true);
			}
		});
		btnPlanes.setFont(new Font("Arial", Font.BOLD, 15));
		btnPlanes.setFocusPainted(false);
		btnPlanes.setBorderPainted(false);
		btnPlanes.setOpaque(true);
		btnPlanes.setBounds(30, 115, 130, 42);
		add(btnPlanes);

		btnServicios = new JButton("Servicios");
		btnServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPlanes(false);
			}
		});
		btnServicios.setFont(new Font("Arial", Font.BOLD, 15));
		btnServicios.setFocusPainted(false);
		btnServicios.setBorderPainted(false);
		btnServicios.setOpaque(true);
		btnServicios.setBounds(160, 115, 130, 42);
		add(btnServicios);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(30, 157, 940, 2);
		add(separator);

		btnNuevoPlan = new JButton("Nuevo plan");
		btnNuevoPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBoton(btnNuevoPlan);
				
				RegPlan ventana = new RegPlan();
				
				ventana.setVisible(true);
				ventana.setModal(true);
			}
		});
		btnNuevoPlan.setFont(new Font("Arial", Font.BOLD, 15));
		btnNuevoPlan.setFocusPainted(false);
		btnNuevoPlan.setOpaque(true);
		btnNuevoPlan.setBorder(new LineBorder(Color.BLACK, 2));
		btnNuevoPlan.setBounds(30, 180, 170, 45);
		add(btnNuevoPlan);

		btnNuevoServicio = new JButton("Nuevo servicio");
		btnNuevoServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBoton(btnNuevoServicio);
				
				RegServicio ventana = new RegServicio();
				
				ventana.setVisible(true);
				ventana.setModal(true);
			}
		});
		btnNuevoServicio.setFont(new Font("Arial", Font.BOLD, 15));
		btnNuevoServicio.setFocusPainted(false);
		btnNuevoServicio.setOpaque(true);
		btnNuevoServicio.setBorder(new LineBorder(Color.BLACK, 2));
		btnNuevoServicio.setBounds(215, 180, 200, 45);
		add(btnNuevoServicio);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBoton(btnEliminar);
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEliminar.setFocusPainted(false);
		btnEliminar.setOpaque(true);
		btnEliminar.setBorder(new LineBorder(Color.BLACK, 2));
		btnEliminar.setBounds(430, 180, 150, 45);
		add(btnEliminar);

		scrollPlanes = new JScrollPane();
		scrollPlanes.setBounds(30, 245, 940, 370);
		scrollPlanes.getViewport().setBackground(Color.WHITE);
		scrollPlanes.setBorder(new LineBorder(new Color(204, 204, 204)));
		add(scrollPlanes);

		tablePlanes = new JTable();
		tablePlanes.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Código", "Nombre", "Servicios", "Descuento", "Precio mensual"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablePlanes.getColumnModel().getColumn(0).setPreferredWidth(120);
		tablePlanes.getColumnModel().getColumn(1).setPreferredWidth(190);
		tablePlanes.getColumnModel().getColumn(2).setPreferredWidth(270);
		tablePlanes.getColumnModel().getColumn(3).setPreferredWidth(130);
		tablePlanes.getColumnModel().getColumn(4).setPreferredWidth(170);
		darEstiloTabla(tablePlanes);
		scrollPlanes.setViewportView(tablePlanes);

		scrollServicios = new JScrollPane();
		scrollServicios.setBounds(30, 245, 940, 370);
		scrollServicios.getViewport().setBackground(Color.WHITE);
		scrollServicios.setBorder(new LineBorder(new Color(204, 204, 204)));
		add(scrollServicios);

		tableServicios = new JTable();
		tableServicios.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Código", "Tipo", "Nombre", "Descripción", "Precio"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableServicios.getColumnModel().getColumn(0).setPreferredWidth(110);
		tableServicios.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableServicios.getColumnModel().getColumn(2).setPreferredWidth(200);
		tableServicios.getColumnModel().getColumn(3).setPreferredWidth(330);
		tableServicios.getColumnModel().getColumn(4).setPreferredWidth(130);
		darEstiloTabla(tableServicios);
		scrollServicios.setViewportView(tableServicios);

		mostrarPlanes(true);
		marcarBoton(btnNuevoPlan);
	}

	private void mostrarPlanes(boolean planes) {
		scrollPlanes.setVisible(planes);
		scrollServicios.setVisible(!planes);
		if(planes) {
			btnPlanes.setBackground(Color.BLACK);
			btnPlanes.setForeground(Color.WHITE);
			btnServicios.setBackground(Color.WHITE);
			btnServicios.setForeground(Color.BLACK);
		}
		else {
			btnServicios.setBackground(Color.BLACK);
			btnServicios.setForeground(Color.WHITE);
			btnPlanes.setBackground(Color.WHITE);
			btnPlanes.setForeground(Color.BLACK);
		}
	}

	private void marcarBoton(JButton elegido) {
		btnNuevoPlan.setBackground(Color.WHITE);
		btnNuevoPlan.setForeground(Color.BLACK);
		btnNuevoServicio.setBackground(Color.WHITE);
		btnNuevoServicio.setForeground(Color.BLACK);
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setForeground(Color.BLACK);
		elegido.setBackground(Color.BLACK);
		elegido.setForeground(Color.WHITE);
	}

	private void darEstiloTabla(JTable tabla) {
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setFont(new Font("Arial", Font.PLAIN, 15));
		tabla.setRowHeight(40);
		tabla.setShowVerticalLines(false);
		tabla.setIntercellSpacing(new Dimension(0, 1));
		tabla.setGridColor(new Color(220, 220, 220));
		tabla.setSelectionBackground(new Color(238, 238, 238));
		tabla.setSelectionForeground(Color.BLACK);
		tabla.setFillsViewportHeight(true);

		DefaultTableCellRenderer celdas = new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, false, row, column);
				setBorder(new EmptyBorder(0, 15, 0, 0));
				return this;
			}
		};
		tabla.setDefaultRenderer(Object.class, celdas);

		JTableHeader encabezado = tabla.getTableHeader();
		encabezado.setReorderingAllowed(false);
		encabezado.setPreferredSize(new Dimension(940, 45));
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setBackground(Color.BLACK);
				setForeground(Color.WHITE);
				setFont(new Font("Arial", Font.BOLD, 15));
				setBorder(new EmptyBorder(0, 15, 0, 0));
				return this;
			}
		};
		encabezado.setDefaultRenderer(renderer);
	}
}