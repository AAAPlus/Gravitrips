public class Game {

	Field fieldObj = new Field();
	private Player playerOne;
	private Player playerTwo;
	private Player currentPlayer;

	boolean firstPlayerActive = true;
	private int choice = 0;
	int slotNr = 0;
	String figure;
	

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

	public void startGame() {
		fieldObj.createField();
		this.currentPlayer = playerOne;
	}

	public void makeMove() {

		boolean attemp = false;

		do {
			try {
				if (currentPlayer.getClass().equals(Human.class)) {
					choice = currentPlayer.getHit();
					figure = currentPlayer.getFigure();
				}
				if (currentPlayer instanceof Comp) {
					choice = currentPlayer.getHit();
					figure = currentPlayer.getFigure();
				}
				slotNr = checkSlot(choice);
				attemp = true;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Oops it is already full, try another column!");
			}
		} while (!attemp);
		fieldObj.addingHit(this.slotNr, this.choice, this.figure);

	}

	public String getWinner() {
		String winner;
		if (firstPlayerActive){
			winner = "PLAYER 1";
		}else{
			winner = "PLAYER 2";
		}
		return winner;
	}

	public void changePlayer() {
		if (firstPlayerActive) {
			currentPlayer = playerTwo;
			firstPlayerActive = false;
		} else {
			currentPlayer = playerOne;
			firstPlayerActive = true;
		}
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public int checkSlot(int move) {
		int i = 5;
		while (fieldObj.gameField[i][move] != Field.FIELD_SIGN) {
			i--;
		}
		return i;
	}

	public boolean horizontalCheck() {

		boolean winner = false;

		for (int i = 0; i < Field.MAX_ROWS; i++) {
			int x = 0;
			int y = 0;
			for (int j = 0; j < Field.MAX_COLUMS; j++) {

				if (fieldObj.gameField[i][j].equals(Field.X_SIGN)) {
					x++;
					y = 0;
				}
				if (fieldObj.gameField[i][j].equals(Field.O_SIGN)) {
					y++;
					x = 0;
				}
				if (fieldObj.gameField[i][j].equals(Field.FIELD_SIGN)) {
					x = 0;
					y = 0;
				}
				if (x == 4 || y == 4) {
				
					winner = true;
				}
			}
		}
		return winner;
	}

	public boolean verticalCheck() {
		boolean winner = false;

		for (int i = 0; i < Field.MAX_COLUMS; i++) {
			int x = 0;
			int y = 0;
			for (int j = 0; j < Field.MAX_ROWS; j++) {

				if (fieldObj.gameField[j][i].equals(Field.X_SIGN)) {
					x++;
					y = 0;
				}
				if (fieldObj.gameField[j][i].equals(Field.O_SIGN)) {
					x = 0;
					y++;

				}
				if (fieldObj.gameField[j][i].equals(Field.FIELD_SIGN)) {

					x = 0;
					y = 0;

				}
				if (x == 4 || y == 4) {
					winner = true;
				}
			}
		}
		return winner;
	}

	public boolean diametralRightCheck() {

		boolean winner = false;

		for (int i = 3; i < Field.MAX_ROWS; i++) {

			for (int j = 0; j < 4; j++) {

				int a = i;
				int b = j;
				int x = 0;
				int y = 0;

				for (int z = 0; z < 4; z++) {

					if (fieldObj.gameField[a][b].equals(Field.X_SIGN)) {
						x++;
						y = 0;
					}
					if (fieldObj.gameField[a][b].equals(Field.O_SIGN)) {
						x = 0;
						y++;
					}
					if (fieldObj.gameField[a][b].equals(Field.FIELD_SIGN)) {
						x = 0;
						y = 0;
					}
					if (x == 4 || y == 4) {
						winner = true;
					}

					a--;
					b++;
				}
			}
		}
		return winner;
	}

	public boolean diametralLeftCheck() {

		boolean winner = false;

		for (int i = 3; i < Field.MAX_ROWS; i++) {

			for (int j = 3; j < Field.MAX_COLUMS; j++) {

				int a = i;
				int b = j;
				int x = 0;
				int y = 0;
				for (int z = 0; z < 4; z++) {

					if (fieldObj.gameField[a][b].equals(Field.X_SIGN)) {
						x++;
						y = 0;
					}
					if (fieldObj.gameField[a][b].equals(Field.O_SIGN)) {
						x = 0;
						y++;
					}
					if (fieldObj.gameField[a][b].equals(Field.FIELD_SIGN)) {
						x = 0;
						y = 0;
					}
					if (x == 4 || y == 4) {
						winner = true;
					}
					a--;
					b--;
				}
			}
		}

		return winner;
	}
}
