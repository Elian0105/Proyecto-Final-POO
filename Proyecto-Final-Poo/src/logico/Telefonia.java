package logico;

public class Telefonia extends Servicio {

	private int minutos;
	private boolean llamadasIlimitadas;
	private int cantidadGB;
	private int vigenciaDias;
	private static final String prefijo = "TEL-";
	
	public Telefonia(String nombre, float precio, String descripcion, int minutos, boolean llamadasIlimitadas, int cantidadGB, int vigenciaDias) {
		super(prefijo, Altice.getGeneradorServicioTelefono(), nombre, precio, descripcion);
		this.minutos = minutos;
		this.llamadasIlimitadas = llamadasIlimitadas;
		this.vigenciaDias = vigenciaDias;
		this.cantidadGB = cantidadGB;
	}
	
	
	public int getMinutos() {
		return minutos;
	}

	public int getCantidadGB() {
		return cantidadGB;
	}


	public void setCantidadGB(int cantidadGB) {
		this.cantidadGB = cantidadGB;
	}


	public int getVigenciaDias() {
		return vigenciaDias;
	}


	public void setVigenciaDias(int vigenciaDias) {
		this.vigenciaDias = vigenciaDias;
	}


	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}


	public boolean isLlamadasIlimitadas() {
		return llamadasIlimitadas;
	}


	public void setLlamadasIlimitadas(boolean llamadasIlimitadas) {
		this.llamadasIlimitadas = llamadasIlimitadas;
	}

	@Override
	public float calcularPrecio() {
		return getPrecio();
	}


	@Override
	public boolean esValido() {
		
		return getPrecio() >= 0 && getNombre() != null && !getNombre().trim().isEmpty() && minutos >= 0 && cantidadGB >= 0 && 
				(minutos > 0 || cantidadGB > 0) && vigenciaDias > 0;
	}
	
}
