package visual;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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

	/**
	 * Create the panel.
	 */
	public PanelPlanesServicios() {
		setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setSize(1000, 650);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Planes y servicios");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(30, 20, 400, 45);
		add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 15));
		tabbedPane.setBounds(30, 130, 940, 480);
		add(tabbedPane);
		
		JPanel panelPlanes = new JPanel();
		panelPlanes.setBorder(null);
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
		
		btnNuevoPlan.setBounds(20, 20, 190, 45);
		panelPlanes.add(btnNuevoPlan);
		
		JButton btnEliminarPlan = new JButton("Eliminar");
		btnEliminarPlan.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminarPlan.setForeground(Color.BLACK);
		btnEliminarPlan.setBackground(Color.WHITE);
		btnEliminarPlan.setBounds(225, 20, 150, 45);
		panelPlanes.add(btnEliminarPlan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 85, 895, 335);
		panelPlanes.add(scrollPane);
		
		tablePlanes = new JTable();
		tablePlanes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePlanes.setFont(new Font("Arial", Font.PLAIN, 14));
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
		tablePlanes.getColumnModel().getColumn(0).setPreferredWidth(120);
		tablePlanes.getColumnModel().getColumn(0).setMinWidth(80);
		tablePlanes.getColumnModel().getColumn(0).setMaxWidth(180);
		tablePlanes.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablePlanes.getColumnModel().getColumn(1).setMinWidth(120);
		tablePlanes.getColumnModel().getColumn(1).setMaxWidth(300);
		tablePlanes.getColumnModel().getColumn(2).setPreferredWidth(260);
		tablePlanes.getColumnModel().getColumn(2).setMinWidth(150);
		tablePlanes.getColumnModel().getColumn(2).setMaxWidth(400);
		tablePlanes.getColumnModel().getColumn(3).setPreferredWidth(130);
		tablePlanes.getColumnModel().getColumn(3).setMinWidth(90);
		tablePlanes.getColumnModel().getColumn(3).setMaxWidth(180);
		tablePlanes.getColumnModel().getColumn(4).setPreferredWidth(185);
		tablePlanes.getColumnModel().getColumn(4).setMinWidth(120);
		tablePlanes.getColumnModel().getColumn(4).setMaxWidth(250);
		
		tablePlanes.setRowHeight(40);
		scrollPane.setViewportView(tablePlanes);
		
		JTableHeader encabezado = tablePlanes.getTableHeader();
		
		encabezado.setBackground(Color.BLACK);
		encabezado.setForeground(Color.WHITE);
		encabezado.setFont(new Font("Arial Black", Font.BOLD, 17));
		encabezado.setPreferredSize(new Dimension(895, 35));
		
		DefaultTableCellRenderer rendererPlanes = new DefaultTableCellRenderer();
		
		rendererPlanes.setBackground(Color.BLACK);
		rendererPlanes.setForeground(Color.WHITE);
		rendererPlanes.setHorizontalAlignment(JLabel.CENTER);
		rendererPlanes.setBorder(null);
		encabezado.setOpaque(true);
		
		encabezado.setDefaultRenderer(rendererPlanes);
		
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
		btnNuevoServicio.setBounds(20, 20, 210, 45);
		panelServicios.add(btnNuevoServicio);
		
		JButton btnEliminarServicio = new JButton("Eliminar");
		btnEliminarServicio.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminarServicio.setForeground(Color.BLACK);
		btnEliminarServicio.setBackground(Color.WHITE);
		btnEliminarServicio.setBounds(245, 20, 150, 45);
		panelServicios.add(btnEliminarServicio);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 85, 895, 335);
		panelServicios.add(scrollPane_1);
		
		tableServicios = new JTable();
		tableServicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableServicios.setShowVerticalLines(false);
		tableServicios.setShowHorizontalLines(false);
		tableServicios.setFont(new Font("Arial", Font.PLAIN, 14));
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
		
		tableServicios.setRowHeight(40);
		JTableHeader encabezadoServicios = tableServicios.getTableHeader();
		
		encabezadoServicios.setBackground(Color.BLACK);
		encabezadoServicios.setForeground(Color.WHITE);
		encabezadoServicios.setFont(new Font("Arial Black", Font.BOLD, 17));
		encabezadoServicios.setPreferredSize(new Dimension(895, 35));
		
		DefaultTableCellRenderer rendererServicios = new DefaultTableCellRenderer();
		
		rendererServicios.setBackground(Color.BLACK);
		rendererServicios.setForeground(Color.WHITE);
		rendererServicios.setHorizontalAlignment(JLabel.CENTER);
		rendererServicios.setBorder(null);
		rendererServicios.setOpaque(true);
		
		encabezadoServicios.setDefaultRenderer(rendererServicios);
		
		JLabel lblNewLabel_1 = new JLabel("Administra los planes y servicios disponibles de Altice.");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 70, 650, 25);
		add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(30, 110, 940, 2);
		add(separator);

	}
}
