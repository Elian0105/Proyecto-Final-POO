package logico;

public class Internet extends Servicio {

	private String tipo;
	private int velocidadSubida;
	private int velocidadBajada;
	private int cantidadGB; //solo para datos moviles, sino seria 0 para el internet fijo
	
	
	public Internet(String id, String nombre, double precio, String descripcion, String tipo, int velocidadSubida, int velocidadBajada, int cantidadGB) {
		super(id, nombre, precio, descripcion);
		this.tipo = tipo;
		this.velocidadSubida = velocidadSubida;
		this.velocidadBajada = velocidadBajada;
		this.cantidadGB = cantidadGB;
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

	public int getCantidadGB() {
		return cantidadGB;
	}

	public void setCantidadGB(int cantidadGB) {
		this.cantidadGB = cantidadGB;
	}

	@Override
	public double calcularPrecio() {
		return 0;
	}

	
}
