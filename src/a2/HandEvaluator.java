package a2;

import java.util.Scanner;

import a2.Card.Suit;

public class HandEvaluator {

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		int rank1;
		Card.Suit suit1;
		int rank2;
		Card.Suit suit2;
		int rank3;
		Card.Suit suit3;
		int rank4;
		Card.Suit suit4;
		int rank5;
		Card.Suit suit5;

		int win = 0;
		int totalWins = 0;
		int finalWinPercentage = 0;

		int numberOfOpponents = 1;
		while (numberOfOpponents != 0) {
			numberOfOpponents = keyboard.nextInt();

			rank1 = keyboard.nextInt();
			suit1 = stringToSuit(keyboard.next());
			rank2 = keyboard.nextInt();
			suit2 = stringToSuit(keyboard.next());
			rank3 = keyboard.nextInt();
			suit3 = stringToSuit(keyboard.next());
			rank4 = keyboard.nextInt();
			suit4 = stringToSuit(keyboard.next());
			rank5 = keyboard.nextInt();
			suit5 = stringToSuit(keyboard.next());

			Card card1 = new CardImpl(rank1, suit1);
			Card card2 = new CardImpl(rank2, suit2);
			Card card3 = new CardImpl(rank3, suit3);
			Card card4 = new CardImpl(rank4, suit4);
			Card card5 = new CardImpl(rank5, suit4);

			for (int i = 0; i < 10000; i++) {
				Deck deck1 = new DeckImpl();
				Card[] myCardArray = { card1, card2, card3, card4, card5 };
				PokerHand myPokerHand = new PokerHandImpl(myCardArray);

				deck1.findAndRemove(card1);
				deck1.findAndRemove(card2);
				deck1.findAndRemove(card3);
				deck1.findAndRemove(card4);
				deck1.findAndRemove(card5);

				for (int j = 0; j < numberOfOpponents; j++) {
					PokerHand opponentsPokerHand = deck1.dealHand();
					myPokerHand.compareTo(opponentsPokerHand);
					if (myPokerHand.compareTo(opponentsPokerHand) == 1) {
						win++;
					}
				}
			}

		}

		if (win == numberOfOpponents) {
			totalWins++;

			double winPercentage;
			winPercentage = ((totalWins / 10000) * 100);

			finalWinPercentage = (int) (winPercentage + 0.5);
			System.out.println(finalWinPercentage);
		}

	}

	public static Card.Suit stringToSuit(String s) {
		switch (s) {
		case "S":
			return Card.Suit.SPADES;
		case "H":
			return Card.Suit.HEARTS;
		case "D":
			return Card.Suit.DIAMONDS;
		case "C":
			return Card.Suit.CLUBS;
		}
		// This will never happen:
		return null;
	}

}
