package desktop;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class ImagePanel extends JPanel {
 
    private Image img;
     
    public ImagePanel(Image img){
        this.img = img;
    }
    
    public void paintComponent(Graphics g) {
   	    	//Pour une image de fond
  	    	g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

