package echecFrPl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Plateau implements ActionListener {

	public static Piece[][] grille = null; // variable static car commun a tous les objets
	public static Vide vide = new Vide(); // variable static car commun a tous les objets, c'est toujours la meme
	Interface interf;
	String blanc, noir;
	public int indiceLiDepAC, indiceColDepAC , indiceLiArrAC, indiceColArrAC;
	public int turn = 0;
	public boolean onBouge = false;
	private Chronometre chrono = new Chronometre();
	Color colorArchive;	
	String col;
	int cimI, cimJ;

	public Plateau() {
		grille = new Piece[8][8]; // on indique les dimensions de la grille;
		init();
		interf = new Interface(this);
		interf.fenetreSTART.setAlwaysOnTop(true);
		interf.fenetreSTART.setVisible(true);
		interf.fenetre.setVisible(true);
		/*
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==interf.boutonJouer) {
					interf.fenetreSTART.setVisible(false);
					interf.fenetre.setVisible(true); } } }; */
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
	//JPanel cimetiereNoir = new JPanel(new GridLayout(2,8));
	//JPanel cimetiereBlanc = new JPanel(new GridLayout(2,8));

	public void bouger(int indLigneDepart, int indColDepart, int indLigneArrive, int indColArrive) {
		System.out.println("§§§§§§§§§ " + col + " " +cimI + " : " +cimJ);
		//cimitiere
		if(col == "blanc") {
			interf.ajoutCimtiereNoir(cimI, cimJ);
			System.out.println(grille[cimI][cimJ].getValue() +" va au cimitiereNoir");
		}
							
		if(col == "noir") {
			interf.ajoutCimtiereBlanc(cimI, cimJ);
			System.out.println(grille[cimI][cimJ].getValue() +" va au cimitiereBlanc");
		}
			
							
		//bouger
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

	public boolean echec() {
		int tindiceLiArrAC = indiceLiArrAC; // t pour temporaire
		int tindiceColArrAC = indiceColArrAC;

		String couleurViensBouger = grille[indiceLiDepAC][indiceColDepAC].getCouleur();
		grille[indiceLiArrAC][indiceColArrAC] = grille[indiceLiDepAC][indiceColDepAC]; // simulation si la piece bouge
		grille[indiceLiDepAC][indiceColDepAC] = vide;

		if (couleurViensBouger == "blanc") { // cherche le roi de celui qui viens de bouger
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (grille[i][j].getK() == 29) { // change les coordonnées d'arrivée avec les corrdonnées de ce roi
						indiceLiArrAC = i;
						indiceColArrAC = j;
					}
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (grille[i][j].getCouleur() == "noir" ) { // pour chaque pieces adverse
						grille[i][j].setCoordonneesDepart(i, j); // change les coordonnées de deppart avec les corrdonnées de cette piece
						grille[i][j].setCoordonneesArrive(indiceLiArrAC, indiceColArrAC);

						if (grille[i][j].deplacementValide()) {
							indiceLiArrAC = tindiceLiArrAC; // reassigne les variables indices aux vrais indices
							indiceColArrAC = tindiceColArrAC;
							grille[indiceLiDepAC][indiceColDepAC].setCoordonneesDepart(indiceLiDepAC, indiceColDepAC);
							grille[indiceLiDepAC][indiceColDepAC].setCoordonneesArrive(indiceLiArrAC, indiceColArrAC);
							grille[indiceLiDepAC][indiceColDepAC] = grille[tindiceLiArrAC][tindiceColArrAC]; // remide de la piece a ca place
							grille[indiceLiArrAC][indiceColArrAC] = vide;
							return true; // echec
						}
					}
				}
			}
		}

		if (couleurViensBouger == "noir") { // cherche le roi de celui qui viens de bouger
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (grille[i][j].getK() == 5) { // change les coordonnées d'arrivée avec les corrdonnées de ce roi
						indiceLiArrAC = i;
						indiceColArrAC = j;
					}
				}
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (grille[i][j].getCouleur() == "blanc" ) { // pour chaque pieces adverse
						grille[i][j].setCoordonneesDepart(i, j); // changer les coordonnées de deppart avec les corrdonnées de cette piece
						grille[i][j].setCoordonneesArrive(indiceLiArrAC, indiceColArrAC);

						if (grille[i][j].deplacementValide()) {
							indiceLiArrAC = tindiceLiArrAC; // réassigne les variables indices aux vrais indices
							indiceColArrAC = tindiceColArrAC;
							grille[indiceLiDepAC][indiceColDepAC] = grille[indiceLiArrAC][indiceColArrAC]; // remide de la piece a ca place
							grille[indiceLiArrAC][indiceColArrAC] = vide;
							grille[indiceLiDepAC][indiceColDepAC].setCoordonneesDepart(indiceLiDepAC, indiceColDepAC);
							grille[indiceLiDepAC][indiceColDepAC].setCoordonneesArrive(indiceLiArrAC, indiceColArrAC);						

							return true; // echec
						}
					}
				}
			}
		}
		indiceLiArrAC = tindiceLiArrAC; // reassigne les variables indices aux vrais indices
		indiceColArrAC = tindiceColArrAC;
		grille[indiceLiDepAC][indiceColDepAC].setCoordonneesDepart(indiceLiDepAC, indiceColDepAC);
		grille[indiceLiDepAC][indiceColDepAC].setCoordonneesArrive(indiceLiArrAC, indiceColArrAC);						
		grille[indiceLiDepAC][indiceColDepAC] = grille[indiceLiArrAC][indiceColArrAC]; // remide de la piece a ca place
		grille[indiceLiArrAC][indiceColArrAC] = vide;
		System.out.println("ECHEC************** " + grille[indiceLiArrAC][indiceColArrAC].getCouleur());
		System.out.println("ECHEC getK************** " + grille[indiceLiArrAC][indiceColArrAC].getK());
		return false;	
	}	

	@Override
	public void actionPerformed(ActionEvent ae) {
		onBouge=false;
		String a = ae.getActionCommand();
		String[] coordonnéesListener = a.split("-");
		indiceLiArrAC = Integer.parseInt(coordonnéesListener[0]);
		indiceColArrAC = Integer.parseInt(coordonnéesListener[1]);

		if (indiceLiDepAC == -1) { // si c'est la premiere fois qu'on cique sur les deux
			indiceLiDepAC = indiceLiArrAC;
			indiceColDepAC = indiceColArrAC;
			
			colorArchive = interf.bouton[indiceLiDepAC][indiceColDepAC].getBackground();
			interf.bouton[indiceLiDepAC][indiceColDepAC].setBackground(Color.decode("#999696")); // vert pastel : #B4ECB4

			// Active les cases pour le joueur actuel
			if (grille[indiceLiDepAC][indiceColDepAC].getCouleur() == "blanc") 
				interf.activeCasesForBlanc();
			if (grille[indiceLiDepAC][indiceColDepAC].getCouleur() == "noir") 
				interf.activeCasesForNoir();
			if (grille[indiceLiDepAC][indiceColDepAC] == vide) 
				JOptionPane.showMessageDialog(null, "Veuillez selectioner une piece", "Erreur", JOptionPane.ERROR_MESSAGE);		
		}

		if (indiceLiDepAC != indiceLiArrAC || indiceColDepAC != indiceColArrAC) { // si c'est le deuxième clique
			grille[indiceLiDepAC][indiceColDepAC].setCoordonneesDepart(indiceLiDepAC, indiceColDepAC);
			grille[indiceLiDepAC][indiceColDepAC].setCoordonneesArrive(indiceLiArrAC, indiceColArrAC);

			System.out.println("################################"); // à supprimer pour la fin
			System.out.println(grille[indiceLiDepAC][indiceColDepAC]); // à supprimer pour la fin
			//System.out.println("@@@@@@@@@@ " + grille[indiceLiArrAC][indiceColArrAC].getCouleur());
			System.out.println("%%%%%%%%%% " + indiceLiArrAC);
			System.out.println("DEBUT getK************** " + grille[indiceLiArrAC][indiceColArrAC].getK());
			col = grille[indiceLiArrAC][indiceColArrAC].getCouleur();
			cimI = indiceLiArrAC;
			cimJ = indiceColArrAC;
			System.out.println("................. " + col);

			if (grille[indiceLiDepAC][indiceColDepAC].deplacementValide() && echec() == false) { // indiceLiDepAC, indiceColDepAC, indiceLiArrAC, indiceColArrAC, "blanc"
			System.out.println("%%%%%%%%%% " + indiceLiArrAC);
				bouger(indiceLiDepAC, indiceColDepAC, indiceLiArrAC, indiceColArrAC);

				onBouge = true;
				chrono.stopN();
				chrono.startB();
			if (chrono.startedB==false && chrono.startedN==true) {
				chrono.startedB=true;
				chrono.startedN=false;
				chrono.startB();
				chrono.stopN();
			}
			if (chrono.startedB==false && chrono.startedN==false) {
				chrono.startedB=true;
				chrono.startB();
			}
			chrono.stopB();
			chrono.startN();
			if (chrono.startedN==false && chrono.startedB==true) {
				chrono.startedN=true;
				chrono.startedB=false;
				chrono.startN();
				chrono.stopB();
			}
			if (chrono.startedN==false && chrono.startedB==false) {
				chrono.startedN=true;
				chrono.startN();
			}

			}

			else {
				interf.bouton[indiceLiDepAC][indiceColDepAC].setBackground(colorArchive);
				if (grille[indiceLiDepAC][indiceColDepAC].getCouleur() == "blanc")
					interf.activeCasesForNoir();
				if (grille[indiceLiDepAC][indiceColDepAC].getCouleur() == "noir") 
					interf.activeCasesForBlanc();
				indiceLiDepAC = -1;
			}

		}
	}

	public static void main(String[] args) {
		Plateau pl = new Plateau();
		// pl.interf.activeCases();
	}
}
