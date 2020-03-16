package proyecto;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class Tablero extends Observable{

	private Jugador Jugador;
	private Casilla [][] Matriz;
	private static Tablero miTablero;
	private int bombas;
	private int bombasRestantes;
	private int marcadas;

	private Tablero() {
		// TODO - implement Tablero.Tablero
		throw new UnsupportedOperationException();
	}

	public void getMiTablero() {
		// TODO - implement Tablero.getMiTablero
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param nivel
	 */
	public void generarTablero(int x, int y, int nivel) {
		// TODO - implement Tablero.generarTablero
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre
	 */
	public void actualizarJugador(String nombre) {
		// TODO - implement Tablero.actualizarJugador
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pulsarCasillasDer(int x, int y) {
		// TODO - implement Tablero.pulsarCasillasDer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pulsarCasillasIzq(int x, int y) {
		// TODO - implement Tablero.pulsarCasillasIzq
		throw new UnsupportedOperationException();
	}

	public void finPartida() {
		// TODO - implement Tablero.finPartida
		throw new UnsupportedOperationException();
	}

	public int getMarcadas() {
		return this.marcadas;
	}

	private boolean haGanado() {
		// TODO - implement Tablero.haGanado
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	private void actualizarBordesPuslado(int x, int y) {
		// TODO - implement Tablero.actualizarBordesPuslado
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	private void insertarBomba(int x, int y) {
		// TODO - implement Tablero.insertarBomba
		throw new UnsupportedOperationException();
	}

	private void guardarPuntuacion() {
		// TODO - implement Tablero.guardarPuntuacion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	private void notifyObservers(int x, int y) {
		// TODO - implement Tablero.notifyObservers
		throw new UnsupportedOperationException();
	}

}