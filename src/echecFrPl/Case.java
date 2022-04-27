package EchecFrPl;

//import java.awt.*;
//import javax.swing.*;

public enum Case {
	VIDE(" ", 0),
	Pion("Pion", 1 ),
	Tour("Tour", 5),
	Cavalier("Cavalier", 3),
	Fou("Fou", 3),
	Reine("Reine", 10),
	Roi("Roi", -1);
	
	private int value;
	private String affichage;
	
	private Case(String aff, int value) { //constructeaur prive
		affichage = aff;
		this.value = value;
	}	
	
	// public String affiche() {return affichage;}
	
	// public boolean isEqual(String x) {return affichage == x; }
}