package echecFrPl;

import java.awt.*;
import javax.swing.*;

public class Interface {

	public JFrame fenetre, fenetreSTART;
	public JPanel panneau, scoreStart, scoreEnd, contScoreNoir, contScoreBlanc , interfaceComplete, sidePanel, cimetiereNoir, cimetiereBlanc; // cont pour contenant
	public JLabel scoreNoir, scoreBlanc;
	public MonBouton[][] bouton;
	public JButton boutonJouer;
	Plateau plateau;
	private Chronometre chronometre;
	public int intscoreBlanc = 0, intscoreNoir = 0;
	//Component chronometre;

    public Interface(Plateau plateau) {
		this.plateau = plateau;
        fenetre = new JFrame("Chess.fr.pl"); 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Plateau avec tout les bouttons
		panneau = new JPanel(new GridLayout(8,8));
		bouton = new MonBouton[8][8]; // Creation de plateau
		for (int i = 0; i < bouton.length; i++) {
			for (int j = 0; j < bouton[i].length; j++) {
				if(Plateau.grille[i][j] != plateau.vide)
					bouton[i][j] = new MonBouton(Plateau.grille[i][j].getTheImage());
				
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
		
		// fenetreSTART
		fenetreSTART = new JFrame("Echec");
		fenetreSTART.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ImageIcon img = new ImageIcon("src/imagesOld/echec.png");
		Image image = img.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
		JLabel labelImage = new JLabel(new ImageIcon(image));
		
		JLabel message = new JLabel(" Aux armes! Les Blancs commencent ");
		JLabel retourALaLigne = new JLabel("                                  ");

		
		JPanel panneauCentral = new JPanel(new GridLayout(2,1));
		panneauCentral.add(message);
		panneauCentral.add(retourALaLigne);
		
		
		fenetreSTART.setLayout(new BorderLayout());
		fenetreSTART.add(labelImage, BorderLayout.PAGE_START);
		fenetreSTART.add(panneauCentral, BorderLayout.CENTER);
		fenetreSTART.setLocation(200, 150);
		fenetreSTART.pack(); // pour une dimension optimale de la fenetre
		fenetreSTART.setVisible(true);
	


		// Score + Cimetière
		cimetiereNoir = new JPanel(new GridLayout(2,8));
		cimetiereBlanc = new JPanel(new GridLayout(2,8));

		scoreStart = new JPanel();
		scoreEnd = new JPanel();

		//ImageIcon imgCim = new ImageIcon("images/cimitiere.png");
		//Image imageCim = imgCim.getImage().getScaledInstance(50, 50,Image.SCALE_DEFAULT);
		//JLabel imageC = new JLabel(new ImageIcon(imageCim));
		//JLabel imageC = new JLabel();
		//imageC.setIcon(imgCim);

		contScoreNoir = new JPanel(new GridLayout(2,1));
		//cimetiereNoir = new JPanel(new GridLayout(2,8));
		//for (int i=0; i<16; i++ ){
		//	cimetiereNoir.add(imageC);}
		

		contScoreBlanc = new JPanel(new GridLayout(2,1));
		//cimetiereBlanc = new JPanel(new GridLayout(2,8));
		//for (int i=0; i<16; i++ ){
		//	cimetiereBlanc.add(imageC);}

		scoreNoir = new JLabel("Score des Noirs : " + plateau.intscoreNoir, JLabel.LEFT);
		scoreBlanc = new JLabel("Score des Blancs : "+ plateau.intscoreBlanc, JLabel.LEFT);

		contScoreNoir.add(cimetiereNoir);
		contScoreNoir.add(scoreNoir);

		contScoreBlanc.add(scoreBlanc);
		contScoreBlanc.add(cimetiereBlanc);
		
		scoreStart.add(contScoreNoir);
		scoreEnd.add(contScoreBlanc);
	    
		// chronometre + messages
		
			sidePanel = new JPanel(new GridLayout(3,1));
			chronometre=new Chronometre();
			//JPanel chronoNoir = chronometre.getViewTime();

			JLabel messageNoir = new JLabel("_______________________________________");
			JLabel messageBlanc = new JLabel("_______________________________________");
			
			chronometre=new Chronometre();
			JPanel chrono = chronometre.getViewTime();
			
			sidePanel.add(messageNoir);
			sidePanel.add(chrono);
			sidePanel.add(messageBlanc);
	
			// Concatenation de toutes les différentes partie de l'interface
			interfaceComplete = new JPanel(new BorderLayout());
			interfaceComplete.add(panneau, BorderLayout.CENTER);
			interfaceComplete.add(sidePanel, BorderLayout.EAST);
			interfaceComplete.add(scoreStart, BorderLayout.PAGE_START);
			interfaceComplete.add(scoreEnd, BorderLayout.PAGE_END);
			
			
			
			fenetreSTART.pack();
			fenetreSTART.setLocationRelativeTo(null);
			
			fenetre.add(interfaceComplete);
			fenetre.pack();
			fenetre.setLocationRelativeTo(null);

		for (int i = 0; i < 8; i++) { // désactive toutes les cases noir et vide pour le premier coup
			for (int j = 0; j < 8; j++) {					
				if (Plateau.grille[i][j].getCouleur() == "noir" || Plateau.grille[i][j] == plateau.vide) {
					bouton[i][j].setEnabled(false);
				}

				if (Plateau.grille[i][j].getCouleur() == "blanc") {
					bouton[i][j].setEnabled(true);
				}
			}
		}
	}

	public void activeCasesForBlanc() { // active les JButton "blanc" et désactive les autres
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {					
				if (Plateau.grille[i][j].getCouleur() == "blanc") {
					bouton[i][j].setEnabled(false);
				}

				if (Plateau.grille[i][j].getCouleur() == "noir" || Plateau.grille[i][j] == plateau.vide) {
					bouton[i][j].setEnabled(true);
				}
			}
		}
	}

	public void activeCasesForNoir() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (Plateau.grille[i][j].getCouleur() == "noir") {
					bouton[i][j].setEnabled(false);
				}

				if (Plateau.grille[i][j].getCouleur() == "blanc" || Plateau.grille[i][j] == plateau.vide) {
					bouton[i][j].setEnabled(true);
				}
			}
		}
	}

	public void activeCasesBlanc() { // active les JButton "blanc" et désactive les autres
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {					
				if (Plateau.grille[i][j].getCouleur() == "blanc") {
					bouton[i][j].setEnabled(true);
				}

				if (Plateau.grille[i][j].getCouleur() == "noir" || Plateau.grille[i][j] == plateau.vide) {
					bouton[i][j].setEnabled(false);
				}
			}
		}
	}

	public void activeCasesNoir() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (Plateau.grille[i][j].getCouleur() == "noir") {
					bouton[i][j].setEnabled(true);
				}

				if (Plateau.grille[i][j].getCouleur() == "blanc" || Plateau.grille[i][j] == plateau.vide) {
					bouton[i][j].setEnabled(false);
				}
			}
		}
	}
	
	public void ajoutCimtiereNoir(int i, int j) {
		System.out.println("on est dans cimitiere noir avec le piece " +plateau.k);
		ImageIcon imgCim = new ImageIcon("src/images/"+ plateau.k+".png");
		Image imageN = imgCim.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		JLabel imageC = new JLabel(new ImageIcon(imageN));		
		cimetiereNoir.add(imageC);
		System.out.println("value de piece mange "+plateau.val);
		intscoreNoir += plateau.val; // incrémentation du score
		scoreNoir.setText("Score des Noirs : " + intscoreNoir); // update du JLabel
	}

	public void ajoutCimtiereBlanc(int i, int j) {
		System.out.println("one est dans cimitiere blanc avec le piece " +plateau.k);
		ImageIcon imgCim = new ImageIcon("src/images/"+ plateau.k+".png");
		Image imageB = imgCim.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
		JLabel imageC = new JLabel(new ImageIcon(imageB));		
		cimetiereBlanc.add(imageC);
		System.out.println("value de piece mange "+plateau.val);
		cimetiereBlanc.add(imageC);
		intscoreBlanc += plateau.val; // incrémentation du score
		scoreBlanc.setText("Score des Blanc : " + intscoreBlanc); // update du JLabel
	}
	
	public void setIntscoreBlanc(int intscoreBlanc) {
		this.intscoreBlanc = intscoreBlanc;
	}

	public void setIntscoreNoir(int intscoreNoir) {
		this.intscoreNoir = intscoreNoir;
	}
}
