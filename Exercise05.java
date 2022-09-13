/*
 * Author: Stanley Pieda
 * Date: March 16, 2022
 * Modified by: Yi Gong
 * Modified Date: July 27, 2022
 * Due date: August 5, 2022
 * Description: Starter Code / Sample Solution Exercise 05
 * Starter Code Note: Use the pseudocode and complete the main method
 */

/*
 * This class only contains method main, to drive the application.
 */
public class Exercise05 {
	
	/*
	 * Entry point for the application, the program in main method is to 
	 * begin a number guess game, it prompts the user to enter number between 1-10
	 * with given 27 fuels. Game is over when user guesses the number or
	 * fuels are all used (fuels are deducted by guess number entered until reaches 0),
	 * lastly, it prompts the used to enter (Y/N) to continue or exit.
	 */
	public static void main(String[] args) {
		User user = new User();
		HighLowGame game = new HighLowGame();

		final String CONTINUE_GAME = "Y";
		final String EXIT_GAME = "N";
		String shouldContinue = EXIT_GAME;

		do {
			if (shouldContinue.equalsIgnoreCase(CONTINUE_GAME)) { //case insensitive
				game.reset();
			}

			game.run();
			shouldContinue = user.inputString("Would you like to play again? (Y/N) ");

		} while (shouldContinue.equalsIgnoreCase(CONTINUE_GAME)); //case insensitive

		System.out.println("Program by Yi Gong");

		
	} //stop method main
	
} //end class	
		

