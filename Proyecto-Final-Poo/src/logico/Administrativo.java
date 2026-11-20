package logico;

import java.util.Date;

public class Administrativo extends Empleado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String departamento;
	private float bono;
	

	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public float getBono() {
		return bono;
	}


	public void setBono(float bono) {
		this.bono = bono;
	}
	



	public Administrativo(String cedula, String nombre, String telefono, String correo, String direccion,
			Date fechaNacimiento, String idEmpleado, String usuario, String contrasena, float sueldoBase, String puesto,
			String sucursal, Date fechaIngreso, String departamento, float bono) {
		super(cedula, nombre, telefono, correo, direccion, fechaNacimiento, idEmpleado, usuario, contrasena, sueldoBase,
				puesto, sucursal, fechaIngreso);
		this.departamento = departamento;
		this.bono = bono;
	}


	@Override
	public float calcularSalario() {
	
		return getSueldoBase() + bono;
	}

}
