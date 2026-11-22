package logico;

import java.util.Date;

public class Contrato {

	private String id;
	private Cliente cliente;
	private Plan plan;
	private Date fechaInicializacion;
	private Comercial comercial;
	private boolean estado;
	private float precioMensual;
	
	private static final String prefijo = "CON-";
	
	public Contrato(Cliente cliente, Plan plan, Comercial comercial) {
		super();
		this.id = Altice.generarCodigo(prefijo, Altice.getGeneradorContrato());
		this.cliente = cliente;
		this.fechaInicializacion = new Date();
		this.estado = true;
		this.comercial = comercial;
		this.plan = plan;
		this.precioMensual = plan.calcularPrecio();
	}
		
	
	public Comercial getComercial() {
		return comercial;
	}
	
	public float getPrecioMensual() {
		return precioMensual;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public String getId() {
		return id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaInicializacion() {
		return fechaInicializacion;
	}
	public void setFechaInicializacion(Date fechaInicializacion) {
		this.fechaInicializacion = fechaInicializacion;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
}
