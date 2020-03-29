package grafica;
/*
 * This class is in charge of moving all the Asteroids on the game's field.
 */
public class MovimientoAsteroidesThread extends Thread{
	
	private double velAsteroides;
	
	private Casilla[][] referencia;
	
	private Consola refConsola;
	
	/*
	 * Sets the main characteristics of the Asteroids' movement manager:
	 * 1. Game's pixels.
	 * 2. Asteroids' speed.
	 * 3. The game's console.
	 */
	MovimientoAsteroidesThread(Casilla [][] recepcion,Consola consola,double velAsteroides){
		this.velAsteroides=velAsteroides;
		this.referencia=recepcion;
		this.refConsola=consola;
	}
	
	/*
	 * Description: Manages the movement of the Asteroids given by the 
	 * 				velocity of the Asteroids, translated in seconds.  
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		
		while(true) {
			this.moverAsteroides();
			this.esperarXsegundos(velAsteroides);
		}
		
	}
	/*
	 * Takes the pixels of the game's table and transport every Asteroid on it. 
	 */
	private void moverAsteroides() {
		for(int j=79;j>0;j--) {
			for(int i=0;i<64;i++) {
				referencia[i][j].setAsteroide(referencia[i][j-1].isAsteroide());
			}
		}
		for(int i=0;i<64;i++) {
			referencia[i][0].setAsteroide(false);;
		}
	}
	
	/*
	 * Description: Puts the actual thread in a sleeping state, hence, it doesn't move any
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
