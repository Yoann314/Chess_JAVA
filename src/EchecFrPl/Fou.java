package EchecFrPl;

public class Fou extends Piece{
	
	
	public Fou(String c, int indL, int indCol, int img) {
		super(img);
		this.setCouleur(c);
		this.ligne = indL;
		this.colonne = indCol;
		this.estActif=true;
	}
		public boolean deplacementValide(int indL, int indCol) // nouvelles coordonnees 
		{
			if (indL < 8 && indCol < 8) {		
				if (this.ligne == indL && this.colonne == indCol) return false; //le piece n'a pas bouge
				
				//diagonale
				int absDiff = Math.abs(this.ligne - indL);
				if (this.ligne == (indL+absDiff) && this.colonne == (indCol+absDiff)) return true;
				if (this.ligne == (indL-absDiff) && this.colonne == (indCol-absDiff)) return true;
				
				}
			return false;
			}
		}
	