/**
 * This class extends the Player class to a more specific type of player, Spartiate
 * @author Elias Haroun
 */
public class Spartiate extends Player {

	/**
	 * This constructor takes the String name, assign it to the calling object, and sets the position and energy level as well.
	 * @param name
	 */
	public Spartiate(String name) {
		super(name);
		this.setPosition(20);
		this.setEnergy(100);
	}
}
