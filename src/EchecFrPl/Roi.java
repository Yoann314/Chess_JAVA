package EchecFrPl;

public class Roi extends Piece {
	
	Plateau grille;

	public Roi(String c, int indL, int indCol, int img) {
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
				if(Plateau.grille[indL][indCol] == Plateau.grille[ligne +1][colonne] ||
						Plateau.grille[indL][indCol] == Plateau.grille[ligne][colonne+1] ||
						Plateau.grille[indL][indCol] == Plateau.grille[ligne+1][colonne+1])
					return true;
			}
			return false;
			}
		
		}
