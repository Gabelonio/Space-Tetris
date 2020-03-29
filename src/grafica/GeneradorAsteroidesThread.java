package grafica;

import java.util.Random;

import logicaAsteroide.AsteroideAbstracto;
import logicaAsteroide.FabricaAsteroide;

/*
 * This class manages the shapes and times of generation of the Asteroids. 
 */
public class GeneradorAsteroidesThread extends Thread{

	private int carril,velGeneracion;
	
	private AsteroideAbstracto asteroide;
	
	private Casilla[][] referencia;
	
	/*
	 * Sets the main characteristics of the Asteroids generator:
	 * 1. Game's pixels.
	 * 2. Asteroids' Lanes.
	 * 3. Asteroids' creation velocity.
	 */
	GeneradorAsteroidesThread(Casilla [][] recepcion,int carril,int velGeneracion){
		this.velGeneracion=velGeneracion; 
		this.referencia=recepcion;
		this.carril=((carril-1)*16);
	}
	
	/*
	 * Description: Generates the physical characteristics of 
	 *              the Asteroids, including the time between asteroids' creation.
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		Random rand = new Random();
		while(true) {
			asteroide = FabricaAsteroide.crearFabrica().fabricarAsteroide();
			this.generarAsteroide();
			this.esperarXsegundos((rand.nextInt(velGeneracion))+(velGeneracion-2));
		}
			
	}
	
	/*
	 * Description: Determines whether an Asteroid can be created depending on the lane.
	 * 
	 * Output: The decision made in the description.
	 */
	private boolean isAsteroideColocable(){
		for(int j=0;j<16;j++) {
			for(int i=carril;i<(carril+16);i++) {
				if(referencia[i][j].isAsteroide())
					return false;
			}
		}
		return true;
	}
	/*
	 * Generates the Asteroid with the given form in the variable "asteroide".
	 */
	private  void generarAsteroide() {
		
		if(isAsteroideColocable()) {
			for(int j=0;j<16;j++) {
				for(int i=carril;i<(carril+16);i++) {
					if(asteroide.formacion[i-carril][j]) 
						this.referencia[i][j].setAsteroide(true);
				}
			}
		}
	}
	/*
	 * Description: Puts the actual thread in a sleeping state, hence, it doesn't generate any
	 * Asteroid. 
	 * 
	 * Input: Number sleeping seconds. 
	 */
	private void esperarXsegundos(double segundos) {
		try {
			Thread.sleep((int)(segundos * 1000));
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
