package src.EchecFrPl;

import java.awt.*;
import javax.swing.*;

public enum Case {
	VIDE(" ", 0),
	Pion("Pion", 1 ),
	Tour("Tour", 5),
	Cavalier("Cavalier", 3),
	Fou("Fou", 3),
	Reine("Reine", 10),
	Roi("Roi", -1);
	
	//new ImageIcon(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/reine_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))

	private int value;
	
	private String affichage;
	
	private Case(String aff, int value) {
		affichage = aff;
		this.value = value;
		}	//constructeaur prive
	
	public String affiche() {return affichage;}
	
	public boolean isEqual(String x) {return affichage == x; }
}