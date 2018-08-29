
/*
 * Description: Generic playing card. Card has a single integer value
 */

public class Card {

	protected int card_value;	//value of the card
	
	//Empty Constructor
	public Card()
	{
		card_value = 0;
	}
	//Main Constructor
	public Card(int v)
	{
		card_value = v;
	}
	
	/*
	 * Description: Sets the value of the card
	 * Preconditions: None
	 * Postconditions: None
	 */
	public void setValue(int v)
	{
		card_value = v;
	}
	
	/*
	 * Description: Get the value of the card
	 * Preconditions: None
	 * Postconditions: None
	 */
	public int getValue()
	{
		return card_value;
	}
	
}
