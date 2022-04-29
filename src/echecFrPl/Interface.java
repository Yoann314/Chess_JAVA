package echecFrPl;

import java.awt.*;
import javax.swing.*;

public class Interface {

    public MonBouton[][] bouton;
	public JLabel trunToPlayDisplay;
	public JFrame fenetre;

    public Interface(Plateau plateau) {
        fenetre = new JFrame("Chess.fr.pl"); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panneau = new JPanel(new GridLayout(8,8));
		
		bouton = new MonBouton[8][8]; // Creation de plateau
		for (int i = 0; i < bouton.length; i++) {
			for (int j = 0; j < bouton[i].length; j++) {
				if(plateau.grille[i][j] != null)
					bouton[i][j] = new MonBouton(plateau.grille[i][j].getTheImage());
				else
					bouton[i][j] = new MonBouton();
				bouton[i][j].addActionListener(plateau);
				bouton[i][j].setActionCommand(String.valueOf(i)+"-"+String.valueOf(j));
				bouton[i][j].setPreferredSize(new Dimension(100,100));

				if (i % 2 == 0) { // Création du damier noir et blanc
					if (j % 2 == 0)
						bouton[i][j].setBackground(Color.WHITE);
					else
						bouton[i][j].setBackground(Color.BLACK);
				}

				else {
					if (j % 2 == 0)
						bouton[i][j].setBackground(Color.BLACK);
					else
						bouton[i][j].setBackground(Color.WHITE);
				}
				panneau.add(bouton[i][j]);
			}
		}
		trunToPlayDisplay = new JLabel("");
        
		fenetre.setLayout(new BorderLayout());
		fenetre.add(panneau, BorderLayout.CENTER);
		fenetre.add(trunToPlayDisplay, BorderLayout.PAGE_END);
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
	}
	
	
	public void afficherPiece(ImageIcon ii, int indiceLigne, int indiceColonne) {
		bouton[indiceLigne][indiceColonne].setDisabledIcon(ii);
		bouton[indiceLigne][indiceColonne].setEnabled(false);
		bouton[indiceLigne][indiceColonne].setIcon(ii);
    }
}
