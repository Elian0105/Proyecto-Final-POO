package logico;

import java.util.ArrayList;

public class Plan {
	
	private ArrayList<Servicio> servicios;
	private String id;
	private String nombre;
	private String descripcion;
	private float descuento;
	private int duracionMeses;
	private static final String prefijo = "PLA-";
	
	public Plan(String nombre, String descripcion, float descuento, int duracionMeses) {
		super();
		this.id = Altice.generarCodigo(prefijo, Altice.getGeneradorPlan());
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.duracionMeses = duracionMeses;
		this.servicios = new ArrayList<>();
	}
	
	public ArrayList<Servicio> getServicios() {
		return servicios;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	public int getDuracionMeses() {
		return duracionMeses;
	}
	public void setDuracionMeses(int duracionMeses) {
		this.duracionMeses = duracionMeses;
	}
	
	public boolean agregarServicio(Servicio servicio)
	{
		if(servicio == null || servicio.getPrecio() < 0)
		{
			return false;
		}
		
		boolean confirmacion = servicios.add(servicio);
		
		return confirmacion;
	}
	
	public float calcularPrecio()
	{
		float precio = 0;
		
		for(Servicio aux : servicios)
		{
			precio += aux.calcularPrecio();
		}
		
		float total = precio - (precio * descuento / 100);
		
		return total;
	}
}
