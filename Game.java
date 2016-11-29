public class Game {

	private Field field;

	private Player playerOne;
	private Player playerTwo;
	private Player currentPlayer;
	private boolean hasGameEnded;
	
	private final static int MAX_MIN_MID = 5;

	private boolean firstPlayerActive = true;

	public boolean HasGameEnded() {
		return hasGameEnded;
	}

	public void setHasGameEnded() {
		this.hasGameEnded = true;
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

	public void settingSigns(String i) {
		if (i.toUpperCase().equals("X")) {
			playerOne.setFigure(Field.X_SIGN);
			playerTwo.setFigure(Field.O_SIGN);
		} else if (i.equals("0")) {
			playerOne.setFigure(Field.O_SIGN);
			playerTwo.setFigure(Field.X_SIGN);
		}
	}

	public Field startGame() {
		this.field = new Field();
		this.currentPlayer = playerOne;
		return field;

	}

	public void makeMove() {
		int choice = 0;
		String figure = null;
		int SlotNr = 0;
		boolean attemp = false;

		field.printingField();

		do {
			try {
				choice = currentPlayer.getHit();
				figure = currentPlayer.getFigure();
				SlotNr = field.checkSlot(choice);
				attemp = true;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Oops it is already full, try another column!");
			}
		} while (!attemp);
		field.addingHit(SlotNr, choice, figure);

	}

	public String getWinner() {
		String winner;
		if (firstPlayerActive) {
			winner = "PLAYER 1";
		} else {
			winner = "PLAYER 2";
		}
		return winner;
	}

	public void changePlayer() {
		if (firstPlayerActive) {
			currentPlayer = playerTwo;
			this.firstPlayerActive = false;
		} else {
			currentPlayer = playerOne;
			this.firstPlayerActive = true;
		}
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public void horizontalCheck() {

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
				checkWinner(x, y);
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
				checkWinner(x, y);

			}
		}
		for (int i = 3; i < Field.MAX_ROWS; i++) {
			int x = 0;
			int y = 0;
			for (int j = 0; j < 4; j++) {

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
					checkWinner(x, y);
					a--;
					b++;
				}
			}
		}
		for (int i = 3; i < Field.MAX_ROWS; i++) {
			int x = 0;
			int y = 0;
			for (int j = 3; j < Field.MAX_COLUMS; j++) {

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
					checkWinner(x, y);
					a--;
					b--;
				}
			}
		}
	}

	
	public void checkWinner(int x, int y) {
		if (x == 4 || y == 4) {
			System.out.println("You are the Winner!!!! it is " + getWinner() + "x=" + x + " y=" + y);
			setHasGameEnded();
			field.printingField();
		}
	}

	public void isFieldFull() {
		if (field.isFieldfull()) {
			setHasGameEnded();
			System.out.println("The Game Has ended, no more free slots!!");
		}
	}

}