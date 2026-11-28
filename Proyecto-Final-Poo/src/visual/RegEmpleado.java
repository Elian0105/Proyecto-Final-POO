package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logico.Administrativo;
import logico.Altice;
import logico.Comercial;
import logico.Empleado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JSpinner spnFechaNacimiento;
	private JTextField txtId;
	private JComboBox<String> cbxTipo;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JTextField txtPuesto;
	private JComboBox<String> cbxSucursal;
	private JTextField txtSueldo;
	private JSpinner spnFechaIngreso;
	private JPanel panelComercial;
	private JTextField txtComision;
	private JPanel panelAdministrativo;
	private JTextField txtDepartamento;
	private JTextField txtBono;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private Empleado miEmpleado;

	public RegEmpleado(Empleado empleado) {
		miEmpleado = empleado;
		setModal(true);
		setResizable(false);
		setTitle("Registrar Empleado");
		setBounds(100, 100, 600, 715);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel franja = new JPanel();
		franja.setBackground(Color.BLACK);
		franja.setBounds(0, 0, 600, 12);
		contentPanel.add(franja);

		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Arial", Font.BOLD, 15));
		lblDatosPersonales.setBounds(30, 22, 300, 20);
		contentPanel.add(lblDatosPersonales);

		JSeparator separator1 = new JSeparator();
		separator1.setForeground(new Color(204, 204, 204));
		separator1.setBounds(30, 44, 535, 2);
		contentPanel.add(separator1);

		JLabel lblCedula = new JLabel("C\u00E9dula");
		lblCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCedula.setBounds(30, 52, 255, 20);
		contentPanel.add(lblCedula);

		txtCedula = new JTextField();
		txtCedula.setBackground(Color.WHITE);
		txtCedula.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCedula.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtCedula.setBounds(30, 74, 255, 30);
		contentPanel.add(txtCedula);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(310, 52, 255, 20);
		contentPanel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		txtNombre.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtNombre.setBounds(310, 74, 255, 30);
		contentPanel.add(txtNombre);

		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTelefono.setBounds(30, 112, 255, 20);
		contentPanel.add(lblTelefono);

		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTelefono.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtTelefono.setBounds(30, 134, 255, 30);
		contentPanel.add(txtTelefono);

		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCorreo.setBounds(310, 112, 255, 20);
		contentPanel.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtCorreo.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtCorreo.setBounds(310, 134, 255, 30);
		contentPanel.add(txtCorreo);

		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDireccion.setBounds(30, 172, 255, 20);
		contentPanel.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDireccion.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtDireccion.setBounds(30, 194, 255, 30);
		contentPanel.add(txtDireccion);

		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 15));
		lblFechaNacimiento.setBounds(310, 172, 255, 20);
		contentPanel.add(lblFechaNacimiento);

		spnFechaNacimiento = new JSpinner();
		spnFechaNacimiento.setModel(new SpinnerDateModel());
		spnFechaNacimiento.setEditor(new JSpinner.DateEditor(spnFechaNacimiento, "dd/MM/yyyy"));
		spnFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 15));
		spnFechaNacimiento.setBorder(new LineBorder(new Color(204, 204, 204)));
		spnFechaNacimiento.setBounds(310, 194, 255, 30);
		contentPanel.add(spnFechaNacimiento);

		JLabel lblDatosEmpleado = new JLabel("Datos del empleado");
		lblDatosEmpleado.setFont(new Font("Arial", Font.BOLD, 15));
		lblDatosEmpleado.setBounds(30, 236, 300, 20);
		contentPanel.add(lblDatosEmpleado);

		JSeparator separator2 = new JSeparator();
		separator2.setForeground(new Color(204, 204, 204));
		separator2.setBounds(30, 258, 535, 2);
		contentPanel.add(separator2);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.PLAIN, 15));
		lblId.setBounds(30, 266, 255, 20);
		contentPanel.add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBackground(Color.WHITE);
		txtId.setFont(new Font("Arial", Font.PLAIN, 15));
		txtId.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtId.setBounds(30, 288, 255, 30);
		contentPanel.add(txtId);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTipo.setBounds(310, 266, 255, 20);
		contentPanel.add(lblTipo);

		cbxTipo = new JComboBox<String>();
		cbxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanelTipo();
			}
		});
		cbxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Empleado", "Comercial", "Administrativo"}));
		cbxTipo.setBackground(Color.WHITE);
		cbxTipo.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxTipo.setBounds(310, 288, 255, 30);
		contentPanel.add(cbxTipo);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUsuario.setBounds(30, 326, 255, 20);
		contentPanel.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		txtUsuario.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtUsuario.setBounds(30, 348, 255, 30);
		contentPanel.add(txtUsuario);

		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 15));
		lblContrasena.setBounds(310, 326, 255, 20);
		contentPanel.add(lblContrasena);

		txtContrasena = new JPasswordField();
		txtContrasena.setFont(new Font("Arial", Font.PLAIN, 15));
		txtContrasena.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtContrasena.setBounds(310, 348, 255, 30);
		contentPanel.add(txtContrasena);

		JLabel lblPuesto = new JLabel("Puesto");
		lblPuesto.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPuesto.setBounds(30, 386, 255, 20);
		contentPanel.add(lblPuesto);

		txtPuesto = new JTextField();
		txtPuesto.setFont(new Font("Arial", Font.PLAIN, 15));
		txtPuesto.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtPuesto.setBounds(30, 408, 255, 30);
		contentPanel.add(txtPuesto);

		JLabel lblSucursal = new JLabel("Sucursal");
		lblSucursal.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSucursal.setBounds(310, 386, 255, 20);
		contentPanel.add(lblSucursal);

		cbxSucursal = new JComboBox<String>();
		cbxSucursal.setModel(new DefaultComboBoxModel<String>(new String[] {"Santiago Centro", "La Vega", "Moca", "Puerto Plata", "Santo Domingo"}));
		cbxSucursal.setEditable(true);
		cbxSucursal.setBackground(Color.WHITE);
		cbxSucursal.setFont(new Font("Arial", Font.PLAIN, 15));
		cbxSucursal.setBounds(310, 408, 255, 30);
		contentPanel.add(cbxSucursal);

		JLabel lblSueldo = new JLabel("Sueldo base");
		lblSueldo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSueldo.setBounds(30, 446, 255, 20);
		contentPanel.add(lblSueldo);

		txtSueldo = new JTextField();
		txtSueldo.setFont(new Font("Arial", Font.PLAIN, 15));
		txtSueldo.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtSueldo.setBounds(30, 468, 255, 30);
		contentPanel.add(txtSueldo);

		JLabel lblFechaIngreso = new JLabel("Fecha de ingreso");
		lblFechaIngreso.setFont(new Font("Arial", Font.PLAIN, 15));
		lblFechaIngreso.setBounds(310, 446, 255, 20);
		contentPanel.add(lblFechaIngreso);

		spnFechaIngreso = new JSpinner();
		spnFechaIngreso.setModel(new SpinnerDateModel());
		spnFechaIngreso.setEditor(new JSpinner.DateEditor(spnFechaIngreso, "dd/MM/yyyy"));
		spnFechaIngreso.setFont(new Font("Arial", Font.PLAIN, 15));
		spnFechaIngreso.setBorder(new LineBorder(new Color(204, 204, 204)));
		spnFechaIngreso.setBounds(310, 468, 255, 30);
		contentPanel.add(spnFechaIngreso);

		panelComercial = new JPanel();
		panelComercial.setBackground(Color.WHITE);
		panelComercial.setBounds(30, 510, 535, 85);
		panelComercial.setLayout(null);
		contentPanel.add(panelComercial);

		JLabel lblSoloComercial = new JLabel("Solo Comercial");
		lblSoloComercial.setFont(new Font("Arial", Font.BOLD, 15));
		lblSoloComercial.setBounds(0, 0, 300, 20);
		panelComercial.add(lblSoloComercial);

		JSeparator separator3 = new JSeparator();
		separator3.setForeground(new Color(204, 204, 204));
		separator3.setBounds(0, 22, 535, 2);
		panelComercial.add(separator3);

		JLabel lblComision = new JLabel("Comisi\u00F3n por contrato");
		lblComision.setFont(new Font("Arial", Font.PLAIN, 15));
		lblComision.setBounds(0, 30, 255, 20);
		panelComercial.add(lblComision);

		txtComision = new JTextField();
		txtComision.setFont(new Font("Arial", Font.PLAIN, 15));
		txtComision.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtComision.setBounds(0, 52, 255, 30);
		panelComercial.add(txtComision);

		panelAdministrativo = new JPanel();
		panelAdministrativo.setBackground(Color.WHITE);
		panelAdministrativo.setBounds(30, 510, 535, 85);
		panelAdministrativo.setLayout(null);
		contentPanel.add(panelAdministrativo);

		JLabel lblSoloAdministrativo = new JLabel("Solo Administrativo");
		lblSoloAdministrativo.setFont(new Font("Arial", Font.BOLD, 15));
		lblSoloAdministrativo.setBounds(0, 0, 300, 20);
		panelAdministrativo.add(lblSoloAdministrativo);

		JSeparator separator4 = new JSeparator();
		separator4.setForeground(new Color(204, 204, 204));
		separator4.setBounds(0, 22, 535, 2);
		panelAdministrativo.add(separator4);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Arial", Font.PLAIN, 15));
		lblDepartamento.setBounds(0, 30, 255, 20);
		panelAdministrativo.add(lblDepartamento);

		txtDepartamento = new JTextField();
		txtDepartamento.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDepartamento.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtDepartamento.setBounds(0, 52, 255, 30);
		panelAdministrativo.add(txtDepartamento);

		JLabel lblBono = new JLabel("Bono");
		lblBono.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBono.setBounds(280, 30, 255, 20);
		panelAdministrativo.add(lblBono);

		txtBono = new JTextField();
		txtBono.setFont(new Font("Arial", Font.PLAIN, 15));
		txtBono.setBorder(new CompoundBorder(new LineBorder(new Color(204, 204, 204)), new EmptyBorder(0, 8, 0, 0)));
		txtBono.setBounds(280, 52, 255, 30);
		panelAdministrativo.add(txtBono);

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
		btnRegistrar.setBounds(290, 615, 130, 45);
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
		btnCancelar.setBounds(435, 615, 130, 45);
		contentPanel.add(btnCancelar);

		cargarDatos();
		mostrarPanelTipo();
	}

	private void mostrarPanelTipo() {
		String tipo = cbxTipo.getSelectedItem().toString();
		panelComercial.setVisible(tipo.equals("Comercial"));
		panelAdministrativo.setVisible(tipo.equals("Administrativo"));
	}

	private void cargarDatos() {
		if(miEmpleado == null) {
			txtId.setText(Altice.generarCodigo("E-", Altice.getGeneradorEmpleado()));
		}
		else {
			setTitle("Modificar Empleado");
			btnRegistrar.setText("Modificar");
			txtCedula.setText(miEmpleado.getCedula());
			txtCedula.setEditable(false);
			txtNombre.setText(miEmpleado.getNombre());
			txtTelefono.setText(miEmpleado.getTelefono());
			txtCorreo.setText(miEmpleado.getCorreo());
			txtDireccion.setText(miEmpleado.getDireccion());
			if(miEmpleado.getFechaNacimiento() != null) {
				spnFechaNacimiento.setValue(miEmpleado.getFechaNacimiento());
			}
			txtId.setText(miEmpleado.getIdEmpleado());
			txtUsuario.setText(miEmpleado.getUsuario());
			txtContrasena.setText(miEmpleado.getContrasena());
			txtPuesto.setText(miEmpleado.getPuesto());
			cbxSucursal.setSelectedItem(miEmpleado.getSucursal());
			txtSueldo.setText("" + miEmpleado.getSueldoBase());
			if(miEmpleado.getFechaIngreso() != null) {
				spnFechaIngreso.setValue(miEmpleado.getFechaIngreso());
			}
			if(miEmpleado instanceof Comercial) {
				cbxTipo.setSelectedItem("Comercial");
				txtComision.setText("" + ((Comercial) miEmpleado).getComisionPorContrato());
			}
			else if(miEmpleado instanceof Administrativo) {
				cbxTipo.setSelectedItem("Administrativo");
				txtDepartamento.setText(((Administrativo) miEmpleado).getDepartamento());
				txtBono.setText("" + ((Administrativo) miEmpleado).getBono());
			}
			else {
				cbxTipo.setSelectedItem("Empleado");
			}
			cbxTipo.setEnabled(false);
		}
	}

	private boolean existeUsuario(String usuario) {
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < Altice.getInstance().getMisEmpleados().size()) {
			Empleado aux = Altice.getInstance().getMisEmpleados().get(i);
			if(aux != miEmpleado && aux.getUsuario().equals(usuario)) {
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}

	private boolean existeCedula(String cedula) {
		int i = 0;
		boolean encontrado = false;
		while(encontrado == false && i < Altice.getInstance().getMisEmpleados().size()) {
			if(Altice.getInstance().getMisEmpleados().get(i).getCedula().equalsIgnoreCase(cedula)) {
				encontrado = true;
			}
			i++;
		}
		return encontrado;
	}

	private void guardar() {
		String cedula = txtCedula.getText();
		String nombre = txtNombre.getText();
		String telefono = txtTelefono.getText();
		String correo = txtCorreo.getText();
		String direccion = txtDireccion.getText();
		Date fechaNacimiento = (Date) spnFechaNacimiento.getValue();
		String usuario = txtUsuario.getText();
		String contrasena = new String(txtContrasena.getPassword());
		String puesto = txtPuesto.getText();
		String sucursal = cbxSucursal.getSelectedItem().toString();
		Date fechaIngreso = (Date) spnFechaIngreso.getValue();
		String tipo = cbxTipo.getSelectedItem().toString();

		if(cedula.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty() || direccion.isEmpty() || usuario.isEmpty() || contrasena.isEmpty() || puesto.isEmpty() || sucursal.isEmpty() || txtSueldo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe llenar todos los campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(miEmpleado == null && existeCedula(cedula)) {
			JOptionPane.showMessageDialog(null, "Ya existe un empleado con esa c\u00E9dula.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(existeUsuario(usuario)) {
			JOptionPane.showMessageDialog(null, "Ese usuario ya est\u00E1 en uso.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}

		float sueldo = 0;
		float comision = 0;
		float bono = 0;
		String departamento = txtDepartamento.getText();
		try {
			sueldo = Float.parseFloat(txtSueldo.getText());
			if(tipo.equals("Comercial")) {
				comision = Float.parseFloat(txtComision.getText());
			}
			if(tipo.equals("Administrativo")) {
				bono = Float.parseFloat(txtBono.getText());
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Sueldo, comisi\u00F3n y bono deben ser n\u00FAmeros.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if(tipo.equals("Administrativo") && departamento.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe escribir el departamento.", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}

		if(miEmpleado == null) {
			Empleado nuevo = null;
			if(tipo.equals("Comercial")) {
				nuevo = new Comercial(cedula, nombre, telefono, correo, direccion, fechaNacimiento, txtId.getText(), usuario, contrasena, sueldo, puesto, sucursal, fechaIngreso, comision);
			}
			else if(tipo.equals("Administrativo")) {
				nuevo = new Administrativo(cedula, nombre, telefono, correo, direccion, fechaNacimiento, txtId.getText(), usuario, contrasena, sueldo, puesto, sucursal, fechaIngreso, departamento, bono);
			}
			else {
				nuevo = new Empleado(cedula, nombre, telefono, correo, direccion, fechaNacimiento, txtId.getText(), usuario, contrasena, sueldo, puesto, sucursal, fechaIngreso);
			}
			Altice.getInstance().registrarEmpleado(nuevo);
			JOptionPane.showMessageDialog(null, "Empleado registrado correctamente.", "Informaci\u00F3n", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			miEmpleado.setNombre(nombre);
			miEmpleado.setTelefono(telefono);
			miEmpleado.setCorreo(correo);
			miEmpleado.setDireccion(direccion);
			miEmpleado.setFechaNacimiento(fechaNacimiento);
			miEmpleado.setUsuario(usuario);
			miEmpleado.setContrasena(contrasena);
			miEmpleado.setPuesto(puesto);
			miEmpleado.setSucursal(sucursal);
			miEmpleado.setSueldoBase(sueldo);
			miEmpleado.setFechaIngreso(fechaIngreso);
			if(miEmpleado instanceof Comercial) {
				((Comercial) miEmpleado).setComisionPorContrato(comision);
			}
			else if(miEmpleado instanceof Administrativo) {
				((Administrativo) miEmpleado).setDepartamento(departamento);
				((Administrativo) miEmpleado).setBono(bono);
			}
			Altice.getInstance().modificarEmpleado(miEmpleado);
			JOptionPane.showMessageDialog(null, "Empleado modificado correctamente.", "Informaci\u00F3n", JOptionPane.INFORMATION_MESSAGE);
		}
		dispose();
	}
}