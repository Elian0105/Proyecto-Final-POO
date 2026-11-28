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
import logico.Contrato;
import logico.Empleado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelConsultarCliente extends JPanel {
	private JTextField txtCedula;
	private JButton btnBuscar;
	private JLabel lblUsuario;
	private JPanel panelDatos;
	private JLabel lblNombre;
	private JLabel lblCodigo;
	private JLabel lblTelefono;
	private JLabel lblCorreo;
	private JLabel lblEstado;
	private JLabel lblDeuda;
	private JTable table;
	private JScrollPane scrollPane;

	public PanelConsultarCliente() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblTitulo = new JLabel("Consultar cliente");
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
				Cliente cli = Altice.getInstance().buscarCliente(txtCedula.getText());
				if(cli == null) {
					JOptionPane.showMessageDialog(null, "No existe un cliente con esa c\u00E9dula.", "Aviso", JOptionPane.WARNING_MESSAGE);
					limpiar();
				}
				else {
					mostrarCliente(cli);
				}
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

		panelDatos = new JPanel();
		panelDatos.setBackground(Color.WHITE);
		panelDatos.setBorder(new LineBorder(new Color(204, 204, 204)));
		panelDatos.setBounds(30, 170, 940, 125);
		panelDatos.setLayout(null);
		add(panelDatos);

		lblNombre = crearDato("Nombre", 20, 15);
		lblCodigo = crearDato("C\u00F3digo", 480, 15);
		lblTelefono = crearDato("Tel\u00E9fono", 20, 50);
		lblCorreo = crearDato("Correo", 480, 50);
		lblEstado = crearDato("Estado", 20, 85);
		lblDeuda = crearDato("Deuda", 480, 85);

		JLabel lblContratos = new JLabel("Contratos del cliente");
		lblContratos.setFont(new Font("Arial", Font.BOLD, 16));
		lblContratos.setBounds(30, 310, 400, 25);
		add(lblContratos);

		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(204, 204, 204)));
		scrollPane.setBounds(30, 345, 940, 285);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Contrato", "Plan", "Inicio", "Mensual", "Pendientes", "Estado"
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
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		lblUsuario.setBounds(width - 430, 25, 400, 35);
		panelDatos.setBounds(30, 170, width - 60, 125);
		scrollPane.setBounds(30, 345, width - 60, height - 365);
	}

	private JLabel crearDato(String titulo, int x, int y) {
		JLabel lblTitulo = new JLabel(titulo);
		lblTitulo.setForeground(Color.GRAY);
		lblTitulo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTitulo.setBounds(x, y, 100, 25);
		panelDatos.add(lblTitulo);

		JLabel lblValor = new JLabel("-");
		lblValor.setFont(new Font("Arial", Font.BOLD, 15));
		lblValor.setBounds(x + 100, y, 330, 25);
		panelDatos.add(lblValor);
		return lblValor;
	}

	private void mostrarCliente(Cliente cli) {
		lblNombre.setText(cli.getNombre());
		lblCodigo.setText(cli.getCodigo());
		lblTelefono.setText(cli.getTelefono());
		lblCorreo.setText(cli.getCorreo());
		if(cli.isEstado()) {
			lblEstado.setText("Activo");
		}
		else {
			lblEstado.setText("Inactivo");
		}
		lblDeuda.setText("RD$" + cli.getDeuda());

		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for(int i = 0; i < cli.getContratos().size(); i++) {
			Contrato con = cli.getContratos().get(i);
			String estado = "Cancelado";
			if(con.isEstado()) {
				estado = "Activo";
			}
			Object[] fila = {con.getId(), con.getPlan().getNombre(), fechaTexto(con.getFechaInicializacion()), "RD$" + con.getPrecioMensual(), cli.facturasPendientesContrato(con), estado};
			modelo.addRow(fila);
		}
	}

	private void limpiar() {
		lblNombre.setText("-");
		lblCodigo.setText("-");
		lblTelefono.setText("-");
		lblCorreo.setText("-");
		lblEstado.setText("-");
		lblDeuda.setText("-");
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
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
				setHorizontalAlignment(SwingConstants.LEFT);
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