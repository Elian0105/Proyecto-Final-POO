package logico;

public class Comercial extends Empleado {
	
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
	

	public Comercial(String idEmpleado, String cedula, String nombreEmp, String telefono, String usuario,
			String contrasena, float sueldoBase, Sucursal sucursal,float comisionPorContrato) {
		super(idEmpleado, cedula, nombreEmp, telefono, usuario, contrasena, sueldoBase, sucursal);
		this.cantContratos = 0;
		this.comisionPorContrato = comisionPorContrato;
	}
	
	public void agregarContrato() {
		
		setCantContratos(getCantContratos()+1);
	}


	@Override
	public float calcularSalario() {
		return getSueldoBase() + (cantContratos*comisionPorContrato);
	}

}
