package grafica;

/*
 * This class manages the ship's movement and interaction with the player.
 */ 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import logicaNave.JugadorNave;
import logicaNave.MovimientoNegativo;
import logicaNave.MovimientoPositivo;

public class NaveThread extends Thread implements KeyListener{
	
	private JugadorNave jugador;
	
	private Casilla[][] referencia;
	
	private Consola refConsola;
	
	/*
	 * Sets the main characteristics of the player:
	 * 1. Game's pixels.
	 * 2. The game's console.
	 * 3. Player's initial position.
	 */
	NaveThread(Casilla [][] recepcion,Consola consola){
		jugador=new JugadorNave();
		jugador.setPosicionX(29);
		jugador.setPosicionY(74);
		this.referencia=recepcion;
		this.refConsola=consola;
		this.generarNave(jugador.getPosicionX(),jugador.getPosicionY());
	}
	
	/*
	 * Moves the player refreshing the console by every time the player presses a movement key.
	 * 
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while(true) {		
			refConsola.refrescarPantalla(referencia);
		}	
	}
	
	/*
	 * Description: Creates the pattern of the ship's shape with the
	 *              given reference to be printed.
	 * 
	 * Input: X and Y position of the player.  
	 */
	private  void generarNave(int posX,int posY) {
		for(int j=posY;j<(posY+6);j++){
			for(int i=posX;i<(posX+6);i++){
				if(((i-posX)==1||(i-posX)==4)&&((j-posY)!=2))
					referencia[i][j].setNave(false);
				else
					referencia[i][j].setNave(true);	
			}
		}
	}
	
	/*
	 * Description: Moves the ship depending on the command the player gives.
	 * 
	 * Input: the event containing the command given. 
	 * 
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent).
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		/*
		 * Translate the command into a comprehensible data type for the conditional.
		 * Gets the actual ship's location.
		 */
		int key = e.getKeyCode();
		int posX=jugador.getPosicionX();
		int posY=jugador.getPosicionY();
		
		/*
		 * Movement of the ship, taking into account the different changes.
		 */
	    if (key == KeyEvent.VK_LEFT) {
	    	//Checks if the ship can move, so it doesn't move beyond the field.
	    	if(posX>=1){
	    		//Deletes the frames where the ship was in the last position.
	    		for(int i=posY+5;i>=posY;i--) {
					referencia[posX+5][i].setNave(false);
				}
	    		
	    		//Changes the coordinates of the ship with the given order.
		    	jugador.setMovimiento(new MovimientoPositivo());
				jugador.setPosicionX(jugador.getMovimiento().ejecutar(
									 jugador.getPosicionX()));
				
				//Updates the game's pixels with the new position. 
				this.generarNave(jugador.getPosicionX(),jugador.getPosicionY());
	    	}
	    }
	    if (key == KeyEvent.VK_RIGHT) {
	    	
	    	if(posX<=57){
	    		
	    		for(int i=posY;i<(posY+6);i++) {
					referencia[posX][i].setNave(false);
				}
	    		
		    	jugador.setMovimiento(new MovimientoNegativo());
				jugador.setPosicionX(jugador.getMovimiento().ejecutar(
									 jugador.getPosicionX()));
				
				this.generarNave(jugador.getPosicionX(),jugador.getPosicionY());
	    	}
	    }
	    if (key == KeyEvent.VK_UP) {
	    	
	    	if(posY>=17){
	    		
	    		for(int i=posX+5;i>=posX;i--) {
					referencia[i][posY+5].setNave(false);
				}
	    		
		    	jugador.setMovimiento(new MovimientoPositivo());
				jugador.setPosicionY(jugador.getMovimiento().ejecutar(
									 jugador.getPosicionY()));
				
				this.generarNave(jugador.getPosicionX(),jugador.getPosicionY());
	    	}
	    }
	    if (key == KeyEvent.VK_DOWN) {
	    	
	    	if(posY<=73){
	    		
	    		for(int i=posX;i<(posX+6);i++) {
					referencia[i][posY].setNave(false);
				}
	    		
		    	jugador.setMovimiento(new MovimientoNegativo());
				jugador.setPosicionY(jugador.getMovimiento().ejecutar(
									 jugador.getPosicionY()));
				
				this.generarNave(jugador.getPosicionX(),jugador.getPosicionY());
	    	}
	    }
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/* 
	 * Calls the function to execute the ship's movement.
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {
		this.keyPressed(arg0);
	}
		
	
}
