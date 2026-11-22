package logico;

import java.util.Date;

public class Factura {

	private String id;
	private Contrato contrato;
	private Date fecha;
	private String sucursal;
	private static final float tasa_itbis = 0.18f;
	private float subtotal;
	private float itbis;
	private float total;
	private boolean pagado;
	private String periodo;
	private static final String prefijo = "FAC-";
	
	public Factura(Contrato contrato, String sucursal, String periodo) {
		super();
		this.id = Altice.generarCodigo(prefijo, Altice.getGeneradorFacturas());
		this.fecha = new Date();
		this.contrato = contrato;
		this.periodo = periodo;
		this.sucursal = sucursal;
		this.pagado = false;
		
		calcularTotal();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Contrato getContrato() {
		return contrato;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public float getItbis() {
		return itbis;
	}
	public float getSubtotal() {
		return subtotal;
	}

	public float getTotal() {
		return total;
	}
	
	public boolean isPagado() {
		return pagado;
	}
	
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void calcularTotal()
	{
		subtotal = contrato.getPrecioMensual();
		itbis = subtotal * tasa_itbis;
		
		total = subtotal + itbis;
	}
	
	public boolean pagar()
	{
		if(pagado)
		{
			return false;
		}
		
		pagado = true;
		return true;
	}
}
