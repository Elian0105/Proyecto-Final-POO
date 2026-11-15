package logico;

public class Telefonia extends Servicio {

	private int minutos;
	private boolean llamadasIlimitadas;
	
	public Telefonia(String id, String nombre, double precio, String descripcion, int minutos, boolean llamadasIlimitadas) {
		super(id, nombre, precio, descripcion);
		this.minutos = minutos;
		this.llamadasIlimitadas = llamadasIlimitadas;
	}
	
	
	public int getMinutos() {
		return minutos;
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
	public double calcularPrecio() {
		return 0;
	}
	
}
