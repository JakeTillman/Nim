package assignment2;

import support.cse131.ArgsProcessor;

public class GameOfNim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int startSticks = ap.nextInt("How many sticks should we start with?");
		int roundNum = 0;
		while (startSticks > 0) {
			int atStart = startSticks;
			int humanTake = ap.nextInt("Choose to take 1 or 2 sticks");
			while (humanTake > 2 || humanTake < 1) {
				humanTake = ap.nextInt("Please take only 1 or 2 sticks");
			}
			startSticks = startSticks - humanTake;
			System.out.println("Round " + roundNum + ": Start with " + atStart + " sticks, human takes " + humanTake + " sticks. " + startSticks + " sticks remain");
			roundNum = roundNum + 1;
		}
		
	}

}
