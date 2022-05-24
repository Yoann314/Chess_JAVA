package echecFrPl;

public class Roi extends Piece {

	public Roi(String c, int img) {
		super(c, img);
		this.value = -1;
		this.pieceBouge = false;
	}
	
	public boolean deplacementValide() { // nouvelles coordonnees 
		if (!cheminOk()) return false;
		if (indLigneArrive < 8 && indColArrive < 8) {
			if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart) return true;
			if(indLigneArrive == indLigneDepart && indColArrive == indColDepart +1) return true;
			if(indLigneArrive == indLigneDepart +1 &&  indColArrive == indColDepart +1) return true;
			if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart) return true;
			if(indLigneArrive == indLigneDepart && indColArrive == indColDepart -1) return true;
			if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart -1)return true;
			if(indLigneArrive == indLigneDepart +1 &&  indColArrive == indColDepart -1) return true;
			if(indLigneArrive == indLigneDepart -1 &&  indColArrive == indColDepart +1) return true;
		}

		if (indLigneDepart == indLigneArrive && indColDepart == indColArrive) return false; //le piece n'a pas bouge

		return false;
	}
	
	public boolean cheminOk() {
		if (Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide && Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur && Plateau.grille[indLigneArrive][indColArrive].getValue() != 5) return false; 
		return true;
	}
}