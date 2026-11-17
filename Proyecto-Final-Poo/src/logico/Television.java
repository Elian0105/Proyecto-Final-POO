package logico;

public class Television extends Servicio{
	
	private int cantCanales;
	private String tipoConexion; //Fibra o Satelital
	private int canalesHD;
	private static final String prefijo = "TV-";
	
	public Television(String nombre, float precio, String descripcion, int cantCanales, String tipoConexion, int canalesHD) {
		super(prefijo, Altice.getGeneradorServicioTv(), nombre, precio, descripcion);
		
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
	public float calcularPrecio() {
		return getPrecio();
	}

	@Override
	public boolean esValido() {

		return getPrecio() >= 0 && getNombre() != null && !getNombre().trim().isEmpty() && 
		cantCanales > 0 && tipoConexion != null && !tipoConexion.trim().isEmpty() && canalesHD >= 0 && canalesHD <= cantCanales;
	}
	
	
	
}
