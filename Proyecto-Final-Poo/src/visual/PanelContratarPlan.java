package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logico.Altice;
import logico.Cliente;
import logico.Internet;
import logico.Plan;
import logico.Servicio;
import logico.Telefonia;
import logico.Television;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelContratarPlan extends JPanel {
	private JTextField txtCedula;
	private JTextField txtBuscarPlan;
	private JTable table;
	private JComboBox cmbFiltroServicio;
	private JLabel lblSubtotal;
	private JLabel lblItbis;
	private JLabel lblTotal;
	private JLabel lblEstadoCliente;
	private JLabel lblNombreCliente;
	private JButton btnBuscarCliente;
	private Cliente clienteSeleccionado;
	private JButton btnContratar;

	/**
	 * Create the panel.
	 */
	public PanelContratarPlan() {

		setSize(1000, 650);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contratar plan");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(30, 20, 400, 45);
		add(lblNewLabel);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVendedor.setForeground(Color.DARK_GRAY);
		lblVendedor.setFont(new Font("Arial", Font.PLAIN, 15));
		lblVendedor.setBounds(670, 25, 300, 35);
		add(lblVendedor);
		
		JLabel lblNewLabel_2 = new JLabel("Consulta los planes disponibles y registra contratos para los clientes.");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(30, 70, 750, 25);
		add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(30, 110, 940, 2);
		add(separator);
		
		lblNombreCliente = new JLabel("Cliente no seleccionado");
		lblNombreCliente.setForeground(Color.BLACK);
		lblNombreCliente.setFont(new Font("Arial", Font.BOLD, 16));
		lblNombreCliente.setBounds(500, 145, 470, 25);
		add(lblNombreCliente);
		
		JLabel lblNewLabel_4 = new JLabel("C\u00E9dula del cliente");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(30, 125, 250, 25);
		add(lblNewLabel_4);
		
		txtCedula = new JTextField();
		txtCedula.setHorizontalAlignment(SwingConstants.LEFT);
		txtCedula.setBackground(Color.WHITE);
		txtCedula.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCedula.setForeground(Color.BLACK);
		txtCedula.setBounds(30, 155, 300, 40);
		add(txtCedula);
		txtCedula.setColumns(10);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cedula = txtCedula.getText().trim();
				
				clienteSeleccionado = null;
				btnContratar.setEnabled(false);
				
				if(cedula.isEmpty())
		        {
		            lblNombreCliente.setText("Cliente no seleccionado");
		            lblEstadoCliente.setText("Ingrese una cédula");
		            lblEstadoCliente.setForeground(Color.RED);
		            return;
		        }

		        clienteSeleccionado = Altice.getInstance().buscarCliente(cedula);

		        if(clienteSeleccionado == null)
		        {
		            lblNombreCliente.setText("Cliente no encontrado");
		            lblEstadoCliente.setText("Verifique la cédula ingresada");
		            lblEstadoCliente.setForeground(Color.RED);
		            return;
		        }

		        lblNombreCliente.setText(clienteSeleccionado.getNombre());

		        if(!clienteSeleccionado.isEstado())
		        {
		            lblEstadoCliente.setText("No puede contratar: cliente inactivo");
		            lblEstadoCliente.setForeground(Color.RED);
		        }
		        else if(!clienteSeleccionado.puedeContratar())
		        {
		            lblEstadoCliente.setText("No puede contratar: deuda o facturas pendientes");
		            lblEstadoCliente.setForeground(Color.RED);
		        }
		        else
		        {
		            lblEstadoCliente.setText("Puede contratar");
		            lblEstadoCliente.setForeground(Color.GREEN.darker());
		        }

		        actualizarBotonContratar();
			}
		});
		btnBuscarCliente.setForeground(Color.BLACK);
		btnBuscarCliente.setBackground(Color.WHITE);
		btnBuscarCliente.setFont(new Font("Arial", Font.BOLD, 15));
		btnBuscarCliente.setFocusPainted(false);
		btnBuscarCliente.setOpaque(true);
		btnBuscarCliente.setBorder(new LineBorder(Color.BLACK, 2));
		btnBuscarCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBuscarCliente.setBounds(345, 155, 130, 40);
		add(btnBuscarCliente);
		
		lblEstadoCliente = new JLabel("");
		lblEstadoCliente.setForeground(Color.GRAY);
		lblEstadoCliente.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEstadoCliente.setBounds(500, 175, 470, 25);
		add(lblEstadoCliente);
		
		JLabel lblNewLabel_3 = new JLabel("Buscar plan");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(30, 215, 300, 25);
		add(lblNewLabel_3);
		
		txtBuscarPlan = new JTextField();
		txtBuscarPlan.setToolTipText("Buscar por c\u00F3digo o nombre");
		txtBuscarPlan.setForeground(Color.BLACK);
		txtBuscarPlan.setBackground(Color.WHITE);
		txtBuscarPlan.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtBuscarPlan.setFont(new Font("Arial", Font.PLAIN, 15));
		txtBuscarPlan.setBounds(30, 245, 450, 35);
		add(txtBuscarPlan);
		txtBuscarPlan.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de servicio");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(500, 215, 250, 25);
		add(lblNewLabel_5);
		
		cmbFiltroServicio = new JComboBox();
		cmbFiltroServicio.setFont(new Font("Arial", Font.PLAIN, 15));
		cmbFiltroServicio.setBackground(Color.WHITE);
		cmbFiltroServicio.setForeground(Color.BLACK);
		cmbFiltroServicio.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Internet", "Televisi\u00F3n", "Telefon\u00EDa"}));
		cmbFiltroServicio.setSelectedIndex(0);
		cmbFiltroServicio.setBounds(500, 245, 250, 35);
		cmbFiltroServicio.setFocusable(false);
		add(cmbFiltroServicio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 300, 940, 235);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(204, 204, 204)));
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Plan", "Servicios", "Precio mensual"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setPreferredWidth(230);
		table.getColumnModel().getColumn(2).setPreferredWidth(370);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setShowVerticalLines(false);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		
		darEstiloTabla(table);
		scrollPane.setViewportView(table);
		
		lblSubtotal = new JLabel("Subtotal: RD$0.00");
		lblSubtotal.setForeground(Color.BLACK);
		lblSubtotal.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSubtotal.setBounds(30, 550, 240, 25);
		add(lblSubtotal);
		
		lblItbis = new JLabel("ITBIS: RD$0.00");
		lblItbis.setForeground(Color.BLACK);
		lblItbis.setFont(new Font("Arial", Font.PLAIN, 15));
		lblItbis.setBounds(280, 550, 200, 25);
		add(lblItbis);
		
		lblTotal = new JLabel("Total: RD$0.00");
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setFont(new Font("Arial", Font.BOLD, 22));
		lblTotal.setBounds(30, 580, 600, 35);
		add(lblTotal);
		
		btnContratar = new JButton("Contratar");
		btnContratar.setBackground(Color.BLACK);
		btnContratar.setForeground(Color.WHITE);
		btnContratar.setFont(new Font("Arial", Font.BOLD, 15));
		btnContratar.setFocusPainted(false);
		btnContratar.setOpaque(true);
		btnContratar.setBorder(new LineBorder(Color.BLACK, 2));
		btnContratar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnContratar.setBounds(790, 560, 180, 45);
		add(btnContratar);
		
		btnContratar.setEnabled(false);
		
		cmbFiltroServicio.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        cargarPlanes();
		    }
		});

		txtBuscarPlan.getDocument().addDocumentListener(new DocumentListener() {

		    public void insertUpdate(DocumentEvent e) {
		        cargarPlanes();
		    }

		    public void removeUpdate(DocumentEvent e) {
		        cargarPlanes();
		    }

		    public void changedUpdate(DocumentEvent e) {
		        cargarPlanes();
		    }
		});
		
		txtCedula.getDocument().addDocumentListener(new DocumentListener() {

		    public void insertUpdate(DocumentEvent e)
		    {
		        limpiarCliente();
		    }

		    public void removeUpdate(DocumentEvent e)
		    {
		        limpiarCliente();
		    }

		    public void changedUpdate(DocumentEvent e)
		    {
		        limpiarCliente();
		    }
		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

		    public void valueChanged(ListSelectionEvent e) {
		        actualizarPrecios();
		        actualizarBotonContratar();
		    }
		});
		
		cargarPlanes();
	}
	
	private void cargarPlanes()
	{
	    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
	    modelo.setRowCount(0);

	    String busqueda = txtBuscarPlan.getText().trim().toLowerCase();
	    int tipo = cmbFiltroServicio.getSelectedIndex();

	    for(Plan aux : Altice.getInstance().getMisPlanes())
	    {
	        String servicios = "";
	        boolean mostrarPlan = false;

	        for(Servicio servicio : aux.getServicios())
	        {
	            if(!servicios.isEmpty())
	            {
	                servicios += ", ";
	            }

	            servicios += servicio.getNombre();

	            switch(tipo)
	            {
	                case 0:
	                    mostrarPlan = true;
	                    break;

	                case 1:
	                    if(servicio instanceof Internet)
	                    {
	                        mostrarPlan = true;
	                    }
	                    break;

	                case 2:
	                    if(servicio instanceof Television)
	                    {
	                        mostrarPlan = true;
	                    }
	                    break;

	                case 3:
	                    if(servicio instanceof Telefonia)
	                    {
	                        mostrarPlan = true;
	                    }
	                    break;
	            }
	        }

	        if(mostrarPlan)
	        {
	            if(aux.getId().toLowerCase().contains(busqueda) || aux.getNombre().toLowerCase().contains(busqueda))
	            {
	                Object[] fila = {aux.getId(), aux.getNombre(), servicios, String.format("RD$%.2f", aux.calcularPrecio())};

	                modelo.addRow(fila);
	            }
	        }
	    }
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

	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {

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
	
	private void actualizarPrecios()
	{
	    int fila = table.getSelectedRow();

	    if(fila == -1)
	    {
	        lblSubtotal.setText("Subtotal: RD$0.00");
	        lblItbis.setText("ITBIS: RD$0.00");
	        lblTotal.setText("Total: RD$0.00");

	        return;
	    }

	    String codigo = (String) table.getValueAt(fila, 0);

	    Plan plan = Altice.getInstance().buscarPlan(codigo);

	    if(plan != null)
	    {
	        float subtotal = plan.calcularPrecio();
	        float itbis = subtotal * 0.18f;
	        float total = subtotal + itbis;

	        lblSubtotal.setText(String.format("Subtotal: RD$%.2f", subtotal));
	        lblItbis.setText(String.format("ITBIS: RD$%.2f", itbis));
	        lblTotal.setText(String.format("Total: RD$%.2f", total));
	    }
	}
	
	private void actualizarBotonContratar()
	{
	    btnContratar.setEnabled(false);

	    if(clienteSeleccionado != null)
	    {
	        if(clienteSeleccionado.isEstado() && clienteSeleccionado.puedeContratar() && table.getSelectedRow() != -1)
	        {
	            btnContratar.setEnabled(true);
	        }
	    }
	}
	
	private void limpiarCliente()
	{
	    clienteSeleccionado = null;

	    lblNombreCliente.setText("Cliente no seleccionado");
	    lblEstadoCliente.setText("");

	    btnContratar.setEnabled(false);
	}
}
