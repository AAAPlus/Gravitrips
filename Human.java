import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {
	
	int hChoice;

	public int getHit() {
		boolean attemp = false;
		do {
			try {
				System.out.println("Enter your number from 1 to 7!");
				Scanner scc = new Scanner(System.in);
				hChoice = scc.nextInt();
				if (hChoice < 1 || hChoice > 7)
					throw new OutOfRangeException();
				attemp = true;
			} catch (InputMismatchException e) {
				System.out.println("Wrong!!! Enter a number!!!");
			} catch (OutOfRangeException e) {
				System.out.println("number is out of range!");
			}
		} while (attemp != true);
		return hChoice - 1;	
	}
}
