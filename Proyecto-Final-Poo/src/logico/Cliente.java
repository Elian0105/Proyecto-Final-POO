package logico;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private boolean estado;
	private ArrayList<Contrato> contratos;
	private ArrayList<Factura> facturas;
	private float deuda;

	public ArrayList<Contrato> getContratos() {
		return contratos;
	}
	public void setContratos(ArrayList<Contrato> contratos) {
		this.contratos = contratos;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public float getDeuda() {
		return deuda;
	}
	public void setDeuda(float deuda) {
		this.deuda = deuda;
	}
	public Cliente(String cedula, String nombre, String telefono, String correo, String direccion, Date fechaNacimiento,
			String codigo) {
		super(cedula, nombre, telefono, correo, direccion, fechaNacimiento);
		this.codigo = codigo;
		this.estado = true;
		contratos = new ArrayList<>();
		facturas = new ArrayList<>();
		this.deuda = 0;
	}
	public boolean tieneContratosActivos()
	{
		for(Contrato aux : contratos)
		{
			if(aux != null && aux.isEstado())
			{
				return true;
			}
		}

		return false;
	}

	public int facturasPendiente()
	{
		int pendiente = 0;

		for(Factura aux : facturas)
		{
			if(!aux.isPagado())
			{
				pendiente++;
			}
		}

		return pendiente;
	}
	public void agregarDeuda(float monto) {
		setDeuda(getDeuda() + monto);

	}
	public boolean puedeContratar() {

		int i = 0;
		int j ;
		boolean encontrado = false;
		while(encontrado == false && i < facturas.size()) {
			for(j = i + 1; j < facturas.size(); j++) {
				if(facturas.get(i).getContrato().getId().equals(facturas.get(j).getContrato().getId()) && !facturas.get(i).isPagado() && !facturas.get(j).isPagado()) {
					encontrado = true;
				}

			}
			j = 0;
			i++;

		}



		boolean permitido = true;
		if(encontrado == true || deuda > 0) {

			permitido = false;
		}

		return permitido;
	}
}
