package echecFrPl;


public class Reine extends Piece {
	
	
	public Reine(String c, int img) {
		super(c, img);
		this.getCouleur(c);
		//this.setForme("reine");
		this.estActif=true;
		this.value = 10;
	}
		public boolean deplacementValide() // nouvelles coordonnees 
		{
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
}
	
