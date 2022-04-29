package echecFrPl;

public class Pion extends Piece{
	
	Plateau grille;

	public Pion(String c, int img) {
		super(img);
		this.setCouleur(c);
		this.setForme("pion");
		this.estActif=true;
		this.value = 1;
	}
		public boolean deplacementValide(int indLigneDepart, int indColDepart, int indLigneArrive, int indColArrive, String c) // nouvelles coordonnees 
		{
			grille = new Plateau();
			
			if (indLigneArrive < 8 && indColArrive < 8 && c=="blanc") {
				if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart] ) 
					return true;
			}
			
			if (indLigneArrive < 8 && indColArrive < 8 && c=="blanc" && indLigneDepart == 6) {
				if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -2][indColDepart] ) 
					return true;
			}
			
			if (indLigneArrive < 8 && indColArrive < 8 && c=="noir") {
				if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart]  ) 
					return true;
			}
			if (indLigneArrive < 8 && indColArrive < 8 && c=="noir" && indLigneDepart == 1) {
				if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +2][indColDepart] ) 
					return true;
			}
			return false;
			}
		
		public boolean peutManger(int indLigneDepart, int indColDepart, int indLigneArrive, int indColArrive, String c) {
			grille = new Plateau();
			
			if (indLigneArrive < 8 && indColArrive < 8 && c=="blanc") {
				if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart +1]  ||
						Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart -1] )  
					return true;
			}
			if (indLigneArrive < 8 && indColArrive < 8 && c=="noir") {
				if	(Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart +1]  ||
						Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart -1] )
					return true;
			}
			return false;
		}
	}
