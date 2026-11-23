package visual;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PanelFacturas extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelFacturas() {
		setSize(1000, 650);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Facturas");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(30, 20, 350, 45);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de corte: 20/12/2026 (Prueba)");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(700, 25, 270, 35);
		add(lblNewLabel_1);
		
		JButton btnPagarFactura = new JButton("Pagar factura");
		btnPagarFactura.setForeground(Color.BLACK);
		btnPagarFactura.setBackground(Color.WHITE);
		btnPagarFactura.setFont(new Font("Arial", Font.BOLD, 16));
		btnPagarFactura.setBounds(255, 140, 190, 45);
		add(btnPagarFactura);
		
		JButton btnGenerarFacturas = new JButton("Generar facturas");
		btnGenerarFacturas.setBackground(Color.BLACK);
		btnGenerarFacturas.setForeground(Color.WHITE);
		btnGenerarFacturas.setFont(new Font("Arial", Font.BOLD, 16));
		btnGenerarFacturas.setBounds(30, 140, 210, 45);
		add(btnGenerarFacturas);
		
		JLabel lblNewLabel_2 = new JLabel("Consulta, genera y administra las facturas de los clientes de Altice.");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 70, 650, 25);
		add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(30, 110, 940, 2);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 210, 940, 380);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Cliente", "Plan", "Total", "Estado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(190);
		table.getColumnModel().getColumn(4).setPreferredWidth(190);
		
		JTableHeader encabezado = table.getTableHeader();
		
		encabezado.setBackground(Color.BLACK);
		encabezado.setForeground(Color.WHITE);
		encabezado.setFont(new Font("Arial Black", Font.BOLD, 17));
		encabezado.setOpaque(true);
		table.setRowHeight(40);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		
		renderer.setBackground(Color.BLACK);
		renderer.setForeground(Color.WHITE);
		renderer.setHorizontalAlignment(JLabel.CENTER);
		renderer.setFont(new Font("Arial Black", Font.BOLD, 17));
		renderer.setBorder(null);
		renderer.setOpaque(true);
		
		encabezado.setDefaultRenderer(renderer);
		encabezado.setPreferredSize(new Dimension(940, 35));

	}

}
