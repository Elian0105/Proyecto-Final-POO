package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import logico.Altice;
import logico.Plan;
import logico.Servicio;

import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegPlan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtDescuento;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPlan dialog = new RegPlan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPlan() {
		setModal(true);
		setResizable(false);
		setTitle("Altice - Administraci\u00F3n");
		setBounds(100, 100, 650, 700);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Registrar plan");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
			lblNewLabel.setBounds(30, 20, 350, 40);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Completa la informacion del plan.");
			lblNewLabel_1.setForeground(Color.GRAY);
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(30, 60, 550, 25);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(30, 95, 580, 2);
			contentPanel.add(separator);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Nombre del plan");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_2.setBounds(30, 120, 200, 25);
			contentPanel.add(lblNewLabel_2);
		}
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setBounds(30, 150, 580, 35);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descripci\u00F3n");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(30, 200, 200, 25);
		contentPanel.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 230, 580, 75);
		contentPanel.add(scrollPane);
		
		JTextArea txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 15));
		scrollPane.setViewportView(txtDescripcion);
		
		JLabel lblNewLabel_4 = new JLabel("Descuento (%)");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(30, 320, 200, 25);
		contentPanel.add(lblNewLabel_4);
		
		txtDescuento = new JTextField();
		txtDescuento.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDescuento.setBounds(30, 350, 260, 35);
		contentPanel.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Duraci\u00F3n (meses)");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(320, 320, 200, 25);
		contentPanel.add(lblNewLabel_5);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(12, 1, 120, 1));
		spinner.setFont(new Font("Arial", Font.PLAIN, 15));
		spinner.setBounds(320, 350, 290, 35);
		contentPanel.add(spinner);
		
		JLabel lblNewLabel_6 = new JLabel("Servicios disponibles");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6.setBounds(30, 405, 300, 25);
		contentPanel.add(lblNewLabel_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 440, 580, 150);
		contentPanel.add(scrollPane_1);
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Seleccionar", "C\u00F3digo", "Servicio", "Precio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		
		table.setRowHeight(30);
		
		JTableHeader encabezado = table.getTableHeader();
		
		encabezado.setBackground(Color.BLACK);
		encabezado.setForeground(Color.WHITE);
		encabezado.setFont(new Font("Arial", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar plan");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						 if (txtNombre.getText().trim().isEmpty() || txtDescripcion.getText().trim().isEmpty() || txtDescuento.getText().trim().isEmpty())
						 {
						       JOptionPane.showMessageDialog(null, "Complete todos los campos obligatorios.");
						       return;
						 }

						        String nombre = txtNombre.getText().trim();
						        String descripcion = txtDescripcion.getText().trim();

						        float descuento;

						        try
						        {
						            descuento = Float.parseFloat(  txtDescuento.getText().trim());
						        } catch (NumberFormatException ex)
						        {
						            JOptionPane.showMessageDialog(null, "Introduzca un descuento numérico válido.");
						            return;
						        }

						        if (!(descuento >= 0 && descuento <= 100))
						        {
						            JOptionPane.showMessageDialog(null,  "El descuento debe estar entre 0 y 100.");
						            return;
						        }

						        int duracion = (Integer) spinner.getValue();

						        Plan plan = new Plan(nombre, descripcion, descuento, duracion);
						        

						        for (int i = 0; i < table.getRowCount(); i++) {

						            if ((Boolean) table.getValueAt(i, 0))
						            {
						                String codigo = table.getValueAt(i, 1).toString();

						                Servicio servicio = Altice.getInstance().buscarServicio(codigo);

						                if (servicio != null && servicio.isEstado())
						                {
						                    plan.agregarServicio(servicio);
						                }
						            }
						        }

						        if (plan.getServicios().isEmpty())
						        {
						            JOptionPane.showMessageDialog(null, "Seleccione al menos un servicio.");
						            return;
						        }

						        if (Altice.getInstance().registrarPlan(plan))
						        {
						            JOptionPane.showMessageDialog(null,  "Plan registrado correctamente.");

						            dispose();

						        } else
						        {
						            JOptionPane.showMessageDialog(null, "No se pudo registrar el plan.");
						        }
						    }
				});
				btnRegistrar.setForeground(Color.WHITE);
				btnRegistrar.setBackground(Color.BLACK);
				btnRegistrar.setFont(new Font("Arial", Font.BOLD, 14));
				btnRegistrar.setActionCommand("OK");
				
				btnRegistrar.setBackground(Color.BLACK);
				btnRegistrar.setForeground(Color.WHITE);
				btnRegistrar.setOpaque(true);
				btnRegistrar.setContentAreaFilled(true);
				btnRegistrar.setBorderPainted(false);
				btnRegistrar.setFocusPainted(false);
				
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setForeground(Color.BLACK);
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setFont(new Font("Arial", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarServicios();
	}
	
	private void cargarServicios() {

	    DefaultTableModel modelo = (DefaultTableModel) table.getModel();

	    modelo.setRowCount(0);

	    for (Servicio aux : Altice.getInstance().getMisServicios()) {

	        if (aux.isEstado())
	        {
	            Object[] fila = {false, aux.getId(), aux.getNombre(), aux.calcularPrecio()
	            };

	            modelo.addRow(fila);
	        }
	    }
	}
}
