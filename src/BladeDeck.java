
public class BladeDeck extends Deck {
	
	public BladeDeck()
	{
		super();
	}
	
	public BladeDeck(int hsize, int dsize)
	{
		super(hsize, dsize);
		
		BladeCard one = new BladeCard(1, 1);
		BladeCard two = new BladeCard(2, 2);
		BladeCard three = new BladeCard(3, 3);
		BladeCard four = new BladeCard(4, 4);
		BladeCard five = new BladeCard(5, 5);
		BladeCard six = new BladeCard(6, 6);
		BladeCard seven = new BladeCard(7, 7);
		BladeCard bolt = new BladeCard(1, 8);
		BladeCard mirror = new BladeCard(1, 9);
		
		//Create the deck
		for(int i=0; i<5; i++)
		{
			deck.add(one);
		}
		for(int i=5; i<10; i++)
		{
			deck.add(two);
		}
		for(int i=10; i<15; i++)
		{
			deck.add(three);
		}
		for(int i=15; i<20; i++)
		{
			deck.add(four);
		}
		for(int i=20; i<25; i++)
		{
			deck.add(five);
		}
		for(int i=25; i<30; i++)
		{
			deck.add(six);
		}
		for(int i=30; i<35; i++)
		{
			deck.add(seven);
		}
		for(int i=35; i<40; i++)
		{
			deck.add(bolt);
		}
		for(int i=40; i<45; i++)
		{
			deck.add(mirror);
		}
		
		
		//Separate Deck into 'hand' and 'pile'
		for(int i=0; i<hand_size; i++)
		{
			hand.add(deck.get(i));
		}
		//Separate Deck into 'hand' and 'pile'
		for(int i=hand_size; i<deck_size; i++)
		{
			pile.add(deck.get(i));
		}
	}
	
	
	//Method to sort Player Hand
	public void sortHand()
	{
		int min_index;
		BladeCard min_Card;
		BladeCard temp_Card;
		
		for(int j=0; j<hand_size; j++)
		{
			min_index = j;
			min_Card = (BladeCard) hand.get(min_index);
			
			for(int i=j; i<hand_size; i++)
			{
				if(min_Card.getSortValue() >= ((BladeCard) hand.get(i)).getSortValue())
				{
					min_index = i;
					min_Card = (BladeCard) hand.get(i);
				}
			}
			
			temp_Card = (BladeCard) hand.get(j);
			hand.set(j, min_Card);
			hand.set(min_index, temp_Card);
			
		}
	}
	
	//Method to remove a card from the hand
	public BladeCard removeCardHand(int i)
	{
		return (BladeCard) hand.remove(i);
	}
	
}
