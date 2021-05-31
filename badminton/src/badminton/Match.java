package badminton;


public class Match {
	int noOfGames = 3;
	ScoreBoard scoreBoard = new ScoreBoard();                                  //Scoreboard cha obj.
	Score currentScore = new Score();                                         //score cha object
	int Awon = 0;
	int Bwon = 0;
	String winner = "" ;
	
	
	boolean incrementScore(String team) {
		
		
		
		
		
		
		
		
		
		boolean isGameEnded = currentScore.incrementScore(team);       //score class madla methodcall
		if(isGameEnded) {
			scoreBoard.addScore(currentScore);                                   //ScoreBoard.java      
			if(currentScore.teamAScore > currentScore.teamBScore) {              // madhla method call
				Awon++;
				rset r=new rset();
			} else {
				Bwon++;
				rset r1=new rset();
			}
			currentScore = new Score();
			return checkIfMatchEnded();
		}
		return false;
		
	}

	private boolean checkIfMatchEnded() {
		if(Awon==2 || Bwon==2) {
			if(Awon==2) winner = "A";
			else winner = "B";
			return true;
		} 
		return false;
	}
}
