package proyecto;

public class Señalada implements Estado{

	@Override
	public void hacerClickD(Casilla pCasilla) {
		// TODO Auto-generated method stub
		pCasilla.cambiarEstado(new Tapada());
	}

	@Override
	public void hacerClickIz(Casilla pCasilla) {
		// TODO Auto-generated method stub
		
	}

}
