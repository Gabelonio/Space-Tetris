package logicaAsteroide;
import java.util.Random;
/*
 * This class fabricates an Asteroid and rotates it, so it has a variety of Asteroid. 
 */
public class FabricaAsteroide {	
	
	/*
	 * Singleton pattern to create an unique instance of this Factory class.  
	 */
	private static FabricaAsteroide fabrica; 
	;
	private FabricaAsteroide() {}
	public static FabricaAsteroide crearFabrica() {
		return (fabrica==null)?fabrica=new FabricaAsteroide():fabrica;
	}
	
	/*
	 * Sets an asteroid and rotates it.
	 */
	public AsteroideAbstracto fabricarAsteroide(){
		
		/*
		 * Creates the asteroid and random numbers for shape and rotation.
		 */
		Random rand = new Random();
		AsteroideAbstracto asteroide=null;
		
		/*
		 * Generates both numbers for setting the Asteroid 
		 * and the rotation's template. 
		 */
		boolean[][] formacionRotada=new boolean[16][16]; 
		int claseAsteroide=rand.nextInt(7)+1;
		int claseRotacion=rand.nextInt(4)+1;
		/*
		 * Selects the Asteroid's shape.
		 */
		switch(claseAsteroide) {
			case 1:{
				asteroide=new AsteroideCuadrado();
				break;
			}
			case 2:{
				asteroide=new AsteroideLargo();
				break;
			}
			case 3:{
				asteroide=new AsteroideBaston();
				break;
			}
			case 4:{
				asteroide=new AsteroideBastonInvertido();
				break;
			}
			case 5:{
				asteroide=new AsteroideT();
				break;
			}
			case 6:{
				asteroide=new AsteroideEscalon();
				break;
			}
			case 7:{
				asteroide=new AsteroideEscalonInvertido();
				break;
			}
		}
		//Creates the Asteroid with its shape.
		asteroide.crearAsteroide();	
		
		/*
		 * Asteroid's rotation pattern.
		 */
		int k=0,l=0;
		switch(claseRotacion) {
			case 1:{
				for(int j=0;j<16;j++) {
					for(int i=0;i<16;i++) {
						formacionRotada[l][k]=asteroide.formacion[i][j];
					l++;
					}
				l=0;
				k++;
				}
				break;
			}
			case 2:{		 
				for(int i=15;i>=0;i--) {
					for(int j=0;j<16;j++) {
						formacionRotada[l][k]=asteroide.formacion[i][j];
						l++;
					}
					l=0; 
					k++;
				}
				break;
			}
			case 3:{
				for(int j=15;j>=0;j--) {
					for(int i=15;i>=0;i--) {
						formacionRotada[l][k]=asteroide.formacion[i][j];
						l++;
					}
					l=0;
					k++;
				}
				break;
			}
			case 4:{
				for(int i=0;i<16;i++) {
					for(int j=15;j>=0;j--) {
						formacionRotada[l][k]=asteroide.formacion[i][j];
						l++;
					}
					l=0;
					k++;
				}
				break;
			}
		}
		
		//Rotates the Asteroid and returns it.
		asteroide.setFormacion(formacionRotada);
		return asteroide;
		
	}
	
}
