package logicaAsteroide;
/*
 * This class sets the shape of the inverted cane-shaped Asteroid.
 */
public class AsteroideBastonInvertido extends AsteroideAbstracto{
	/*
	 * Creates the pattern that gives shape to the cane-shaped Asteroid.
	 * (non-Javadoc)
	 * @see logicaAsteroide.AsteroideAbstracto#crearAsteroide()
	 */	
	public void crearAsteroide() {
		
		for(int j=12;j<16;j++) {
			for(int i=0;i<4;i++) {
				super.formacion[i][j]=true; 
			}
		}
		for(int j=4;j<16;j++) {
			for(int i=4;i<8;i++) {
				super.formacion[i][j]=true;
			}
		}
		
	}
}
