package echecFrPl;

public class Pion extends Piece {
	
	public Pion(String c, int img) {
		super(c, img);
		this.estActif = true;
		this.value = 1;
	}
	
	public boolean deplacementValide() { // nouvelles coordonnees 
		if (!cheminOk()) return false;
		if (Plateau.grille[indLigneArrive][indColArrive] == Plateau.vide) {
			if (Plateau.grille[indLigneDepart][indColDepart].couleur == "noir") {
				if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart) return true;
				if(indLigneDepart == 1 && indLigneArrive == 3 && indColArrive == indColDepart) return true;
			}

			if (Plateau.grille[indLigneDepart][indColDepart].couleur == "blanc") {
				if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart) return true;
				if(indLigneDepart == 6 && indLigneArrive == 4 && indColArrive == indColDepart) return true;
			} 
		}

		// diagonales (pour manger)
		if(Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide) {
			if (Plateau.grille[indLigneDepart][indColDepart].couleur == "blanc") {
				if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart +1) return true;
				if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart -1) return true;
			}
			if (Plateau.grille[indLigneDepart][indColDepart].couleur == "noir") {
				if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart +1) return true;
				if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart -1) return true;
			}
		}
		if (indLigneDepart == indLigneArrive) return false; // le piece n'a pas bouge

		return false;
	}

	public boolean cheminOk() {
		if (Plateau.grille[indLigneArrive][indColArrive].couleur == Plateau.grille[indLigneDepart][indColDepart].couleur) return false;
		
		if (Plateau.grille[indLigneDepart][indColDepart].couleur == "blanc") { 
			//diagonales
			if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart +1) return true;
			if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart -1) return true;

			// tout droit
			if(Plateau.grille[indLigneDepart-1][indColDepart] != Plateau.vide) return false;
			if(indLigneDepart == 6 && indLigneArrive == 4 && indColArrive == indColDepart)
				if(Plateau.grille[indLigneDepart-2][indColDepart] != Plateau.vide) return false;
		}

		if (Plateau.grille[indLigneDepart][indColDepart].couleur == "noir") { 
			//diagonales
			if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart +1) return true;
			if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart -1) return true;

			// tout droit
			if(Plateau.grille[indLigneDepart+1][indColDepart] != Plateau.vide) return false;
			if(indLigneDepart == 1 && indLigneArrive == 3 && indColArrive == indColDepart)
				if(Plateau.grille[indLigneDepart+2][indColDepart] != Plateau.vide) return false;
		}
		return true;
	}
}