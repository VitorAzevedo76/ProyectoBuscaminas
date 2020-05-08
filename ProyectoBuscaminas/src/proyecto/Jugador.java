
package proyecto;

public class Jugador {
	
	private String nombre;	
	private int valor;
	
	public Jugador(String pNombre) {
		nombre=pNombre;
	}
	
	public int getValor() {
		return valor;
	}
	public void setPunt(int p) {
		valor=p;
	}
	
	public String getNombre() {
		return nombre;
	}
}

