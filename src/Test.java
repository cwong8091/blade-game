/*
 * Main Program for the Game BLADE from Trails of Cold Steel
 */

import java.util.*;


public class Test {
	
	static int players_scores[] = new int[2];
	static int players_lastCard[] = new int[2];
	static int players_discard[] = new int[2];
	static int players_handSize[] = new int[2];
	
	static int curr_Player;
	static BladeDeck[] decks = new BladeDeck[2];
	static ArrayList<Card> currHand;
	
	static Scanner reader = new Scanner(System.in);
	static int user_input;
	
	static BladeCard currCard;
	
	static int game_continue;
	
	public static void main(String[] args) {
		
		//initialize game
		initializeGame();
		
		//find the starting player for a particular round
		drawCardFromPile();
		
		while(game_continue != 0)
		{
			//display the hand of the current player
			if(displayHand())
			{
				//ask for player to choose a card and tally score
				playOneRound();
				
				//checks current score and decides a winner
				game_continue = checkWinner();
				
				if(game_continue == 1)
				{
					drawCardFromPile();
				}
			}
		}
		
		System.out.println("\nThanks for Playing!");
		
		//close the reader once the game is over but before exiting
		reader.close();
		
	}
	
	
	//Function to initialize game
	public static void initializeGame()
	{
		players_scores[0] = players_scores[1] = 0;
		players_lastCard[0] = players_lastCard[1] = 0;
		players_discard[0] = players_discard[1] = 0;
		
		players_handSize[0] = players_handSize[1] = 10;
		
		curr_Player = -1;
		
		game_continue = 2;
		
		decks[0] = new BladeDeck(10, 45);
		decks[1] = new BladeDeck(10, 45);
		
		//Initialize player 1 deck
		decks[0].shuffleDeck();
		decks[0].sortHand();
		
		//Initialize player 2 deck
		decks[1].shuffleDeck();
		decks[1].sortHand();
	}
	
	//Function to pull card from pile and reset scores
	public static void drawCardFromPile()
	{
		int currVal0;
		int currVal1;
		
		do
		{
			currVal0 = decks[0].getNextCard().getValue();
			currVal1 = decks[1].getNextCard().getValue();
			
			System.out.println("Player 1: " + currVal0);
			System.out.println("Player 2: " + currVal1);
			
			if(currVal0 < currVal1)
			{
				System.out.println("Player 1 goes first.");
				curr_Player = 0;
			}
			else if(currVal0 > currVal1)
			{
				System.out.println("Player 2 goes first.");
				curr_Player = 1;
			}
			else
			{
				System.out.println("Redraw.");
			}
			
		}while(currVal0 == currVal1);
		
		players_scores[0] = players_lastCard[0] = currVal0;
		players_scores[1] = players_lastCard[1] = currVal1;
		
		players_discard[0] = 0;
		players_discard[1] = 0;
		
	}
	
	//Function to display the current player's hand
	public static boolean displayHand()
	{
		currHand = decks[curr_Player].getHand();
		
		if(currHand.isEmpty())
		{
			System.out.println("Player" + (curr_Player+1) + "has no more cards");
			game_continue = 0;
			return false;
		}
		else
		{
			System.out.print("\nPlayer " + (curr_Player+1) + " Current Hand: ");
			for(int i=0; i<players_handSize[curr_Player]; i++)
			{
				System.out.print(((BladeCard)currHand.get(i)).getSortValue() + ", ");
			}
			return true;
		}
		
	}
	
	//Function to play a single round of the game
	public static void playOneRound()
	{
		//ask for player to choose a card from their hand
		System.out.print("\nPlease Choose a Card: ");
		user_input = reader.nextInt();
		
		currCard = decks[curr_Player].removeCardHand(user_input);
		players_handSize[curr_Player] = players_handSize[curr_Player] - 1;
		
		System.out.println("\nPlayer " + (curr_Player+1) + " Chose Card " + currCard.getSortValue());
		
		players_lastCard[curr_Player] = currCard.getValue();
		players_scores[curr_Player] = players_scores[curr_Player] + players_lastCard[curr_Player];
		
		
		if(curr_Player == 0)
		{
			curr_Player = 1;
		}
		else
		{
			curr_Player = 0;
		}
		
	}
	
	//Function to check for a winner of the game (0=gameover, 1=tie, 2=continue)
	public static int checkWinner()
	{		
		System.out.println("\nCurrent Score: \nPlayer1: " + players_scores[0] + "\nPlayer2: " + players_scores[1]);
		if(players_scores[0] > players_scores[1] && curr_Player == 0)
		{
			System.out.println("Player 1 is Winner");
			return 0;
		}
		else if(players_scores[0] < players_scores[1] && curr_Player == 1)
		{
			System.out.println("Player 2 is Winner");
			return 0;
		}
		else if(players_scores[0] == players_scores[1])
		{
			System.out.println("Tie. Redraw.");
			return 1;
		}
		else
		{
			System.out.println("Game Continues.");
			return 2;
		}
	}

}
