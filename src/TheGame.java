import java.util.Random;
import java.util.Scanner;

/**
 * Bulls and cows game. The program creates a random 4 digit secret number. The
 * digits is all different. Then, in turn, the player try to guess this number.
 * If the matching digits are in their right positions, they are "bulls", if in
 * different positions, they are "cows". Example: Secret number: 4271 | Player
 * try: 1234 | Answer: 1 bull and 2 cows. (The bull is "2", the cows are "4" and
 * "1".)
 *
 * @author Vladimir Dimitrow
 * @version 1.0
 * @since 2016-01-22
 */

public class TheGame {
	public static void main(String[] args) {
		wellcomeMsg();
		Random r = new Random();
		int secretNumber = 0;
		int trynum = 0;
		// Generate a new number until meet the condition of the method
		// uniqueNumber
		do {
			secretNumber = (r.nextInt(9000) + 1000);
		} while (!uniqueNumber(secretNumber));
		String secretStr = String.valueOf(secretNumber);
		boolean game = true;
		boolean quit = false;
		Scanner input = new Scanner(System.in);
		//
		do {
			//System.out.println("Test num: " + secretNumber);
			int bulls = 0;
			int cows = 0;
			System.out.print("Try to guess the secret number: ");
			int guess;
			guess = input.nextInt();
			// If the user enters the rescue code "919191", the game ends.
			if (guess == 919191) {
				quit = true;
				game = false;
				break;
			}
			// Convert the secret number to String for more easily comparisons.
			// Add zero to beginning of String, if "guess" start with zero.
			String guessStr = String.format("%04d", guess);
			if (!uniqueNumber(guess)) {
				System.out.println(
						"\nYou entered a WRONG number. Accepted only four digit number with no duplicate digits.");
				continue;
			}
			trynum++;
			for (int i = 0; i < 4; i++) {
				if (guessStr.charAt(i) == secretStr.charAt(i)) {
					bulls++;
				} else if ((secretStr.contains(guessStr.charAt(i) + ""))) {
					cows++;
				}
			}
			if (bulls == 4) {
				game = false;
			} else {
				System.out.println("\n" + cows + " Cows and " + bulls + " Bulls.\n");
			}
		} while (game);
		if (quit) {
			surrenderMsg(trynum, secretNumber);
		} else {
			winMsg(trynum, secretNumber);
		}
	}

	// Comparing each number with the next after him. If meet identical the
	// method
	// returns false
	public static boolean uniqueNumber(int secretNumber) {
		String checknum = String.valueOf(secretNumber);
		if (checknum.length() != 4) {
			return false;
		}
		if (checknum.charAt(0) == checknum.charAt(1)) {
			return false;
		} else if (checknum.charAt(1) == checknum.charAt(2)) {
			return false;
		} else if (checknum.charAt(2) == checknum.charAt(3)) {
			return false;
		} else {
			return true;
		}
	}

	// Methods responsible for the messages that the user receives during the}
	// game.
	public static void wellcomeMsg() {
		System.out.println("******************************************" + "\n*                                        *"
				+ "\n*     WELCOME to Cows and bulls game     *" + "\n*     Try to guess our secret number     *"
				+ "\n*                                        *" + "\n*  If you want to QUIT just type 919191  *"
				+ "\n*                                        *" + "\n******************************************\n");
	}

	public static void surrenderMsg(int trynum, int number) {
		System.out.println("\nYou surrender after " + trynum + " attempts!");
		System.out.println("The secret number you are trying to guess is " + number);
		System.out.println("Please dont give up and try again soon :)");
	}

	public static void winMsg(int trynum, int number) {
		if (trynum > 10) {
			System.out.println("\n******************************************"
					+ "\n*                                        *" + "\n*             CONGRATULATION!            *"
					+ "\n*          You Win in " + trynum + " attempts!       *" + "\n*       The secret number is "
					+ number + ".       *" + "\n*                                        *"
					+ "\n******************************************\n");
		} else if (trynum < 10) {
			System.out.println("\n******************************************"
					+ "\n*                                        *" + "\n*             CONGRATULATION!            *"
					+ "\n*          You Win in " + trynum + " attempts!        *" + "\n*       The secret number is "
					+ number + ".       *" + "\n*                                        *"
					+ "\n******************************************\n");
		}
	}
}