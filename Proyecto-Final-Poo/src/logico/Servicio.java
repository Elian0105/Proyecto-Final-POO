package logico;

public abstract class Servicio {

	protected String id;
	protected String nombre;
	protected float precio;
	protected String descripcion;
	protected boolean estado;
	
	public Servicio(String prefijo, int num, String nombre, float precio, String descripcion) {
		super();
		this.id = Altice.generarCodigo(prefijo, num);
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.estado = true;
	}	
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public abstract float calcularPrecio();
	
	public abstract boolean esValido();
	
}
