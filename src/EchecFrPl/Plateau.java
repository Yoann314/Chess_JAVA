package EchecFrPl;

public class Plateau {

	private Case[][] grille; 
	private Piece[][] pieces;
	
	public Plateau(){
		grille = new Case[8][8]; // on indique les dimensions de la grille
		pieces = new Piece[2][16];
		init(); // on initialise le plateau
	}
			
	public void init(){
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

		for(int indiceLigne = 3; indiceLigne = 6; indiceLigne++) {
			for(int indiceColonne = 0; indiceColonne < grille[indiceLigne].length; indiceColonne++) {
				grille[indiceLigne][indiceColonne] = Case.VIDE;
			}
		}
	}

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

	}
}
