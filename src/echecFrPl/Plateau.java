package echecFrPl;

import java.awt.*;
import java.awt.event.*;

public class Plateau implements ActionListener {
	public static Piece[][] grille;
	Interface interf;
	String blanc;
	String noir;
	int indiceLiDepAC;
	int indiceColDepAC;

	public Plateau(){
		grille = new Piece[8][8]; // on indique les dimensions de la grille;
		interf = new Interface(this);
		indiceLiDepAC = -1;
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
				}
			}
		}
	}
	
	public void bouger(int indLigneDepart, int indColDepart, int indLigneArrive, int indColArrive) {
		grille[indLigneArrive][indColArrive] = grille[indLigneDepart][indColDepart];
		interf.bouton[indLigneArrive][indColArrive].setIcon(grille[indLigneArrive][indColArrive].getTheImage());
		grille[indLigneDepart][indColDepart] = null;
		interf.bouton[indLigneDepart][indColDepart].setIcon((Image)null);
	}
	
	public boolean verifierGagnant() {
		return false;
	}

	public static void main (String[] args) {
		Plateau m = new Plateau();
		m.init();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String a = ae.getActionCommand();
		String[] coordonnéesListener = a.split("-");
		int indiceLiArrAC = Integer.parseInt(coordonnéesListener[0]);
		int indiceColArrAC = Integer.parseInt(coordonnéesListener[1]);

		if(indiceLiDepAC == -1) {
			indiceLiDepAC = indiceLiArrAC;
			indiceColDepAC = indiceColArrAC;
		}
			
		if (indiceLiDepAC != indiceLiArrAC || indiceColDepAC != indiceColArrAC) {
			bouger(indiceLiDepAC, indiceColDepAC, indiceLiArrAC, indiceColArrAC);
			indiceLiDepAC=-1;
		}
	}
}
