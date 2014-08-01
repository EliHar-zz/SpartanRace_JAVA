/**
 * This class extends the Cell class to a more specific type of cells
 * @author Elias Haroun
 */
public class RegularCell extends Cell{

	/**
	 * This constructor takes a character and assigns it to the cell type of the object
	 * @param newChar
	 */
	public RegularCell(char newChar) {
		super(newChar);
	}

	/**
	 * This method takes an object of type Player, performs the action and sets the new position of the player
	 */
	public void action(Player aPlayer) {
		if (aPlayer.getEnergy() <= 0)
			BoardGame.print("");
		else
			BoardGame.print("Keep playing.\n\n");
	}

	/**
	 * This method takes an object of type player and updates its energy based on the cell's requirements
	 */
	public void energyUpdate(Player aPlayer) {
		super.energyUpdate(aPlayer);
	}

	/**
	 * This method returns the cell type
	 * @return Cell type
	 */
	public char getCellType() {
		return super.getCellType();
	}
}
