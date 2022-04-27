package EchecFrPl;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Interface {

    public JButton[][] bouton;
	// private Timer t;
	public JLabel trunToPlayDisplay;

    public Interface(ActionListener listener) {
        JFrame fenetre = new JFrame("Chess.fr.pl"); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panneau = new JPanel(new GridLayout(8,8));
		
		bouton = new JButton[8][8]; // Creation de plateau
		for (int i = 0; i < bouton.length; i++) {
			for (int j = 0; j < bouton[i].length; j++) {
				bouton[i][j] = new MonBouton();
				bouton[i][j].addActionListener(listener);
				bouton[i][j].setActionCommand(String.valueOf(i)+"-"+String.valueOf(j));
				bouton[i][j].setPreferredSize(new Dimension(80,80));

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

		/*
		Tour rrr = new Tour("blanc",0,0,1);
		bouton[1][1].add(Piece(1));
		panneau.add(bouton[1][1]);
		*/


		/*
		// BOUTON X O
		int k = 1;

		bouton = new JButton[8][8]; // Creation de plateau
		for (int i = 0; i < bouton.length; i++) {
			for (int j = 0; j < bouton[i].length; j++) {
				if (i < 2) {
					ImageIcon imgX = new ImageIcon("src/images/"+k+".png"); k++;
					Image imageX = imgX.getImage().getScaledInstance(50, -1,Image.SCALE_DEFAULT);
					bouton[i][j] = new MonBouton(imageX);
					bouton[i][j].addActionListener(listener);
					bouton[i][j].setActionCommand(String.valueOf(i)+"-"+String.valueOf(j));
					bouton[i][j].setPreferredSize(new Dimension(80,60));
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

				if (i > 1 && i < 6) {
					bouton[i][j] = new MonBouton();
					bouton[i][j].addActionListener(listener);
					bouton[i][j].setActionCommand(String.valueOf(i)+"-"+String.valueOf(j));
					bouton[i][j].setPreferredSize(new Dimension(80,60));
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
				if (i > 5) {
					ImageIcon imgX = new ImageIcon("src/images/"+k+".png"); k++;
					Image imageX = imgX.getImage().getScaledInstance(50, -1,Image.SCALE_DEFAULT);
					bouton[i][j] = new MonBouton(imageX);
					bouton[i][j].addActionListener(listener);
					bouton[i][j].setActionCommand(String.valueOf(i)+"-"+String.valueOf(j));
					bouton[i][j].setPreferredSize(new Dimension(80,60));
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
		}
		//bouton[1][1]

		
        t = new Timer(1000, new ActionListener(){ // Demande un rechargement du plateau pour afficher les images
			// si non les images n'ont pas le temps de charger
			@Override
			public void actionPerformed(ActionEvent e) {
				t.stop();
				fenetre.repaint();
			}
		});
		t.start();
		*/
        
		fenetre.setLayout( new BorderLayout());
		fenetre.add(panneau, BorderLayout.CENTER);
		fenetre.add(trunToPlayDisplay, BorderLayout.PAGE_END);
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
		
	}
	
	
	public void afficherPiece(ImageIcon ii, int indiceLigne, int indiceColonne) {
		bouton[indiceLigne][indiceColonne].setDisabledIcon(ii);
		bouton[indiceLigne][indiceColonne].setEnabled(false);
		bouton[indiceLigne][indiceColonne].setIcon(ii);
    }
	
	
    

    public static void main(String[] args) {
        new Interface(null);
    }
}