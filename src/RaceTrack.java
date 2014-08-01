import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * This class implements the race track's methods. To rest the track, update it's cells and print it.
 * @author Elias Haroun
 */
public class RaceTrack {

	/**
	 * This method takes an array of objects Cell, resets each cell to it's default values.
	 * @param arrayOfCells
	 */
	public static void resetTrack(Cell[] arrayOfCells) {
		for(int i = 0; i<arrayOfCells.length; i++){
			switch(i) {

			case (10-1):
			case (30-1):
			case (50-1):
			case (70-1): 
				arrayOfCells[i] = new DeckOfFortuneCell('D');
			break;

			// Player will take shortcut to position 68
			case (20-1):  
			case (55-1):   
				arrayOfCells[i] = new SkipCell('S');
			break;

			// Player will spin the wheel if landed on those positions
			case (40-1):
			case (60-1):
			case (80-1): 
				arrayOfCells[i] = new WheelOfFortuneCell('W');
			break;

			// Player gets to choose to pick a card or spin the wheel
			case (17-1):
			case (37-1):  
			case (57-1): 
				arrayOfCells[i] = new JokerCell('?');
			break;

			// In case player didn't land on an obstacle
			default:
				arrayOfCells[i] = new RegularCell(' ');
			}
		}
	}

	/**
	 * This method takes an array of objects of type Cell, the number of the cell and the new value that the set will
	 * have. It changes the cells' values according to the players' position.
	 * @param arrayOfCells
	 * @param cellNum
	 * @param newCellValue
	 */
	public static void setCellValue_To(Cell[] arrayOfCells, int cellNum, char newCellValue) {
		arrayOfCells[cellNum - 1].setCellValue(newCellValue);
	}

	public static void modCellNum(Cell[] arrayOfCells, int cellNum){
		// Moving players on the board. Numbers on the board correspond to how many players are in that location
		// Position from 1 to 30
		if (cellNum > 0 && cellNum <= 30)
			switch(arrayOfCells[cellNum - 1].getCellValue()) {

			case '_': setCellValue_To(arrayOfCells, cellNum, '1');
			break;

			case '1': setCellValue_To(arrayOfCells, cellNum, '2');
			break;

			case '2': setCellValue_To(arrayOfCells, cellNum, '3');
			break;

			case '3': setCellValue_To(arrayOfCells, cellNum, '4');
			break;
			}

		// Position from 31 to 60
		else if (cellNum > 30 && cellNum <= 60)
			switch(arrayOfCells[cellNum-1].getCellValue()) {

			case '_': setCellValue_To(arrayOfCells, cellNum, '1');
			break;

			case '1': setCellValue_To(arrayOfCells, cellNum, '2');
			break;

			case '2': setCellValue_To(arrayOfCells, cellNum, '3');
			break;

			case '3': setCellValue_To(arrayOfCells, cellNum, '4');
			break;
			}

		// Position from 61 to 89
		else if (cellNum > 60 && cellNum < 90)
			switch(arrayOfCells[cellNum-1].getCellValue()) {

			case '_': setCellValue_To(arrayOfCells, cellNum, '1');
			break;

			case '1': setCellValue_To(arrayOfCells, cellNum, '2');
			break;

			case '2': setCellValue_To(arrayOfCells, cellNum, '3');
			break;

			case '3': setCellValue_To(arrayOfCells, cellNum, '4');
			break;
			}

		// If player's dice roll moves them on or further than position 90
		else if (cellNum >= 90) {

			Player.setWinners(Player.getWinners()+1); // Counting the winners

			// Placing all the winners on position 90 on the board, even if they landed at a higher number
			switch(arrayOfCells[89].getCellValue()) {

			case '_': setCellValue_To(arrayOfCells, 90, '1');
			break;

			case '1': setCellValue_To(arrayOfCells, 90, '2');
			break;

			case '2': setCellValue_To(arrayOfCells, 90, '3');
			break;

			case '3': setCellValue_To(arrayOfCells, 90, '4');
			break;
			}
		}
	}

	/**
	 * This method takes an array of objects of type Cell, and prints the cells with their types to draw the updated track
	 * @param arrayOfCells
	 */
	public static void printRaceTrack(Cell[] arrayOfCells) {

		for(int i=0; i<arrayOfCells.length; i++) {
			if (i>=0 && i<=29)
				BoardGame.printOut(arrayOfCells[i].getCellValue()+" ");
		}
		BoardGame.printOut("\n");

		for(int i=0; i<arrayOfCells.length; i++) {
			if (i>=0 && i<=29)
				BoardGame.printOut(arrayOfCells[i].getCellType()+" ");
		}
		BoardGame.printOut("\n\n");

		for(int i=0; i<arrayOfCells.length; i++) {
			if (i>=30 && i<=59)
				BoardGame.printOut(arrayOfCells[i].getCellValue()+" ");
		}
		BoardGame.printOut("\n");

		for(int i=0; i<arrayOfCells.length; i++) {
			if (i>=30 && i<=59)
				BoardGame.printOut(arrayOfCells[i].getCellType()+" ");
		}

		BoardGame.printOut("\n\n");
		for(int i=0; i<arrayOfCells.length; i++) {
			if (i>=60 && i<=89)
				BoardGame.printOut(arrayOfCells[i].getCellValue()+" ");
		}
		BoardGame.printOut("\n");

		for(int i=0; i<arrayOfCells.length; i++) {
			if (i>=60 && i<=89)
				BoardGame.printOut(arrayOfCells[i].getCellType()+" ");
		}

		BoardGame.printOut("\n");
	}
}
