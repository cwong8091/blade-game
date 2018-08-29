import java.util.*;

/*
 * Description: Generic deck of cards. The deck has a particular size as well as a hand size, depending on the game
 */

public class Deck {
	
	protected int hand_size;			//Number of cards in the hand
	protected int deck_size;			//Number of cards in the deck
	
	protected ArrayList<Card> deck;		//The deck that will be split into the hand and the pile
	protected ArrayList<Card> hand;		//The hand, which is the first portion of the deck
	protected ArrayList<Card> pile;		//The pile, which is the second portion of the deck
	
	//Empty Constructor
	public Deck()
	{
		hand_size = 0;
		deck_size = 0;
	}
	//Main Constructor
	public Deck(int hsize, int dsize)
	{
		hand_size = hsize;
		deck_size = dsize;
		
		deck = new ArrayList<Card>(deck_size);
		hand = new ArrayList<Card>(hand_size);
		pile = new ArrayList<Card>(deck_size - hand_size);

	}
	
	
	/*
	 * Description: Method to shuffle the current deck
	 * Preconditions: None
	 * Postconditions: None
	 */
	public void shuffleDeck()
	{
		//calling the predefined shuffle method
		Collections.shuffle(deck);
		
		//Define 'hand' and 'pile' as the first and second portions of the deck respectively
		for(int i=0; i<hand_size; i++)
		{
			hand.set(i, deck.get(i));
		}
		for(int i=hand_size; i<deck_size; i++)
		{
			pile.set(i-hand_size, deck.get(i));
		}
		
	}
	
	/*
	 * Description: Method to sort the current player's hand from lowest to highest card
	 * Preconditions: None
	 * Postconditions: None
	 */
	public void sortHand()
	{
		int min_index;	//index for the minimum card value
		Card min_Card;	//the current smallest card in the hand that has not been sorted
		Card temp_Card;	//a temp card variable for swapping within the hand
		
		//Swap each card in the hand, ording them from lowest value to highest value
		for(int j=0; j<hand_size; j++)
		{
			min_index = j;
			min_Card = hand.get(min_index);
			
			//check each card of the remaining hand and find the smallest card
			for(int i=j; i<hand_size; i++)
			{
				if(min_Card.getValue() > hand.get(i).getValue())
				{
					min_index = i;
					min_Card = hand.get(i);
				}
			}
			
			//swap the smallest and current card
			temp_Card = hand.get(j);
			hand.set(j, min_Card);
			hand.set(min_index, temp_Card);
			
		}

	}
	
	/*
	 * Description: Returns the deck to the user for further use
	 * Preconditions: None
	 * Postconditions: None
	 */
	public ArrayList<Card> getDeck()
	{
		return deck;
	}
	
	/*
	 * Description: Returns the card at a given location
	 * Preconditions: None
	 * Postconditions: None
	 */
	public Card getCard(int v)
	{
		return deck.get(v);
	}
	
	/*
	 * Description: Returns the current hand
	 * Preconditions: None
	 * Postconditions: None
	 */
	public ArrayList<Card> getHand()
	{
		return hand;
	}
	
	/*
	 * Description: Returns the current piles
	 * Preconditions: None
	 * Postconditions: None
	 */
	public ArrayList<Card> getPile()
	{
		return pile;
	}
	
	
	/*
	 * Description: Returns the next card in the pile and removes it from the top of the pile
	 * Preconditions: None
	 * Postconditions: None
	 */
	public Card getNextCard()
	{
		return pile.remove(0);
	}
	
	
}
