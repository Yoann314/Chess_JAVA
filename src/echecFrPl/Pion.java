package echecFrPl;

public class Pion extends Piece {
	
	public Pion(String c, int img) {
		super(c, img);
		this.estActif=true;
		this.value = 1;
	}
	
	public boolean deplacementValide() { // nouvelles coordonnees 
		if (!cheminOk()) return false;
		if (indLigneArrive < 8 && indColArrive < 8 && Plateau.grille[indLigneArrive][indColArrive] == Plateau.vide) {
			if (Plateau.grille[indLigneDepart][indColDepart].couleur == "noir") {
				if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart) return true;
				if(indLigneDepart == 1 && indLigneArrive == 3 && indColArrive == indColDepart) return true;
			}

			if (Plateau.grille[indLigneDepart][indColDepart].couleur == "blanc") {
				if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart) return true;
				if(indLigneDepart == 6 && indLigneArrive == 4 && indColArrive == indColDepart) return true;
			}

			// diagonales (pour manger)
			if(Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide){
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
		}
		return false;
	}

	public boolean cheminOk() {
		if (Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur && Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide) return false;

		if (indLigneDepart > indLigneArrive) { //blancs
			if(Plateau.grille[indLigneDepart-1][indColDepart] != Plateau.vide) return false;
			if(Plateau.grille[indLigneDepart-2][indColDepart] != Plateau.vide) return false;
			//diagonales
				//if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart +1) return true;
				//if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart -1) return true;
		}

		if (indLigneDepart < indLigneArrive) { //noirs
			if(Plateau.grille[indLigneDepart+1][indColDepart] != Plateau.vide) return false;
			if(Plateau.grille[indLigneDepart+2][indColDepart] != Plateau.vide) return false;
			//diagonales
				//if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart +1) return true;
				//if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart -1) return true;
		}
		return true;
	}

	/* 
	public boolean peutManger() {
		if (indLigneArrive < 8 && indColArrive < 8 && couleur.equals("blanc")) {
			if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart +1]  ||
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart -1] )  
				return true;
		}
		if (indLigneArrive < 8 && indColArrive < 8 && couleur.equals("noir")) {
			if	(Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart +1]  ||
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart -1] )
				return true;
		}
		return false;
	}

	
	public boolean deplacementValide() { // nouvelles coordonnees 
		if (indLigneArrive < 8 && indColArrive < 8) {
			if(Plateau.grille[indLigneDepart][indColDepart].couleur == "noir") { 
				if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart) return true;
				if(indLigneDepart == 1 && indLigneArrive == indLigneDepart +2 && indColArrive == indColDepart) return true;
			}
			if(Plateau.grille[indLigneDepart][indColDepart].couleur == "blanc") { 
				if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart) return true;
				if(indLigneDepart == 6 && indLigneArrive == indLigneDepart -2 && indColArrive == indColDepart) return true;
			}
			if (indLigneDepart == indLigneArrive) return false; //le piece n'a pas bouge
		}
		return false;
	}
	*/
}