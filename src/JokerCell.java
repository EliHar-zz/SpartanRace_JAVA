/**
 * This class extends the Cell class to a more specific cell type
 * @author Elias Haroun
 */


public class JokerCell extends Cell{

	private static int userPref;
	private static final int CARD_ENERGY_INCREASE = 30;

	/**
	 * This constructor takes a character and assigns it to the cell type of the object
	 * @param newChar
	 */
	public JokerCell(char newChar) {
		super(newChar);
	}

	/**
	 * This method returns the userPref value entered by the user to either spin the wheel or pick a card
	 * @return UserPref
	 */
	public static int getUserPref() {
		return userPref;
	}

	/**
	 * This method takes an integer number and sets it to the userPref value
	 * @param number
	 */
	public static void setUserPref(int number){
		userPref = number;
	}

	/**
	 * This method takes and object of type player and performs the action, sets the new position as well
	 */
	public void action(Player aPlayer) {
		//Spin wheel or pick card
		if (getUserPref() == 1){
			BoardGame.print("Spinning the wheel of fortune. ");

			// Spin the wheel
			WheelOfFortune.spinWheel();

			// Player goes back to position 0
			if (WheelOfFortune.getWheelValue() == 0) {
				aPlayer.setPosition(0);
				BoardGame.print("You are back to position "+aPlayer.getPosition()+"\n\n");
			}

			// Player moves backward
			else if (WheelOfFortune.getWheelValue() < 0) {
				BoardGame.print("Go back "+Math.abs(WheelOfFortune.getWheelValue())+". ");
				aPlayer.setPosition(aPlayer.getPosition()+WheelOfFortune.getWheelValue());
				BoardGame.print("You are at location "+aPlayer.getPosition()+"\n\n");  
			}

			// Player moves forward
			else if (WheelOfFortune.getWheelValue() > 0) {
				BoardGame.print("Go forward "+WheelOfFortune.getWheelValue()+". ");
				aPlayer.setPosition(aPlayer.getPosition()+WheelOfFortune.getWheelValue());
				BoardGame.print("You are at location "+aPlayer.getPosition()+"\n\n");    
			}
		}

		//Pick a card
		else if (getUserPref() == 2){
			BoardGame.print("Picking a card of fortune. ");

			// Picks a card randomly
			DeckOfFortune.pickCard();

			BoardGame.print("Current card "+DeckOfFortune.getCardNum()+", so ");

			// Player goes back to position 0
			if (DeckOfFortune.getCardValue() == 0) {
				aPlayer.setPosition(0);
				BoardGame.print("You are back to position "+aPlayer.getPosition()+"\n\n");
			}

			// Player goes backward
			else if (DeckOfFortune.getCardValue() < 0) {
				BoardGame.print("go back "+Math.abs(DeckOfFortune.getCardValue())+". ");
				aPlayer.setPosition(aPlayer.getPosition()+DeckOfFortune.getCardValue());
				BoardGame.print("You are at location "+aPlayer.getPosition()+"\n\n");  
			}

			// Player goes backward
			else if (DeckOfFortune.getCardValue() > 0) {
				BoardGame.print("go forward "+DeckOfFortune.getCardValue()+". ");
				aPlayer.setPosition(aPlayer.getPosition()+DeckOfFortune.getCardValue());
				BoardGame.print("You are at location "+aPlayer.getPosition()+"\n\n");    
			}
		}
	}

	/**
	 * This method takes and object of type player and updates its energy
	 */
	public  void energyUpdate(Player aPlayer) {
		super.energyUpdate(aPlayer);
		if (getUserPref() == 1){
			aPlayer.setEnergy(2*aPlayer.getEnergy()); // Energy doubles
		}
		else if (getUserPref() == 2)
			aPlayer.setEnergy(aPlayer.getEnergy()+CARD_ENERGY_INCREASE); // Energy increases by 30 units
	}

	/**
	 * This method returns the cell type
	 * @return Cell Type
	 */
	public char getCellType() {
		return super.getCellType();
	}

}
