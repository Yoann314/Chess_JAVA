package echecFrPl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chronometre implements ActionListener{
	
	JPanel frame = new JPanel();
	JButton startButton = new JButton("START/STOP");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 600000;
	int seconds = 0;
	int minutes = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds); // pour avoir le format 00, 01, 02, 03 ...
	String minutes_string = String.format("%02d", minutes); // pour avoir le format 00, 01, 02, 03 ...
	
	Timer timer = new Timer(1000,new ActionListener() { // chaque 1000 miliseconds (donc 1 seconde) on va inceremter le temps
		
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime -=1000;
			minutes = (elapsedTime/60000);
			seconds = (elapsedTime/1000) %60 ; //modulo 60, pour ne pas avoir 61 secondes...
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			timeLabel.setText(minutes_string +" : "+seconds_string);
		}
	});

	
	Chronometre(){
		
		timeLabel.setText(minutes_string +" : "+seconds_string);
		timeLabel.setBounds(50,15,120,50);
		timeLabel.setFont(new Font("Courier New", Font.PLAIN, 18));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton.setBounds(50, 70, 120, 20);
		startButton.setFont(new Font("Courier New", Font.PLAIN, 13));
		startButton.setBackground(Color.GREEN);
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		
		
		frame.add(startButton);
		frame.add(timeLabel);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(230,150);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==startButton) {
			start();
			if (started==false) {
				started=true;
				start();
			}
			else {
				started=false;
				stop();
			}
		}
		
	}

	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}

	public JPanel getViewTime(){
		return this.frame;
	}
	
	//public static void main(String[] args) {
	//	Chronometre chronometre = new Chronometre();}

}
