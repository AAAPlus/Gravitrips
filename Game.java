public class Game {
	
	private Field field;
	private Player playerOne;
	private Player playerTwo;
	private Player currentPlayer;
	private boolean hasGameEnded = false;
	
	public Game(){
		field = new Field();
	
	}
	
	public void setCurrentPlayer(){
		this.currentPlayer = playerOne;
	}
	
	
	public void setGameEnded() {
		this.hasGameEnded = true;
	}

	public void runTime() {
		while (!hasGameEnded && !field.isFieldfull()) {

			makeMove();

			winnerCheck();

			changePlayer();
		}
	}

	public void settingSigns(String i) {
		if (i.toUpperCase().equals("X")) {
			playerOne.setFigure(Field.X_SIGN);
			playerTwo.setFigure(Field.O_SIGN);
		} else if (i.equals("0")) {
			playerOne.setFigure(Field.O_SIGN);
			playerTwo.setFigure(Field.X_SIGN);
		}
	}

	public void makeMove() {
		int choice = 0;
		String figure = null;
		int slotNr = 0;

		field.printingField();
			do {
				
				choice = currentPlayer.getHit();
				figure = currentPlayer.getFigure();
			
			} while(field.outOfBounds(choice));
			slotNr = field.checkSlot(choice);
		field.addingHit(slotNr, choice, figure);
	}

	public String getWinner() {
		String winner;
		if (currentPlayer == playerOne) {
			winner = "PLAYER 1";
		} else {
			winner = "PLAYER 2";
		}
		return winner;
	}

	public void changePlayer() {
		if (currentPlayer == playerOne) {
			currentPlayer = playerTwo;
		} else {
			currentPlayer = playerOne;
		}
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public void winnerCheck() {
		for (int i = 0; i < Field.MAX_ROWS; i++) {

			int x = 0;
			int y = 0;

			for (int j = 0; j < Field.MAX_COLUMS; j++) {

				if (field.gameField[i][j].equals(Field.X_SIGN)) {
					x++;
					y = 0;
				}
				if (field.gameField[i][j].equals(Field.O_SIGN)) {
					y++;
					x = 0;
				}
				if (field.gameField[i][j].equals(Field.FIELD_SIGN)) {
					x = 0;
					y = 0;
				}
				checkFourSlots(x, y);
			}
		}

		for (int i = 0; i < Field.MAX_COLUMS; i++) {
			int x = 0;
			int y = 0;
			for (int j = 0; j < Field.MAX_ROWS; j++) {

				if (field.gameField[j][i].equals(Field.X_SIGN)) {
					x++;
					y = 0;
				}
				if (field.gameField[j][i].equals(Field.O_SIGN)) {
					x = 0;
					y++;

				}
				if (field.gameField[j][i].equals(Field.FIELD_SIGN)) {

					x = 0;
					y = 0;
				}
				checkFourSlots(x, y);

			}
		}

		for (int i = 3; i < Field.MAX_ROWS; i++) {

			for (int j = 0; j < 4; j++) {
				int x = 0;
				int y = 0;
				int a = i;
				int b = j;

				for (int z = 0; z < 4; z++) {

					if (field.gameField[a][b].equals(Field.X_SIGN)) {
						x++;
						y = 0;
					}
					if (field.gameField[a][b].equals(Field.O_SIGN)) {
						x = 0;
						y++;
					}
					if (field.gameField[a][b].equals(Field.FIELD_SIGN)) {
						x = 0;
						y = 0;
					}
					a--;
					b++;
				}
				checkFourSlots(x, y);

			}
		}
		for (int i = 3; i < Field.MAX_ROWS; i++) {

			for (int j = 3; j < Field.MAX_COLUMS; j++) {
				int x = 0;
				int y = 0;
				int a = i;
				int b = j;
				for (int z = 0; z < 4; z++) {

					if (field.gameField[a][b].equals(Field.X_SIGN)) {
						x++;
						y = 0;
					}
					if (field.gameField[a][b].equals(Field.O_SIGN)) {
						x = 0;
						y++;
					}
					if (field.gameField[a][b].equals(Field.FIELD_SIGN)) {
						x = 0;
						y = 0;
					}
					a--;
					b--;
				}
				checkFourSlots(x, y);

			}
		}

	}

	public void checkFourSlots(int x, int y) {
		if ((x == 4 || y == 4) && !hasGameEnded) {
			setGameEnded();
			field.printingField();
			System.out.println(getWinner() + " has won the game!");
		}
	}
}
