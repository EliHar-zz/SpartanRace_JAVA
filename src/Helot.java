/**
 * This class extends the Player class to a more specific type of player, Helot
 * @author Elias Haroun
 */
public class Helot extends Player{

	/**
	 * This method takes the String name and assigns it to the alling object, and sets the position and energy level
	 * @param name
	 */
	public Helot(String name) {
		super("h_"+name);
		this.setPosition(40);
		this.setEnergy(60);
	}

}
