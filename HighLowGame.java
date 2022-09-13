/*
 * Author: Stanley Pieda
 * Date: March 16, 2022
 * Modified by: Yi Gong
 * Modified Date:July 27, 2022
 * Due Date: August 5, 2022
 * Description: Starter Code / Sample Solution Exercise 05
 * Starter Code Note: Use the pseudocode and complete the reset and run methods
 */

import java.util.Random;

/*
 * This class represents a high low game, created object user, imported Random,
 * contains fields for fuelAvailable and numberToGuess
 * contains constants for MIN and MAX
 * There are worker methods to reset fuel, run the game, and report the game result. 

 */
public class HighLowGame {
	private User user = new User(); // internal only, no get/set
	private Random random = new Random(); // internal only, no get/set
	private int fuelAvailable;
	private int numberToGuess;
	private static final int MIN = 1; // internal only, no get/set
	private static final int MAX = 10; // internal only, no get/set

	/*
	 * No argument constructor, calls method reset to initialize the game
	 */
	public HighLowGame() {
		reset();
	}
	/*
	 * Accessor for fuelAvailable
	 */
	public int getFuelAvailable() {
		return fuelAvailable;
	}
	/*
	 * Mutator for fuelAvailable
	 */
	public void setFuelAvailable(int fuelAvailable) {
		this.fuelAvailable = fuelAvailable;
	}
	/*
	 * Access for numberToGuess
	 */
	public int getNumberToGuess() {
		return numberToGuess;
	}
	/*
	 * Mutator for numberToGuess
	 */
	public void setNumberToGuess(int numberToGuess) {
		this.numberToGuess = numberToGuess;
	}
	/*
	 * Method reset() is to set the number of initial fuels
	 * by adding numbers from MIN to MAX (1-10) and divide by 2.
	 */
	public void reset() {
		int sum = 0;
	// random.nextInt(MAX) returns a value from 0 to (MAX - 1)
    // so add 1 to get a number between 1 to MAX inclusive
    numberToGuess = random.nextInt(MAX) + 1;
    
    for(int value = MIN; value <= MAX; value++) {
    	sum = sum + value;
    }
    fuelAvailable = sum / 2;
	}
	/*
	 * Method run() is made to run the game and calculate the available fuel
	 * after guesses have been entered.
	 */
	public void run() {
		
		CheckGuessResult checkGuessResult = null;
		String message;
		boolean isWon = false;
		int guessCount = 0;
		int userNumber;
		System.out.printf("Guess the number from %d to %d%n", MIN, MAX);
		System.out.printf("You have %d guess-fuel remaining%n", fuelAvailable);
		
		while(fuelAvailable > 0 && isWon == false) {
			guessCount = guessCount + 1;
			userNumber = user.inputInteger("guess: ");
			
			// first loop control variable adjustment
			fuelAvailable = fuelAvailable - userNumber;
			
            // let them have this last play, but prevent negative
            // fuel values in the output
			if(fuelAvailable < 0 ) {
				fuelAvailable = 0;
			}
			// second loop control variable adjustment
			checkGuessResult = checkGuess(userNumber);
						
			isWon = checkGuessResult.isWin();
						
			message = checkGuessResult.getMessage();
						
			System.out.println(message); // in game messaging
			}
				       
			message = reportGameResult(isWon, guessCount);
			System.out.println(message);
				}
	/*
	 * This method examines the guess to see if it matches the numberToGuess
	 * value. To report win or no-win, with a message as well a CheckGuessResult
	 * instance is created with these results, and the reference to the
	 * CheckGuessResult object is returned.
	 */
	private CheckGuessResult checkGuess(int guess) {
		boolean isWin = false;
		String message;

		if (guess == numberToGuess) {
			message = "You guessed the number";
			isWin = true;
		}
		else {
			if(guess < numberToGuess) {
				message = "too low, ";
			}
			else {
				message = "too high, ";
			}
			message = message + String.format(
					"%d guess-fuel remaining", fuelAvailable);
		}
		CheckGuessResult checkGuessResult = new CheckGuessResult(message, isWin);
		return checkGuessResult;
	}
	/*
	 * This method writes out a final result of the game (win or lose) as well
	 * as the number of guesses used by the player (i.e. the user).
	 */
	private String reportGameResult(boolean isWon, int guessCount) {
		String message;
		if(isWon) {
			message = "You win! It took you ";
		}
		else {
			message = "You did not win, you used ";
		}
		message = String.format(message + "%d guesses", guessCount);
		return message;
	}
}
