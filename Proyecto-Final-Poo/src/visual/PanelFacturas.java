package visual;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logico.Altice;
import logico.Factura;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFacturas extends JPanel {
	private JTable table;
	private JButton btnGenerarFacturas;
	private JButton btnPagarFactura;

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

		JLabel lblPeriodo = new JLabel("Per\u00EDodo actual:");
		lblPeriodo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeriodo.setForeground(Color.GRAY);
		lblPeriodo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPeriodo.setBounds(670, 25, 300, 35);
		add(lblPeriodo);

		JLabel lblNewLabel_2 = new JLabel("Consulta, genera y administra las facturas de los clientes de Altice.");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 70, 650, 25);
		add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(30, 110, 940, 2);
		add(separator);

		btnGenerarFacturas = new JButton("Generar facturas");
		btnGenerarFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBoton(btnGenerarFacturas);
			}
		});
		btnGenerarFacturas.setFont(new Font("Arial", Font.BOLD, 15));
		btnGenerarFacturas.setFocusPainted(false);
		btnGenerarFacturas.setOpaque(true);
		btnGenerarFacturas.setBorder(new LineBorder(Color.BLACK, 2));
		btnGenerarFacturas.setBounds(30, 135, 200, 45);
		add(btnGenerarFacturas);

		btnPagarFactura = new JButton("Pagar factura");
		btnPagarFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBoton(btnPagarFactura);
			}
		});
		btnPagarFactura.setFont(new Font("Arial", Font.BOLD, 15));
		btnPagarFactura.setFocusPainted(false);
		btnPagarFactura.setOpaque(true);
		btnPagarFactura.setBorder(new LineBorder(Color.BLACK, 2));
		btnPagarFactura.setBounds(245, 135, 180, 45);
		add(btnPagarFactura);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 200, 940, 415);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(204, 204, 204)));
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Código", "Cliente", "Plan", "Total", "Estado"
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
		darEstiloTabla(table);
		scrollPane.setViewportView(table);

		marcarBoton(btnGenerarFacturas);
		cargarFacturas();
	}
	
	private void cargarFacturas()
	{
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		 modelo.setRowCount(0);

		    for (Factura aux : Altice.getInstance().getMisFacturas()) {

		        Object[] fila = {aux.getId(), aux.getContrato().getCliente().getNombre(), aux.getContrato().getPlan().getNombre(), aux.getTotal(),  aux.isPagado() ? "Pagada" : "Pendiente"};

		        modelo.addRow(fila);
		    }
	}

	private void marcarBoton(JButton elegido) {
		btnGenerarFacturas.setBackground(Color.WHITE);
		btnGenerarFacturas.setForeground(Color.BLACK);
		btnPagarFactura.setBackground(Color.WHITE);
		btnPagarFactura.setForeground(Color.BLACK);
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