package EchecFrPl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Plateau implements ActionListener {

	private Case[][] grille; 
	private Piece[][] pieces;
	private ImageIcon image;
	Interface bouton;
	
	public ImageIcon getImage() {
		return image;
	}
	
	public Plateau(){
		grille = new Case[8][8]; // on indique les dimensions de la grille
		pieces = new Piece[2][16];
		init(); // on initialise le plateau
		bouton = new Interface(this);
		bouton.afficherPiece();
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
		pieces[0][0] = new Tour(0,0);
		pieces[0][1] = new Cavalier(0,1);
		pieces[0][2] = new Fou(0,2);
		pieces[0][3] = new Reine(0,3);
		pieces[0][4] = new Roi(0,4);
		pieces[0][5] = new Fou(0,5);
		pieces[0][6] = new Cavalier(0,6);
		pieces[0][7] = new Tour(0,7);

		for(int i = 8; i < 16; i++){
			pieces[0][i] = new Pion(1,i);
		}

		for(int i = 8; i < 16; i++){
			pieces[1][i] = new Pion(6,i);
		}

		pieces[1][0] = new Tour(7,0);
		pieces[1][1] = new Cavalier(7,1);
		pieces[1][2] = new Fou(7,2);
		pieces[1][3] = new Reine(7,3);
		pieces[1][4] = new Roi(7,4);
		pieces[1][5] = new Fou(7,5);
		pieces[1][6] = new Cavalier(7,6);
		pieces[1][7] = new Tour(7,7);

	}
	

	public void afficherInitPlateau(int indiceLigne, int indiceColonne) {
		bouton.afficherPiece(new ImageIcon("X.png"), 0, 0);
	}

/*
	public void affichePlateau() {
		for(int indiceLigne = 0; indiceLigne < 8; indiceLigne++) {
			for(int indiceColonne = 0; indiceColonne < 8; indiceColonne++) {
				grille[pieces[][].indiceLigne][pieces[][].indiceColonne] = new JButton(new ImageIcon("/Echec.fr.pl/src/EchecFrPl/images/reine_draft1.png").getImage().getScaledInstance(100,  100, Image.SCALE_DEFAULT))
			}
		}

	}
	*/

	/*	
	public boolean remplir(int idJoueur, int idLigne, int idCol) {
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
	}
	@Override
		public void ActionPerformed(ActionEvent arg0) {
			String res = arg0.getActionCommand();
			String[] coordonnees = res.split("-");
			int indiceLigne = Integer.parseInt(coordonnees[0]);
			int indiceColonne = Integer.parseInt(coordonnees[1]);
			afficherInitPlateau(indiceLigne, indiceColonne);
		}
}
