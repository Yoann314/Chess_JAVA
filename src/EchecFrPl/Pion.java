package src.EchecFrPl;

public class Pion extends Piece{

	public Pion(String c, int indL, int indCol) {
		this.setCouleur(c);
		this.ligne = indL;
		this.colonne = indCol;
		this.estActif = true;

	}

}
