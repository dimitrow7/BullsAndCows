import java.util.Random;
import java.util.Scanner;

// Създаваме произволно число в границите 1000 - 9999
public class TheGame { 
	public static void main(String[] args) {
		Random r = new Random();
		int number = 0;
		while (uniq(number = (r.nextInt(9000) + 1000)))
			;
		System.out.println(number);
	}

	// Създаваме метод, който да проверява дали числото е уникално
	public static boolean uniq(int num) {
		String checknum = num + "";
		if (checknum.charAt(0) == checknum.charAt(1))
			return false;
		else if (checknum.charAt(1) == checknum.charAt(2))
			return false;
		else if (checknum.charAt(2) == checknum.charAt(3))
			return false;
		return true;
	};
}