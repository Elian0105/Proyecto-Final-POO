package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logico.Altice;
import logico.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JSpinner spnFechaNacimiento;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private Cliente miCliente;

	public RegCliente(Cliente cliente) {
		miCliente = cliente;
		setModal(true);
		setResizable(false);
		setTitle("Registrar Cliente");
		setBounds(100, 100, 560, 440);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel franja = new JPanel();
		franja.setBackground(Color.BLACK);
		franja.setBounds(0, 0, 560, 12);
		contentPanel.add(franja);

		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCodigo.setBounds(30, 30, 235, 20);
		contentPanel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBackground(Color.WHITE);
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCodigo.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtCodigo.setBounds(30, 55, 235, 35);
		contentPanel.add(txtCodigo);

		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCedula.setBounds(290, 30, 235, 20);
		contentPanel.add(lblCedula);

		txtCedula = new JTextField();
		txtCedula.setBackground(Color.WHITE);
		txtCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCedula.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtCedula.setBounds(290, 55, 235, 35);
		contentPanel.add(txtCedula);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(30, 100, 235, 20);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtNombre.setBounds(30, 125, 235, 35);
		contentPanel.add(txtNombre);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTelefono.setBounds(290, 100, 235, 20);
		contentPanel.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTelefono.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtTelefono.setBounds(290, 125, 235, 35);
		contentPanel.add(txtTelefono);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCorreo.setBounds(30, 170, 235, 20);
		contentPanel.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCorreo.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtCorreo.setBounds(30, 195, 235, 35);
		contentPanel.add(txtCorreo);

		JLabel lblFecha = new JLabel("Fecha de nacimiento");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblFecha.setBounds(290, 170, 235, 20);
		contentPanel.add(lblFecha);

		spnFechaNacimiento = new JSpinner();
		spnFechaNacimiento.setModel(new SpinnerDateModel());
		spnFechaNacimiento.setEditor(new JSpinner.DateEditor(spnFechaNacimiento, "dd/MM/yyyy"));
		spnFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 15));
		spnFechaNacimiento.setBorder(new LineBorder(new Color(204, 204, 204)));
		spnFechaNacimiento.setBounds(290, 195, 235, 35);
		contentPanel.add(spnFechaNacimiento);

		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDireccion.setBounds(30, 240, 495, 20);
		contentPanel.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDireccion.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtDireccion.setBounds(30, 265, 495, 35);
		contentPanel.add(txtDireccion);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setOpaque(true);
		btnRegistrar.setBorder(new LineBorder(Color.BLACK, 2));
		btnRegistrar.setBounds(250, 330, 130, 45);
		contentPanel.add(btnRegistrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 15));
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setOpaque(true);
		btnCancelar.setBorder(new LineBorder(Color.BLACK, 2));
		btnCancelar.setBounds(395, 330, 130, 45);
		contentPanel.add(btnCancelar);

		cargarDatos();
	}

	private void cargarDatos() {
		if(miCliente == null) {
			txtCodigo.setText(Altice.generarCodigo("C-", Altice.generadorCliente));
		}
		else {
			setTitle("Modificar Cliente");
			btnRegistrar.setText("Modificar");
			txtCodigo.setText(miCliente.getCodigo());
			txtCedula.setText(miCliente.getCedula());
			txtCedula.setEditable(false);
			txtNombre.setText(miCliente.getNombre());
			txtTelefono.setText(miCliente.getTelefono());
			txtCorreo.setText(miCliente.getCorreo());
			txtDireccion.setText(miCliente.getDireccion());
			if(miCliente.getFechaNacimiento() != null) {
				spnFechaNacimiento.setValue(miCliente.getFechaNacimiento());
			}
		}
	}

	private void guardar() {
		String cedula = txtCedula.getText();
		String nombre = txtNombre.getText();
		String telefono = txtTelefono.getText();
		String correo = txtCorreo.getText();
		String direccion = txtDireccion.getText();
		Date fechaNacimiento = (Date) spnFechaNacimiento.getValue();

		if(cedula.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty() || direccion.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
		}
		else if(miCliente == null) {
			if(Altice.getInstance().buscarCliente(cedula) != null) {
				JOptionPane.showMessageDialog(null, "Ya existe un cliente con esa c\u00E9dula.", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			else {
				Cliente nuevo = new Cliente(cedula, nombre, telefono, correo, direccion, fechaNacimiento, txtCodigo.getText());
				Altice.getInstance().registrarCliente(nuevo);
				JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.", "Informaci\u00F3n", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			}
		}
		else {
			miCliente.setNombre(nombre);
			miCliente.setTelefono(telefono);
			miCliente.setCorreo(correo);
			miCliente.setDireccion(direccion);
			miCliente.setFechaNacimiento(fechaNacimiento);
			Altice.getInstance().modificarCliente(miCliente);
			JOptionPane.showMessageDialog(null, "Cliente modificado correctamente.", "Informaci\u00F3n", JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}
}