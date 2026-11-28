package visual;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logico.Altice;
import logico.Cliente;
import logico.Empleado;
import logico.Factura;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelPagarFactura extends JPanel {
	private JTextField txtCedula;
	private JButton btnBuscar;
	private JButton btnPagar;
	private JLabel lblUsuario;
	private JLabel lblCliente;
	private JTable table;
	private JScrollPane scrollPane;
	private Cliente miCliente;

	public PanelPagarFactura() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblTitulo = new JLabel("Pagar factura");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setBounds(30, 20, 400, 45);
		add(lblTitulo);

		lblUsuario = new JLabel("");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(Color.GRAY);
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsuario.setBounds(570, 25, 400, 35);
		add(lblUsuario);

		Empleado emp = Altice.getLoginUser();
		if(emp != null) {
			lblUsuario.setText(emp.getNombre() + "  \u00B7  " + emp.getPuesto());
		}

		JLabel lblSubtitulo = new JLabel("C\u00E9dula del cliente");
		lblSubtitulo.setForeground(Color.GRAY);
		lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSubtitulo.setBounds(30, 75, 300, 25);
		add(lblSubtitulo);

		txtCedula = new JTextField();
		txtCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCedula.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 10, 0, 0)));
		txtCedula.setBounds(30, 105, 300, 45);
		add(txtCedula);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miCliente = Altice.getInstance().buscarCliente(txtCedula.getText());
				if(miCliente == null) {
					JOptionPane.showMessageDialog(null, "No existe un cliente con esa c\u00E9dula.", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				cargarFacturas();
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 15));
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(new LineBorder(Color.BLACK, 2));
		btnBuscar.setBounds(345, 105, 125, 45);
		add(btnBuscar);

		lblCliente = new JLabel("");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 15));
		lblCliente.setBounds(490, 105, 480, 45);
		add(lblCliente);

		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(204, 204, 204)));
		scrollPane.setBounds(30, 170, 940, 390);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Factura", "Contrato", "Per\u00EDodo", "Fecha", "Total", "Estado"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		darEstiloTabla(table);
		scrollPane.setViewportView(table);

		btnPagar = new JButton("Pagar seleccionada");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagarSeleccionada();
			}
		});
		btnPagar.setFont(new Font("Arial", Font.BOLD, 15));
		btnPagar.setFocusPainted(false);
		btnPagar.setBackground(Color.BLACK);
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setOpaque(true);
		btnPagar.setBorder(new LineBorder(Color.BLACK, 2));
		btnPagar.setBounds(770, 580, 200, 45);
		add(btnPagar);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		lblUsuario.setBounds(width - 430, 25, 400, 35);
		scrollPane.setBounds(30, 170, width - 60, height - 255);
		btnPagar.setBounds(width - 230, height - 70, 200, 45);
	}

	private void cargarFacturas() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		lblCliente.setText("");
		if(miCliente != null) {
			for(int i = 0; i < miCliente.getFacturas().size(); i++) {
				Factura fac = miCliente.getFacturas().get(i);
				String estado = "Pendiente";
				if(fac.isPagado()) {
					estado = "Pagada";
				}
				Object[] fila = {fac.getId(), fac.getContrato().getId(), fac.getPeriodo(), fechaTexto(fac.getFecha()), "RD$" + fac.getTotal(), estado};
				modelo.addRow(fila);
			}
			int pendientes = miCliente.facturasPendiente();
			lblCliente.setText(miCliente.getNombre() + "  \u00B7  " + pendientes + " pendientes");
			if(pendientes > 0) {
				lblCliente.setForeground(new Color(200, 0, 0));
			}
			else {
				lblCliente.setForeground(Color.BLACK);
			}
		}
	}

	private void pagarSeleccionada() {
		int fila = table.getSelectedRow();
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Seleccione una factura de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		else {
			String id = table.getValueAt(fila, 0).toString();
			Factura fac = Altice.getInstance().buscarFactura(id);
			if(fac != null && fac.isPagado()) {
				JOptionPane.showMessageDialog(null, "Esa factura ya est\u00E1 pagada.", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			else {
				int opcion = JOptionPane.showConfirmDialog(null, "\u00BFRegistrar el pago de la factura " + id + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
				if(opcion == JOptionPane.YES_OPTION) {
					if(Altice.getInstance().pagarFactura(id)) {
						JOptionPane.showMessageDialog(null, "Pago registrado correctamente.", "Informaci\u00F3n", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "No se pudo registrar el pago.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					cargarFacturas();
				}
			}
		}
	}

	private String fechaTexto(Date fecha) {
		if(fecha == null) {
			return "-";
		}
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		int dia = calendario.get(Calendar.DAY_OF_MONTH);
		int mes = calendario.get(Calendar.MONTH) + 1;
		int anio = calendario.get(Calendar.YEAR);
		return dia + "/" + mes + "/" + anio;
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