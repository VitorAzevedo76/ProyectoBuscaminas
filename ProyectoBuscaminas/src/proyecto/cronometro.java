package proyecto;

import java.util.ArrayList;
import java.util.Iterator;

public class cronometro implements NObservable{
	private ArrayList<NObserver> observers;
	private int minutos;
	private int segundos;
	private boolean start;
	private static cronometro miCrometro;
	
	private cronometro (){
		start=true;
		observers= new ArrayList<NObserver>();
		contar();
	}
	
	public static cronometro getMiCronometro() {
		if (miCrometro==null) {
			miCrometro=new cronometro();
		}
		
		return miCrometro;
	}
	
	public static void main(String [] agrs) {
			
	}
	private void contar() {
		minutos =0;
		segundos=0;
		while(start&&(minutos<60)) {
			while(start&&(segundos<60)) {
				System.out.println(minutos+":"+segundos);
				delaySegundo();
				notifyObservers(-1,-1);
				segundos++;
			}
			minutos++;
		}
	}
	
	private static void delaySegundo() {
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {}
	}
	@Override
	public void anadirObservers(NObserver pObs) {
		observers.add(pObs);
		
	}
	@Override
	public void borrarObserver(NObserver pObs) {
		observers.remove(pObs);
		
		
	}
	@Override
	public void notifyObservers(int x, int y) {
		Iterator<NObserver> iter = observers.iterator();
		while(iter.hasNext()) {
			NObserver o = iter.next();
			o.update(this,-1,-1);
		}
		
	}
	
	public void activar() {
		start=true;
	}
	public void desactivar() {
		start=false;
	}
	public int [] getHora(){
		int [] resp = new int[2];
		resp[0]=segundos;
		resp[1]=minutos;
		return resp;
	}
}
