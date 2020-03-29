package grafica;

/*
 * This class manages the player's score. 
 */
public class PuntajeThread extends Thread{

	private int contador;
	
	private Consola refConsola;
	
	/*
	 * Sets the main characteristics of the score manager:
	 * 1. The player's score.
	 * 2. Asteroids' speed.
	 */
	PuntajeThread(Consola consola){
		this.contador=0;
		this.refConsola=consola;
	}

	/*
	 * Increases the player's score by one for every second that remains.
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while(true) {
			contador+=1;
			refConsola.refrescarPuntaje(contador);
			esperarXsegundos(1);
		}	
	}
	
	/*
	 * Description: Puts the actual thread in a sleeping state, hence, it doesn't increase
	 * the score in that time.  
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
