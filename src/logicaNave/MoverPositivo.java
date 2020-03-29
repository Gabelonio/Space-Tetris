package logicaNave;
/*
 * This class is the concrete movement of the concrete Iterators. 
 */
public class MoverPositivo {
	/*
	 * Description: Moves the ship's position in a positive coordinate
	 *              (Right and Down).
	 *  
	 * Input: the ship's position.
	 */
	public int mover(int posicion){
		return posicion-1;
	}
}
