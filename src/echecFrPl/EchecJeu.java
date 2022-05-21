/*
package echecFrPl;
import java.util.Random;

public class EchecJeu {

	public void turn() {
		
	}

	public static boolean commencer() {
		Random r = new Random();
		int tour = r.nextInt(10);
		if(tour % 2 == 0) return true;
		return false;
	}
	

	public void Roque(int LigneRoi, int ColRoi, int LigneTour, int ColTour) {
		int nouvelleLigneRoi = LigneTour;
		int nouvelleColonneRoi = ColTour;
		int nouvelleLigneTour = LigneRoi;
		int nouvelleColonneTour = ColRoi;
		
		if (Piece.forme =="roi") {
			Plateau.grille[nouvelleLigneRoi][nouvelleColonneRoi] = Plateau.grille[LigneRoi][ColRoi];
			//Plateau.getActionPerformed();
		if (Piece.forme == "tour") {
			Plateau.grille[nouvelleLigneTour][nouvelleColonneTour] = Plateau.grille[LigneTour][ColTour];
		}
		}
	}
	
	
	
	public boolean RoiEnEchec(Piece p) {
		Roi r;
			int indLigneDepartRoi = r.indLigneDepart; 
			int indColDepartRoi = r.indColDepart; 
			String couleurRoi;
		
		
		if (p.deplacementValide(p.indLigneDepart, p.indColDepart, p.indLigneArrive, p.indColArrive, p.getCouleur()) ) {
			if (p.indLigneDepart == indLigneDepartRoi) return true;
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		Plateau pl = new Plateau();


		
		pl.init();
		if (commencer()) {
			pl.interf.trunToPlayDisplay.setText("Player 1 you have the White pieces and player 2 you have you have the Black pieces");
		}

		else
			pl.interf.trunToPlayDisplay.setText("Player 1 you have the Black pieces and player 2 you have you have the White pieces");
		
	}
}
*/
