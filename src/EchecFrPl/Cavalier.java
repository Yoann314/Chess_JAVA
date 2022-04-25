package src.EchecFrPl;

public class Cavalier extends Piece {

	public Cavalier(String c, int indL, int indCol) {
		this.setCouleur(c);
		this.ligne = indL;
		this.colonne = indCol;
		this.estActif = true;
		
	}

}
