/**
 * This class implements a system of methods for the wheel of fortune. Action, Update energy and return cell type.
 * @author Elias Haroun
 */
public class WheelOfFortuneCell extends Cell {

	public WheelOfFortuneCell(char newChar) {
		super(newChar);
	}

	/**
	 * This method takes an object of type Player and does the action based on the cell type
	 */
	public void action(Player aPlayer){
		BoardGame.print("Spinning the wheel of fortune. ");
		WheelOfFortune.spinWheel();

		// Player goes back to position 0
		if (WheelOfFortune.getWheelValue() == 0) {
			aPlayer.setPosition(0);
			BoardGame.print("You are back to position "+aPlayer.getPosition()+"\n\n");
		}

		// Player moves backward
		else if (WheelOfFortune.getWheelValue() < 0) {
			BoardGame.print("Go back "+Math.abs(WheelOfFortune.getWheelValue())+". ");
			aPlayer.setPosition(aPlayer.getPosition()+WheelOfFortune.getWheelValue());
			BoardGame.print("You are at location "+aPlayer.getPosition()+"\n\n");  
		}

		// Player moves forward
		else if (WheelOfFortune.getWheelValue() > 0) {
			BoardGame.print("Go forward "+WheelOfFortune.getWheelValue()+". ");
			aPlayer.setPosition(aPlayer.getPosition()+WheelOfFortune.getWheelValue());
			BoardGame.print("You are at location "+aPlayer.getPosition()+"\n\n");    
		}
	}

	/**
	 * This method takes an object of type Player and update its energy based on this cell type
	 */
	public void energyUpdate(Player aPlayer){
		super.energyUpdate(aPlayer);
		aPlayer.setEnergy(2*aPlayer.getEnergy()); // Energy doubles
	}

	/**
	 * This method returns cell the cell type
	 * @return Cell type
	 */
	public char getCellType() {
		return super.getCellType();
	}

}
