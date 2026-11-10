package logico;

public class Cliente {
	private String cedula;
	private String codigo;
	private String nombre;
	private String telefono;
	private String direccion;
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Cliente(String cedula, String codigo, String nombre, String telefono, String direccion) {
		super();
		this.cedula = cedula;
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	

}
