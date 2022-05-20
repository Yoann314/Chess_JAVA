package echecFrPl;
public class Roi extends Piece {
	

	public Roi(String c, int img) {
		super(c, img);
		this.getCouleur(c);
		//this.setForme("roi");
		this.estActif=true;
		this.value = -1;
	}
	
	public boolean deplacementValide() // nouvelles coordonnees 
	{
		if (indLigneArrive < 8 && indColArrive < 8) {
			if(indLigneArrive == indLigneDepart +1 && indColArrive == indColDepart) return true;
			if(indLigneArrive == indLigneDepart && indColArrive == indColDepart +1) return true;
			if(indLigneArrive == indLigneDepart +1 &&  indColArrive == indColDepart +1) return true;
			if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart) return true;
			if(indLigneArrive == indLigneDepart && indColArrive == indColDepart -1) return true;
			if(indLigneArrive == indLigneDepart -1 && indColArrive == indColDepart -1)return true;
			if(indLigneArrive == indLigneDepart +1 &&  indColArrive == indColDepart -1) return true;
			if(indLigneArrive == indLigneDepart -1 &&  indColArrive == indColDepart +1) return true;
		}
		if (indLigneDepart == indLigneArrive && indColDepart == indColArrive) return false; //le piece n'a pas bouge
		return false;
		}
		}
