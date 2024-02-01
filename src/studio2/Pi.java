package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Scanner = new Scanner(System.in);
		System.out.println("How many throws? ");
		double totalThrows = Scanner.nextDouble();
		int throwsIn=0;
		for(int i=0; i<totalThrows; i++) {
			double x=Math.random();
			double y=Math.random();
			if (Math.sqrt((Math.pow(x, 2)+Math.pow(y, 2)))<.5){
			throwsIn++;	
			}
		}
		System.out.println(16*throwsIn/totalThrows);
	}

}
