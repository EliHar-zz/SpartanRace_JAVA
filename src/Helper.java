	/**
	 * This class contains helper that will display the welcome message, program's version, and a
	 * message to players prior to starting the game
	 * @author Elias Haroun
	 */
public class Helper {
	
	private static final double VERSION = 3.0; // Program's version

	/**
	 * Static method that will display a welcome message
	 */
	public static void welcome(){
		System.out.println("\t\t-------------------------------");
		System.out.println("\t\t|\tWelcome to \t\t|");
		System.out.println("\t\t| Spartan Race - Version "+VERSION+"\t|");
		System.out.println("\t\t-------------------------------\n\n");
	}

	/**
	 * Static method that will display a message to the players proior to starting the game
	 */
	public static void prepStart(){
		System.out.println("\n\nWelcome racers ... how many of you will be sold as slaves today ... Hahahaha :D");
		System.out.println("Ready ... Set ... Go!\n");
	}

	/**
	 * Method that will get the current version of the program
	 * @return Version of the program
	 */
	public static double getVersion() {
		return VERSION; 
	}
}