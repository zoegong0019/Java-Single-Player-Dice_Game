/*
 * Author: Stanley Pieda
 * Date: March 16, 2022
 * Modified by: Yi Gong
 * Modified Date:July 27, 2022
 * Due Date: August 5, 2022
 * Description: Starter Code / Sample Solution Exercise 05
 * Starter Code Note: Use the pseudocode and complete the reset and run methods
 */

public class CheckGuessResult {
	
	private String message;
	private boolean isWin;
	
	public CheckGuessResult() {
		this("on game",false);
	}

	public CheckGuessResult(String message, boolean isWin) {
		this.message = message;
		this.isWin = isWin;
	}

	public boolean isWin() {
		// TODO Auto-generated method stub
		return isWin;
	}
	
	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		String report;
		report = "CheckGuessResult : message "+ message + ", ";
		return report = report + "isWin "+isWin;			
	}	
}
