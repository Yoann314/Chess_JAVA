package EchecFrPl;

public class Pion extends Piece{
	
	Plateau grille;

	public Pion(String c, int indL, int indCol, int img) {
		super(img);
		this.setCouleur(c);
		this.ligne = indL;
		this.colonne = indCol;
		this.estActif=true;
	}
		public boolean deplacementValide(int indL, int indCol, String c) // nouvelles coordonnees 
		{
			grille = new Plateau();
			
			if (indL < 8 && indCol < 8 && c=="blanc") {
				if( (Plateau.grille[indL][indCol] == Plateau.grille[ligne -1][colonne +1]  ||
						Plateau.grille[indL][indCol] == Plateau.grille[ligne -1][colonne -1] )  &&
						Plateau.grille[indL][indCol] != Case.VIDE)
					return true;
			}
			if (indL < 8 && indCol < 8 && c=="noir") {
				if( (Plateau.grille[indL][indCol] == Plateau.grille[ligne +1][colonne +1]  ||
						Plateau.grille[indL][indCol] == Plateau.grille[ligne +1][colonne -1] ) &&
						Plateau.grille[indL][indCol] != Case.VIDE)
					return true;
			}
			return false;
			}
		
		public boolean peutManger(int indL, int indCol, String c) {
			grille = new Plateau();
			
			if (indL < 8 && indCol < 8 && c=="blanc") {
				if( Plateau.grille[indL][indCol] == Plateau.grille[ligne -1][colonne +1]  ||
						Plateau.grille[indL][indCol] == Plateau.grille[ligne -1][colonne -1] )  
					return true;
			}
			if (indL < 8 && indCol < 8 && c=="noir") {
				if	(Plateau.grille[indL][indCol] == Plateau.grille[ligne +1][colonne +1]  ||
						Plateau.grille[indL][indCol] == Plateau.grille[ligne +1][colonne -1] )
					return true;
			}
			return false;
		}
	}