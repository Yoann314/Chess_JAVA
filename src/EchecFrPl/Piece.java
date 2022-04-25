package src.EchecFrPl;

public abstract class Piece {
    private String couleur;
    protected int ligne;
	protected int colonne;
    protected int value;

    public void JOueur(String c) { 
    	this.setCouleur(c); 
    	}
    
    public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getLigne() { 
		return this.ligne; 
		}
	
	public int getColonne() { 
		return this.colonne; 
		}

    public void setCoordonnees(int indL, int indCol) {
		this.ligne=indL;
		this.colonne=indCol;
	}

    public void getValue(int valeurPiece) {
        this.value = valeurPiece;
    }
}
