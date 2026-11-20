package logico;

import java.util.Date;

public class Empleado extends Persona{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idEmpleado;
	private String usuario;
	private String contrasena;
	private float sueldoBase;
	private boolean estado;
	private String puesto;
	private String sucursal;
	private Date fechaIngreso;
	private Date fechaSalida;
	
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getSucursal() {
		return sucursal;
	}
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
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
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	public Empleado(String cedula, String nombre, String telefono, String correo, String direccion,
			Date fechaNacimiento, String idEmpleado, String usuario, String contrasena, float sueldoBase, String puesto,
			String sucursal, Date fechaIngreso) {
		super(cedula, nombre, telefono, correo, direccion, fechaNacimiento);
		this.idEmpleado = idEmpleado;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.sueldoBase = sueldoBase;
		this.puesto = puesto;
		this.sucursal = sucursal;
		this.fechaIngreso = fechaIngreso;
		this.estado = true;
		this.fechaSalida = null;
	}
	public float calcularSalario() {
		
		return getSueldoBase();
	}
	
}