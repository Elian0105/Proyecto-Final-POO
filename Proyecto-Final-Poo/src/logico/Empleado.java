package logico;

public abstract class Empleado {
	
	private String idEmpleado;
	private String cedula;
	private String nombreEmp;
	private String telefono;
	private String usuario;
	private String contrasena;
	private float sueldoBase;
	private Sucursal sucursal;
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombreEmp() {
		return nombreEmp;
	}
	public void setNombreEmp(String nombreEmp) {
		this.nombreEmp = nombreEmp;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public float getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public Empleado(String idEmpleado, String cedula, String nombreEmp, String telefono, String usuario,
			String contrasena, float sueldoBase, Sucursal sucursal) {
		super();
		this.idEmpleado = idEmpleado;
		this.cedula = cedula;
		this.nombreEmp = nombreEmp;
		this.telefono = telefono;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.sueldoBase = sueldoBase;
		this.sucursal = sucursal;
	}
	public abstract float calcularSalario();
	
	

} 