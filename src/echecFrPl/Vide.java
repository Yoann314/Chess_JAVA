package echecFrPl;

public class Vide extends Piece {

    public Vide() {
        super();
	}
    
    public boolean deplacementValide() {
        return false;
    }

    @Override
    public boolean cheminOk() {
        // TODO Auto-generated method stub
        return false;
    }    
}
