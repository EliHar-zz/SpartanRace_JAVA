
/**
 * This class implements a system to keep track of the players. It contains the player's attribute like name and position.
 * It also contains the methods used by the players to movie along the board and to manage their choices.
 * @author Elias Haroun
 */
public abstract class Player {

	private String name; // Name of the player
	private int position; // Player's position on the board
	private int energy; // Player's energy level
	private static int winners = 0;// number of winners starting at 0

	/**
	 * Constructor which takes a player's name and stores it in the attribute name. 
	 * It also sets the initial location at position 0 for every player
	 * @param playerName Name of the player to be stored
	 */
	public Player(String playerName) {
		this.name = playerName;
	}

	/**
	 * Changes the position of the player based on the sum of the dice he/she rolled
	 */
	public void move() {
		this.position += (Dice.getDie1()+ Dice.getDie2());
	}

	/**
	 * Method used in the debugging mode. It takes a specific location and sets the user position to that location.
	 * @param specPosition Desired location to go to
	 */
	public void goTo(int specPosition) {
		this.position = specPosition;
	}

	/**
	 * This method takes a string and sets it as the name of the player
	 * @param newName Player's name to be stored in the attribute name
	 */
	public void setName(String newName) {
		this.name = newName; 
	}

	/**
	 * This method takes an integer and sets it as the position of the player
	 * @param newPosition Value to be stored in the attribute position
	 */
	public void setPosition(int newPosition){
		this.position = newPosition;
	}

	/**
	 * This method takes an integer and sets it as the energy level of the player
	 * @param energyLvl value to be stored in the attribute energy
	 */
	public void setEnergy(int energyLvl){
		this.energy = energyLvl;
	}

	public static void setWinners(int numWinners) {
		winners = numWinners;
	}

	/**
	 * This method returns the player's position
	 * @return Position of the player
	 */
	public int getPosition() {
		return position; 
	}

	/**
	 * This method returns the player's energy level
	 * @return Energy level of the player
	 */
	public int getEnergy() {
		return energy; 
	}

	/**
	 * This method returns the name of the player
	 * @return Player's name
	 */
	public String getName() {
		return name; 
	}

	/**
	 * This method returns the number of winners
	 * @return Number of Winners
	 */
	public static int getWinners(){
		return winners;
	}
}