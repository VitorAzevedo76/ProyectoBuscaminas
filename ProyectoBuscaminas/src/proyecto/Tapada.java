package proyecto;

public class Tapada implements Estado {

	public Tapada() {}
	
	public void hacerClickD(Casilla pCasilla) {
		System.out.println("ClickD");
		pCasilla.cambiarEstado(new Señalada());
	}

	@Override
	public void hacerClickIz(Casilla pCasilla) {
		// TODO Auto-generated method stub
		System.out.println("ClickIzq");
		pCasilla.cambiarEstado(new Destapada());

	}

}
