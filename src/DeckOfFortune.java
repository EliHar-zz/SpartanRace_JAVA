/**
 * This class implements a system for the deck of fortune. Where the the number of the card will be generated randomly.
 * The outcome will dictate the player's movement.
 * @author Elias Haroun
 */
public class DeckOfFortune {

	private static int cardNum; // Card's number

	/* Value representing the message on the card. If negative, player will move backward, if positive player will move forward,
	 * if zero the player will go to position 0
	 */
	private static int cardValue;

	/**
	 * This method will generate a random number between 1 and 10 that will correspond to the card number,
	 * then it will reveal its value to dictate the player's movement
	 */
	public static void pickCard() {

		final int MAX_CARDS = 10; // Maximum number of cards in the deck

		cardNum = (int)(Math.random()*(MAX_CARDS)+1);

		switch (cardNum) {

		case 1: cardValue = -9;
		break;

		case 2: cardValue = 0;
		break;

		case 3: cardValue = -3;
		break;

		case 4: cardValue = -8;
		break;

		case 5: cardValue = 2;
		break;

		case 6: cardValue = 1;
		break;

		case 7: cardValue = 3;
		break;

		case 8: cardValue = 0;
		break;

		case 9: cardValue = -4;
		break;

		case 10: cardValue = 6;
		break;
		}
	}

	/**
	 * This method gets the card number that was randomly generated
	 * @return Number of the card
	 */
	public static int getCardNum() {
		return cardNum; 
	}

	/**
	 * This method gets the value of the card which corresponds to the movement that the player will undergo
	 * @return Value of the card
	 */
	public static int getCardValue() {
		return cardValue; 
	}
}