import java.util.Random;
import java.util.Scanner;

public class TheGame {
	public static void main(String[] args) {
		Random r = new Random();
		int number = 0;
		int trynum = 0;
		while (uniq(number = (r.nextInt(9000) + 1000)))
			;
		String targetStr = number + "";
		boolean game = true;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Test num: " + number);
			int bulls = 0;
			int cows = 0;
			System.out.print("Guess a number: ");
			int guess;
			guess = input.nextInt();
			if (guess > 9999 || guess < 1000) {
				System.out.println("err");
				continue;
			}
			trynum++;
			String guessStr = guess + "";
			// System.out.println(guessStr + "");
			for (int i = 0; i < 4; i++) {
				if (guessStr.charAt(i) == targetStr.charAt(i)) {
					bulls++;
				} else if (targetStr.contains(guessStr.charAt(i) + "")) {
					cows++;
				}
			}
			if (bulls == 4) {
				game = false;
			} else {
				System.out.println(cows + " Cows and " + bulls + " Bulls.");
			}
		} while (game);
		System.out.println("You won after " + trynum + " guesses!");
	}

	public static boolean uniq(int number) {
		String checknum = number + "";
		if (checknum.charAt(0) == checknum.charAt(1))
			return false;
		else if (checknum.charAt(1) == checknum.charAt(2))
			return false;
		else if (checknum.charAt(2) == checknum.charAt(3))
			return false;
		return true;
	};
}