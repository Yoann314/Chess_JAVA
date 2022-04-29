package echecFrPl;


public class Reine extends Piece {
	
	
	public Reine(String c, int img) {
		super(img);
		this.setCouleur(c);
		this.setForme("reine");
		this.estActif=true;
		this.value = 10;
	}
		public boolean deplacementValide(int indLigneDepart, int indColDepart, int indLigneArrive, int indColArrive, String c) // nouvelles coordonnees 
		{
			if (indLigneArrive < 8 && indColArrive < 8) {		
				
				//diagonale
				int absDiff = Math.abs(indLigneDepart - indLigneArrive);
				if (indLigneArrive == (indLigneDepart+absDiff) && indColArrive == (indColDepart+absDiff)) return true;
				if (indLigneArrive == (indLigneDepart-absDiff) && indColArrive == (indColDepart-absDiff)) return true;
				
				if (indLigneArrive == indLigneDepart && indColArrive == indColDepart) return false; //le piece n'a pas bouge
	
				if (indLigneArrive == indLigneDepart || indColArrive == indColDepart) return true; //verticale ou horizontale
				
				}
			return false;
			}
		}
	
