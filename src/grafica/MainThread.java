package grafica;

import javax.swing.JOptionPane;

/*
 * This class is the main thread of the game and 
 * the main objective is to set the difficulty, also starts the other threads.
 */
public class MainThread {
	
	public static void main(String arg[])
	{
		
		/*
		 * Initial user interface for setting the difficulty
		 * of the Game and showing Game controls
		 */
		String[] opciones = new String[] {"Easy","Normal","Hard"};
	    int respuesta = JOptionPane.showOptionDialog(null, "Welcome to Space Tetris!"
	    		+ "\nChoose a difficulty\nMove with the Keyboard's arrows", "SpaceTetris",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, opciones, opciones[0]);
	    
	    /*
	     * Configuration of the asteroids' speed and the quantity of them
	     */
	    int velGeneracionAsteroides=0;
	    double velAsteroides=0.0; 
	    switch(respuesta) {
		    case 0:{
		    		velGeneracionAsteroides=3;
		    		velAsteroides=0.07;
		    		break;
		    }
			case 1:{
					velGeneracionAsteroides=4;
					velAsteroides=0.05;
					break;
		    }
			case 2:{
					velGeneracionAsteroides=3;
					velAsteroides=0.06;
					break;
			}
	    }
	    //In case of not selecting an option
	    if(respuesta==-1)
	    	System.exit(0);
	    
	    //Initialization of the game field
	    Casilla[][] pixeles= new Casilla[64][80];
		for(int i=0;i<80;i++) {
			for(int j=0;j<64;j++) {
				pixeles[j][i]=new Casilla();
			}
		}	
	    
		//Creation of the Game Console
	    Consola con = new Consola();
		con.setVisible(true);			
		
		//Creation of the thread for every row(4) where each asteroid is invoked 
		GeneradorAsteroidesThread hiloAsteroidesUno=new GeneradorAsteroidesThread(pixeles,1,velGeneracionAsteroides);
		GeneradorAsteroidesThread hiloAsteroidesDos=new GeneradorAsteroidesThread(pixeles,2,velGeneracionAsteroides);
		GeneradorAsteroidesThread hiloAsteroidesTres=new GeneradorAsteroidesThread(pixeles,3,velGeneracionAsteroides);
		GeneradorAsteroidesThread hiloAsteroidesCuatro=new GeneradorAsteroidesThread(pixeles,4,velGeneracionAsteroides);
		
		//Creation of the player thread
		NaveThread nave=new NaveThread(pixeles,con);
		con.setListener(nave);
		
		//Creation of the thread where each asteroid gains the hability to move
		MovimientoAsteroidesThread hiloEspacio=new MovimientoAsteroidesThread(pixeles,con,velAsteroides);
		
		//Creation of the score thread
		PuntajeThread hiloPuntaje=new PuntajeThread(con);
		
		//Creating all the threads 
		hiloAsteroidesUno.start();
		hiloAsteroidesDos.start();
		hiloAsteroidesTres.start();
		hiloAsteroidesCuatro.start();
		hiloEspacio.start();
		nave.start();
		hiloPuntaje.start();
		
	}
}
