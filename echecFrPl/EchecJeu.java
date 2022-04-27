package EchecFrPl;
import java.util.Random;

import javax.swing.JLabel;

public class EchecJeu {


	public void canMouve() {

	}

	public void turn() {
		
	}

	public static boolean begin() {
		Random r = new Random();
		int tour = r.nextInt(10);
		if(tour % 2 == 0) return true;
		return false;
	}



	public static void main(String[] args) {
		Interface interfaceJeu = new Interface(null);
		if (begin()) {
			interfaceJeu.trunToPlayDisplay.setText("Player 1 you have the White pieces and player 2 you have you have the Black pieces");
		}

		else
			interfaceJeu.trunToPlayDisplay.setText("Player 1 you have the Black pieces and player 2 you have you have the White pieces");

	}

}

/*
question : 
	-  comment relier la grille et le JButton
*/
