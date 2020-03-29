package logicaNave;
/*
 * This class sets the movements and position of the ship. 
 */
public class JugadorNave {
	
	//X and Y position of the ship.
	private int posicionX,posicionY; 
	
	//Aggregate part in the Iterator pattern, also is the movement of the ship. 
	private EjecucionMovimiento movimiento; 
	
	/*
	 * Setter and getter of the ship's X position. 
	 */
	public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	/*
	 * Setter and getter of the ship's Y position.
	 */
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	/*
	 * Setter and getter of the ship's movement. 
	 */
	public void setMovimiento(EjecucionMovimiento movimiento) {
		this.movimiento = movimiento;
	}
	public EjecucionMovimiento getMovimiento() {
		return movimiento;
	}
}
