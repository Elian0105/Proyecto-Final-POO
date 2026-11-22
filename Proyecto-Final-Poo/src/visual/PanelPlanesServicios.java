package visual;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class PanelPlanesServicios extends JPanel {
	private JTable tablePlanes;
	private JTable tableServicios;

	/**
	 * Create the panel.
	 */
	public PanelPlanesServicios() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setSize(1000, 650);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Planes y servicios");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(35, 20, 400, 40);
		add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 15));
		tabbedPane.setBounds(35, 115, 920, 485);
		add(tabbedPane);
		
		JPanel panelPlanes = new JPanel();
		panelPlanes.setBackground(Color.WHITE);
		tabbedPane.addTab("Planes", null, panelPlanes, null);
		panelPlanes.setLayout(null);
		
		JButton btnNuevoPlan = new JButton("+ Nuevo plan");
		btnNuevoPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevoPlan.setForeground(Color.BLACK);
		btnNuevoPlan.setBackground(Color.WHITE);
		btnNuevoPlan.setFont(new Font("Arial", Font.BOLD, 15));
		
		btnNuevoPlan.setBackground(Color.BLACK);
		btnNuevoPlan.setForeground(Color.WHITE);
		btnNuevoPlan.setOpaque(true);
		btnNuevoPlan.setContentAreaFilled(true);
		btnNuevoPlan.setBorderPainted(false);
		btnNuevoPlan.setFocusPainted(false);
		
		btnNuevoPlan.setBounds(650, 20, 210, 42);
		panelPlanes.add(btnNuevoPlan);
		
		JButton btnEliminarPlan = new JButton("Eliminar");
		btnEliminarPlan.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminarPlan.setForeground(Color.BLACK);
		btnEliminarPlan.setBackground(Color.WHITE);
		btnEliminarPlan.setBounds(500, 20, 135, 42);
		panelPlanes.add(btnEliminarPlan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 90, 870, 342);
		panelPlanes.add(scrollPane);
		
		tablePlanes = new JTable();
		tablePlanes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePlanes.setFont(new Font("Arial", Font.PLAIN, 15));
		tablePlanes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Servicios", "Descuento", "Precio Mensual"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		tablePlanes.setRowHeight(30);
		tablePlanes.getColumnModel().getColumn(0).setPreferredWidth(110);
		tablePlanes.getColumnModel().getColumn(0).setMinWidth(80);
		tablePlanes.getColumnModel().getColumn(0).setMaxWidth(180);
		tablePlanes.getColumnModel().getColumn(1).setPreferredWidth(190);
		tablePlanes.getColumnModel().getColumn(1).setMinWidth(120);
		tablePlanes.getColumnModel().getColumn(1).setMaxWidth(300);
		tablePlanes.getColumnModel().getColumn(2).setPreferredWidth(250);
		tablePlanes.getColumnModel().getColumn(2).setMinWidth(150);
		tablePlanes.getColumnModel().getColumn(2).setMaxWidth(400);
		tablePlanes.getColumnModel().getColumn(3).setPreferredWidth(120);
		tablePlanes.getColumnModel().getColumn(3).setMinWidth(90);
		tablePlanes.getColumnModel().getColumn(3).setMaxWidth(180);
		tablePlanes.getColumnModel().getColumn(4).setPreferredWidth(180);
		tablePlanes.getColumnModel().getColumn(4).setMinWidth(120);
		tablePlanes.getColumnModel().getColumn(4).setMaxWidth(250);
		scrollPane.setViewportView(tablePlanes);
		
		JTableHeader encabezado = tablePlanes.getTableHeader();
		
		encabezado.setBackground(Color.BLACK);
		encabezado.setForeground(Color.WHITE);
		encabezado.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JPanel panelServicios = new JPanel();
		panelServicios.setBackground(Color.WHITE);
		tabbedPane.addTab("Servicios", null, panelServicios, null);
		panelServicios.setLayout(null);
		
		JButton btnNuevoServicio = new JButton("+ Nuevo servicio");
		btnNuevoServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevoServicio.setForeground(Color.WHITE);
		btnNuevoServicio.setBackground(Color.BLACK);
		btnNuevoServicio.setFont(new Font("Arial", Font.BOLD, 15));
		
		btnNuevoServicio.setBackground(Color.BLACK);
		btnNuevoServicio.setForeground(Color.WHITE);
		btnNuevoServicio.setOpaque(true);
		btnNuevoServicio.setContentAreaFilled(true);
		btnNuevoServicio.setBorderPainted(false);
		btnNuevoServicio.setFocusPainted(false);
		btnNuevoServicio.setBounds(650, 20, 210, 42);
		panelServicios.add(btnNuevoServicio);
		
		JButton btnEliminarServicio = new JButton("Eliminar");
		btnEliminarServicio.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminarServicio.setForeground(Color.BLACK);
		btnEliminarServicio.setBackground(Color.WHITE);
		btnEliminarServicio.setBounds(500, 20, 135, 42);
		panelServicios.add(btnEliminarServicio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 90, 870, 342);
		panelServicios.add(scrollPane_1);
		
		tableServicios = new JTable();
		tableServicios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Tipo", "Nombre", "Descripci\u00F3n"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableServicios.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableServicios.getColumnModel().getColumn(0).setMinWidth(80);
		tableServicios.getColumnModel().getColumn(0).setMaxWidth(180);
		tableServicios.getColumnModel().getColumn(1).setPreferredWidth(160);
		tableServicios.getColumnModel().getColumn(1).setMinWidth(100);
		tableServicios.getColumnModel().getColumn(1).setMaxWidth(250);
		tableServicios.getColumnModel().getColumn(2).setPreferredWidth(230);
		tableServicios.getColumnModel().getColumn(2).setMinWidth(130);
		tableServicios.getColumnModel().getColumn(2).setMaxWidth(350);
		tableServicios.getColumnModel().getColumn(3).setPreferredWidth(360);
		tableServicios.getColumnModel().getColumn(3).setMinWidth(180);
		tableServicios.getColumnModel().getColumn(3).setMaxWidth(500);
		scrollPane_1.setViewportView(tableServicios);
		
		tableServicios.setRowHeight(30);
		JTableHeader encabezadoServicios = tableServicios.getTableHeader();
		
		encabezadoServicios.setBackground(Color.BLACK);
		encabezadoServicios.setForeground(Color.WHITE);
		encabezadoServicios.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Administra los planes y servicios disponibles de Altice.");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(35, 60, 650, 25);
		add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(35, 95, 920, 2);
		add(separator);

	}
}
