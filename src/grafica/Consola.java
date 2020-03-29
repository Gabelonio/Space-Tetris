package grafica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * This class is the visual core of the game when the difficulty is already set.
 */
public class Consola extends JFrame{
	
	//Logical part of the game field.
	private Casilla[][] pixeles;
	
	//Graphic part of the game field. 
	public JLabel[][] casillas; 
	
	
	/*
	 * Constructor of the class "Consola"
	 * -Initializes the frame's properties
	 * -Configures the game field (Visual aspect with labels)
	 */
	Consola(){	
		casillas=new JLabel[64][80];
		//Size
		this.setSize(700,700);
		//Create a grid
	    this.setLayout(new GridLayout(80,64));
  	    //Default exit
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Centering the frame
		this.setLocationRelativeTo(null);
		//Not resizable
		this.setResizable(false);
		
	    //Set the frame's colors
	    this.getContentPane().setBackground(Color.black);
	    this.setForeground(Color.BLACK);
	   
	    //Set the visible and non-visible zone of the game
	    for(int j=0;j<80;j++)
	    {
	    	for(int i=0;i<64;i++)
		    {
	    		JLabel casilla=new JLabel();
				casilla.setBackground(Color.black);
				casilla.setOpaque(true);
	    		casilla.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	    		
	    		if(j<=15) 
	    			casilla.setVisible(false);
	    		
				this.casillas[i][j]=casilla;
				this.add(this.casillas[i][j]);
		    }
	    }
	    
	}
	/*
	 * Description: Sets the color of every pixel of the game and 
	 *              ends the game when the collision between asteroid
	 *              and player is given. 
	 * Input: the Matrix of the fields of the game (pixels) 
	 * 
	 */
	public void refrescarPantalla(Casilla[][] recepcion) {
		pixeles=recepcion;
		for(int j=0;j<80;j++)
	    {
	    	for(int i=0;i<64;i++)
		    {
	    		if(!pixeles[i][j].isAsteroide()&&!pixeles[i][j].isNave())
	    			casillas[i][j].setBackground(Color.black);
	    		if(pixeles[i][j].isAsteroide())
	    			casillas[i][j].setBackground(Color.white);
	    		if(pixeles[i][j].isNave())
	    			casillas[i][j].setBackground(Color.red);
	    		if(pixeles[i][j].isAsteroide()&&pixeles[i][j].isNave()) {
	    			casillas[i][j].setBackground(Color.green);
	    			this.dispose();
	    			int opcion = JOptionPane.showConfirmDialog(null, 
	    			   		"GAME OVER ."+this.getTitle()+"\n ¿Play Again?",
	    			   		null,
	    			   		JOptionPane.YES_NO_OPTION);
	    			if(opcion == JOptionPane.YES_OPTION) { 
	    				pixeles = null;    				
	    				String[] args = new String[0];	    				
	    				MainThread.main(args);
	    			}
	    			else {
	    				System.exit(0);
	    			}	    			
	    		}
		    }
	    }
		this.revalidate();
	}
	/*
 	 * Description: Refreshes the score of the player.
 	 * 
	 * Input: the score of the player, it comes from the main Thread.   
	 */
	public void refrescarPuntaje(int puntaje) {
		this.setTitle("Score: "+puntaje);
	}
	/*
	 * Description: Adds the keylistener ti the window, 
	 *              specifically the listener from the ship.
	 * 
	 * Input: the keyListener from the player's ship.
	 */
	public void setListener(KeyListener listener) {
		this.addKeyListener(listener);
	}
	
}
