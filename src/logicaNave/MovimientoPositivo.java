package logicaNave;
/*
 * This is the concrete Iterator of the Iterator pattern.
 * Also executes the movement calling the concrete movement.
 */
public class MovimientoPositivo implements EjecucionMovimiento{
	/*
	 * Description: Executes the ship's function to move the ship
	 * 				in a positive coordinate. 
	 *              (Left and Up).
	 *  
	 * Input: the ship's position.
	 * (non-Javadoc)
	 * @see logicaNave.EjecucionMovimiento#ejecutar(int)
	 */
	@Override
	public int ejecutar(int posicion) {
		return new MoverPositivo().mover(posicion);
	}

}
