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
				
				//diagonale
				int absDiff = Math.abs(indLigneDepart - indLigneArrive);
				int absDiffCol = Math.abs(indColDepart - indColArrive);
				if (indLigneArrive == (indLigneDepart+absDiff) && indColArrive == (indColDepart+absDiffCol)) return true;
				if (indLigneArrive == (indLigneDepart-absDiff) && indColArrive == (indColDepart-absDiffCol)) return true;
				if (indLigneArrive == (indLigneDepart+absDiff) && indColArrive == (indColDepart-absDiffCol)) return true;
				if (indLigneArrive == (indLigneDepart-absDiff) && indColArrive == (indColDepart+absDiffCol)) return true;
				}
			return false;
			}
		}
	
