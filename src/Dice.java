	/**
	 * This class implements a system of the dice that will be used in the game. It stores the randomly generated
	 * values into two static attributes die1 and die2
	 * @author Elias Haroun
	 */
public class Dice {

	private static int die1; // Where the first die value will be stored
	private static int die2; // Where the second die value will be stored

	/**
	 * Generates random numbers between 1 and 6 and stores them in die1 and die2
	 */
	public static void throwDice() {
		final int MAX_DIE_VALUE = 6;
		die1 = (int)(Math.random()*(MAX_DIE_VALUE)+1);
		die2 = (int)(Math.random()*(MAX_DIE_VALUE)+1);
	}

	/**
	 * Gets the value stored in die1
	 * @return The value of the first die
	 */
	public static int getDie1(){
		return die1;
	}

	/**
	 * Gets the value stored in die2
	 * @return The value of the second die
	 */
	public static int getDie2(){
		return die2;
	}
	
	public static void setDie1(int a) {
		die1 = a;
	}
	
	public static void setDie2(int b) {
		die2 = b;
	}
}