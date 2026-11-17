package logico;

public class Internet extends Servicio {

	private String tipo;
	private int velocidadSubida;
	private int velocidadBajada;
	private static final String prefijo = "INT-";
	
	
	public Internet(String nombre, float precio, String descripcion, String tipo, int velocidadSubida, int velocidadBajada) {
		super(prefijo, Altice.getGeneradorServicioInternet(), nombre, precio, descripcion);
		this.tipo = tipo;
		this.velocidadSubida = velocidadSubida;
		this.velocidadBajada = velocidadBajada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getVelocidadSubida() {
		return velocidadSubida;
	}

	public void setVelocidadSubida(int velocidadSubida) {
		this.velocidadSubida = velocidadSubida;
	}

	public int getVelocidadBajada() {
		return velocidadBajada;
	}

	public void setVelocidadBajada(int velocidadBajada) {
		this.velocidadBajada = velocidadBajada;
	}

	@Override
	public float calcularPrecio() {
		return getPrecio();
	}

	@Override
	public boolean esValido() {
		
		return getNombre() != null && !getNombre().trim().isEmpty() && getPrecio() >= 0 && velocidadSubida > 0 && velocidadBajada > 0
			&& velocidadSubida < velocidadBajada;
	}

	
}
