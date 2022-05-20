package echecFrPl;

import java.awt.*;
import javax.swing.*;

public class Interface {

	//public JLabel trunToPlayDisplay;
	public JFrame fenetre;

	public JPanel panneau, scoreStart, scoreEnd, contScoreNoir, contScoreBlanc, cimetiereNoir, cimetiereBlanc, interfaceComplete; // cont pour contenant
	public JLabel scoreNoir, scoreBlanc;

	public MonBouton[][] bouton;

    public Interface(Plateau plateau) {
        fenetre = new JFrame("Chess.fr.pl"); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Plateau avec tout les bouttons
		panneau = new JPanel(new GridLayout(8,8));
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

		// Score + Cimetière
		scoreStart = new JPanel();
		scoreEnd = new JPanel();

		contScoreNoir = new JPanel(new GridLayout(2,1));
		cimetiereNoir = new JPanel(new GridLayout(2,8));

		contScoreBlanc = new JPanel(new GridLayout(2,1));
		cimetiereBlanc = new JPanel(new GridLayout(2,8));

		scoreNoir = new JLabel("Score des Noirs : ", JLabel.LEFT);
		scoreBlanc = new JLabel("Score des Blancs : ", JLabel.LEFT);

		contScoreNoir.add(cimetiereNoir);
		contScoreNoir.add(scoreNoir);

		contScoreBlanc.add(cimetiereBlanc);
		contScoreBlanc.add(scoreBlanc);

		scoreStart.add(contScoreNoir);
		scoreEnd.add(contScoreBlanc);

		// Concatenation de toutes les différentes partie de l'interface
		interfaceComplete = new JPanel(new BorderLayout());
		interfaceComplete.add(panneau, BorderLayout.CENTER);
		interfaceComplete.add(scoreStart, BorderLayout.PAGE_START);
		interfaceComplete.add(scoreEnd, BorderLayout.PAGE_END);


		fenetre.add(interfaceComplete);
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
	}
}
