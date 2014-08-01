/**
 * This class extends the Cell class to a specific cell type, Skip Cell
 * @author Elias Haroun
 */
public class SkipCell extends Cell{

	/**
	 * This constructor takes the character corresponding to the cell type and assigns it to the calling object
	 * @param newChar
	 */
	public SkipCell(char newChar) {
		super(newChar);
	}

	/**
	 * This method takes an object of type player, performs the action and modifies the player's position
	 */
	public void action(Player aPlayer){
		BoardGame.print("Take a shortcut to location 68\n\n");
		aPlayer.setPosition(68);
	}

	/**
	 * This method takes an object of type Player, and updates it's energy
	 */
	public void energyUpdate(Player aPlayer) {
		super.energyUpdate(aPlayer);
	}

	/**
	 * This method returns the cell type
	 * @return Cell Type
	 */
	public char getCellType() {
		return super.getCellType();
	}
}
