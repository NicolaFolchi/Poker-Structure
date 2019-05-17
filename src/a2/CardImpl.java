package a2;

public class CardImpl implements Card {

	private int r;
	private Card.Suit s;
	
	public CardImpl(int rank, Card.Suit suit) {
		
		if((rank<2) || (rank>14)) {
		throw new RuntimeException ();
		}
		
		this.r = rank;
		this.s = suit;
	}
	
	public int getRank() {
		
		return r;
	}
	
	public Card.Suit getSuit(){
		return s;
	}
	
	public String toString() {
		String rankString = "";
		
		switch (getRank()) {
		case 2 : rankString = "Two";
		case 3 : rankString = "Three";
		case 4 : rankString = "Four";
		case 5 : rankString = "Five";
		case 6 : rankString = "Six";
		case 7 : rankString = "Seven";
		case 8 : rankString = "Eight";
		case 9 : rankString = "Nine";
		case 10 : rankString = "Ten";
		case Card.JACK : rankString = "Jack";
		case Card.QUEEN : rankString = "Queen";
		case Card.KING : rankString = "King";
		case Card.ACE : rankString = "Ace";
		}
		
		return rankString + "of" + getSuit();
	}
	
	public boolean equals(Card other) {
		
		if(getRank()==(other.getRank()) && getSuit()==(other.getSuit()))
			return true;
		else
			return false;
	}
}
