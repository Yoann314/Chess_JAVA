package EchecFrPl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Plateau implements ActionListener {
	Interface bouton = new Interface(null);
	private Case[][] grille; 
	private Piece[][] pieces;
	private ImageIcon image;
	int indiceLigne ;
	int indiceColonne ;
	String joueur ;
	
	
	public ImageIcon getImage() {
		return image;
	}
	
	public Plateau(){
		grille = new Case[8][8]; // on indique les dimensions de la grille
		pieces = new Piece[2][16];
		init(); // on initialise le plateau
		//bouton = new Interface(this);
		bouton.afficherPiece(image, indiceLigne, indiceColonne);
	}

	/*
	ImageIcon image = new ImageIcon("IMG_8094.jpeg");
        Image img = image.getImage().getScaledInstance(40, -1, Image.SCALE_DEFAULT);
        JButton buttonX = new JButton(new ImageIcon(img));

		JButton[][] boutons = new JButton[3][3];
        for (int i = 0; i < boutons.length; i++) {
            for (int j = 0; j < boutons[i].length; j++) {
                boutons[i][j] = new JButton(new ImageIcon(buttonX));//new ImageIcon(img));
                boutons[i][j].setPreferredSize(new Dimension(50,50));
                panneau.add(boutons[i][j]);
			}
		}
	*/
	


			
	public void init() {
		pieces[0][0] = new Tour(joueur,0,0,1);
		pieces[0][1] = new Cavalier(joueur,0,1,2);
		pieces[0][2] = new Fou(joueur,0,2,3);
		pieces[0][3] = new Reine(joueur,0,3,4);
		pieces[0][4] = new Roi(joueur,0,4,5);
		pieces[0][5] = new Fou(joueur,0,5,6);
		pieces[0][6] = new Cavalier(joueur,0,6,7);
		pieces[0][7] = new Tour(joueur,0,7,8);

		int l = 9;
		for(int i = 8; i < 16; i++){
			pieces[0][i] = new Pion(joueur,1,i,l);
			l++;
		}

		for(int i = 8; i < 16; i++){
			pieces[1][i] = new Pion(joueur,6,i,l);
			l++;
		}

		pieces[1][0] = new Tour(joueur,7,0,25);
		pieces[1][1] = new Cavalier(joueur,7,1,26);
		pieces[1][2] = new Fou(joueur,7,2,27);
		pieces[1][3] = new Reine(joueur,7,3,28);
		pieces[1][4] = new Roi(joueur,7,4,29);
		pieces[1][5] = new Fou(joueur,7,5,30);
		pieces[1][6] = new Cavalier(joueur,7,6,31);
		pieces[1][7] = new Tour(joueur,7,7,32);

	}
	

	public void affichePlateauDepart() {
		for(int indCol = 0; indCol < 8; indCol++) {
			bouton.afficherPiece(image, 0, indCol);
		}
		
			for(int intCol = 1; intCol < 8; intCol++) {
				bouton.afficherPiece(image, 1, intCol);
			}
	}
	

	
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
			affichePlateauDepart();
		}

}
