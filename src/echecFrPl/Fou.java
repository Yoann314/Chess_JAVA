package echecFrPl;

public class Fou extends Piece{
	
	
	public Fou(String c, int img) {
		super(c, img);
		this.getCouleur(c);
		//this.setForme("fou");
		this.estActif=true;
		this.value = 3;
	}
	
		/*public boolean deplacementValide() // nouvelles coordonnees 
		{
		int absDiff = Math.abs(indLigneDepart - indLigneArrive);
		int absDiffCol = Math.abs(indColDepart - indColArrive);
		
			if (indLigneArrive < 8 && indColArrive < 8) {		
				if (indLigneArrive == indLigneDepart && indColArrive == indColDepart) return false; //le piece n'a pas bouge
				//diagonale
				if (indLigneArrive == indLigneDepart+absDiff && indColArrive == indColDepart+absDiffCol) return true;
				if (indLigneArrive == indLigneDepart-absDiff && indColArrive == indColDepart-absDiffCol) return true;
				if (indLigneArrive == indLigneDepart+absDiff && indColArrive == indColDepart-absDiffCol) return true;
				if (indLigneArrive == indLigneDepart-absDiff && indColArrive == indColDepart+absDiffCol) return true;
				}
			return false;
			}*/
	public boolean deplacementValide() {
		if (!cheminOk()) return false;
		//diagonale
		for(int i=0; i<= 8; i++){
    		if(indLigneDepart+i==indLigneArrive && indColDepart+i==indColArrive)return true;
    		if(indLigneDepart-i==indLigneArrive && indColDepart-i==indColArrive)return true;
    		if(indLigneDepart+i==indLigneArrive && indColDepart-i==indColArrive)return true;
    		if(indLigneDepart-i==indLigneArrive && indColDepart+i==indColArrive)return true; 	
	}
		return false; }
	
	public boolean cheminOk() 
	{
		if (Plateau.grille[indLigneArrive][indColArrive] != null && Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur) return false;
		
		if(indLigneArrive<indLigneDepart && indColArrive<indColDepart){ // vers bas droit
    		while(indLigneDepart != indLigneArrive+1 && indColDepart != indColArrive+1){
    			if (Plateau.grille[indLigneArrive+1][indColArrive+1] != null) return false;
    			
    			indLigneArrive++;
    			indColArrive++;
    		}
    		return true;
    	}
    	if(indLigneArrive>indLigneDepart && indColArrive>indColDepart){ // vers haut gauche
    		while(indLigneDepart != indLigneArrive-1 && indColDepart != indColArrive-1){
    			if (Plateau.grille[indLigneArrive-1][indColArrive-1] != null)return false;
    			
    			indLigneArrive--;
    			indColArrive--;
    		}
    		return true;
    	}
    	if(indLigneArrive<indLigneDepart && indColArrive>indColDepart){ // vers haut droit
    		while(indLigneDepart != indLigneArrive+1 && indColDepart != indColArrive-1){
    			if (Plateau.grille[indLigneArrive+1][indColArrive-1] != null)return false;
    			
    			indLigneArrive++;
    			indColArrive--;
    		}
    		return true;
    	}
    	if(indLigneArrive>indLigneDepart && indColArrive<indColDepart){ // vers bas gauche
    		while(indLigneDepart != indLigneArrive-1 && indColDepart != indColArrive+1){
    			if (Plateau.grille[indLigneArrive-1][indColArrive-1] != null)return false;
    			
    			indLigneArrive--;
    			indColArrive++;
    		}
    		return true;
    	}
    	
        return true;
        
	}
	/*public boolean cheminOk() 
	{
		if (Plateau.grille[indLigneArrive][indColArrive] != null && Plateau.grille[indLigneArrive][indColArrive].couleur == this.couleur) return false;
		
		if (indLigneDepart < indLigneArrive && indColDepart < indColArrive) {	// vers bas droite
			for (int i = indLigneDepart+1; i < indLigneArrive; i++) {
				for (int j = indColDepart+1; j < indColArrive; j++) {
					if(Plateau.grille[i][j] != null) return false;
					}
				} 
			}
		if (indLigneDepart > indLigneArrive && indColDepart > indColArrive) {	// vers haut gauche
			for (int i = indLigneDepart-1; i > indLigneArrive; i--) {
				for (int j = indColDepart-1; j > indColArrive; j--) {
					if(Plateau.grille[i][j] != null) return false;
					}
				} 
			}
		if (indLigneDepart < indLigneArrive && indColDepart > indColArrive) {	// vers bas gauche
			for (int i = indLigneDepart+1; i < indLigneArrive; i++) {
				for (int j = indColDepart-1; j > indColArrive; j--) {
					if(Plateau.grille[i][j] != null) return false;
					}
				} 
			}
		if (indLigneDepart > indLigneArrive && indColDepart < indColArrive) {	// vers haut droite
			for (int i = indLigneDepart-1; i > indLigneArrive; i--) {
				for (int j = indColDepart+1; j < indColArrive; j++) {
					if(Plateau.grille[i][j] != null) return false;
					}
				} 
			}
		return true;
	}*/
}
	
