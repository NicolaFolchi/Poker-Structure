package a2;

public class PokerHandImpl implements PokerHand {
	public Card[] myCards;

	public PokerHandImpl(Card[] cards) {

		myCards = new Card[5];

		if (cards == null) 		
			throw new RuntimeException("Cards are null");
		
	if (cards.length != 5) {
		throw new RuntimeException("Cards are not five");
	}
		
		for (int i=0; i<cards.length; i++) {
			  for (int j=i+1; j<cards.length; j++) {
			    if (cards[i].getRank() > cards[j].getRank()) {
			      Card tmp = cards[i];
			      cards[i] = cards[j];
			      cards[j] = tmp;
			    }
			  }
			}

		this.myCards = cards.clone();
	}
	
	

	public Card[] getCards() {
		
		return myCards.clone();
	}

	public boolean contains(Card c) {

		for (int i = 0; i < myCards.length; i++) {
			if (myCards[i].equals(c))
				return true;
		}
		return false;
	}

	public boolean isOnePair() {

		for (int l = 0; l < myCards.length; l++)
			System.out.println(myCards[l].getRank());
		int counter = 0;
		for (int i = 0; i < 4; i++) {

			if (myCards[i].getRank() == myCards[i + 1].getRank())
				counter++;
		}

		if (counter == 1)
			return true;
		else
			return false;
	}

	public boolean isTwoPair() {
		Card[] isTwoPair = getCards();
		int counter = 0
				;
		if (isTwoPair[0].getRank() == isTwoPair[1].getRank()) {
			if (isTwoPair[1].getRank() == isTwoPair[2].getRank()) 
				return false;
			else 
				counter += 1;
		}
		if (isTwoPair[1].getRank() == isTwoPair[2].getRank()) {
			if (isTwoPair[2].getRank() == isTwoPair[3].getRank()) {
				return false;
			} else {
				counter += 1;
			}
		}
		if (isTwoPair[2].getRank() == isTwoPair[3].getRank()) {
			if (isTwoPair[3].getRank() == isTwoPair[4].getRank())
				return false;
			 else 
				counter += 1;
		}
		if (isTwoPair[3].getRank() == isTwoPair[4].getRank()) 
			counter += 1;
			
		if (counter == 2) 
			return true;
		 else 
			return false;
		
	}

	public boolean isThreeOfAKind() {
		Card[] isThreePair = getCards();
		
		if (isThreePair[0].getRank() == isThreePair[1].getRank()) {
			if (isThreePair[1].getRank() == isThreePair[2].getRank()) {
				if (isThreePair[2].getRank() == isThreePair[3].getRank()) 
					return false;
				
				else if (isThreePair[3].getRank() == isThreePair[4].getRank()) 
					return false;
				
			} else if (isThreePair[2].getRank() == isThreePair[3].getRank()) {
				if (isThreePair[3].getRank() == isThreePair[4].getRank())
					return false;
			}
		}
		if (isThreePair[0].getRank() == isThreePair[1].getRank()) {
			if (isThreePair[1].getRank() == isThreePair[2].getRank()) {
				if (isThreePair[3].getRank() != isThreePair[4].getRank())
					return true;
			}
		} else if (isThreePair[1].getRank() == isThreePair[2].getRank()) {
			if (isThreePair[2].getRank() == isThreePair[3].getRank())
				return true;
		}
		return false;
	}

	public boolean isStraight() {
		Card[] isStraight = getCards();
		int counter = 0;
		
		if (isStraight[0].getRank() == 2) {
			if (isStraight[4].getRank() == 14) 
				counter += 1;
		}
		
		for (int i = 0; i < 4; i++) {
			if ((isStraight[i].getRank()) + 1 == isStraight[i + 1].getRank()) 
				counter += 1;
			 else 
				break;
		}
		if (counter >= 4) 
			return true;
		else 
			return false;
	}

	public boolean isFlush() {
		Card[] flush = getCards();
		int counter = 0;
		
		for (int i = 0; i < 4; i++) {
			if (flush[i].getSuit().equals(flush[i + 1].getSuit()))
				counter += 1;
		}
		if (counter == 4) {
			return true;
		}
		return false;
	}

	public boolean isFullHouse() {
		Card[] fullHouse = getCards();

		if (fullHouse[0].getRank() == fullHouse[1].getRank()) {
			if (fullHouse[1].getRank() == fullHouse[2].getRank()) {
				if (fullHouse[3].getRank() == fullHouse[4].getRank()) 
					return true;
			}
		}
		if (fullHouse[0].getRank() == fullHouse[1].getRank()) {
			if (fullHouse[2].getRank() == fullHouse[3].getRank()) {
				if (fullHouse[3].getRank() == fullHouse[4].getRank()) 
					return true;
			}
		}

		return false;
	}

	public boolean isFourOfAKind() {
		Card[] fourOfAKind = getCards();
		int counter = 0;
		
		if (fourOfAKind[0].getRank() == fourOfAKind[3].getRank())
			counter += 1;
		else if (fourOfAKind[1].getRank() == fourOfAKind[4].getRank())
			counter += 1;

		if (counter == 1)
			return true;
		else
			return false;
	}

	public boolean isStraightFlush() {
		Card[] StraightFlush = getCards();
		int counter = 0;
		
		if (StraightFlush[0].getRank() == 2) {
			if (StraightFlush[4].getRank() == 14)
				counter += 1;
		}
		for (int i = 0; i < 4; i++) {

			if ((StraightFlush[i].getRank()) + 1 == StraightFlush[i + 1].getRank())
				counter += 1;
			else
				break;
		}
		if (counter >= 4) {
			int sf = 0;
			for (int i = 0; i < 4; i++) {
				if (StraightFlush[i].getSuit().equals(StraightFlush[i + 1].getSuit()))
					sf += 1;
			}
			if (sf == 4)
				return true;
			else
				return false;
		}
		return false;
	}

	public int getHandTypeValue() {

		if (isStraightFlush() == true)
			return 9;
		else if (isFourOfAKind() == true)
			return 8;
		else if (isFullHouse() == true)
			return 7;
		else if (isFlush() == true)
			return 6;
		else if (isStraight() == true)
			return 5;
		else if (isThreeOfAKind() == true)
			return 4;
		else if (isTwoPair() == true)
			return 3;
		else if (isOnePair() == true)
			return 2;
		else
			return 1;
	}

	public int getHandRank() {
		Card[] rank = getCards();
		
		if (isOnePair() == true) {
			if (rank[3].getRank() == rank[4].getRank())
				return rank[4].getRank();
			else if (rank[2].getRank() == rank[3].getRank())
				return rank[3].getRank();
			else if (rank[1].getRank() == rank[2].getRank())
				return rank[2].getRank();
			else if (rank[0].getRank() == rank[1].getRank())
				return rank[1].getRank();
		} else if (isTwoPair() == true) {
			if (rank[3].getRank() == rank[4].getRank())
				return rank[4].getRank();
			else if (rank[2].getRank() == rank[3].getRank())
				return rank[3].getRank();
			else if (rank[1].getRank() == rank[2].getRank())
				return rank[2].getRank();
			else if (rank[0].getRank() == rank[1].getRank())
				return rank[1].getRank();
		} else if (isThreeOfAKind() == true)
			return rank[2].getRank();
		else if (isStraight() == true)
			if (rank[4].getRank() == 14)
				return 5;
			else
				return rank[4].getRank();

		else if (isFlush() == true)
			return rank[4].getRank();
		else if (isFullHouse() == true)
			return rank[2].getRank();
		else if (isFourOfAKind() == true)
			return rank[2].getRank();
		else if (isStraightFlush() == true)
			if (rank[4].getRank() == 14)
				return 5;
			else
				return rank[4].getRank();

		else
			return rank[4].getRank();

		return 0;
	}

	public int compareTo(PokerHand other) {
		if (getHandTypeValue() < other.getHandTypeValue())
			return -1;
		else if (getHandTypeValue() > other.getHandTypeValue())
			return 1;
		else if (getHandTypeValue() == other.getHandTypeValue()) {
			if (getHandRank() < other.getHandRank())
				return -1;
			else if (getHandRank() > other.getHandRank())
				return 1;
			else if (getHandRank() == other.getHandRank())
				return 0;
		}
		return 0;

	}

}
