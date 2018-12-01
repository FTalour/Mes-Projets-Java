package TP1;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	
	Panneau pan = new Panneau();
	
	public Fenetre() {
		this.setTitle("Ma petite fenetre");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(pan);
		this.setVisible(true);
		go();
	}
	
	private void go(){
		int x = pan.getPosX(), y = pan.getPosY();
		boolean backX = false, backY = false;
		
		while(true){
			//Si la coordonnee x est inferieure e 1, on avance
		    if(x < 1)
		      backX = false;

		    //Si la coordonnee x est superieure e la taille du Panneau moins la taille du rond, on recule
		    if(x > pan.getWidth()-pan.getDimX())
		      backX = true;
		    //Idem pour l'axe y
		    if(y < 1)
		      backY = false;
		    if(y > pan.getHeight()-pan.getDimY())
		      backY = true;

		    //Si on avance, on incremente la coordonnee
		    //backX est un booleen, donc !backX revient e ecrire
		    //if (backX == false)
		    if(!backX)
		      pan.setPosX(++x);

		    //Sinon, on decremente
		    else
		      pan.setPosX(--x);

		    //Idem pour l'axe Y
		    if(!backY)
		      pan.setPosY(++y);
		    else
		      pan.setPosY(--y);
		    //On redessine notre Panneau
		    pan.repaint();

		    //Comme on dit : la pause s'impose ! Ici, trois milliemes de seconde
		    try {
		      Thread.sleep(3);
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
		}
	}
}
