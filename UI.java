import java.util.Scanner;

public class UI {

	public static void main(String[] args) {
		UI newUi = new UI();
		Scanner sc = new Scanner(System.in);
		Game newGame = new Game();

		System.out.println("Player 1: 1 for Human, 2 for Comp");
		newGame.setPlayerOne(newUi.allocatePlayer(sc.nextInt()));

		System.out.println("Player 2: 1 for Human, 2 for Comp");
		newGame.setPlayerTwo(newUi.allocatePlayer(sc.nextInt()));

		System.out.println("Player 1 plays with X or 0 ?");
		newGame.settingSigns(sc.next().toString());

		newGame.startGame();
		newGame.runTime();

		System.out.println("Goodbuy");
		sc.close();
	}

	public Player allocatePlayer(int i) {
		Player player = null;
		if (i == 1) {
			player = new Human();
		} else if (i == 2) {
			player = new Comp();
		}
		return player;
	}
}