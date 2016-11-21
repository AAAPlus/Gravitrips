import java.util.Scanner;

public class UI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean hasGameEnded = false;
		Game newGame = new Game();

		System.out.println("Player 1: 1 for Human, 2 for Comp");
		newGame.setPlayerOne(newGame.allocatePlayer(sc.nextInt()));

		System.out.println("Player 2: 1 for Human, 2 for Comp");
		newGame.setPlayerTwo(newGame.allocatePlayer(sc.nextInt()));

		System.out.println("Player 1 plays with X or 0 ?");
		newGame.settingSigns(sc.next().toString());

		newGame.startGame();

		while (!hasGameEnded) {

			newGame.makeMove();
			newGame.fieldObj.printingField();

			if (newGame.horizontalCheck() || newGame.verticalCheck() || 
					newGame.diametralLeftCheck() || newGame.diametralRightCheck() ) {
				System.out.println("WE HAVE A WINNER: " + newGame.getWinner());
				newGame.fieldObj.printingField();
				hasGameEnded = true;
			}
			
			if (newGame.fieldObj.isFieldfull()) {
				hasGameEnded = true;
				System.out.println("The Game Has ended, no more free slots!!");
			}
			newGame.changePlayer();
		}
		System.out.println("Goodbuy");
		sc.close();
	}
}
