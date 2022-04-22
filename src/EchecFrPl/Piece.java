package EchecFrPl;

public abstract class Piece {
    private String joueur;
    public int indiceLigne;
    public int indiceColonne;
    private int value;

    public String getJoueur() {
        return joueur;
    }

    public int getIndiceLigne() {
        return indiceLigne;
    }

    public int getIndiceColonne() {
        return indiceColonne;
    }

    public void setCoordonnees(int indiceLigne, int indiceColonne) {
        this.indiceLigne = indiceLigne;
        this.indiceColonne = indiceColonne;
    }

    public int getValue() {
        return value;
    }
}
