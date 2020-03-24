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
	
	public void hacerClickDer() {
		estado.hacerClickD(this);
	}
	
	public void hacerClickIzq() {
		estado.hacerClickIz(this);
	}
	public boolean esMina() {
		return conMina;
	}
	
	public Estado getEstado() {
		return estado;
	}
	public int getValor() {
		return valor;
	}
	public void incValorCasilla() {
		valor++;
	}
	
	public void addMina() {
		conMina=true;
	}
	
	//Prueba
}
