package proyecto;

import java.util.*;

public class Tablero  {
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
	
	public static Tablero getMiTablero() {
		if (miTablero==null) {
			miTablero=new Tablero();
		}
		
		return miTablero;
	}
	
	//METODOS DE INICIO DE JUEGO
	
	public void generarTablero(int x, int y, int pNivel) {
		matriz=new Casilla[x][y];
		bombas=y*pNivel;
		bombasRestantes=0;
		marcadas=0;
		Random Rf=new Random();
		Random Rc=new Random();
		int f=Rf.nextInt(x+1);
		int c=Rc.nextInt(x+1);
		
		//Inicializar todas las casillas a vacias con valor 0
		
		for(int i=0; i<x; i++) {
			for(int j=0; j<y;j++) {
				matriz[i][j]=new Casilla();
			}
			
		}
		imprimir(); //Para comprobaciones BORRAR LUEGO
		imprimirB();//Para comprobaciones BORRAR LUEGO
		
		while (bombasRestantes<bombas) {
			if(!matriz[f][c].esMina()) {
				insertarBomba(f,c);
				bombasRestantes++;
			}
			f=Rf.nextInt(x);
			c=Rc.nextInt(y);
			
			System.out.println("Proxima en " +f+c);
		}
		
		imprimirB();

	}
	
	public void actualizarJugador(String pName) {
		jugador=new Jugador(pName);
	}
	
	private void insertarBomba(int x, int y) {
		System.out.println("Bomba en "+x+y);
		matriz[x][y].addMina();
		
		//Rodear
		
		for(int i=-1;i<=1;i++) {
			
			for(int j=-1; j<=1;j++) {
				
				if((i+x)>=0 && (j+y)>=0 && (i+x)<matriz.length &&(j+y)<matriz[1].length) {
					matriz[x+i][j+y].incValorCasilla();
					System.out.println("Insercion correcta "+(x+i)+(j+y));
				}
			}
		}
		
		
	}
	
	//Para comprobaciones BORRAR LUEGO
	private void imprimir() {
		for (int i=0; i<matriz.length;i++) {
			for (int j=0;j<matriz[1].length;j++) {
				System.out.print(" "+i+"-"+j);
			}
			System.out.println("");
		}
	}
	//Para comprobaciones BORRAR LUEGO
	private void imprimirB() {
		for (int i=0; i<matriz.length;i++) {
			for (int j=0;j<matriz[1].length;j++) {
				if(matriz[i][j].esMina()){
					System.out.print("M ");
				}
				else {
					System.out.print(matriz[i][j].getValor()+" ");
				}
			}
			System.out.println("");
		}
	}

	
	//METODOS DE JUEGO EN CURSO
	
	public void pulsarCasillaDer(int x, int y) {
		System.out.println("Der -Has pulsado la casilla "+x+"-"+y);
	}
	
	public void pulsarCasillaIzq(int x, int y) {
		System.out.println("Izq -Has pulsado la casilla "+x+"-"+y);
	}
	
	public void finPartida() {
		//Hay que ver como hacer que la vista se entere de que el juego ha terminado
		
	}
	private boolean haGanado() {
		return false;
	}
	
	private void actualizarBordesPulsado(int x, int y) {
		
	}
		
	//Otros metodos
	
	private int getMarcadas() {
		return marcadas;
	}
	private void guardarPuntuacion() {
		
	}
	
	private void notifyObservers(int x, int y) {
		
	}
	
	
	
}


























