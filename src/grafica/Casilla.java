package grafica;

/*
 * This class is the logical core of the game field's pixels
 * as it contains two boolean describing four individual states:
 * 1. Ship's presence.
 * 2. Asteroid's presence.
 * 3. None Ship's or Asteroid's presence.
 * 4. Both Ship's and Asteroid's presence (Collision).  
 */
public class Casilla {
	
	private boolean isNave; 
	private boolean isAsteroide;
	
	//Sets the default state of the pixel.
	Casilla(){
		this.isNave=false;
		this.isAsteroide=false;
	}
	
	//Gets the state of the ship's state of the pixel.
	public boolean isNave() {
		return isNave;
	}
	
	//Sets the state of the ship's state of the pixel.
	public void setNave(boolean isNave) {
		this.isNave = isNave;
	}
	
	//Gets the state of the Asteroid's state of the pixel.
	public boolean isAsteroide() {
		return isAsteroide;
	}
	
	//Sets the state of the Asteroid's state of the pixel.
	public void setAsteroide(boolean isAsteroide) {
		this.isAsteroide = isAsteroide;
	}
	
	
}
