package logicaAsteroide;
/*
 * This class sets the shape of the square-shaped Asteroid.
 */
public class AsteroideCuadrado extends AsteroideAbstracto{
	/*
	 * Creates the pattern that gives shape to the cane-shaped Asteroid.
	 * (non-Javadoc)
	 * @see logicaAsteroide.AsteroideAbstracto#crearAsteroide()
	 */
	@Override
	public void crearAsteroide() {
		
		for(int j=0;j<8;j++) {
			for(int i=0;i<8;i++) {
				super.formacion[i][j]=true;
			}
		}
	}
	
}
