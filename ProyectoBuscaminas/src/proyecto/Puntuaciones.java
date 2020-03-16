package proyecto;

public class Puntuaciones {
	//Atributos
	private Jugador[] lista;
	private static Puntuaciones misPuntuaciones;
	
	//Constructora
	
	private Puntuaciones() {
		//lista=new Jugador[10]();
	}
	
	public static Puntuaciones getMisPuntuaciones() {
		if(misPuntuaciones==null) {
			misPuntuaciones= new Puntuaciones();
		}
		return misPuntuaciones;
	}
	
	//METODOS
	
	public void insertar(Jugador pJug) {
		//Insercion ordenada
		
	}
	
	public void cargarDatos() {
	//Cargar Fichero de texto	
	}
	
	public void guardarDatosEnFich(){
		
	}
}
