package desktop;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dossier {
	
	protected JLabel folder = new JLabel();
	static ArrayList<JLabel> contenu = new ArrayList<JLabel>();
	protected static Point pos;
	
	public Dossier (){
		folder = new JLabel("folder");
		folder.setForeground(new Color(255, 255, 255));
		folder.setHorizontalTextPosition(JLabel.CENTER);
		folder.setVerticalTextPosition(JLabel.BOTTOM);
		folder.setIcon(new ImageIcon("img/folder.png"));
		pos = new Point();
	}
	
	public void organiser(Point point){
		
		for(int i=0; i<contenu.size();i++){
			contenu.get(i).setBounds(point.x,point.y, 80, 80);
			point.y += 80;
				if (point.y > point.y+300) {
					point.y = point.y;
					point.x += 80;
					
				}
		}
		
	}
	
}