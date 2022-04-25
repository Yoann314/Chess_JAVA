package src.EchecFrPl;

public class Tour extends Piece {
	
	
	public Tour(String c, int indL, int indCol, int img) {
		super(img);
		this.setCouleur(c);
		this.ligne = indL;
		this.colonne = indCol;
		this.estActif=true;
	}
		public boolean deplacementValide(int indL, int indCol) // nouvelles coordonnees 
		{
			if (indL < 8 && indCol < 8) {		
				if (this.ligne == indL && this.colonne == indCol) return false;
				if (this.ligne == indL || this.colonne == indCol) return true;
				}
			return false;
			}
		}
	