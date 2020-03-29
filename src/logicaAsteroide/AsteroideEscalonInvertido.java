package logicaAsteroide;
/*
 * This class sets the shape of the inverted stair-shaped Asteroid.
 */
public class AsteroideEscalonInvertido extends AsteroideAbstracto{
	/*
	 * Creates the pattern that gives shape to the stair-shaped Asteroid.
	 * (non-Javadoc)
	 * @see logicaAsteroide.AsteroideAbstracto#crearAsteroide()
	 */
	@Override
	public void crearAsteroide() {
		
		for(int j=8;j<12;j++) {
			for(int i=0;i<8;i++) {
				super.formacion[i][j]=true;
			}
		}
		for(int j=12;j<16;j++) {
			for(int i=4;i<12;i++) {
				super.formacion[i][j]=true;
			}
		}
		
	}
}
