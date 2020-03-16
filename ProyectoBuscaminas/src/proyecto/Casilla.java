package proyecto;

public class Casilla {
	private boolean conMina;
	private int valor;
	private Estado estado;
	
	public Casilla() {
		valor=0;
		conMina=false;
		estado= new Tapada();
	}

	public void cambiarEstado(Estado pEstado) {
		estado=pEstado;
	}
	
	public boolean esMina() {
		return conMina;
	}
	
	public Estado getEstado() {
		return estado;
	}
	public void incValorCasilla() {
		valor++;
	}
}