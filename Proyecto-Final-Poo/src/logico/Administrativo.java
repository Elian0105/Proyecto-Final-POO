package logico;

public class Administrativo extends Empleado {
	
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
	

	public Administrativo(String idEmpleado, String cedula, String nombreEmp, String telefono, String usuario,
			String contrasena, float sueldoBase, Sucursal sucursal, String departamento, float bono) {
		super(idEmpleado, cedula, nombreEmp, telefono, usuario, contrasena, sueldoBase, sucursal);
		this.departamento = departamento;
		this.bono = bono;
	}


	@Override
	public float calcularSalario() {
	
		return getSueldoBase() + bono;
	}

}
