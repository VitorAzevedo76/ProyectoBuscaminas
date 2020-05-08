package proyecto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class cronometro {
	private int minutos;
	private int segundos;
	private static cronometro miCrometro;
	long inicio;
	long fin;
	long tiempoPasado;
	
	private cronometro (){
	}
	
	public static cronometro getMiCronometro() {
		if (miCrometro==null) {
			miCrometro=new cronometro();
		}
		
		return miCrometro;
	}
	
	private void contar() {
		
		minutos = (int) TimeUnit.MILLISECONDS.toMinutes(tiempoPasado);
		segundos = (int) TimeUnit.MILLISECONDS.toSeconds(-tiempoPasado);
		System.out.println("Ha pasado "+minutos+" : "+segundos);
	}

	
	public void activar() {
		inicio = System.currentTimeMillis();
	}
	public void desactivar() {
		fin = System.currentTimeMillis();
		tiempoPasado=inicio-fin;
		this.contar();
	}
	public long getSegundos(){
		return tiempoPasado;
	}
}
