package EchecFrPl;
import java.awt.*;

public class Roi extends Piece {

	public Roi(String c, int indL, int indCol, int img) {
		super(img);
		this.setCouleur(c);
		this.ligne = indL;
		this.colonne = indCol;
		this.estActif = true;
	
	}

}
