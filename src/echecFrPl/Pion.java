package echecFrPl;
public class Pion extends Piece {
	

	public Pion(String c, int img) {
		super(c, img);
		this.getCouleur(c);
		//this.setForme("pion");
		this.estActif=true;
		this.value = 1;
	}
	
	public boolean deplacementValide() // nouvelles coordonnees 
	{
		if (indLigneArrive < 8 && indColArrive < 8) {
			if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart) return true;
			if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart) return true;
			if(indLigneDepart == 1 && indLigneArrive == indLigneDepart +2 && indColArrive == indColDepart) return true;
			if(indLigneDepart == 6 && indLigneArrive == indLigneDepart -2 && indColArrive == indColDepart) return true;
			
		if (indLigneDepart == indLigneArrive) return false; //le piece n'a pas bouge
		}
		return false;
		}

	public boolean peutManger() {
		
		if (indLigneArrive < 8 && indColArrive < 8 && couleur.equals("blanc")) {
			if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart +1]  ||
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart -1] )  
				return true;
		}
		if (indLigneArrive < 8 && indColArrive < 8 && couleur.equals("noir")) {
			if	(Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart +1]  ||
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart -1] )
				return true;
		}
		return false;
	}
	/* public boolean deplacementValide() // nouvelles coordonnees 
	{
		if (indLigneArrive < 8 && indColArrive < 8) {
			if(Plateau.grille[indLigneDepart][indColDepart].couleur == "noir") { 
				if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart) return true;
				if(indLigneDepart == 1 && indLigneArrive == indLigneDepart +2 && indColArrive == indColDepart) return true;
			}
			if(Plateau.grille[indLigneDepart][indColDepart].couleur == "blanc") { 
				if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart) return true;
				if(indLigneDepart == 6 && indLigneArrive == indLigneDepart -2 && indColArrive == indColDepart) return true;
			}
		if (indLigneDepart == indLigneArrive) return false; //le piece n'a pas bouge
		}
		return false;
		}*/
}