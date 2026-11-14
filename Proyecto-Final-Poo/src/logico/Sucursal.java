package logico;

public class Sucursal {
	
	private String idSucursal;
	private String nombreSuc;
	private String  provincia;
	private String direccion;
	public String getIdSucursal() {
		return idSucursal;
	}
	public void setIdSucursal(String idSucursal) {
		this.idSucursal = idSucursal;
	}
	public String getNombreSuc() {
		return nombreSuc;
	}
	public void setNombreSuc(String nombreSuc) {
		this.nombreSuc = nombreSuc;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Sucursal(String idSucursal, String nombreSuc, String provincia, String direccion) {
		super();
		this.idSucursal = idSucursal;
		this.nombreSuc = nombreSuc;
		this.provincia = provincia;
		this.direccion = direccion;
	}
	
	

}
