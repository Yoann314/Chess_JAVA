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
		for(int i=0; i<= 8; i++){
    		if(indLigneDepart+i==indLigneArrive && indColDepart+i==indColArrive)
    			return true;
    		if(indLigneDepart-i==indLigneArrive && indColDepart-i==indColArrive)
    			return true;
    		if(indLigneDepart+i==indLigneArrive && indColDepart-i==indColArrive)
    			return true;
    		if(indLigneDepart-i==indLigneArrive && indColDepart+i==indColArrive)
    			return true; 	
	}
		return false; }
}
	
