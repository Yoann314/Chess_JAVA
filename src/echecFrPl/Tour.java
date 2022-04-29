package echecFrPl;
public class Tour extends Piece {
	
	
	public Tour(String c, int img) {
		super(img);
		this.getCouleur();
		//this.setForme("tour");
		this.estActif=true;
		this.value = 5;
	}
		public boolean deplacementValide() // nouvelles coordonnees 
		{
			if (indLigneArrive < 8 && indColArrive < 8) {		
				if (indLigneDepart == indLigneArrive && indColDepart == indColArrive) return false; //le piece n'a pas bouge
				if (indLigneDepart == indLigneArrive || indColDepart == indColArrive) return true; //verticale ou horizontale
				}
			return false;
			}
		}
	
