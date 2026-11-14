package logico;

public class Trabajador extends Empleado {
	
	public static final float PagoHoraExtra = 355;
	
	private String area;
	private int horasExtras;
	

	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public int getHorasExtras() {
		return horasExtras;
	}


	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}
	

	public Trabajador(String idEmpleado, String cedula, String nombreEmp, String telefono, String usuario,
			String contrasena, float sueldoBase, Sucursal sucursal, String area, int horasExtras) {
		super(idEmpleado, cedula, nombreEmp, telefono, usuario, contrasena, sueldoBase, sucursal);
		this.area = area;
		this.horasExtras = horasExtras;
	}


	@Override
	public float calcularSalario() {
		
		return getSueldoBase() + (horasExtras*PagoHoraExtra);
	}

}
