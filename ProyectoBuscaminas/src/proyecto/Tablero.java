package proyecto;

public class Tablero {
	//Atributos
	private Jugador jugador;
	private Casilla[][] matriz;
	private static Tablero miTablero;
	private int bombas;
	private int bombasRestantes;
	private int marcadas;
	
	//Constructora
	private Tablero() {
		
	}
	
	public Tablero getMiTablero() {
		if (miTablero==null) {
			miTablero=new Tablero();
		}
		
		return miTablero;
	}
	
	//Metodos de incio de juego
	
	public void generarTablero(int x, int y, int pNivel) {
		matriz=new Casilla[x][y];
		bombas=y*pNivel;
		bombasRestantes=bombas;
		marcadas=0;
		
		/////La insercion de bombas....
		///..
		///....
	}
	
	public void actualizarJugador(String pName) {
		jugador=new Jugador(pName);
	}
	
	private void insertarBomba(int x, int y) {
		
	}

	
	//Metodos de juego en curso
	
	public void pulsarCasillaDer(int x, int y) {
		
	}
	public void pulsarCasillaIzq(int x, int y) {
		
	}
	public void finPartida() {
		//Hay que ver como hacer que la vista se entere de que el juego ha terminado
		
	}
	private boolean haGanado() {
		return false;
	}
	
	private void actualizarBordes(int x, int y) {
		
	}
	
	
	
	
	
}


























