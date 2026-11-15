package logico;

public abstract class Servicio {

	protected String id;
	protected String nombre;
	protected double precio;
	protected String descripcion;
	
	public Servicio(String id, String nombre, double precio, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
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

	public abstract double calcularPrecio();
	
}
