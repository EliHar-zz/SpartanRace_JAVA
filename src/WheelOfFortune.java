/**
 * This class implements a system for the wheel of fortune. Where the the numbers of the wheel will be generated randomly.
 * The outcome will dictate the player's movement.
 * @author Elias Haroun
 */
public class WheelOfFortune {

	private static int numOnWheel; // The number on the wheel

	/* Value representing the message behind each number on the wheel. If negative, player moves backward,
	 * if positive player moves forward, if zero the player will go to position 0
	 */
	private static int wheelValue;

	/**
	 * This method will generate a random number between 1 and 8 that will correspond to one of the numbers on the wheel,
	 * then it will reveal its value dictating the player's movement.
	 */
	public static void spinWheel() {

		final int MAX_Wheel_SPOTS = 8; // Maximum numbered spots on the wheel

		numOnWheel = (int)(Math.random()*(MAX_Wheel_SPOTS)+1);

		switch (numOnWheel) {

		case 1: wheelValue = +1;
		break;

		case 2: wheelValue = +2;
		break;

		case 3: wheelValue = 0;
		break;

		case 4: wheelValue = -4;
		break;

		case 5: wheelValue = -6;
		break;

		case 6: wheelValue = -7;
		break;

		case 7: wheelValue = -8;
		break;

		case 8: wheelValue = -9;
		break;
		} 
	}

	/**
	 * This method gets the value behind the chosen number on the wheel, which corresponds to a movement that the player will
	 * undergo
	 * @return The wheel's value corresponding to the player's movement
	 */
	public static int getWheelValue() {
		return  wheelValue;
	}
}