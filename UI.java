import java.util.Scanner;

public class UI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game newGame = new Game();

		System.out.println("Player 1: 1 for Human, 2 for Comp");
		newGame.setPlayerOne(allocatePlayer(sc.nextInt()));

		System.out.println("Player 2: 1 for Human, 2 for Comp");
		newGame.setPlayerTwo(allocatePlayer(sc.nextInt()));

		newGame.setCurrentPlayer();

		System.out.println("Player 1 plays with X or 0 ?");
		newGame.settingSigns(sc.next().toString());

		newGame.runTime();

		System.out.println("Goodbuy");
		sc.close();
	}

	public static Player allocatePlayer(int i) {
		Player player = null;
		if (i == 1) {
			player = new Human();
		} else if (i == 2) {
			player = new Comp();
		}
		return player;
	}
}