package badminton;

import javax.swing.JOptionPane;


public class Score {
	
	
	//-------------------------------------------------------------------------------------
	int teamAScore;
	int teamBScore;
	int countarr=0;
	String[] scorearray = new String[50];
	
	boolean incrementScore(String team) {
		if("A".equals(team)) {
			teamAScore++;
			Tracker tr=new Tracker(0);
			//JOptionPane.showMessageDialog(null,"playerAName");  // ikde team a scored ani team b scored 
															// database made takta yeil
			
			scorearray[countarr] = "playerAName ";
			countarr+=1;
			//JOptionPane.showMessageDialog(null,"playerAname"); 
		} else {
			teamBScore++;
			Tracker tr1=new Tracker(1);
			
			
			scorearray[countarr] = "playerBName ";
			countarr+=1;
		}
		return checkIfGameEnded();
	}

	private boolean checkIfGameEnded() {
		if(teamAScore >= 21 || teamBScore >= 21) {
			if(Math.abs(teamAScore-teamBScore) > 1) {
				return true;
			}
		} 
		return false;
	}
}
