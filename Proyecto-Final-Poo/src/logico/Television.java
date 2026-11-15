package logico;

public class Television extends Servicio{
	
	private int cantCanales;
	private String tipoConexion; //Fibra o Satelital
	private int canalesHD;
	
	public Television(String id, String nombre, double precio, String descripcion, int cantCanales, String tipoConexion, int canalesHD) {
		super(id, nombre, precio, descripcion);
		
		this.cantCanales = cantCanales;
		this.tipoConexion = tipoConexion;
		this.canalesHD = canalesHD;
	}
	
	public int getCantCanales() {
		return cantCanales;
	}
	public void setCantCanales(int cantCanales) {
		this.cantCanales = cantCanales;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
	public int getCanalesHD() {
		return canalesHD;
	}
	public void setCanalesHD(int canalesHD) {
		this.canalesHD = canalesHD;
	}

	@Override
	public double calcularPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
