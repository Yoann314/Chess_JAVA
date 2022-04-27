package EchecFrPl;

public class Cavalier extends Piece {
	
	Plateau grille;

	public Cavalier(String c, int indL, int indCol, int img) {
		super(img);
		this.setCouleur(c);
		this.ligne = indL;
		this.colonne = indCol;
		this.estActif=true;
	}
	public boolean deplacementValide(int indL, int indCol) // nouvelles coordonnees 
	{
		grille = new Plateau();
		
		if (indL < 8 && indCol < 8) {
			if(		Plateau.grille[indL][indCol] == Plateau.grille[ligne +1][colonne -2] || 
					Plateau.grille[indL][indCol] == Plateau.grille[ligne +1][colonne +2] ||
					Plateau.grille[indL][indCol] == Plateau.grille[ligne +2][colonne -1] ||
					Plateau.grille[indL][indCol] == Plateau.grille[ligne +2][colonne +1] ||
					Plateau.grille[indL][indCol] == Plateau.grille[ligne -1][colonne -2] ||
					Plateau.grille[indL][indCol] == Plateau.grille[ligne -1][colonne +2] ||
					Plateau.grille[indL][indCol] == Plateau.grille[ligne -2][colonne -1] ||
					Plateau.grille[indL][indCol] == Plateau.grille[ligne -2][colonne +1])
				return true;
		}
		if (this.ligne == indL && this.colonne == indCol) return false; //le piece n'a pas bouge
		return false;
		}

}
