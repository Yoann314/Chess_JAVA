package echecFrPl;

import javax.swing.ImageIcon;
import java.awt.*;

public abstract class Piece {
    private String couleur;
    public static String forme;
    protected int indLigneDepart;
	protected int indColDepart;
    protected int indLigneArrive;
	protected int indColArrive;
    protected int value;
    boolean estActif;
    public abstract boolean deplacementValide(int indLigneDepart, int indColDepart, int indLigneArrive, int indColArrive, String couleur);
	Image img;

	public Piece(int k){ // le nom de l'image part 1
		ImageIcon imgX = new ImageIcon("src/images/"+k+".png");
		img = imgX.getImage().getScaledInstance(50, -1,Image.SCALE_DEFAULT);
	}
	public void setForme(String f) { 
		Piece.forme=f; 
		}

	public Image getTheImage() {
		return img;
	}

    public void Joueur(String c) { 
    	this.setCouleur(c); 
    }
    
    public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getLigneDepart() { 
		return this.indLigneDepart; 
	}
	
	public int getColDepart() { 
		return this.indColDepart; 
	}
	public int getLigneArrive() { 
		return this.indLigneArrive; 
	}
	
	public int getColArrive() { 
		return this.indColArrive; 
	}

    public void setCoordonneesDepart(int indLigneDepart, int indColDepart) {
		this.indLigneDepart=indLigneDepart;
		this.indColDepart=indColDepart;
	}
    
    public void setCoordonneesArrive(int indLigneArrive, int indColArrive) {
		this.indLigneArrive=indLigneArrive;
		this.indColArrive=indColArrive;
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
    
    public boolean getdeplacementValide() {
    	return this.deplacementValide(this.indLigneDepart,this.indColDepart, this.indLigneArrive, this.indColArrive, this.couleur);
    }
    
}
