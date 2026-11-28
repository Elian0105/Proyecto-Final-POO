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

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.CardLayout;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;

import logico.Altice;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegServicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtVelocidadSubida;
	private JTextField txtTipoInternet;
	private JTextField txtVelocidadBajada;
	private JTextField txtPrecio;
	private JTextField txtCantidadCanales;
	private JTextField txtTipoConexionTV;
	private JTextField textField;
	private JTextField txtMinutos;
	private JTextField txtCantidadGB;
	private JTextField textField_1;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegServicio dialog = new RegServicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegServicio() {
		setResizable(false);
		setModal(true);
		setTitle("Altice - Administraci\u00F3n");
		setBounds(100, 100, 650, 850);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Registrar servicio");
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
			lblNewLabel.setBounds(30, 20, 400, 40);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Completa la informaci\u00F3n del servicio.");
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
			JLabel lblNewLabel_2 = new JLabel("Tipo de servicio");
			lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
			lblNewLabel_2.setBounds(30, 120, 250, 25);
			contentPanel.add(lblNewLabel_2);
		}
		
		JComboBox cmbTipoServicio = new JComboBox();
		cmbTipoServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tipo = cmbTipoServicio.getSelectedItem().toString();
				
				CardLayout layout = (CardLayout) panel.getLayout();
				
				switch(tipo)
				{
				case "Internet":
				{
					layout.show(panel, "Internet");
					break;
				}
				
				case "Televisión":
				{
					layout.show(panel, "Television");
					break;
				}
				
				case "Telefonía":
				{
					layout.show(panel, "Telefonia");
					break;
				}
				
				default:
				{
					layout.show(panel, "Vacio");
				}
				}
			}
		});
		cmbTipoServicio.setModel(new DefaultComboBoxModel(new String[] {"Seleccione un tipo de servicio", "Internet", "Televisi\u00F3n", "Telefon\u00EDa"}));
		cmbTipoServicio.setFont(new Font("Arial", Font.PLAIN, 15));
		cmbTipoServicio.setBounds(30, 150, 580, 35);
		cmbTipoServicio.setFocusable(false);
		contentPanel.add(cmbTipoServicio);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(30, 200, 250, 25);
		contentPanel.add(lblNewLabel_3);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setBounds(30, 230, 580, 35);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Descripci\u00F3n");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_4.setBounds(30, 280, 250, 25);
		contentPanel.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 310, 580, 80);
		contentPanel.add(scrollPane);
		
		JTextArea txtDescripcion = new JTextArea();
		txtDescripcion.setFont(new Font("Arial", Font.PLAIN, 15));
		scrollPane.setViewportView(txtDescripcion);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(40, 535, 560, 205);
		contentPanel.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		JPanel panelVacio = new JPanel();
		panelVacio.setBackground(Color.WHITE);
		panel.add(panelVacio, "Vacio");
		
		JPanel panelTelevision = new JPanel();
		panelTelevision.setBackground(Color.WHITE);
		panel.add(panelTelevision, "Television");
		panelTelevision.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Cantidad de canales");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_10.setBounds(10, 15, 250, 25);
		panelTelevision.add(lblNewLabel_10);
		
		txtCantidadCanales = new JTextField();
		txtCantidadCanales.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCantidadCanales.setBounds(10, 45, 260, 35);
		panelTelevision.add(txtCantidadCanales);
		txtCantidadCanales.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Tipo de conexi\u00F3n");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_11.setBounds(300, 15, 260, 35);
		panelTelevision.add(lblNewLabel_11);
		
		txtTipoConexionTV = new JTextField();
		txtTipoConexionTV.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTipoConexionTV.setBounds(300, 45, 260, 35);
		panelTelevision.add(txtTipoConexionTV);
		txtTipoConexionTV.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Cantidad de canales HD");
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_12.setBounds(10, 110, 250, 25);
		panelTelevision.add(lblNewLabel_12);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(10, 140, 260, 35);
		panelTelevision.add(textField);
		textField.setColumns(10);
		
		JPanel panelTelefonia = new JPanel();
		panelTelefonia.setBackground(Color.WHITE);
		panel.add(panelTelefonia, "Telefonia");
		panelTelefonia.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("Minutos incluidos");
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_13.setBounds(10, 15, 260, 25);
		panelTelefonia.add(lblNewLabel_13);
		
		txtMinutos = new JTextField();
		txtMinutos.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMinutos.setBounds(10, 45, 260, 35);
		panelTelefonia.add(txtMinutos);
		txtMinutos.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Llamadas ilimitadas");
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_14.setBounds(300, 15, 260, 25);
		panelTelefonia.add(lblNewLabel_14);
		
		JCheckBox chkLLamadasIlimitadas = new JCheckBox("S\u00ED");
		chkLLamadasIlimitadas.setFont(new Font("Arial", Font.PLAIN, 15));
		chkLLamadasIlimitadas.setBackground(Color.WHITE);
		chkLLamadasIlimitadas.setBounds(300, 45, 260, 35);
		panelTelefonia.add(chkLLamadasIlimitadas);
		
		JLabel lblNewLabel_15 = new JLabel("Cantidad de GB");
		lblNewLabel_15.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_15.setBounds(10, 110, 260, 25);
		panelTelefonia.add(lblNewLabel_15);
		
		txtCantidadGB = new JTextField();
		txtCantidadGB.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCantidadGB.setBounds(10, 140, 260, 35);
		panelTelefonia.add(txtCantidadGB);
		txtCantidadGB.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Vigencia (d\u00EDas)");
		lblNewLabel_16.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_16.setBounds(300, 110, 260, 25);
		panelTelefonia.add(lblNewLabel_16);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 15));
		textField_1.setBounds(300, 140, 260, 35);
		panelTelefonia.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panelInternet = new JPanel();
		panelInternet.setBackground(Color.WHITE);
		panel.add(panelInternet, "Internet");
		panelInternet.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Velocidad de subida (Mbps)");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6.setBounds(300, 15, 270, 25);
		panelInternet.add(lblNewLabel_6);
		
		txtVelocidadSubida = new JTextField();
		txtVelocidadSubida.setBackground(Color.WHITE);
		txtVelocidadSubida.setForeground(Color.BLACK);
		txtVelocidadSubida.setFont(new Font("Arial", Font.PLAIN, 15));
		txtVelocidadSubida.setBounds(300, 45, 260, 35);
		panelInternet.add(txtVelocidadSubida);
		txtVelocidadSubida.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Tipo de conexi\u00F3n");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_7.setBounds(10, 15, 250, 25);
		panelInternet.add(lblNewLabel_7);
		
		txtTipoInternet = new JTextField();
		txtTipoInternet.setForeground(Color.BLACK);
		txtTipoInternet.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTipoInternet.setBounds(10, 45, 260, 35);
		panelInternet.add(txtTipoInternet);
		txtTipoInternet.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Velocidad de bajada (Mbps)");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_8.setBounds(10, 110, 270, 25);
		panelInternet.add(lblNewLabel_8);
		
		txtVelocidadBajada = new JTextField();
		txtVelocidadBajada.setForeground(Color.BLACK);
		txtVelocidadBajada.setFont(new Font("Arial", Font.PLAIN, 15));
		txtVelocidadBajada.setBounds(10, 140, 260, 35);
		panelInternet.add(txtVelocidadBajada);
		txtVelocidadBajada.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Caracter\u00EDsticas del servicio");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(30, 490, 350, 25);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_9 = new JLabel("Precio (RD$)");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_9.setBounds(30, 405, 200, 25);
		contentPanel.add(lblNewLabel_9);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Arial", Font.PLAIN, 15));
		txtPrecio.setBounds(30, 435, 260, 35);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(Color.BLACK));
		panel_1.setBounds(30, 520, 580, 235);
		contentPanel.add(panel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrarServicio = new JButton("Registrar servicio");
				btnRegistrarServicio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(cmbTipoServicio.getSelectedIndex() == 0)
						{
							JOptionPane.showMessageDialog(null, "Seleccione un tipo de servicio.");
							return;
						}
						
						if(txtNombre.getText().trim().isEmpty() || txtDescripcion.getText().trim().isEmpty() || txtPrecio.getText().trim().isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Debe de completar todos los campos.");
							return;
						}
						
						String nombre = txtNombre.getText().trim();
						String descripcion = txtDescripcion.getText().trim();
						
						float precio;
						String mensaje = "Introduzca un precio numérico válido";
						
						try
						{
							precio = Float.parseFloat(txtPrecio.getText().trim());
							
						}catch(NumberFormatException s)
						{
							JOptionPane.showMessageDialog(null, "Introduzca un precio numérico válido.");
							return;
						}
						
						if(precio <= 0)
						{
							JOptionPane.showMessageDialog(null, "El precio debe ser un número mayor que cero.");
						}
						
						boolean registrado = false;
						
						switch (cmbTipoServicio.getSelectedIndex()) {

						case 1:

						    if (txtTipoInternet.getText().trim().isEmpty() || txtVelocidadSubida.getText().trim().isEmpty() || txtVelocidadBajada.getText().trim().isEmpty())
						    {
						        JOptionPane.showMessageDialog(null, "Complete todos los campos de Internet.");
						        return;
						    }

						    try {
						        String tipo = txtTipoInternet.getText().trim();

						        int velocidadSubida = Integer.parseInt(txtVelocidadSubida.getText().trim());

						        int velocidadBajada = Integer.parseInt(txtVelocidadBajada.getText().trim());

						        registrado = Altice.getInstance().registrarServicioInternet( nombre, descripcion, precio, tipo,velocidadSubida, velocidadBajada);

						    }catch (NumberFormatException ex) {
						        JOptionPane.showMessageDialog(null, "Introduzca velocidades válidas.");
						        	return;
						    }

						    break;

						case 2:

						    if (txtCantidadCanales.getText().trim().isEmpty() || txtTipoConexionTV.getText().trim().isEmpty() || textField.getText().trim().isEmpty())
						    {

						        JOptionPane.showMessageDialog(null, "Complete todos los campos de Televisión.");
						        return;
						    }

						    try {
						        int cantidadCanales = Integer.parseInt(txtCantidadCanales.getText().trim());

						        String tipoConexion = txtTipoConexionTV.getText().trim();

						        int canalesHD = Integer.parseInt(textField.getText().trim());

						        registrado = Altice.getInstance().registrarServicioTelevision(nombre, descripcion, precio, cantidadCanales, tipoConexion, canalesHD);

						    } catch (NumberFormatException ex) 
						    
						    {JOptionPane.showMessageDialog(null, "Introduzca cantidades de canales válidas.");
						        return;
						    }

						    break;

						case 3:

						    if (txtMinutos.getText().trim().isEmpty() || txtCantidadGB.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty())
						    {
						        JOptionPane.showMessageDialog(null, "Complete todos los campos de Telefonía.");
						        return;
						    }

						    try {
						        int minutos = Integer.parseInt(txtMinutos.getText().trim());

						        boolean llamadasIlimitadas = chkLLamadasIlimitadas.isSelected();

						        int cantidadGB = Integer.parseInt(txtCantidadGB.getText().trim());

						        int vigenciaDias = Integer.parseInt(textField_1.getText().trim());

						        registrado = Altice.getInstance().registrarServicioTelefonia(nombre, descripcion, precio, minutos, llamadasIlimitadas, cantidadGB, vigenciaDias);

						    } catch (NumberFormatException ex) {
						        JOptionPane.showMessageDialog(null, "Introduzca valores numéricos válidos para Telefonía.");
						        return;
						    }

						    break;
						}
						
						if (registrado)
						{
						    JOptionPane.showMessageDialog(null, "Servicio registrado correctamente.");
						    dispose();
						    
						} else
						{
						    JOptionPane.showMessageDialog(null, "Los datos del servicio no son válidos.");
						}
						
					}
				});
				btnRegistrarServicio.setForeground(Color.WHITE);
				btnRegistrarServicio.setBackground(Color.BLACK);
				btnRegistrarServicio.setFont(new Font("Arial", Font.BOLD, 15));
				btnRegistrarServicio.setActionCommand("OK");
				buttonPane.add(btnRegistrarServicio);
				getRootPane().setDefaultButton(btnRegistrarServicio);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setForeground(Color.BLACK);
				btnCancelar.setBackground(Color.WHITE);
				btnCancelar.setFont(new Font("Arial", Font.BOLD, 15));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
}
