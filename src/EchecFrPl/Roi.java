package src.EchecFrPl;

public class Roi extends Piece {

	public Roi(String c, int indL, int indCol) {
		this.setCouleur(c);
		this.ligne = indL;
		this.colonne = indCol;
		this.estActif = true;
	
	}

}
