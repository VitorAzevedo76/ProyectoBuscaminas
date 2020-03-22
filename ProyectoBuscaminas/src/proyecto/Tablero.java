package proyecto;

import java.util.*;

public class Tablero implements NObservable {
	//Atributos
	private Jugador jugador;
	private Casilla[][] matriz;
	private static Tablero miTablero;
	private int bombas;
	private int bombasRestantes;
	private int marcadas;
	private boolean juego;
	private int numCasillaDestapada;
	private List<NObserver> observers;
	
	//Constructora
	private Tablero() {
		juego=true;
		numCasillaDestapada=0;
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
		int f=Rf.nextInt(x);
		int c=Rc.nextInt(x);
		this.haGanado();
		
		//Inicializar todas las casillas a vacias con valor 0
		
		for(int i=0; i<x; i++) {
			for(int j=0; j<y;j++) {
				matriz[i][j]=new Casilla();
			}
			
		}
		imprimir(); //Para comprobaciones BORRAR LUEGO
		imprimirB();//Para comprobaciones BORRAR LUEGO
		System.out.println(f+"-"+c);//Para comprobaciones BORRAR LUEGO
		
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
		imprimirJ() ;

	}
	
	public void actualizarJugador(String pName) {
		jugador=new Jugador(pName);
	}
	
	private void insertarBomba(int x, int y) {
		//System.out.println("Bomba en "+x+y);
		matriz[x][y].addMina();
		
		//Rodear
		
		for(int i=-1;i<=1;i++) {
			
			for(int j=-1; j<=1;j++) {
				
				if((i+x)>=0 && (j+y)>=0 && (i+x)<matriz.length &&(j+y)<matriz[1].length) {
					matriz[x+i][j+y].incValorCasilla();
					//System.out.println("Insercion correcta "+(x+i)+(j+y));
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
	private void imprimirJ() {
		for (int i=0; i<matriz.length;i++) {
			for (int j=0;j<matriz[1].length;j++) {
				if(matriz[i][j].getEstado() instanceof Destapada){
					if(matriz[i][j].esMina()){
						System.out.print("M ");
					}
					else {
						System.out.print(matriz[i][j].getValor()+" ");
					}
				}
				else {
					System.out.print("* ");
				}
			}
			System.out.println("");
		}
	}

	
	//METODOS DE JUEGO EN CURSO
	
	public void pulsarCasillaDer(int x, int y) {
		if(juego) {
			if(marcadas<bombas) {
				System.out.println("Der -Has pulsado la casilla "+x+"-"+y);
				matriz[x][y].hacerClickDer();
				Estado estAct=matriz[x][y].getEstado();
				if(estAct instanceof Tapada ) {
					bombasRestantes++;
					marcadas--;
				}
				else if (estAct instanceof Señalada) {
					bombasRestantes--;
					marcadas++;
			}
			}
			else if(matriz[x][y].getEstado() instanceof Señalada) {
				matriz[x][y].hacerClickDer();
				bombasRestantes++;
				marcadas--;
			}
		}
	}
	
	public void pulsarCasillaIzq(int x, int y) {
		if(juego && (matriz[x][y].getEstado() instanceof Tapada)) {
		System.out.println("Izq -Has pulsado la casilla "+x+"-"+y);
		numCasillaDestapada++;
		matriz[x][y].hacerClickIzq();
		System.out.println(numCasillaDestapada);
		actualizarBordesPulsado(x,y);
		System.out.println(numCasillaDestapada);
		imprimirJ() ;
		if(matriz[x][y].esMina()) {
			System.out.println("Has perdido pulsando la casilla "+x+"-"+y);
			juego=false;
		}
		else if(haGanado()) {
			System.out.println("Has ganado pulsando la casilla "+x+"-"+y);
			juego=false;
		}
		}
	}
	
	public boolean finPartida() {
		return juego;
		
	}
	public boolean haGanado() {
		int numTotal=matriz[0].length * matriz.length;
		boolean resp=numCasillaDestapada>=(numTotal-bombas);
		return resp;
	}
	
	private void actualizarBordesPulsado(int x, int y) {
		HashMap<Casilla, int[]> evaluados=new HashMap<Casilla, int[]>();
		Queue<Casilla> cola= new LinkedList<Casilla>();
		int[] cor=new int[2];
		cor[0]=x;
		cor[1]=y;
		evaluados.put(matriz[x][y], cor );
		cola.add(matriz[x][y]);
	
		if(matriz[x][y].getValor()==0) {
		while(!cola.isEmpty()) {
			Casilla cas=cola.remove();
			System.out.println(evaluados.containsKey(matriz[x][y]));
			int[] coord=evaluados.get(cas);
			x =coord[0];
			y=coord[1];
			
			if(cas.getValor()==0) {
				
				for(int i=-1;i<=1;i++) {	
					
					for(int j=-1; j<=1;j++) {
						
						if((i+x)>=0 && (j+y)>=0 && (i+x)<matriz.length &&(j+y)<matriz[1].length) {
							int[] coor=new int[2];
							coor[0]=x+i;
							coor[1]=y+j;
							if(!evaluados.containsKey(matriz[x+i][y+j])&& matriz[x+i][y+j].getValor()==0) {
								cola.add(matriz[x+i][y+j]);
								evaluados.put(matriz[x+i][y+j], coor);
								
								}
							else{
								if(matriz[x+i][y+j].getEstado() instanceof Tapada) {System.out.println("DEStapda: "+(x+i)+(y+j));
								this.numCasillaDestapada++;}
								else {System.out.println("tapda "+(x+i)+(y+j));
										}
								matriz[x+i][y+j].hacerClickIzq();
							}
							
							
							//System.out.println(evaluados.containsKey(matriz[x+i][y+j]));
						//	System.out.println( ""+coor[0]+""+coor[1]);
							
							
							}
						}
					}
			
			}
			cas.hacerClickIzq();
			
		}
		}
		}
		
	//Otros metodos
	public Casilla getCasilla(int x, int y) {
		return matriz[x][y];
	}
	private int getMarcadas() {
		return marcadas;
		
	}
	private void guardarPuntuacion() {
		
	}
	public void añadirObservers(NObserver o) {
		observers.add(o);
	}
	
	public void borrarObserver(NObserver o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}
	
	public void notifyObservers(int x, int y) {
		Iterator<NObserver> iter = observers.iterator();
		while(iter.hasNext()) {
			NObserver o = iter.next();
			o.update(this,x,y);
		}
	}
	
	
}


























