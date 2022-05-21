package echecFrPl;

public class Tour extends Piece {
	
	public Tour(String c, int img) {
		super(c, img);
		this.estActif=true;
		this.value = 5;
	}
	public boolean deplacementValide() { // nouvelles coordonnees 
		if (!cheminOk()) return false;
		if (indLigneArrive < 8 && indColArrive < 8) {		
			if (indLigneDepart == indLigneArrive && indColDepart == indColArrive) return false; //le piece n'a pas bouge
			if (indLigneDepart == indLigneArrive || indColDepart == indColArrive) return true; //verticale ou horizontale
		}
		return false;
	}
	
	public boolean cheminOk() {
		if (Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide && Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur) return false;
		
		if (indLigneDepart != indLigneArrive && indColDepart == indColArrive) { //bouge sur les horizontales
			if (indLigneDepart < indLigneArrive) {	// de haut en bas du plateau
				for (int i = indLigneDepart+1; i < indLigneArrive; i++) {
					if(Plateau.grille[i][indColArrive] != Plateau.vide) return false;
				}
			}
			
			if (indLigneDepart > indLigneArrive) { // de bas en haut du plateau
				for (int i = indLigneDepart-1; i > indLigneArrive; i--) {
					if(Plateau.grille[i][indColArrive] != Plateau.vide) return false;
				}
			}
		}

		if (indLigneDepart == indLigneArrive && indColDepart != indColArrive) { //bouge sur les verticales
			if (indColDepart < indColArrive) {	// de gauche a droite du plateau
				for (int i = indColDepart +1; i < indColArrive; i++) {
					if(Plateau.grille[indLigneDepart][i] != Plateau.vide) return false;
				}
			}

			if (indColDepart > indColArrive) {	// de droite a gauche du plateau
				for (int i = indColDepart -1; i > indColArrive; i--) {
					if(Plateau.grille[indLigneDepart][i] != Plateau.vide) return false;
				}
			}
		}
		return true;
	}
}
	
