//********************************************************************************************
// Spartan Race
// Written by Elias Haroun
//********************************************************************************************

import java.util.InputMismatchException;
import java.util.Scanner; // Imports the class Scanner
import java.io.*;

/**
 * This program runs the boardgame The Spartan Race v3.0. In this game, the user will choose between play mode or debugging mode.
 * After that, the user will enter the number of racers then will enter their names and type. In the play mode,
 * the users will be rolling the dice to determine their next location on the board. If they land on an obstacle,
 * they need to act according to the dictated situation, whether to draw a card and follow the instructions on it,
 * spin the wheel and follow it's instructions, more to location 68 or choose between drawing a card or spinning the wheel.
 * The first one to arrive at location 90 on the board will be declared the winner, all output will be stored in a text file.
 * However in the debug mode, the user input will be taken from an input text file, and all output will be stored in an output text file.
 * @author Elias Haroun
 * @version 3.0
 */
public class BoardGame {

 private static int mode; // Debug or Game mode

 /**
  * This method returns the mode value entered by the user
  * @return The mode value
  */
 public static int getMode(){
  return mode;
 }

 /**
  * This is the main method in the program that does all the control and displays the program
  * @param args
  * @throws DieValueOutOfBoundsException 
  */
 public static void main(String[] args) throws DieValueOutOfBoundsException {

  resetFile();

  Helper.welcome(); // Displays welcome message

  Cell[] cells = new Cell[90];

  // Reset track at the beginning of the game
  RaceTrack.resetTrack(cells);

  Scanner keyIn = new Scanner(System.in); // Declares and initializes keyIn of type Scanner

  // Creates a file reader
  Scanner reader = null;
  try {
   reader = new Scanner (new FileInputStream ("debug_input.txt"));
  } catch (FileNotFoundException e) {
   print("The file is not found. Make sure you create the file \"debug_input.txt\" and place it the project directory.\n\n\n");
   System.exit(0);
  }

  String answer = ""; // Player's answer to decide whether to play the game or not
  int numRacers = 0;
  do {
   try{
    // User decides between play mode or debugging mode
    print("\n\nEnter 0 to play the game, 1 for test mode: ");
    mode = keyIn.nextInt();
    printOut(mode);

    // Error Message
    while (mode != 1 && mode != 0) {
     print("\nInvalid number... Enter 0 to play the game, 1 for test mode: \n");
     mode = keyIn.nextInt();
     printOut(mode);
    }
   } catch (InputMismatchException e) {
    print("The entered value is not a 0 or 1\n");

    System.exit(0);
   }

   print("\nHow many racers will there be (2 to 4)? ");
   try{

    if (mode == 0){
     numRacers = keyIn.nextInt();
     printOut(numRacers);
    }
    else if (mode == 1) {

     if (reader.hasNext()) {
      numRacers = reader.nextInt(); 
      printOut(numRacers);
     } else {
      print("\nThe input file has no more data.\n");
      System.exit(0);
     }
    }
    if (mode == 1 && (numRacers<2 || numRacers>4)) {
     print("\nThe number entered is out of bound... The program will now exit\n");
     System.exit(0);
    }

    // Error message
    while(numRacers<2 || numRacers>4){
     print("   "+numRacers+" racer(s) is not possible. The track can accommodate 2 to 4 players only.\n");
     print("So how many racers?");

     numRacers = keyIn.nextInt(); 
     printOut(numRacers);
    }
   } catch (InputMismatchException e) {
    print("\nThe entered value is not a number between 2 and 4\n");
    System.exit(0);
   }

   //Array of players (objects) of type Player
   Player [] players = new Player[numRacers];

   for(int i=0; i<numRacers;i++){
    print("\nName of Racer #"+(i+1)+" please: ");

    String playerName = null;

    if (mode == 0) {
     playerName = keyIn.next(); // User input the names
     printOut(playerName); 
    }
    else if (mode == 1) {

     if (reader.hasNext()) {
      playerName = reader.next(); 
      print(playerName);
     } else {
      print("\nThe input file has no more data.\n");
      System.exit(0);
     }
    }
    // Only show the types ones
    if (i==0){
     print("\nType of Players:\n");
     print("\n\t1. Spartiate: Starts at position 20 with 100 units of energy.\n");
     print("\t2. Helot: Starts at position 40 with 60 units of energy.\n");
     print("\t3. Perioikoi: Starts at position 0 with 130 units of energy.\n");
    }

    print("\nWhat type of player are you? Enter 1, 2 or 3: ");

    int playerType = 0;

    try{

     if (mode == 0) {
      playerType = keyIn.nextInt(); // User input the names
      printOut(playerType); 
     }
     else if (mode == 1) {

      if (reader.hasNext()) {
       playerType = reader.nextInt(); 
       printOut(playerType);
      } else {
       print("\nThe input file has no more data.\n");
       System.exit(0);
      }
     }

     if (mode == 1 && (playerType<1 || playerType>3)) {
      print("\nThe number entered is out of bound... The program will now exit\n");
      System.exit(0);
     }

     // Error message
     while(playerType<1 || playerType>3){
      print("\nInvalid number. Choose from the list above (Enter 1, 2 or 3): ");
      playerType = keyIn.nextInt(); // User input the names
      printOut(playerType);
     }
    } catch (InputMismatchException e) {
     print("\nThe entered value is not a number between 1 and 3\n");
     System.exit(0);
    }
    switch(playerType) {

    case 1: // player will be assigned name and set position to 20 and energy to 100
     players[i] = new Spartiate(playerName);
     break;
    case 2: // player will be assigned name and set position to 40 and energy to 60
     players[i] = new Helot(playerName);
     break;
    case 3: // player will be assigned name and set position to 0 and energy to 130
     players[i] = new Perioikoi(playerName);
     break;
    }
   }

   Helper.prepStart(); // Message to players

   int maxPosition = players[0].getPosition(); // At the beginning the maximum position will be that of player 1

   int losers = 0; // counts the number of losers, whose energy reached 0.

   // The loop of the game will run as long as no one has reached the final location, position 90
   while (maxPosition<90) {

    if (losers == players.length-1)
     break;

    for(int i = 0; i<players.length;i++){

     if (losers == players.length-1)
      break;
     // If the player has no energy, skip them and move to the next player
     if(players[i].getEnergy() <= 0) {
      continue;
     }

     print("\n\nPlayer "+players[i].getName()+" - Enter a "+(i+1)+" to roll the dice: ");
     int userNum = 0;
     try {
      userNum = keyIn.nextInt(); // Player enters his number to roll the dice
      printOut(userNum);
      // Error Message
      while(userNum!=(i+1)){
       print("Invalid number. Please enter a "+(i+1)+" to roll the dice: ");
       userNum = keyIn.nextInt(); // Player enters his number to roll the dice
       printOut(userNum);
      }
     } catch (InputMismatchException e) {
      print("The entered value is not a number\n");

      System.exit(0);
     }
     // In play mode
     if (mode==0) {
      Dice.throwDice(); // Will generate dice values
      players[i].move(); // Will change player's position according to the value of the dice
      print("\nYou rolled a "+Dice.getDie1()+" and a "+Dice.getDie2()+"."); // Display dice value
     }

     // In debugging mode
     else if (mode==1){
      // Manually input dice value

      int die1 = 0;
      int die2 = 0;

      try {

       if (reader.hasNext())
        die1 = reader.nextInt();
       else {
        print("\nThe input file has no more data.\n");
        System.exit(0);
       }

       if (reader.hasNext())
        die2 = reader.nextInt();
       else {
        print("\nThe input file has no more data.\n");
        System.exit(0);
       }

       Dice.setDie1(die1);
       Dice.setDie2(die2);

       print("\nYou rolled a "+Dice.getDie1()+" and a "+Dice.getDie2()+"."); // Display dice value

       if (Dice.getDie1() < 1 || Dice.getDie2() < 1 || Dice.getDie1() > 6 || Dice.getDie2() > 6 )
        throw new DieValueOutOfBoundsException ("The entered value of dice is out of bound.");

       players[i].move(); // Will change player's position according to the value of the dice
      } catch (InputMismatchException e) {
       print("\nThe entered value is not a number\n");
       System.exit(0);
      } catch (DieValueOutOfBoundsException e2) {
       print(e2.getMessage()+"\n");
       print("The program will now close...\n");

       System.exit(0);
      }

     }
     int tempValue = 0;
     if (players[i].getPosition()>0 && players[i].getPosition()<90)
      tempValue = players[i].getPosition();
     else if (players[i].getPosition()>=90)
      tempValue = 90;

     // Takes action based on the player's location
     switch(tempValue) {

     // User will pick a card of fortune if landed on those positions
     case 10:
     case 30:
     case 50:
     case 70: 
      cells[tempValue-1].energyUpdate(players[i]);
      if (players[i].getEnergy() <= 0)
       print ("");
      else
       print("\nYou're at location "+players[i].getPosition()+". \n"); // Displays current location
      cells[tempValue-1].action(players[i]);
      break;

      // Player will take shortcut to position 68
     case 20:  
     case 55:   
      cells[tempValue-1].energyUpdate(players[i]);
      if (players[i].getEnergy() <= 0)
       print("");
      else
       print("\nYou're at location "+players[i].getPosition()+". \n"); // Displays current location
      cells[tempValue-1].action(players[i]);
      break;

      // Player will spin the wheel if landed on those positions
     case 40:
     case 60:
     case 80: 
      cells[tempValue-1].energyUpdate(players[i]);
      if (players[i].getEnergy() <= 0)
       print("");
      else
       print("\nYou're at location "+players[i].getPosition()+". \n"); // Displays current location
      cells[tempValue-1].action(players[i]);
      break;

      // Player gets to choose to pick a card or spin the wheel
     case 17:
     case 37:  
     case 57: 
      print("\nEnter 'w' to spin the wheel or 'c' to pick a card: ");
      try {
       char userInput = 'a';
       JokerCell.setUserPref(0); // reset userPref

       if (mode == 0) {
        userInput = keyIn.next().charAt(0);
        printOut(""+userInput); 
       }
       else if (mode == 1) {
        if (reader.hasNext()) {
         userInput = reader.next().charAt(0);
         print(""+userInput);
        } else {
         print("\nThe input file has no more data.\n");
         System.exit(0);
        }
       }
       if (userInput == 'c')
        JokerCell.setUserPref(2); // User makes decision
       else if (userInput == 'w')
        JokerCell.setUserPref(1);

       if (mode == 1 && JokerCell.getUserPref()!=1 && JokerCell.getUserPref()!=2) {
        print("\nThe entered charachter is invalid. The program will quit...\n");
        System.exit(0);
       }

       // Error message
       while (JokerCell.getUserPref()!=1 && JokerCell.getUserPref()!=2){
        print("\nInvalid character... Enter 'w' to spin the wheel or 'c' to pick a card: ");

        userInput = keyIn.next().charAt(0);
        printOut(""+userInput);

        if (userInput == 'c')
         JokerCell.setUserPref(2); // User makes decision
        else if (userInput == 'w')
         JokerCell.setUserPref(1);
       }
      } catch (Exception e) {
       print("\nThe value entered is not a character\n");
      }

      cells[tempValue-1].energyUpdate(players[i]);
      if (players[i].getEnergy() <= 0)
       print ("");
      else
       print("\nYou're at location "+players[i].getPosition()+". \n"); // Displays current location

      cells[tempValue-1].action(players[i]);

      break;

      // In case player didn't land on an obstacle
     default:
      cells[tempValue-1].energyUpdate(players[i]);
      if (players[i].getEnergy() <= 0)
       print("");
      else
       print("\nYou're at location "+players[i].getPosition()+". \n"); // Displays current location
      cells[tempValue-1].action(players[i]);
     }

     if (players[i].getEnergy()<=0) {
      print("Oops O_O ... Your have no energy left. You lose :(\n\n\n");
      players[i].setPosition(0);
      losers++;
     }
     else
      print("Your energy level is at: "+players[i].getEnergy()+" units.\n\n\n");


     // Modify race track based on player's position
     RaceTrack.modCellNum(cells, players[i].getPosition());

     // Condition of while loop, setting maxPosition to the highest position on the board
     if (maxPosition < players[i].getPosition())
      maxPosition = players[i].getPosition();

     if (mode == 1)
      if (reader.hasNextLine())
       reader.nextLine();// Moves to next line in the input file
      else {
       print("No more data in the file\n");

       System.exit(0);
      }
    }

    // Prints the board after the modification.
    RaceTrack.printRaceTrack(cells);

    // Once the board is printed on the screen, it will be reset for future modifications
    RaceTrack.resetTrack(cells);
   }

   // Displays the number of winners
   print("We have "+Player.getWinners());

   // Determines winner/winners for appropriate output
   if (Player.getWinners()>1) {
    print(" winners!\n");
    print("Congratualtion to:\n");
   }
   else if (Player.getWinners() == 1){
    print(" winner!\n");
    print("Congratualtion to:\n");
   }
   else if (Player.getWinners() == 0)
    print(" winners! GAME OVER\n\n");

   // Prints only names of the winners
   for (int i=0; i<players.length; i++) {
    if (players[i].getPosition() >= 90)
     print("\t"+players[i].getName()+"\n");
   }

   // If some players didn't win
   if (Player.getWinners()>0 && Player.getWinners() < players.length)
    print("\n\nThe rest of you will be sold as slaves!\n");
   else if (Player.getWinners() == players.length) // all players have won
    print("\n\nWOW!! You've all made it!\n");

   // Ask player to play again
   if (mode == 0)
    print("\n\nWould you like to play again? (1 for YES, anything for NO) ");
   else if (mode == 1) {
    print("\n\nThank you for playing the game ... Goodbye.");

    System.exit(0);
   }

   // User's new answer
   answer = keyIn.next();
   printOut(answer);
   if (!answer.equals("1")) {
    print("Thank you for playing The Spartan Race version "+Helper.getVersion()+"\n"); // Goodbye message

    System.exit(0); // Shuts down the program
   }

  } while (answer.equals("1")); // Keep running the program as long as the users's answer is 1
 }

 /**
  * A static method that takes a String as parameter and ouputs its value on the screen and in the output file.
  * @param str
  */
 public static void print(String str) {
  PrintWriter writer = null;
  try {
   writer = new PrintWriter (new FileOutputStream ("race_out.txt", true));
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  System.out.print(str);
  writer.print(str);
  writer.flush();
 }

 // Assisting static methods

 /**
  * A static method that takes a String as parameter and ouputs its value in the output file.
  * @param str
  */
 public static void printOut(String str) {
  PrintWriter writer = null;
  try {
   writer = new PrintWriter (new FileOutputStream ("race_out.txt", true));
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  writer.print(str);
  writer.flush();
 }

 /**
  * A static method that takes an integer as parameter and ouputs its value in the output file.
  * @param num
  */
 public static void printOut(int num) {
  PrintWriter writer = null;
  try {
   writer = new PrintWriter (new FileOutputStream ("race_out.txt", true));
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  if (mode == 0)
   writer.print(num);
  else if (mode == 1) {
   writer.print(num);
   System.out.print(num);
  }
  writer.flush();
 }

 /**
  * A static method that resets the output file at the beginning of program.
  */
 public static void resetFile() {
  PrintWriter writer = null;
  try {
   writer = new PrintWriter (new FileOutputStream ("race_out.txt"));
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  }
  writer.print("");
  if (writer != null)
   writer.close();
 }
}
// End of program Spartan Race v3.0