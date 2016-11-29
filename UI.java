import java.util.Scanner;

public class UI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game newGame = new Game();

		System.out.println("Player 1: 1 for Human, 2 for Comp");
		newGame.setPlayerOne(newGame.allocatePlayer(sc.nextInt()));

		System.out.println("Player 2: 1 for Human, 2 for Comp");
		newGame.setPlayerTwo(newGame.allocatePlayer(sc.nextInt()));

		System.out.println("Player 1 plays with X or 0 ?");
		newGame.settingSigns(sc.next().toString());

		newGame.startGame();

		while (!newGame.HasGameEnded()) {

			newGame.makeMove();

			newGame.horizontalCheck();

			
			newGame.changePlayer();
		}
		System.out.println("Goodbuy");
		sc.close();
	}
}