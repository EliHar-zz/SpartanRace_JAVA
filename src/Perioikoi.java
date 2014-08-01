/**
 * This class extends the Player class to a more specific type of player
 * @author Elias Haroun
 */
public class Perioikoi extends Player {

	/**
	 * This constructor takes a String name and sets it to the object, as well as sets the position and starting energy level
	 * @param name
	 */
	public Perioikoi(String name) {
		super("p_"+name);
		this.setPosition(0);
		this.setEnergy(130);
	}
}
