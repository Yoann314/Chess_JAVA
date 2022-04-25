package EchecFrPl;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class Interface {

    JButton[][] boutons;
	Timer t;

    public Interface(ActionListener listener) {
        JFrame fenetre = new JFrame("Chess.fr.pl"); 
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		JPanel panneau = new JPanel(new GridLayout(8,8));
		
        
		// BOUTON X O
		int k = 1;

		boutons = new JButton[8][8]; // Creation de plateau
		for (int i = 0; i < boutons.length; i++) {
			for (int j = 0; j < boutons[i].length; j++) {
				if (i < 2) {
					ImageIcon imgX = new ImageIcon("src/images/"+k+".png"); k++;
					Image imageX = imgX.getImage().getScaledInstance(50, -1,Image.SCALE_DEFAULT);
					boutons[i][j] = new MonBouton(imageX);
					boutons[i][j].addActionListener(listener);
					boutons[i][j].setActionCommand(String.valueOf(i)+"-"+String.valueOf(j));
					boutons[i][j].setPreferredSize(new Dimension(80,60));
					if (i % 2 == 0) { // Création du damier noir et blanc
						if (j % 2 == 0)
							boutons[i][j].setBackground(Color.WHITE);
						else
							boutons[i][j].setBackground(Color.BLACK);
					}
					else {
						if (j % 2 == 0)
							boutons[i][j].setBackground(Color.BLACK);
						else
							boutons[i][j].setBackground(Color.WHITE);
					}
					panneau.add(boutons[i][j]);
				}

				if (i > 1 && i < 6) {
					boutons[i][j] = new MonBouton();
					boutons[i][j].addActionListener(listener);
					boutons[i][j].setActionCommand(String.valueOf(i)+"-"+String.valueOf(j));
					boutons[i][j].setPreferredSize(new Dimension(80,60));
					if (i % 2 == 0) { // Création du damier noir et blanc
						if (j % 2 == 0)
							boutons[i][j].setBackground(Color.WHITE);
						else
							boutons[i][j].setBackground(Color.BLACK);
					}
					else {
						if (j % 2 == 0)
							boutons[i][j].setBackground(Color.BLACK);
						else
							boutons[i][j].setBackground(Color.WHITE);
					}
					panneau.add(boutons[i][j]);
				}
				if (i > 5) {
					ImageIcon imgX = new ImageIcon("src/images/"+k+".png"); k++;
					Image imageX = imgX.getImage().getScaledInstance(50, -1,Image.SCALE_DEFAULT);
					boutons[i][j] = new MonBouton(imageX);
					boutons[i][j].addActionListener(listener);
					boutons[i][j].setActionCommand(String.valueOf(i)+"-"+String.valueOf(j));
					boutons[i][j].setPreferredSize(new Dimension(80,60));
					if (i % 2 == 0) { // Création du damier noir et blanc
						if (j % 2 == 0)
							boutons[i][j].setBackground(Color.WHITE);
						else
							boutons[i][j].setBackground(Color.BLACK);
					}
					else {
						if (j % 2 == 0)
							boutons[i][j].setBackground(Color.BLACK);
						else
							boutons[i][j].setBackground(Color.WHITE);
					}
					panneau.add(boutons[i][j]);
				}	
			}
		}
		//boutons[1][1]

		
        t = new Timer(1000, new ActionListener(){ // Demande un rechargement du plateau pour afficher les images
			// si non les images n'ont pas le temps de charger
			@Override
			public void actionPerformed(ActionEvent e) {
				t.stop();
				fenetre.repaint();
			}
		});
		t.start();


        fenetre.add(panneau, BorderLayout.CENTER);
		fenetre.pack();
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
		
	}
	
    /*
	public void afficherPiece(ImageIcon ii, int indiceLigne, int indiceColonne) {
		boutons[indiceLigne][indiceColonne].setDisabledIcon(ii);
		boutons[indiceLigne][indiceColonne].setEnabled(false);
		boutons[indiceLigne][indiceColonne].setIcon(ii);
    }
	*/
    

    public static void main(String[] args) {
        new Interface(null);
    }
}