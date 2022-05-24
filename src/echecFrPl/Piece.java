package echecFrPl;

import javax.swing.ImageIcon;
import java.awt.*;

public abstract class Piece {

    public String couleur;
    protected int indLigneDepart, indColDepart, indLigneArrive, indColArrive, value;
    boolean estActif, pieceBouge;
    public abstract boolean deplacementValide();
	public abstract boolean cheminOk();
	Image img;
	int k; // image de chauque Pieces

	public Piece(String couleur, int k) { // le nom de l'image part 1
		ImageIcon imgX = new ImageIcon("src/images/"+k+".png");
		img = imgX.getImage().getScaledInstance(50, -1,Image.SCALE_DEFAULT);
		this.couleur = couleur;
		this.k = k;
	}

	public Piece() {}	

	/*
	public String toString() { // à supprimer pour la fin
		return "("+String.valueOf(indLigneDepart)+","+String.valueOf(indColDepart)+") --> ("+String.valueOf(indLigneArrive)+","+String.valueOf(indColArrive)+")";
	}
	*/
	
	public boolean getPieceBouge(){
		return pieceBouge;
	}

	public void setPieceBouge(boolean pieceBouge){
		this.pieceBouge = pieceBouge;
	}

	public Image getTheImage() {
		return img;
	}

	public int getK() {
		return k;
	}
    
    public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public void setCoordonneesDepart(int indLigneDepart, int indColDepart) { // conkat avec arrivée ?
		this.indLigneDepart=indLigneDepart;
		this.indColDepart=indColDepart;
	}
    
    public void setCoordonneesArrive(int indLigneArrive, int indColArrive) {
		this.indLigneArrive=indLigneArrive;
		this.indColArrive=indColArrive;
	}

	public int getValue() {
        return value;
    }

    public boolean getestActif() { 
    	return this.estActif; 
    }
    
    public void estActif(boolean actif) {
		if(actif!=false) this.estActif=false;
		if(actif==true) this.estActif=true;
	}
}