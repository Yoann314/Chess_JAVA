package EchecFrPl;

import javax.swing.*;

import EchecFrPl.Case;

import java.awt.*;
import java.awt.event.*;
//import


public class Plateau implements ActionListener {
	public static Piece[][] grille;
	private ImageIcon image;
	int indiceLigne;
	int indiceColonne;
	String blanc;
	String noir;

	
	
	public ImageIcon getImage() {
		return image;
	}
	
	public Plateau(){
		grille = new Piece[8][8]; // on indique les dimensions de la grille;
		init(); // on initialise le plateau
		//interfaceJeu = new Interface(this);
	}

	/*
	ImageIcon image = new ImageIcon("IMG_8094.jpeg");
        Image img = image.getImage().getScaledInstance(40, -1, Image.SCALE_DEFAULT);
        JButton buttonX = new JButton(new ImageIcon(img));

		JButton[][] interfaceJeus = new JButton[3][3];
        for (int i = 0; i < interfaceJeus.length; i++) {
            for (int j = 0; j < interfaceJeus[i].length; j++) {
                interfaceJeus[i][j] = new JButton(new ImageIcon(buttonX));//new ImageIcon(img));
                interfaceJeus[i][j].setPreferredSize(new Dimension(50,50));
                panneau.add(interfaceJeus[i][j]);
			}
		}
	*/
	


			
	public void init() {
		pieces[0][0] = new Tour(noir,0,0,1);
		pieces[0][1] = new Cavalier(noir,0,1,2);
		pieces[0][2] = new Fou(noir,0,2,3);
		pieces[0][3] = new Reine(noir,0,3,4);
		pieces[0][4] = new Roi(noir,0,4,5);
		pieces[0][5] = new Fou(noir,0,5,6);
		pieces[0][6] = new Cavalier(noir,0,6,7);
		pieces[0][7] = new Tour(noir,0,7,8);

		int l = 9;
		for(int i = 8; i < 16; i++){
			pieces[0][i] = new Pion(noir,1,i,l);
			l++;
		}

		for(int i = 8; i < 16; i++){
			pieces[1][i] = new Pion(blanc,6,i,l);
			l++;
		}

		pieces[1][0] = new Tour(blanc,7,0,25);
		pieces[1][1] = new Cavalier(blanc,7,1,26);
		pieces[1][2] = new Fou(blanc,7,2,27);
		pieces[1][3] = new Reine(blanc,7,3,28);
		pieces[1][4] = new Roi(blanc,7,4,29);
		pieces[1][5] = new Fou(blanc,7,5,30);
		pieces[1][6] = new Cavalier(blanc,7,6,31);
		pieces[1][7] = new Tour(blanc,7,7,32);
		

		int k=0; l=0;
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				grille[i][j] = pieces[k][l]; l++;

				if (j== grille[i].length-1) k++;

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
	

	
	public boolean remplir(int idJoueur, int idLigne, int idCol) {
		if(grille[idLigne][idCol]!=Case.VIDE)
			return false;
		grille[idLigne][idCol] = Case.values()[idJoueur+1]; //on met +1 car à l'indice 0 on à VIDE, donc l'indice du J1 est à 1 dans Case
		return true;
		
	}
	
	
	
	public boolean verifierGagnant() {
		return false;
	}

	public static void main (String[] args) {
		Plateau m = new Plateau();
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
