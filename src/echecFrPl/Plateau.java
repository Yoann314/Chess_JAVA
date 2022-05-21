package echecFrPl;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class Plateau implements ActionListener {

	public static Piece[][] grille = null; // variable static car commun a tous les objets
	public static Vide vide = new Vide(); // variable static car commun a tous les objets, c'est toujours la meme
	Interface interf;
	String blanc, noir;
	public int indiceLiDepAC, indiceColDepAC , indiceLiArrAC, indiceColArrAC;
	public int turn = 0;
	Color colorArchive;	

	public Plateau() {
		grille = new Piece[8][8]; // on indique les dimensions de la grille;
		init();
		interf = new Interface(this);
		interf.fenetre.setVisible(true);
		indiceLiDepAC = -1;
	}
		
	public void init() {
		grille[0][0] = new Tour("noir",1);
		grille[0][1] = new Cavalier("noir",2);
		grille[0][2] = new Fou("noir",3);
		grille[0][3] = new Reine("noir",4);
		grille[0][4] = new Roi("noir",5);
		grille[0][5] = new Fou("noir",6);
		grille[0][6] = new Cavalier("noir",7);
		grille[0][7] = new Tour("noir",8);

		int l = 9;
		for(int j = 0; j < 8; j++) {
			grille[1][j] = new Pion("noir",l);
			l++;
		}

		for(int i = 2; i < 6; i++) { // 
			for (int j = 0; j < 8; j++) {
				grille[i][j] = vide;
			}
		}

		for(int j = 0; j < 8; j++) {
			grille[6][j] = new Pion("blanc",l);
			l++;
		}

		grille[7][0] = new Tour("blanc",25);
		grille[7][1] = new Cavalier("blanc",26);
		grille[7][2] = new Fou("blanc",27);
		grille[7][3] = new Reine("blanc",28);
		grille[7][4] = new Roi("blanc",29);
		grille[7][5] = new Fou("blanc",30);
		grille[7][6] = new Cavalier("blanc",31);
		grille[7][7] = new Tour("blanc",32);
	}
	
	public void bouger(int indLigneDepart, int indColDepart, int indLigneArrive, int indColArrive) {
		grille[indLigneArrive][indColArrive] = grille[indLigneDepart][indColDepart];
		interf.bouton[indLigneArrive][indColArrive].setIcon(grille[indLigneArrive][indColArrive].getTheImage());
		grille[indLigneDepart][indColDepart] = vide;
		interf.bouton[indLigneDepart][indColDepart].setIcon((Image)null);
		interf.bouton[indiceLiDepAC][indiceColDepAC].setBackground(colorArchive);

		// active les cases pour le joueur suivant
		if (grille[indLigneArrive][indColArrive].getCouleur() == "blanc")
				interf.activeCasesNoir();
			if (grille[indLigneArrive][indColArrive].getCouleur() == "noir") 
				interf.activeCasesBlanc();

		indiceLiDepAC = -1;
		turn++;
	}
	
	public boolean verifierGagnant() {
		return false;
	}

	/*
	public void recupererCoord(int indiceLiArrAC, int indiceColArrAC) {
		if (this.indiceLiDepAC == -1) {
			this.indiceLiDepAC = indiceLiArrAC;
			this.indiceColDepAC = indiceColArrAC;
		}
			
		if (this.indiceLiDepAC != indiceLiArrAC || this.indiceColDepAC != indiceColArrAC) {
			indiceLiDepAC=-1;
		}
	}
	*/
/*
	public boolean verifEchec() {
		int tindiceLiDepAC = indiceLiDepAC;// t pour temporaire
		int tindiceColDepAC = indiceColDepAC;
		int tindiceLiArrAC = indiceLiArrAC;
		int tindiceColArrAC = indiceColArrAC;

		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (grille[i][j].couleur == grille[indiceLiDepAC][indiceColDepAC].couleur && ) {
				String yo = grille[indiceLiDepAC][indiceColDepAC].couleur;

		}}}
		// chercher le roi de celui qui viens de bouger
		// changer les coordonnées d'arrivée avec les corrdonnées de ce roi
		//pour chaqu'une des pieces adverse 
			//changer les coodonnées de départ avec les coordonner de la piece
			// regarder si déplacement valide est ok 
			// si il y a un retrun true --> return true
			// si il n'y a pas de return true --> reassigner les variables indices aux vrais indices et return false

		//if (grille[indiceLiDepAC][indiceColDepAC].deplacementValide()) // indiceLiDepAC, indiceColDepAC, indiceLiArrAC, indiceColArrAC, "blanc"

		return true;
		
	}
*/


	@Override
	public void actionPerformed(ActionEvent ae) {
		String a = ae.getActionCommand();
		String[] coordonnéesListener = a.split("-");
		indiceLiArrAC = Integer.parseInt(coordonnéesListener[0]);
		indiceColArrAC = Integer.parseInt(coordonnéesListener[1]);

		System.out.println(grille[0][4].getCouleur());

		if (indiceLiDepAC == -1) {
			indiceLiDepAC = indiceLiArrAC;
			indiceColDepAC = indiceColArrAC;
			colorArchive = interf.bouton[indiceLiDepAC][indiceColDepAC].getBackground();
			interf.bouton[indiceLiDepAC][indiceColDepAC].setBackground(Color.GREEN);

			// Active les cases pour le joueur actuel
			if (grille[indiceLiDepAC][indiceColDepAC].getCouleur() == "blanc") 
				interf.activeCasesForBlanc();
			if (grille[indiceLiDepAC][indiceColDepAC].getCouleur() == "noir") 
				interf.activeCasesForNoir();
			if (grille[indiceLiDepAC][indiceColDepAC] == vide) 
				JOptionPane.showMessageDialog(null, "Veuillez selectioner une piece", "Erreur", JOptionPane.ERROR_MESSAGE);
		}

		if (indiceLiDepAC != indiceLiArrAC || indiceColDepAC != indiceColArrAC) {
			grille[indiceLiDepAC][indiceColDepAC].setCoordonneesDepart(indiceLiDepAC, indiceColDepAC);
			grille[indiceLiDepAC][indiceColDepAC].setCoordonneesArrive(indiceLiArrAC, indiceColArrAC);

			System.out.println("################################"); // à supprimer pour la fin
			System.out.println(grille[indiceLiDepAC][indiceColDepAC]); // à supprimer pour la fin

			if (grille[indiceLiDepAC][indiceColDepAC].deplacementValide()) { // indiceLiDepAC, indiceColDepAC, indiceLiArrAC, indiceColArrAC, "blanc"
				bouger(indiceLiDepAC, indiceColDepAC, indiceLiArrAC, indiceColArrAC);
			}
			else 
				indiceLiDepAC = -1;		
		}
	}

	public static void main(String[] args) {
		Plateau pl = new Plateau();
		// pl.interf.activeCases();
	}
}
