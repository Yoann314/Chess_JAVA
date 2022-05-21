package echecFrPl;


public class Reine extends Piece {
	
	
	public Reine(String c, int img) {
		super(c, img);
		//this.getCouleur(c);
		//this.setForme("reine");
		this.estActif=true;
		this.value = 10;
	}
		public boolean deplacementValide() // nouvelles coordonnees 
		{
			if (!cheminOk()) return false;
			if (indLigneArrive < 8 && indColArrive < 8) {			
				if (indLigneDepart == indLigneArrive && indColDepart == indColArrive) return false; //le piece n'a pas bouge
				if (indLigneDepart == indLigneArrive || indColDepart == indColArrive) return true; //verticale ou horizontale
			}
				//diagonale
				for(int i=0; i<= 8; i++){
		    		if(indLigneDepart+i==indLigneArrive && indColDepart+i==indColArrive)return true;
		    		if(indLigneDepart-i==indLigneArrive && indColDepart-i==indColArrive)return true;
		    		if(indLigneDepart+i==indLigneArrive && indColDepart-i==indColArrive)return true;
		    		if(indLigneDepart-i==indLigneArrive && indColDepart+i==indColArrive)return true; 	
			}
			return false;
			
		}
		public boolean cheminOk() 
		{
			if (Plateau.grille[indLigneArrive][indColArrive] != Plateau.vide && Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur) return false;
			
			// diagonales
			if(indLigneArrive<indLigneDepart && indColArrive<indColDepart){ // vers bas droit
	    		while(indLigneDepart != indLigneArrive+1 && indColDepart != indColArrive+1){
	    			if (Plateau.grille[indLigneArrive+1][indColArrive+1] != Plateau.vide) return false;
	    			
	    			indLigneArrive++;
	    			indColArrive++;
	    		}
	    		return true;
	    	}
	    	if(indLigneArrive>indLigneDepart && indColArrive>indColDepart){ // vers haut gauche
	    		while(indLigneDepart != indLigneArrive-1 && indColDepart != indColArrive-1){
	    			if (Plateau.grille[indLigneArrive-1][indColArrive-1] != Plateau.vide)return false;
	    			
	    			indLigneArrive--;
	    			indColArrive--;
	    		}
	    		return true;
	    	}
	    	if(indLigneArrive<indLigneDepart && indColArrive>indColDepart){ // vers haut droit
	    		while(indLigneDepart != indLigneArrive+1 && indColDepart != indColArrive-1){
	    			if (Plateau.grille[indLigneArrive+1][indColArrive-1] != Plateau.vide)return false;
	    			
	    			indLigneArrive++;
	    			indColArrive--;
	    		}
	    		return true;
	    	}
	    	if(indLigneArrive>indLigneDepart && indColArrive<indColDepart){ // vers bas gauche
	    		while(indLigneDepart != indLigneArrive-1 && indColDepart != indColArrive+1){
	    			if (Plateau.grille[indLigneArrive-1][indColArrive-1] != Plateau.vide)return false;
	    			
	    			indLigneArrive--;
	    			indColArrive++;
	    		}
	    		return true;
	    	}
	    	
	    	// verticales et horizontales
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
	
