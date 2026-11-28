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

import logico.Administrativo;
import logico.Altice;
import logico.Comercial;
import logico.Empleado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEmpleados extends JPanel {
	private JTable table;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JButton btnRegistrar;
	private JButton btnModificar;
	private JButton btnDesactivar;
	private JButton btnActivar;
	private JScrollPane scrollPane;

	public PanelEmpleados() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblTitulo = new JLabel("Empleados");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		lblTitulo.setBounds(30, 20, 350, 45);
		add(lblTitulo);

		JLabel lblSubtitulo = new JLabel("Busca por ID o nombre, registra y administra el personal de Altice.");
		lblSubtitulo.setForeground(Color.GRAY);
		lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSubtitulo.setBounds(30, 70, 650, 25);
		add(lblSubtitulo);

		txtBuscar = new JTextField();
		txtBuscar.setToolTipText("Buscar por ID o nombre");
		txtBuscar.setFont(new Font("Arial", Font.PLAIN, 15));
		txtBuscar.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 10, 0, 0)));
		txtBuscar.setBounds(30, 110, 800, 45);
		add(txtBuscar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarEmpleados(txtBuscar.getText());
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
				RegEmpleado ventana = new RegEmpleado(null);
				ventana.setModal(true);
				ventana.setVisible(true);
				cargarEmpleados();
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
				Empleado emp = empleadoSeleccionado();
				if(emp != null) {
					RegEmpleado ventana = new RegEmpleado(emp);
					ventana.setModal(true);
					ventana.setVisible(true);
					cargarEmpleados();
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
				Empleado emp = empleadoSeleccionado();
				if(emp != null) {
					if(emp == Altice.getLoginUser()) {
						JOptionPane.showMessageDialog(null, "No puede desactivar su propio usuario.", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
					else if(!emp.isEstado()) {
						JOptionPane.showMessageDialog(null, "El empleado ya est\u00E1 inactivo.", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
					else {
						int opcion = JOptionPane.showConfirmDialog(null, "\u00BFDesea desactivar a " + emp.getNombre() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
						if(opcion == JOptionPane.YES_OPTION) {
							Altice.getInstance().eliminarEmpleado(emp.getIdEmpleado());
							cargarEmpleados();
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
				Empleado emp = empleadoSeleccionado();
				if(emp != null) {
					if(emp.isEstado()) {
						JOptionPane.showMessageDialog(null, "El empleado ya est\u00E1 activo.", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
					else {
						Altice.getInstance().activarEmpleado(emp.getIdEmpleado());
						cargarEmpleados();
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
						"ID", "Nombre", "Tipo", "Puesto", "Sucursal", "Salario", "Estado"
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
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(170);
		table.getColumnModel().getColumn(5).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		darEstiloTabla(table);
		scrollPane.setViewportView(table);

		marcarBoton(btnRegistrar);
		cargarEmpleados();
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		txtBuscar.setBounds(30, 110, width - 200, 45);
		btnBuscar.setBounds(width - 155, 110, 125, 45);
		scrollPane.setBounds(30, 235, width - 60, height - 255);
	}

	private void cargarEmpleados() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for(int i = 0; i < Altice.getInstance().getMisEmpleados().size(); i++) {
			agregarFila(Altice.getInstance().getMisEmpleados().get(i));
		}
	}

	private void buscarEmpleados(String texto) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		String buscado = texto.toLowerCase();
		for(int i = 0; i < Altice.getInstance().getMisEmpleados().size(); i++) {
			Empleado emp = Altice.getInstance().getMisEmpleados().get(i);
			if(texto.isEmpty() || emp.getIdEmpleado().equalsIgnoreCase(texto) || emp.getNombre().toLowerCase().contains(buscado)) {
				agregarFila(emp);
			}
		}
		if(modelo.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "No se encontraron empleados.", "Aviso", JOptionPane.WARNING_MESSAGE);
			cargarEmpleados();
		}
	}

	private void agregarFila(Empleado emp) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		String tipo = "Empleado";
		if(emp instanceof Comercial) {
			tipo = "Comercial";
		}
		else if(emp instanceof Administrativo) {
			tipo = "Administrativo";
		}
		String estado = "Inactivo";
		if(emp.isEstado()) {
			estado = "Activo";
		}
		Object[] fila = {emp.getIdEmpleado(), emp.getNombre(), tipo, emp.getPuesto(), emp.getSucursal(), "RD$" + emp.calcularSalario(), estado};
		modelo.addRow(fila);
	}

	private Empleado empleadoSeleccionado() {
		int fila = table.getSelectedRow();
		Empleado emp = null;
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Seleccione un empleado de la tabla.", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		else {
			String id = table.getValueAt(fila, 0).toString();
			emp = Altice.getInstance().buscarEmpleado(id);
		}
		return emp;
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