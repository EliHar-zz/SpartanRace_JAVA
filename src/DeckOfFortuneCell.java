/**
 * This class extends the Cell class to a more specific cell type
 * @author Elias Haroun
 */
public class DeckOfFortuneCell extends Cell{
	
	private static final int CARD_ENERGY_INCREASE = 30;

	/**
	 * This constructor takes a character and sets it to the cell type of the object
	 * @param newChar
	 */
	public DeckOfFortuneCell(char newChar) {
		super(newChar);
	}

	/**
	 * This method takes an object of type Player and performs the action and updates the player's position
	 */
	public void action(Player aPlayer) {
		BoardGame.print("Picking a card of fortune. ");
		DeckOfFortune.pickCard();
		BoardGame.print("Current card "+DeckOfFortune.getCardNum()+", so ");

		// Players goes to position 0
		if (DeckOfFortune.getCardValue() == 0) {
			aPlayer.setPosition(0);
			BoardGame.print("you are back to position "+aPlayer.getPosition()+"\n\n");
		}

		// Player will move backward
		else if (DeckOfFortune.getCardValue() < 0) {
			BoardGame.print("go back "+Math.abs(DeckOfFortune.getCardValue())+". ");
			aPlayer.setPosition(aPlayer.getPosition()+DeckOfFortune.getCardValue());
			BoardGame.print("You are at location "+aPlayer.getPosition()+"\n\n");  
		}

		// Player will move forward
		else if (DeckOfFortune.getCardValue() > 0) {
			BoardGame.print("go forward "+DeckOfFortune.getCardValue()+". ");
			aPlayer.setPosition(aPlayer.getPosition()+DeckOfFortune.getCardValue());
			BoardGame.print("You are at location "+aPlayer.getPosition()+"\n\n");    
		}
	}

	/**
	 * This method takes an object of type player and updates its energy based on the cell requirements
	 */
	public void energyUpdate(Player aPlayer) {
		super.energyUpdate(aPlayer);
		aPlayer.setEnergy(aPlayer.getEnergy()+CARD_ENERGY_INCREASE); // Energy increase by 30 units
	}

	/**
	 * This method returns the cell type
	 * @return Cell Type
	 */
	public char getCellType() {
		return super.getCellType();
	}

}
