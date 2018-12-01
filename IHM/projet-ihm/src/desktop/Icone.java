package desktop;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Icone {
	static ArrayList<ImageIcon> ImagesIcon = new ArrayList<ImageIcon>();
	protected static ArrayList<JLabel> LabelIcone = new ArrayList<JLabel>();
	static protected Point icon_pos = new Point(0,0);
	
	/**
	  Constructeur de la classe icone initalise toutes les images initales du bureau
	 */
	public Icone(){
		// chargement des images
		ImageIcon icon_windows = new ImageIcon("img/windows.png");
		ImageIcon icon_picture = new ImageIcon("img/picture.png");
		ImageIcon icon_dvd = new ImageIcon("img/dvd.png");
		ImageIcon icon_msn = new ImageIcon("img/msn.png");
		ImageIcon icon_word = new ImageIcon("img/word.png");
		ImageIcon icon_excel = new ImageIcon("img/excel.png");
		ImageIcon icon_pdf = new ImageIcon("img/pdf.png");
		ImageIcon icon_mail = new ImageIcon("img/mail.png");
		ImageIcon icon_gplus = new ImageIcon("img/gplus.png");
		ImageIcon icon_face = new ImageIcon("img/face.png");
		ImageIcon icon_fire = new ImageIcon("img/firefox.png");
		
		ajout(icon_dvd,"dvd");
		ajout(icon_windows,"VLC");
		ajout(icon_picture,"picture");
		ajout(icon_msn,"msn");
		ajout(icon_word,"word");
		ajout(icon_excel,"excel");
		ajout(icon_pdf,"pdf");
		ajout(icon_mail,"mail");
		ajout(icon_gplus,"google +");
		ajout(icon_face,"facebook");
		ajout(icon_fire,"Chrome");
	}
	
	
	/**
	 * ajoute une icone à partir d'une image et lui donne un texte
	 * @param img
	 * @param nomIcone
	 */
	public void ajout(ImageIcon img, String nomIcone){
		JLabel label = new JLabel(nomIcone);
		label.setForeground(new Color(255, 255, 255));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.BOTTOM);
		label.setIcon(img);
		label.setBounds(icon_pos.x,icon_pos.y,80,80);
		LabelIcone.add(label);
		/*icon_pos.y += 120;
		if(icon_pos.y > 600){
			icon_pos.y = 0;
			icon_pos.x += 120;
		}*/
	}
	
	/**
	 * ajoute une icone à partir d'une autre icone en un point donné
	 * @param iconeJLabel
	 * @param pt
	 */
	public void ajout(JLabel iconeJLabel,Point pt){
		JLabel label = new JLabel();
		label.setText(iconeJLabel.getText());
		label.setIcon(iconeJLabel.getIcon());
		label.setBounds(pt.x,pt.y,80,80);
		LabelIcone.add(label);
	}
	
	/**
	 * supprime une icone du burreau 
	 * @param iconeJLabel
	 */
	public void supprimer(JLabel iconeJLabel){
		LabelIcone.remove(iconeJLabel);
	}
	
	/**
	 * réorganise les icones selon leur ordre dans la collection
	 */
	static void Organiser(){
		Point pos = new Point(0,0);
		for (JLabel icon : Icone.LabelIcone) {
			icon.setBounds(pos.x,pos.y,80,80);
			pos.y += 120;
			if (pos.y > 600) {
				pos.y = 0;
				pos.x += 120;
			}
		}
	}
}
