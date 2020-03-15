package proyecto;

public class Tapada implements Estado {

	public Tapada() {}
	
	public void hacerClickD(Casilla pCasilla) {
		System.out.println("Click");

	}

	@Override
	public void hacerClickIz(Casilla pCasilla) {
		// TODO Auto-generated method stub
		System.out.println("Click");
		pCasilla.cambiarEstado(new Destapada());

	}

}
