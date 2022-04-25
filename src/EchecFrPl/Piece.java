package EchecFrPl;

import javax.swing.ImageIcon;
import java.awt.*;

public abstract class Piece {
    private String couleur;
    protected int ligne;
	protected int colonne;
    protected int value;
    boolean estActif;
	Image img;

	protected Piece(int k){
		ImageIcon imgX = new ImageIcon("src/images/"+k+".png");
		img = imgX.getImage().getScaledInstance(50, -1,Image.SCALE_DEFAULT);
	}

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
    
    public boolean getestActif() { 
    	return this.estActif; 
    }
    
    public void estActif(boolean actif) {
		if(actif!=false) this.estActif=false;
		if(actif==true) this.estActif=true;
	}
}