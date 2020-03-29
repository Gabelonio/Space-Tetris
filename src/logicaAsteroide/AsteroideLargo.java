package logicaAsteroide;
/*
 * This class sets the shape of the stick-shaped Asteroid.
 */
public class AsteroideLargo extends AsteroideAbstracto{
	/*
	 * Creates the pattern that gives shape to the stick-shaped Asteroid.
	 * (non-Javadoc)
	 * @see logicaAsteroide.AsteroideAbstracto#crearAsteroide()
	 */
	@Override
	public void crearAsteroide() {
		
		for(int j=0;j<16;j++) {
			for(int i=0;i<4;i++){
				super.formacion[i][j]=true;
			}
		}
	}
	
	
	
}
