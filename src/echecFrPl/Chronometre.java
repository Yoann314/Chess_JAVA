package echecFrPl;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Chronometre implements ActionListener{
	Plateau plateau;
	JPanel frame = new JPanel();
	JButton startButtonB = new JButton("START BLANCS");
	JButton startButtonN = new JButton("START NOIRS");
	JLabel timeLabelB = new JLabel();
	JLabel timeLabelN = new JLabel();
	int elapsedTimeB = 600000;
	int secondsB = 0;
	int minutesB = 0;
	int elapsedTimeN = 600000;
	int secondsN = 0;
	int minutesN = 0;
	boolean startedB = false;
	boolean startedN = false;
	String seconds_stringB = String.format("%02d", secondsB); // pour avoir le format 00, 01, 02, 03 ...
	String minutes_stringB = String.format("%02d", minutesB); // pour avoir le format 00, 01, 02, 03 ...
	String seconds_stringN = String.format("%02d", secondsN); // pour avoir le format 00, 01, 02, 03 ...
	String minutes_stringN = String.format("%02d", minutesN); // pour avoir le format 00, 01, 02, 03 ...
	
	ActionListener actionListenerB = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elapsedTimeB -=1000;
				minutesB = (elapsedTimeB/60000);
				secondsB = (elapsedTimeB/1000) %60 ; //modulo 60, pour ne pas avoir 61 secondes...
				seconds_stringB = String.format("%02d", secondsB);
				minutes_stringB = String.format("%02d", minutesB);
				timeLabelB.setText(minutes_stringB +" : "+seconds_stringB);
		}};
	
	Timer timerB = new Timer(1000,actionListenerB);
	
	ActionListener actionListenerN = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elapsedTimeN -=1000;
				minutesN = (elapsedTimeN/60000);
				secondsN = (elapsedTimeN/1000) %60 ; //modulo 60, pour ne pas avoir 61 secondes...
				seconds_stringN = String.format("%02d", secondsN);
				minutes_stringN = String.format("%02d", minutesN);
				timeLabelN.setText(minutes_stringN +" : "+seconds_stringN);
	}};

	Timer timerN = new Timer(1000,actionListenerN);
	
	Chronometre() {
		timeLabelB.setText(minutes_stringB +" : "+seconds_stringB);
		timeLabelB.setBounds(25,15,100,50);
		timeLabelB.setFont(new Font("Courier New", Font.PLAIN, 20));
		timeLabelB.setBorder(BorderFactory.createBevelBorder(1));
		timeLabelB.setOpaque(true);
		timeLabelB.setHorizontalAlignment(JTextField.CENTER);
		
		timeLabelN.setText(minutes_stringN +" : "+seconds_stringN);
		timeLabelN.setBounds(145,15,100,50);
		timeLabelN.setFont(new Font("Courier New", Font.PLAIN, 20));
		timeLabelN.setBorder(BorderFactory.createBevelBorder(1));
		timeLabelN.setOpaque(true);
		timeLabelN.setHorizontalAlignment(JTextField.CENTER);
		 
		startButtonB.setBounds(25, 70, 100, 25);
		startButtonB.setFont(new Font("Courier New", Font.PLAIN, 10));
		startButtonB.setBackground(Color.GREEN);
		startButtonB.setFocusable(false);
		startButtonB.addActionListener(this);
		
		startButtonN.setBounds(145, 70, 100, 25);
		startButtonN.setFont(new Font("Courier New", Font.PLAIN, 10));
		startButtonN.setBackground(Color.GREEN);
		startButtonN.setFocusable(false);
		startButtonN.addActionListener(this);
			
		frame.add(startButtonB);
		frame.add(startButtonN);
		frame.add(timeLabelB);
		frame.add(timeLabelN);
		frame.setSize(300,150);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==startButtonN) {
			stopB();
			startN();
			if (startedN==false && startedB==true) {
				startedN=true;
				startedB=false;
				startN();
				stopB();
			}
			if (startedN==false && startedB==false) {
				startedN=true;
				startN();
			}
		}
		
		if (e.getSource()==startButtonB) {
			stopN();
			startB();
			if (startedB==false && startedN==true) {
				startedB=true;
				startedN=false;
				startB();
				stopN();
			}
			if (startedB==false && startedN==false) {
				startedB=true;
				startB();
			}
		}	
	}

	void startB() {
		timerB.start();
	}
	
	void startN() {
		timerN.start();
	}
	
	void stopB() {
		timerB.stop();
	}
	
	void stopN() {
		timerN.stop();
	}

	public JPanel getViewTime(){
		return this.frame;
	}
}