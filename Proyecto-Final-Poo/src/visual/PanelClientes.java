package visual;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logico.Altice;
import logico.Cliente;
import logico.Contrato;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelClientes extends JPanel {
	private JTable table;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnDesactivar;
	private JButton btnActivar;
	private JButton btnVerContratos;
	private JScrollPane scrollPane;

	public PanelClientes() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblTitulo = new JLabel("Clientes");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setBounds(30, 20, 350, 45);
		add(lblTitulo);

		JLabel lblSubtitulo = new JLabel("Busca, registra y administra los clientes de Altice.");
		lblSubtitulo.setForeground(Color.GRAY);
		lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSubtitulo.setBounds(30, 70, 650, 25);
		add(lblSubtitulo);

		txtBuscar = new JTextField();
		txtBuscar.setToolTipText("Buscar por c\u00E9dula");
		txtBuscar.setFont(new Font("Arial", Font.PLAIN, 15));
		txtBuscar.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 10, 0, 0)));
		txtBuscar.setBounds(30, 110, 800, 45);
		add(txtBuscar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtBuscar.getText();
				if(cedula.isEmpty()) {
					cargarClientes();
				}
				else {
					Cliente cli = Altice.getInstance().buscarCliente(cedula);
					if(cli == null) {
						JOptionPane.showMessageDialog(null, "No existe un cliente con esa c\u00E9dula.", "Aviso", JOptionPane.WARNING_MESSAGE);
						cargarClientes();
					}
					else {
						DefaultTableModel modelo = (DefaultTableModel) table.getModel();
						modelo.setRowCount(0);
						agregarFila(cli);
					}
				}
			}
		});
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 15));
		btnBuscar.setFocusPainted(false);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setOpaque(true);
		btnBuscar.setBorder(new LineBorder(Color.BLACK, 2));
		btnBuscar.setBounds(845, 110, 125, 45);
		add(btnBuscar);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBoton(btnRegistrar);
				RegCliente ventana = new RegCliente(null);
				ventana.setModal(true);
				ventana.setVisible(true);
				cargarClientes();
			}
		});
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setOpaque(true);
		btnRegistrar.setBorder(new LineBorder(Color.BLACK, 2));
		btnRegistrar.setBounds(30, 170, 130, 45);
		add(btnRegistrar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBoton(btnModificar);
				Cliente cli = clienteSeleccionado();
				if(cli != null) {
					RegCliente ventana = new RegCliente(cli);
					ventana.setModal(true);
					ventana.setVisible(true);
					cargarClientes();
				}
			}
		});
		btnModificar.setFont(new Font("Arial", Font.BOLD, 15));
		btnModificar.setFocusPainted(false);
		btnModificar.setOpaque(true);
		btnModificar.setBorder(new LineBorder(Color.BLACK, 2));
		btnModificar.setBounds(175, 170, 135, 45);
		add(btnModificar);

		btnDesactivar = new JButton("Desactivar");
		btnDesactivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBoton(btnDesactivar);
				Cliente cli = clienteSeleccionado();
				if(cli != null) {
					if(!cli.isEstado()) {
						JOptionPane.showMessageDialog(null, "El cliente ya est\u00E1 inactivo.", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
					else {
						int opcion = JOptionPane.showConfirmDialog(null, "\u00BFDesea desactivar a " + cli.getNombre() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
						if(opcion == JOptionPane.YES_OPTION) {
							Altice.getInstance().eliminarCliente(cli.getCedula());
							cargarClientes();
						}
					}
				}
			}
		});
		btnDesactivar.setFont(new Font("Arial", Font.BOLD, 15));
		btnDesactivar.setFocusPainted(false);
		btnDesactivar.setOpaque(true);
		btnDesactivar.setBorder(new LineBorder(Color.BLACK, 2));
		btnDesactivar.setBounds(325, 170, 150, 45);
		add(btnDesactivar);

		btnActivar = new JButton("Activar");
		btnActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBoton(btnActivar);
				Cliente cli = clienteSeleccionado();
				if(cli != null) {
					if(cli.isEstado()) {
						JOptionPane.showMessageDialog(null, "El cliente ya est\u00E1 activo.", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
					else {
						Altice.getInstance().activarCliente(cli.getCedula());
						cargarClientes();
					}
				}
			}
		});
		btnActivar.setFont(new Font("Arial", Font.BOLD, 15));
		btnActivar.setFocusPainted(false);
		btnActivar.setOpaque(true);
		btnActivar.setBorder(new LineBorder(Color.BLACK, 2));
		btnActivar.setBounds(490, 170, 120, 45);
		add(btnActivar);

		btnVerContratos = new JButton("Ver contratos");
		btnVerContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcarBoton(btnVerContratos);
				Cliente cli = clienteSeleccionado();
				if(cli != null) {
					mostrarContratos(cli);
				}
			}
		});
		btnVerContratos.setFont(new Font("Arial", Font.BOLD, 15));
		btnVerContratos.setFocusPainted(false);
		btnVerContratos.setOpaque(true);
		btnVerContratos.setBorder(new LineBorder(Color.BLACK, 2));
		btnVerContratos.setBounds(625, 170, 170, 45);
		add(btnVerContratos);

		scrollPane = new JScrollPane();
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(204, 204, 204)));
		scrollPane.setBounds(30, 235, 940, 395);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"C\u00F3digo", "C\u00E9dula", "Nombre", "Tel\u00E9fono", "Pendientes", "Deuda", "Estado"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(140);
		table.getColumnModel().getColumn(6).setPreferredWidth(110);
		darEstiloTabla(table);
		scrollPane.setViewportView(table);

		marcarBoton(btnRegistrar);
		cargarClientes();
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		txtBuscar.setBounds(30, 110, width - 200, 45);
		btnBuscar.setBounds(width - 155, 110, 125, 45);
		scrollPane.setBounds(30, 235, width - 60, height - 255);
	}

	private void cargarClientes() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for(int i = 0; i < Altice.getInstance().getMisClientes().size(); i++) {
			agregarFila(Altice.getInstance().getMisClientes().get(i));
		}
	}

	private void agregarFila(Cliente cli) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		String estado = "Inactivo";
		if(cli.isEstado()) {
			estado = "Activo";
		}
		Object[] fila = {cli.getCodigo(), cli.getCedula(), cli.getNombre(), cli.getTelefono(), cli.facturasPendiente(), "RD$" + cli.getDeuda(), estado};
		modelo.addRow(fila);
	}

	private Cliente clienteSeleccionado() {
		int fila = table.getSelectedRow();
		Cliente cli = null;
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Seleccione un cliente de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		else {
			String cedula = table.getValueAt(fila, 1).toString();
			cli = Altice.getInstance().buscarCliente(cedula);
		}
		return cli;
	}

	private void mostrarContratos(Cliente cli) {
		String texto = "";
		for(int i = 0; i < cli.getContratos().size(); i++) {
			Contrato con = cli.getContratos().get(i);
			String estado = "Cancelado";
			if(con.isEstado()) {
				estado = "Activo";
			}
			texto += con.getId() + "  -  " + con.getPlan().getNombre() + "  -  RD$" + con.getPrecioMensual() + "  -  " + estado + "\n";
		}
		if(texto.isEmpty()) {
			texto = "Este cliente no tiene contratos.";
		}
		JOptionPane.showMessageDialog(null, texto, "Contratos de " + cli.getNombre(), JOptionPane.INFORMATION_MESSAGE);
	}

	private void marcarBoton(JButton elegido) {
		btnRegistrar.setBackground(Color.WHITE);
		btnRegistrar.setForeground(Color.BLACK);
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setForeground(Color.BLACK);
		btnDesactivar.setBackground(Color.WHITE);
		btnDesactivar.setForeground(Color.BLACK);
		btnActivar.setBackground(Color.WHITE);
		btnActivar.setForeground(Color.BLACK);
		btnVerContratos.setBackground(Color.WHITE);
		btnVerContratos.setForeground(Color.BLACK);
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