/**
 * This class implements a system of methods for the cells.
 * @author Elias Haroun
 */
public abstract class Cell {

	private char cellType;
	private char cellValue;

	/**
	 * This method takes an object of type player to be used by methods of the derived classes
	 * @param aPlayer
	 */
	abstract public void action(Player aPlayer);

	/**
	 * This method does the general energy update on the cell objects
	 * @param aPlayer
	 */
	public void energyUpdate(Player aPlayer) {
		// Decrease energy based on movement
			aPlayer.setEnergy(aPlayer.getEnergy() - Dice.getDie1() - Dice.getDie2());
	}

	/**
	 * This method takes a character and assignes it to the cell type, and sets the default cell value to '_'
	 * @param type
	 */
	public Cell(char type) {
		this.cellType = type;
		this.cellValue = '_';
	}

	/**
	 * This method takes a character and sets it to the cell value
	 * @param newChar
	 */
	public void setCellValue(char newChar) {
		this.cellValue = newChar;
	}

	/**
	 * This method returns the cell value
	 * @return Cell Value
	 */
	public char getCellValue() {
		return cellValue;
	}

	/**
	 * This method returns the cell Type
	 * @return Cell type
	 */
	public char getCellType() {
		return cellType;
	}
}
