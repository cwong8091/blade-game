/*
 * Description: Card specifically used in the game BLADE in Trails of Cold Steel
 */

public class BladeCard extends Card {
	
	/*
	 * Possible Card Values = 1-7
	 * Special Values
	 *      1 = Revive
	 *      8 = Bolt
	 *      9 = Mirror
	 */
	
	protected int sortValue;

	//Empty Constructor
	public BladeCard()
	{
		super();
	}
	//Constructor for only a single true value with no special value
	public BladeCard(int v)
	{
		super(v);
		sortValue = 0;
	}
	//Constructor for specialty BLADE cards, such as REVIVE, BOLT, and MIRROR
	public BladeCard(int v, int s)
	{
		super(v);
		sortValue = s;
	}
	
	/*
	 * Description: Sets the current special value, also used for sorting
	 * Preconditions: None
	 * Postconditions: None
	 */
	public void setSortValue(int s)
	{
		sortValue = s;
	}
	
	/*
	 * Description: Gets the current special value, also used for sorting
	 * Preconditions: None
	 * Postconditions: None
	 */
	public int getSortValue()
	{
		return sortValue;
	}
}
