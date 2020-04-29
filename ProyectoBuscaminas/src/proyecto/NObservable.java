package proyecto;

public interface NObservable {
	
		public void anadirObservers(NObserver pObs);
		public void borrarObserver(NObserver pObs);
		public void notifyObservers(int x, int y);
	
}
