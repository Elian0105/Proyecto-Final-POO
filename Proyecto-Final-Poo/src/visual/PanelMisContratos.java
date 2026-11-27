package visual;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logico.Altice;
import logico.Contrato;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelMisContratos extends JPanel {
	private JTextField txtBuscarContrato;
	private JTable table;
	private JComboBox cmbEstado;
	private JLabel lblTotalContratos;
	private JLabel lblVendedor;
	private JButton btnCancelarContrato;
	private Contrato contratoSeleccionado;

	/**
	 * Create the panel.
	 */
	public PanelMisContratos() {
		
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(1000, 650);
		
		JLabel lblNewLabel = new JLabel("Mis contratos");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(30, 20, 400, 45);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Administra los contratos registrados.");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 70, 750, 25);
		add(lblNewLabel_1);
		
		lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setForeground(Color.DARK_GRAY);
		lblVendedor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVendedor.setFont(new Font("Arial", Font.PLAIN, 15));
		lblVendedor.setBounds(670, 25, 300, 35);
		add(lblVendedor);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(30, 110, 940, 2);
		add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Buscar contrato");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(30, 125, 400, 25);
		add(lblNewLabel_2);
		
		txtBuscarContrato = new JTextField();
		txtBuscarContrato.setBackground(Color.WHITE);
		txtBuscarContrato.setForeground(Color.BLACK);
		txtBuscarContrato.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtBuscarContrato.setToolTipText("Buscar por codigo o cliente");
		txtBuscarContrato.setFont(new Font("Arial", Font.PLAIN, 15));
		txtBuscarContrato.setBounds(30, 155, 400, 35);
		add(txtBuscarContrato);
		txtBuscarContrato.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Estado");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(450, 125, 220, 35);
		add(lblNewLabel_3);
		
		cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"Todos", "Activo", "Cancelado"}));
		cmbEstado.setSelectedIndex(0);
		cmbEstado.setForeground(Color.BLACK);
		cmbEstado.setBackground(Color.WHITE);
		cmbEstado.setFont(new Font("Arial", Font.PLAIN, 15));
		cmbEstado.setBounds(450, 155, 220, 35);
		cmbEstado.setFocusable(false);
		add(cmbEstado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 215, 940, 365);
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.setBorder(new LineBorder(new Color(204, 204, 204)));
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Contrato", "Cliente", "Plan", "Fecha", "Mensual", "Estado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(140);
		table.getColumnModel().getColumn(1).setPreferredWidth(160);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(4).setPreferredWidth(160);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);

		darEstiloTabla(table);

		scrollPane.setViewportView(table);
		
		lblTotalContratos = new JLabel("Total de contratos: 0");
		lblTotalContratos.setForeground(Color.GRAY);
		lblTotalContratos.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTotalContratos.setBounds(30, 590, 400, 30);
		add(lblTotalContratos);
		
		btnCancelarContrato = new JButton("Cancelar contrato");
		btnCancelarContrato.setBackground(Color.WHITE);
		btnCancelarContrato.setForeground(Color.BLACK);
		btnCancelarContrato.setFont(new Font("Arial", Font.BOLD, 15));
		btnCancelarContrato.setFocusPainted(false);
		btnCancelarContrato.setOpaque(true);
		btnCancelarContrato.setBorder(new LineBorder(Color.BLACK, 2));
		btnCancelarContrato.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCancelarContrato.setBounds(750, 150, 220, 40);
		btnCancelarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelarContrato.setBackground(Color.WHITE);
		btnCancelarContrato.setForeground(Color.BLACK);
		btnCancelarContrato.setFont(new Font("Arial", Font.BOLD, 15));
		btnCancelarContrato.setBounds(750, 150, 220, 40);
		add(btnCancelarContrato);
		
		txtBuscarContrato.getDocument().addDocumentListener(new DocumentListener() {

		    public void insertUpdate(DocumentEvent e)
		    {
		    	cargarContratos();
		    }

		    public void removeUpdate(DocumentEvent e)
		    {
		        cargarContratos();
		    }

		    public void changedUpdate(DocumentEvent e)
		    {
		        cargarContratos();
		    }
		});
		
		cargarContratos();
		
	}
	
	private void cargarContratos()
	{
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		
		modelo.setRowCount(0);
		
		int pos = cmbEstado.getSelectedIndex();
		
		if(pos < 0)
		{
			return;
		}
		
		for(Contrato aux : Altice.getInstance().getMisContratos())
		{
			if(pos == 0)
			{
				Object[] fila = {aux.getId(), aux.getCliente().getNombre(), aux.getPlan().getNombre(), aux.getFechaInicializacion(), aux.getPrecioMensual(), aux.isEstado()};
				modelo.addRow(fila);
			}
			else if(pos == 1)
			{
				if(aux.isEstado())
				{
					Object[] fila = {aux.getId(), aux.getCliente().getNombre(), aux.getPlan().getNombre(), aux.getFechaInicializacion(), aux.getPrecioMensual(), aux.isEstado()};
					modelo.addRow(fila);
				}
			}
			else if(pos == 2)
			{
				if(!aux.isEstado())
				{
					Object[] fila = {aux.getId(), aux.getCliente().getNombre(), aux.getPlan().getNombre(), aux.getFechaInicializacion(), aux.getPrecioMensual(), aux.isEstado()};
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

	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	        {
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

	        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	        {
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
