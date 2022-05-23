package echecFrPl;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Plateau implements ActionListener {

	public static Piece[][] grille = null; // variable static car commun a tous les objets
	public static Vide vide = new Vide(); // variable static car commun a tous les objets, c'est toujours la meme
	public int indiceLiDepAC, indiceColDepAC , indiceLiArrAC, indiceColArrAC, indiceLRoi, indiceCRoi, iMemoireEchec, jMemoireEchec, entreEchecEtMat = 0, turn = 0, iModR, jModR;
	Piece[][] grilleMemoire = new Piece[1][1];
	Interface interf;
	String blanc, noir, couleurViensBouger;
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

		public boolean echec(String couleurViensBouger) {
		//System.out.println("1 " + grille[4][4].getCouleur());

		int indiceRoi =  -1;
		String couleurATester = " ";

		if (couleurViensBouger == "blanc") {
			indiceRoi = 29;
			couleurATester = "noir";
		}

		if (couleurViensBouger == "noir") {
			indiceRoi = 5;
			couleurATester = "blanc";
		}


		if (entreEchecEtMat == 0) { // avant echecEtMat
			grille[indiceLiArrAC][indiceColArrAC] = grille[indiceLiDepAC][indiceColDepAC]; // simulation si la piece bouge
			grille[indiceLiDepAC][indiceColDepAC] = vide;
		}

			for (int i = 0; i < 8; i++) { // cherche le roi de celui qui viens de bouger
				for (int j = 0; j < 8; j++) {
					if (grille[i][j].getK() == indiceRoi) { // change les coordonnées d'arrivée avec les corrdonnées du roi blanc
						indiceLRoi = i;
						indiceCRoi = j;
					}
				}
			}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (grille[i][j].getCouleur() == couleurATester ) { // pour chaque pieces adverse
					grille[i][j].setCoordonneesDepart(i, j); // change les coordonnées de deppart avec les corrdonnées de cette piece
					if (entreEchecEtMat == 0) 
						grille[i][j].setCoordonneesArrive(indiceLRoi, indiceCRoi);

					if (entreEchecEtMat == 1) 
						grille[i][j].setCoordonneesArrive(iModR, jModR);

					//System.out.println(grille[i][j] + " " + grille[i][j].deplacementValide());
					if (grille[i][j].deplacementValide()) {
						if (entreEchecEtMat == 0) {
							grille[indiceLiDepAC][indiceColDepAC].setCoordonneesDepart(indiceLiDepAC, indiceColDepAC);
							grille[indiceLiDepAC][indiceColDepAC].setCoordonneesArrive(indiceLiArrAC, indiceColArrAC);
							grille[indiceLiDepAC][indiceColDepAC] = grille[indiceLiArrAC][indiceColArrAC]; // remide de la piece a ca place
							grille[indiceLiArrAC][indiceColArrAC] = vide;
							JOptionPane.showMessageDialog(null, "Votre Roi est en echec par la piece au coordonées : " + (i+1) + " : " + (j+1), "Echec", JOptionPane.ERROR_MESSAGE);		
						}
						return true; // echec
					}
				}
			}
		}

		if (entreEchecEtMat == 0) {
			grille[indiceLiDepAC][indiceColDepAC].setCoordonneesDepart(indiceLiDepAC, indiceColDepAC);
			grille[indiceLiDepAC][indiceColDepAC].setCoordonneesArrive(indiceLiArrAC, indiceColArrAC);	
			grille[indiceLiDepAC][indiceColDepAC] = grille[indiceLiArrAC][indiceColArrAC]; // remise de la piece a ca place
			grille[indiceLiArrAC][indiceColArrAC] = vide;
		}					
		
		//System.out.println("3 " + grille[4][4].getCouleur());
		//System.out.println("Couleur a tester pour manger le roi: " + couleurATester);
		//System.out.println("Indice roi : " + indiceLRoi + " " + indiceCRoi);

		return false;	
	}
	
	public boolean echecEtMat() {
		int a = indiceLRoi, a1 = indiceLRoi+1, a11 = indiceLRoi-1, b = indiceCRoi, b1 = indiceCRoi+1, b11 = indiceCRoi-1;
		
		String couleurATesterMat = " ";

		if (couleurViensBouger == "blanc")
			couleurATesterMat = "noir";

		if (couleurViensBouger == "noir")
			couleurATesterMat = "blanc";

		grille[indiceLiArrAC][indiceColArrAC] = grille[indiceLiDepAC][indiceColDepAC]; // simulation si la piece bouge
		grille[indiceLiDepAC][indiceColDepAC] = vide;
		if (echec(couleurATesterMat)) { // Si le roi adverse est en echec
			System.out.println("le roi est en echec");
			
			// test si l'attant peut etre manger
			for (int i = 0; i < 8; i++) { 
				for (int j = 0; j < 8; j++) {
					if (grille[i][j].getCouleur() == couleurATesterMat) { // Esce qu'1 noir peut manger l'attaquant
						grille[i][j].setCoordonneesDepart(i, j);
						grille[i][j].setCoordonneesArrive(iMemoireEchec, jMemoireEchec); // attaquant 
						if (grille[i][j].deplacementValide()) {
							grille[indiceLiDepAC][indiceColDepAC].setCoordonneesDepart(indiceLiDepAC, indiceColDepAC);
							grille[indiceLiDepAC][indiceColDepAC].setCoordonneesArrive(indiceLiArrAC, indiceColArrAC);
							System.out.println("attaquant peut etre manger");
							return false; // l'attaquant peut etre manger
						}
					}
				}
			}
			
		
			// tester si une piece de peut s'interposer entre l'attaquant et le roi de


			// test si le roi peut etre bouger

			//if (a >= 0 && a < 8 && a1 >= 0 && a1 < 8 && a11 >= 0 && a11 < 8 && b >= 0 && b < 8 && b1 >= 0 && b1 < 8 && b11 >= 0 && b11 < 8) { // rentre pas dedans pb...
				// grille[a][b].setCoordonneesDepart(a, b); 
				grille[a][b].setCoordonneesArrive(a1, b); // test roi i+1 j+0   1/8
				if (grille[a][b].deplacementValide()) {
					grilleMemoire[1][1] = grille[a1][b]; // au cas ou il y ai une piece adverse
					grille[a1][b] = grille[a][b]; 
					grille[a][b] = vide;

					if (!echec(couleurATesterMat)) { // si le roi n'est pas en echec
						grille[a][b] = grille[a1][b]; // remise en place des Pieces
						grille[a1][b] = grilleMemoire[1][1]; 
						System.out.println("le roi peut fuire 1");
						return false;
					}

					else { // remise en place des Pieces
						grille[a][b] = grille[a1][b]; // remise en place des Pieces
						grille[a1][b] = grilleMemoire[1][1]; 
					}
				}

				//grille[a][b].setCoordonneesDepart(a, b); 
				grille[a][b].setCoordonneesArrive(a1, b1); // test roi i+1 j+1   2/8
				if (grille[a][b].deplacementValide()) {
					grilleMemoire[1][1] = grille[a1][b1]; // au cas ou il y ai une piece adverse
					grille[a1][b1] = grille[a][b]; 
					grille[a][b] = vide;

					if (!echec(couleurATesterMat)) { // si le roi n'est pas en echec
						grille[a][b] = grille[a1][b1]; // remise en place des Pieces
						grille[a1][b1] = grilleMemoire[1][1]; 
						System.out.println("le roi peut fuire 2");
						return false;
					}

					else { 
						grille[a][b] = grille[a1][b1]; // remise en place des Pieces
						grille[a1][b1] = grilleMemoire[1][1]; 
					}
				}

				//grille[a][b].setCoordonneesDepart(a, b); 
				grille[a][b].setCoordonneesArrive(a, b1); // test roi i+0 j+1   3/8
				if (grille[a][b].deplacementValide()) {
					grilleMemoire[1][1] = grille[a][b1]; // au cas ou il y ai une piece adverse
					grille[a][b1] = grille[a][b]; 
					grille[a][b] = vide;

					if (!echec(couleurATesterMat)) { // si le roi n'est pas en echec
						grille[a][b] = grille[a][b1]; // remise en place des Pieces
						grille[a][b1] = grilleMemoire[1][1]; 
						System.out.println("le roi peut fuire 3");
						return false;
					}

					else { 
						grille[a][b] = grille[a][b1]; // remise en place des Pieces
						grille[a][b1] = grilleMemoire[1][1];
					}
				} 

				//grille[a][b].setCoordonneesDepart(a, b); 
				grille[a][b].setCoordonneesArrive(a11, b1); // test roi i-1 j+1   4/8
				if (grille[a][b].deplacementValide()) {
					grilleMemoire[1][1] = grille[a11][b1]; // au cas ou il y ai une piece adverse
					grille[a11][b1] = grille[a][b]; 
					grille[a][b] = vide;

					if (!echec(couleurATesterMat)) { // si le roi n'est pas en echec
						grille[a][b] = grille[a11][b1]; // remise en place des Pieces
						grille[a11][b1] = grilleMemoire[1][1];
						System.out.println("le roi peut fuire 4"); 
						return false;
					}

					else {
						grille[a][b] = grille[a11][b1]; // remise en place des Pieces
						grille[a11][b1] = grilleMemoire[1][1];
					}
				}

				//grille[a][b].setCoordonneesDepart(a, b); 
				grille[a][b].setCoordonneesArrive(a11, b); // test roi i-1 j+0   5/8
				if (grille[a][b].deplacementValide()) {
					grilleMemoire[1][1] = grille[a11][b]; // au cas ou il y ai une piece adverse
					grille[a11][b] = grille[a][b]; 
					grille[a][b] = vide;

					if (!echec(couleurATesterMat)) { // si le roi n'est pas en echec
						grille[a][b] = grille[a11][b]; // remise en place des Pieces
						grille[a11][b] = grilleMemoire[1][1]; 
						System.out.println("le roi peut fuire 5");
						return false;
					}

					else { 
						grille[a][b] = grille[a11][b]; // remise en place des Pieces
						grille[a11][b] = grilleMemoire[1][1];
					}
				}

				//grille[a][b].setCoordonneesDepart(a, b); 
				grille[a][b].setCoordonneesArrive(a11, b11); // test roi i-1 j-1   6/8
				if (grille[a][b].deplacementValide()) {
					grilleMemoire[1][1] = grille[a11][b11]; // au cas ou il y ai une piece adverse
					grille[a11][b11] = grille[a][b]; 
					grille[a][b] = vide;

					if (!echec(couleurATesterMat)) { // si le roi n'est pas en echec
						grille[a][b] = grille[a11][b11]; // remise en place des Pieces
						grille[a11][b11] = grilleMemoire[1][1]; 
						System.out.println("le roi peut fuire 6");
						return false;
					}

					else { 
						grille[a][b] = grille[a11][b11]; // remise en place des Pieces
						grille[a11][b11] = grilleMemoire[1][1];
					}
				}

				//grille[a][b].setCoordonneesDepart(a, b); 
				grille[a][b].setCoordonneesArrive(a, b11); // test roi i+0 j-1   7/8
				if (grille[a][b].deplacementValide()) {
					grilleMemoire[1][1] = grille[a][b11]; // au cas ou il y ai une piece adverse
					grille[a][b11] = grille[a][b]; 
					grille[a][b] = vide;

					if (!echec(couleurATesterMat)) { // si le roi n'est pas en echec
						grille[a][b] = grille[a][b11]; // remise en place des Pieces
						grille[a][b11] = grilleMemoire[1][1]; 
						System.out.println("le roi peut fuire 7");
						return false;
					}

					else { 
						grille[a][b] = grille[a][b11]; // remise en place des Pieces
						grille[a][b11] = grilleMemoire[1][1];
					}
				}

				System.out.println("coucou");

				grille[a][b].setCoordonneesDepart(a, b); 
				grille[a][b].setCoordonneesArrive(a1, b11); // test roi i+1 j-1   8/8
				iModR = a1;
				jModR = b11;
				if (grille[a][b].deplacementValide()) {
					grilleMemoire[1][1] = grille[a1][b11]; // au cas ou il y ai une piece adverse
					grille[a1][b11] = grille[a][b]; 
					grille[a][b] = vide;

					if (!echec(couleurATesterMat)) { // si le roi n'est pas en echec
						grille[a][b] = grille[a1][b11]; // remise en place des Pieces
						grille[a1][b11] = grilleMemoire[1][1]; 
						System.out.println("le roi peut fuire 8");
						return false;
					}

					else { 
						grille[a][b] = grille[a1][b11]; 
						grille[a1][b11] = grilleMemoire[1][1];
					}
				}
			//}
			return true;
		}	
		
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
			
			couleurViensBouger = grille[indiceLiDepAC][indiceColDepAC].getCouleur();
			if (grille[indiceLiDepAC][indiceColDepAC].deplacementValide() && !echec(couleurViensBouger)) { // indiceLiDepAC, indiceColDepAC, indiceLiArrAC, indiceColArrAC, "blanc"
				bouger(indiceLiDepAC, indiceColDepAC, indiceLiArrAC, indiceColArrAC);
				entreEchecEtMat = 1;
				if (echecEtMat())
					JOptionPane.showMessageDialog(null, "Les " + couleurViensBouger + " gagne !!!!!", "Echec et mat", JOptionPane.ERROR_MESSAGE);		
				
				entreEchecEtMat = 0;
				indiceLiDepAC = -1;

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
