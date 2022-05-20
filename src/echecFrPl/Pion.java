package echecFrPl;
public class Pion extends Piece {
	
	//Plateau grille;

	public Pion(String c, int img) {
		super(c, img);
		this.getCouleur(c);
		//this.setForme("pion");
		this.estActif = true;
		this.value = 1;
	}
		public boolean deplacementValide() {// nouvelles coordonnees 
		
			//grille = new Plateau();
			
			if (indLigneArrive < 8 && indColArrive < 8 && couleur =="blanc") {
				if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -1][indColDepart] ) 
					return true;
			}
			
			if (indLigneArrive < 8 && indColArrive < 8 && couleur == "blanc" && indLigneDepart == 6) {
				if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart -2][indColDepart] ) 
					return true;
			}
			
			if (indLigneArrive < 8 && indColArrive < 8 && couleur == "noir") {
				if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +1][indColDepart]  ) 
					return true;
			}
			if (indLigneArrive < 8 && indColArrive < 8 && couleur == "noir" && indLigneDepart == 1) {
				if( Plateau.grille[indLigneArrive][indColArrive] == Plateau.grille[indLigneDepart +2][indColDepart] ) 
					return true;
			}
			return false;
			}
		
		public boolean peutManger() {
			//grille = new Plateau();
			
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
	}
