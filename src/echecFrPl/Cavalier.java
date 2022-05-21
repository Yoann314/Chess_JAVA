package echecFrPl;

public class Cavalier extends Piece {
	
	public Cavalier(String c, int img) {
		super(c, img);
		//this.getCouleur(c);
		//this.setForme("cavalier");
		this.estActif=true;
		this.value = 3;
	}
	
	public boolean deplacementValide() { // nouvelles coordonnees 
		if (!cheminOk()) return false;
		if (indLigneArrive < 8 && indColArrive < 8) {
			if(indLigneArrive == indLigneDepart -2 && indColArrive == indColDepart+1) return true;
			if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart-2) return true;
			if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart+2) return true;
			if(indLigneArrive == indLigneDepart +2 && indColArrive == indColDepart-1) return true;
			if(indLigneArrive == indLigneDepart +2 && indColArrive == indColDepart+1) return true;
			if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart-2) return true;
			if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart+2) return true;
			if(indLigneArrive == indLigneDepart -2 && indColArrive == indColDepart-1) return true;
			
		}
		return false;
	}

	public boolean cheminOk() {
		if (Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide && Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur) return false;
		
		return true;
	}
}
