package logicaNave;
/*
 * This class is the concrete movement of the concrete Iterators. 
 */
public class MoverNegativo {
	/*
	 * Description: Moves the ship's position in a positive coordinate
	 *              (Left and Up).
	 *  
	 * Input: the ship's position.
	 */
	public int mover(int posicion){
		return posicion+1;
	}
}
