package logico;

import java.util.ArrayList;

public class Plan {
	
	private ArrayList<Servicio> servicios;
	private String id;
	private String nombre;
	private String descripcion;
	private double descuento;
	private int duracionMeses;
	
	public Plan(String id, String nombre, String descripcion, double descuento, int duracionMeses) {
		super();
		this.id = id;
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
	
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public int getDuracionMeses() {
		return duracionMeses;
	}
	public void setDuracionMeses(int duracionMeses) {
		this.duracionMeses = duracionMeses;
	}
	
	
	
}
