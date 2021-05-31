package badminton;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ScoreBoard extends Score
{
	ArrayList<Score>scores = new ArrayList<>();
	
	void addScore(Score score) {
		scores.add(score);
		
		//JOptionPane.showInternalMessageDialog(null, this,"Score="+scorearray, 0);  // to show on terminal
		//JOptionPane.showMessageDialog(scorearray, "Printing complete");
		}
}


