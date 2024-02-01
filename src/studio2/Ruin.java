package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner Scanner = new Scanner(System.in);
		System.out.println("What is your starting amount? ");
		int startAmount = Scanner.nextInt();
		int amount = startAmount;
		System.out.println("What is your win chance? ");
		double winChance = Scanner.nextDouble();
		System.out.println("What is your win limit? ");
		double winLimit = Scanner.nextDouble();
		boolean win = true;
		double expectedRuin = 0;
		double a = (1-winChance)/(winChance);
		if(winChance ==.5) {
			expectedRuin=1-(startAmount/winLimit);
		}
		else{
			expectedRuin=(Math.pow(a, startAmount)-Math.pow(a, winLimit)/(1-Math.pow(a, winLimit)));
		}

		System.out.println("How many days to simulate? ");
		int totalSimulations = Scanner.nextInt();
		boolean dayWon = false;
		int losses = 0;
		int wins = 0;
		for (int n = 1; n <= totalSimulations; n++) {
			int timesPlayed = 0;
			amount = startAmount;
			while (0 < amount && amount < winLimit) {
				if (Math.random() < winChance) {
					win = true;
					amount++;
					//System.out.println("You won " + amount);
					timesPlayed++;
				} else {
					win = false;
					amount--;
					//System.out.println("you lost " + amount);
					timesPlayed++;
				}
			}
			if (amount == 0) {
				losses++;
				System.out.println("Simulation " + n + ": " + timesPlayed + " LOSE ");
			}
			if (amount == winLimit) {
				wins++;
				System.out.println("Simulation " + n + ": " + timesPlayed + " WIN ");
			}

		}
		System.out.println("Losses: "+ losses + " Simulataions: "+totalSimulations);
		System.out.println("Ruin Rate: "+ (double)losses/totalSimulations + " Expected Ruin Rate: "+expectedRuin);
	}
}
