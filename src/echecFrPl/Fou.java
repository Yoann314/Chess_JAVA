package echecFrPl;

public class Fou extends Piece{
	
	public Fou(String c, int img) {
		super(c, img);
		this.estActif=true;
		this.value = 3;
	}

	public boolean deplacementValide() {
		if (!cheminOk()) return false;
		//diagonale
		for(int i=0; i<9; i++){
    		if(indLigneDepart+i==indLigneArrive && indColDepart+i==indColArrive)return true;
    		if(indLigneDepart-i==indLigneArrive && indColDepart-i==indColArrive)return true;
    		if(indLigneDepart+i==indLigneArrive && indColDepart-i==indColArrive)return true;
    		if(indLigneDepart-i==indLigneArrive && indColDepart+i==indColArrive)return true; 	
		}
		return false; 
	}
	
	public boolean cheminOk() {
		if (Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide && Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur) return false;
		
		if(indLigneArrive<indLigneDepart && indColArrive<indColDepart) { // vers haut gauche
    		while(indLigneDepart != indLigneArrive+1 && indColDepart != indColArrive+1) {
    			if (Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide
					&& Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur) return false;
    			indLigneArrive++;
    			indColArrive++;
    		}
    		return true;
    	}

    	if(indLigneArrive>indLigneDepart && indColArrive>indColDepart) { // vers bas droit
    		while(indLigneDepart != indLigneArrive-1 && indColDepart != indColArrive-1) {
    			if (Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide
					&& Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur)return false;
    			indLigneArrive--;
    			indColArrive--;
    		}
    		return true;
    	}

    	if(indLigneArrive<indLigneDepart && indColArrive>indColDepart) { // vers haut droit
    		while(indLigneDepart != indLigneArrive+1 && indColDepart != indColArrive-1) {
    			if (Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide
					&& Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur)return false;
    			indLigneArrive++;
    			indColArrive--;
    		}
    		return true;
    	}

    	if(indLigneArrive>indLigneDepart && indColArrive<indColDepart) { // vers bas gauche
    		while(indLigneDepart != indLigneArrive-1 && indColDepart != indColArrive+1) {
    			if (Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide
					&& Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur)return false;
    			indLigneArrive--;
    			indColArrive++;
    		}
    		return true;
    	}
        return true;
	}
}