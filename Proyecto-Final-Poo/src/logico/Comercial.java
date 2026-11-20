package logico;

import java.util.Date;

public class Comercial extends Empleado {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cantContratos;
	private float comisionPorContrato;
	

	public int getCantContratos() {
		return cantContratos;
	}


	public void setCantContratos(int cantContratos) {
		this.cantContratos = cantContratos;
	}


	public float getComisionPorContrato() {
		return comisionPorContrato;
	}


	public void setComisionPorContrato(float comisionPorContrato) {
		this.comisionPorContrato = comisionPorContrato;
	}
	

	
	public Comercial(String cedula, String nombre, String telefono, String correo, String direccion,
			Date fechaNacimiento, String idEmpleado, String usuario, String contrasena, float sueldoBase, String puesto,
			String sucursal, Date fechaIngreso, float comisionPorContrato) {
		super(cedula, nombre, telefono, correo, direccion, fechaNacimiento, idEmpleado, usuario, contrasena, sueldoBase,
				puesto, sucursal, fechaIngreso);
		this.comisionPorContrato = comisionPorContrato;
		this.cantContratos = 0;
	}


	public void agregarContrato() {
		
		setCantContratos(getCantContratos()+1);
	}


	@Override
	public float calcularSalario() {
		return getSueldoBase() + (cantContratos*comisionPorContrato);
	}

}
