package echecFrPl;

public class Cavalier extends Piece {
	

	public Cavalier(String c, int img) {
		super(c, img);
		this.getCouleur(c);
		//this.setForme("cavalier");
		this.estActif=true;
		this.value = 3;
	}
	public boolean deplacementValide() // nouvelles coordonnees 
	{
		
		if (indLigneArrive < 8 && indColArrive < 8) {
			if(		Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -2][indColDepart +1]) return true;
			if(		Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart -2]) return true;
			if(		Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart +2]) return true;
			if(		Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +2][indColDepart -1]) return true;
			if(		Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +2][indColDepart +1]) return true;
			if(		Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart -2]) return true;
			if(		Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart +2]) return true;
			if(		Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -2][indColDepart -1]) return true;
		}
		return false;
		}

}
