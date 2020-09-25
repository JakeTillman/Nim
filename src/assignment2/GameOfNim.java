package assignment2;

import support.cse131.ArgsProcessor;

public class GameOfNim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int startSticks = ap.nextInt("How many sticks should we start with?");
		int roundNum = 0;
		double humanOrComp = 0.0;
		int compTake = 0;
		while (startSticks > 2) {

			int atStart = startSticks;
			int humanTake = ap.nextInt("Choose to take 1 or 2 sticks");
			while (humanTake > 2 || humanTake < 1) {
				humanTake = ap.nextInt("Please take only 1 or 2 sticks");
			}
			startSticks = startSticks - humanTake;
			System.out.println("Round " + roundNum + ": Start with " + atStart + " sticks, human takes " + humanTake + " sticks. " + startSticks + " sticks remain");
			humanOrComp = humanOrComp + 1.0;
			roundNum = roundNum + 1; // end human player turn
			
			if (startSticks > 2) {
			atStart = atStart - humanTake;
			double compTurn = Math.random();
			if (compTurn > 0.5) {
				compTake = 2;
			}
			else {
				compTake = 1;
			}
			startSticks = startSticks - compTake;
			System.out.println("Round " + roundNum + ": Start with " + atStart + " sticks, computer takes " + compTake + " sticks. " + startSticks + " sticks remain");
			humanOrComp = humanOrComp + 1.0;
			roundNum = roundNum + 1; // end computer turn
			}
		}
		humanOrComp = humanOrComp % 2;
		if (humanOrComp > 0.5) {
			// Turn Starts with Computer
			if (startSticks > 1.5) {
				compTake = 2;
				startSticks = startSticks - compTake;
				System.out.println("Round " + roundNum + ": Start with 2 sticks, computer takes " + compTake + " sticks. " + startSticks + " sticks remain.");
				System.out.println("Computer Wins!"); //Computer Wins by Taking 2
			}
			else {
				compTake = 1;
				startSticks = startSticks - compTake;
				System.out.println("Round " + roundNum + ": Start with 1 stick, computer takes " + compTake + " stick. " + startSticks + " sticks remain.");
				System.out.println("Computer Wins!"); //Computer Wins by Taking 1
			}
		}
		else {
			//Turn starts with Player
			if (startSticks > 1.5) {
				int humanTake = ap.nextInt("Choose to take 1 or 2 sticks");
				while (humanTake > 2 || humanTake < 1) {
					humanTake = ap.nextInt("Please take only 1 or 2 sticks");	
				}
				startSticks = startSticks - humanTake;
				if (humanTake > 1.5) {
					System.out.println("Round " + roundNum + ": Start with 2 sticks, human takes " + humanTake + " sticks. " + startSticks + " sticks remain");
					System.out.println("Human Wins!"); //Human Wins by Taking 2
				}
				else {
					System.out.println("Round " + roundNum + ": Start with 2 sticks, human takes " + humanTake + " stick. " + startSticks + " stick remains");
					roundNum = roundNum + 1;
					System.out.println("Round " + roundNum + ": Start with 1 sticks, computer takes 1 stick. 0 sticks remain");
					System.out.println("Computer Wins!"); //Human Gives Up Easy Win
				}
			}
			else {
				int humanTake = ap.nextInt("One Stick Remains to Choose");
				while (humanTake != 1) {
					humanTake = ap.nextInt("You Can Only Take One Stick");
				}
				System.out.println("Round " + roundNum + ": Start with 1 stick, human takes 1 stick. 0 sticks remain");
				System.out.println("Human Wins!"); //Human Wins by Taking 1
			}
		}
	}
}

