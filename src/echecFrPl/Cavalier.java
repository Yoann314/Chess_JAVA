package echecFrPl;

public class Cavalier extends Piece {
	
	Plateau grille;

	public Cavalier(String c, int img) {
		super(img);
		this.setCouleur(c);
		this.setForme("cavalier");
		this.estActif=true;
		this.value = 3;
	}
	public boolean deplacementValide(int indLigneDepart, int indColDepart, int indLigneArrive, int indColArrive, String c) // nouvelles coordonnees 
	{
		grille = new Plateau();
		
		if (indLigneArrive < 8 && indColArrive < 8) {
			if(		Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart -2] || 
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart +2] ||
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +2][indColDepart -1] ||
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +2][indColDepart +1] ||
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart -2] ||
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart +2] ||
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -2][indColDepart -1] ||
					Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -2][indColDepart +1])
				return true;
		}
		if (indLigneDepart == indLigneArrive && indColDepart == indColArrive) return false; //le piece n'a pas bouge
		return false;
		}

}
