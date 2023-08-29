package com.auriopro.test;

import java.util.Random;

import java.util.Scanner;

public class BookCricketTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 1 to start or 0 to exit:");
		int choice = scanner.nextInt();

		if (choice == 1) {
			int totalPages = 300;
			Random random = new Random();

			// Player 1
			System.out.println("Enter Player 1 Name:");
			String player1Name = scanner.next();
			System.out.println("Enter Player 2 Name:");
			String player2Name = scanner.next();
			int player1Score = 0;
			int player1Turns = 0;
			int player1Page;
			System.out.println("Player:" + player1Name);
			do {
				
				System.out.println("Enter 1 to open the book for " + player1Name + ":");
                choice = scanner.nextInt();

				player1Page = random.nextInt(totalPages) + 1;
				int player1TurnScore = player1Page % 7;
				player1Score += player1TurnScore;
				player1Turns++;
				System.out.println(
						"Page Number:" + player1Page + "   Point:" + player1TurnScore + "   Score:" + player1Score);
			} while (player1Page % 7 != 0  && choice != 0);

			System.out.println(player1Name + " Total Score:" + player1Score);
			System.out.println(player1Name + " Takes " + player1Turns + " Rounds");
			int target = player1Score+1;
			System.out.println(player2Name + " need " + target + " in " + player1Turns + " to WIN MATCH");
			
			int player2Score = 0;
			int player2Turns = 0;
			int player2Page;
			System.out.println("Player:" + player2Name);

			do {
				
				
				player2Page = random.nextInt(totalPages) + 1;
				int player2TurnScore = player2Page % 7;
				player2Score += player2TurnScore;
				player2Turns++;
				int turnsRemains = player1Turns - player2Turns;
				if (turnsRemains > 0) {
                    System.out.println("Enter 1 to open the book for " + player2Name + ":");
                    choice = scanner.nextInt();
                }
				System.out.println("Page Number:" + player2Page + "   Point:" + player2TurnScore + "   Score:"
						+ player2Score + "   Rounds left:" + turnsRemains);
				if (player2Score > player1Score) {
	                    break;
	            }
			} while (player2Page % 7 != 0 && player2Turns <= player1Turns && choice != 0);

			System.out.println(player2Name+ " score:" + player2Score);
			System.out.println(player2Name+ " turns:" + player2Turns);

			
			if (player1Score > player2Score) {
				System.out.println(player1Name+" wins!");
			} else if (player2Score > player1Score) {
				System.out.println(player2Name+" wins!");
			} else {
				if (player1Turns < player2Turns) {
					System.out.println( player1Name+" wins due to fewer turns!");
				} else if (player2Turns < player1Turns) {
					System.out.println(player1Name+" wins due to fewer turns!");
				} else {
					System.out.println("It's a tie!");
				}
			}
		} else if (choice == 0) {
			System.out.println("Exiting the game.");
		} else {
			System.out.println("Invalid input. Exiting the game.");
		}

		scanner.close();
	}
}
