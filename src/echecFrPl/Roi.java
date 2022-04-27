package echecFrPl;

public class Roi extends Piece {
	
	Plateau grille;

	public Roi(String c, int img) {
		super(img);
		this.setCouleur(c);
		this.estActif=true;
		this.value = -1;
	}
		public boolean deplacementValide(int indLigneDepart, int indColDepart, int indLigneArrive, int indColArrive) // nouvelles coordonnees 
		{
			grille = new Plateau();
			if (indLigneArrive < 8 && indColArrive < 8) {
				if(Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart] ||
						Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart][indColDepart+1] ||
						Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart+1][indColDepart+1] ||
						Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart] ||
						Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart][indColDepart-1] ||
						Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart-1][indColDepart-1] ||
						Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart+1][indColDepart-1] ||
						Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart-1][indColDepart+1] )
					return true;
			}
			if (indLigneDepart == indLigneArrive && indColDepart == indColArrive) return false; //le piece n'a pas bouge
			return false;
			}
		
		}