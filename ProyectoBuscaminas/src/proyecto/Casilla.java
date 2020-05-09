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
	
	public int getEstado() {
		int resp=-1;
		if(estado instanceof Tapada) {
			resp=1;
		}
		else if(estado instanceof Destapada) {
			resp=2;
		}
		else if(estado instanceof Senalada) {
			resp=3;
		}
		return resp;
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

}
