package EchecFrPl;

import java.awt.*;
import javax.swing.*;

public enum Case {
	VIDE(" ", null),
	Pion_JOUEUR1("Pion_1", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/reine_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Tour_JOUEUR1("Tour_1", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/reine_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Cavalier_JOUEUR1("Cavalier_1", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/reine_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Fou_JOUEUR1("Fou_1", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/reine_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Reine_JOUEUR1("Reine_1", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/reine_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Roi_JOUEUR1("Roi_1", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/reine_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Pion_JOUEUR2("Pion_2", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/roi_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Tour_JOUEUR2("Tour_2", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/roi_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Cavalier_JOUEUR2("Cavalier_2", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/roi_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Fou_JOUEUR2("Fou_2", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/roi_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Reine_JOUEUR2("Reine_2", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/roi_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),
	Roi_JOUEUR2("Roi_2", new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/roi_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))),;
	
	private ImageIcon image;
	
	private String affichage;
	
	private Case(String aff, ImageIcon image) {
		affichage = aff;
		this.image = image;
		}	//constructeaur prive
	
	public String affiche() {return affichage;}
	
	public ImageIcon getImage() {
		return image;
	}
	
	public boolean isEqual(String x) {return affichage == x; }
}
