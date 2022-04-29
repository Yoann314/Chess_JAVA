package echecFrPl;

public class Fou extends Piece{
	
	
	public Fou(String c, int img) {
		super(img);
		this.setCouleur(c);
		this.setForme("fou");
		this.estActif=true;
		this.value = 3;
	}
		public boolean deplacementValide(int indLigneDepart, int indColDepart, int indLigneArrive, int indColArrive, String c) // nouvelles coordonnees 
		{
			if (indLigneArrive < 8 && indColArrive < 8) {		
				if (indLigneArrive == indLigneDepart && indColArrive == indColDepart) return false; //le piece n'a pas bouge
				
				//diagonale
				int absDiff = Math.abs(indLigneDepart - indLigneArrive);
				if (indLigneArrive == (indLigneDepart+absDiff) && indColArrive == (indColDepart+absDiff)) return true;
				if (indLigneArrive == (indLigneDepart-absDiff) && indColArrive == (indColDepart-absDiff)) return true;
				
				}
			return false;
			}
		}
	
