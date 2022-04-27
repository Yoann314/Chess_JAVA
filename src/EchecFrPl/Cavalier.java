package EchecFrPl;
import java.awt.*;

public class Cavalier extends Piece {

	public Cavalier(String c, int indL, int indCol, int img) {
		super(img);
		this.setCouleur(c);
		this.ligne = indL;
		this.colonne = indCol;
		this.estActif = true;
		
	}

}
