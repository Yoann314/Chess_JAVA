package EchecFrPl;

import java.awt.*;

public class Interface {

    JButton[][] boutons;

    public Interface(ActionListener listener){
        JFrame fenetre = new JFrame("Chess.fr.pl"); 
		fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fenetre.setLayout(new BorderLayout());
		
		JPanel panneau = new JPanel(new GridLayout(8,8));
		
        /*
		// BOUTON X O
		ImageIcon imgX = new ImageIcon("X.png");
		Image imageX = imgX.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		JButton boutonImageX = new JButton(new ImageIcon(imageX));
		
		ImageIcon imgO = new ImageIcon("Y.jpg");
		Image imageO = imgO.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		JButton boutonImageO = new JButton(new ImageIcon(imageO));
        */

        boutons = new JButton[8][8]; // Creation de tableau
        for (int i = 0; i < boutons.length; i++) {
            for (int j = 0; j < boutons[i].length; j++) {
                boutons[i][j] = new JButton();
                //boutons[i][j].setIcon(new ImageIcon(boutonImageX));
				boutons[i][j].addActionListener(listener);
				boutons[i][j].setActionCommand(String.valueOf(i)+"-"+String.valueOf(j));
                boutons[i][j].setPreferredSize(new Dimension(50,50));
                panneau.add(boutons[i][j]);

            }
        } 

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
