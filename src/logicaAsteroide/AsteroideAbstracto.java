package logicaAsteroide;
/*
 * Creates the template for the Asteroid classes, defines its behavior 
 * and default space in the game's field.  
 */
public abstract class AsteroideAbstracto {
	
	public boolean formacion[][];
	/*
	 * Setting the necessary space for any piece's structure
	 */
	AsteroideAbstracto(){
		formacion=new boolean[16][16];
	}
	/*
	 * Description: Imports the shape of an Asteroid (generated and rotated).
	 * 
	 * Input: The template of an Asteroid. 
	 */
	public void setFormacion(boolean [][] recepcion) {
		formacion=recepcion;
	}
	/*
	 * Sets the shape of the Asteroid-classes.  
	 */
    protected abstract void crearAsteroide();
}
