package echecFrPl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Plateau implements ActionListener {
	public static Piece[][] grille;
	Interface interf;
	int indiceLigne;
	int indiceColonne;
	String blanc;
	String noir;


	public Plateau(){
		grille = new Piece[8][8]; // on indique les dimensions de la grille;
		interf = new Interface(this);
		//init(); // on initialise le plateau
		//interfaceJeu = new Interface(this);
	}
		
	public void init() {
		grille[0][0] = new Tour(noir,1);
		grille[0][1] = new Cavalier(noir,2);
		grille[0][2] = new Fou(noir,3);
		grille[0][3] = new Reine(noir,4);
		grille[0][4] = new Roi(noir,5);
		grille[0][5] = new Fou(noir,6);
		grille[0][6] = new Cavalier(noir,7);
		grille[0][7] = new Tour(noir,8);

		int l = 9;
		for(int i = 0; i < 8; i++){
			grille[1][i] = new Pion(noir,l);
			l++;
		}

		for(int i = 0; i < 8; i++){
			grille[6][i] = new Pion(blanc,l);
			l++;
		}

		grille[7][0] = new Tour(blanc,25);
		grille[7][1] = new Cavalier(blanc,26);
		grille[7][2] = new Fou(blanc,27);
		grille[7][3] = new Reine(blanc,28);
		grille[7][4] = new Roi(blanc,29);
		grille[7][5] = new Fou(blanc,30);
		grille[7][6] = new Cavalier(blanc,31);
		grille[7][7] = new Tour(blanc,32);

		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				if (grille[i][j] != null) {
					interf.bouton[i][j].setIcon(grille[i][j].getTheImage());
					System.out.println(grille[i].length);
				}
			}
		}
	}

	
	/*
	public void affichePlateauDepart() {
		for(int indCol = 0; indCol < 8; indCol++) {
			interfaceJeu.afficherPiece(image, 0, indCol);
		}
		
			for(int intCol = 1; intCol < 8; intCol++) {
				interfaceJeu.afficherPiece(image, 1, intCol);
			}
	}
	*/
	
	/*	
	public boolean remplir(int idLigne, int idCol) {
		if(grille[idLigne][idCol]!=Case.VIDE)
			return false;
		grille[idLigne][idCol] = Case.values()[idJoueur+1]; //on met +1 car à l'indice 0 on à VIDE, donc l'indice du J1 est à 1 dans Case
		return true;
		
	}
	*/
	
	
	
	public boolean verifierGagnant() {
		return false;
	}

	public static void main (String[] args) {
		Plateau m = new Plateau();
		m.init();
	}

	@Override
		public void actionPerformed(ActionEvent arg0) {
			String res = arg0.getActionCommand();
			String[] coordonnees = res.split("-");
			int indiceLigne = Integer.parseInt(coordonnees[0]);
			int indiceColonne = Integer.parseInt(coordonnees[1]);
			//affichePlateauDepart();
		}

}
