public class Field {

	public Field() {
		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMS; j++) {
				gameField[i][j] = FIELD_SIGN;
			}
		}
	}

	public static final String X_SIGN = "X";
	public static final String O_SIGN = "0";
	public static final String FIELD_SIGN = "*";
	public static final int MAX_ROWS = 6;
	public static final int MAX_COLUMS = 7;

	String[][] gameField = new String[MAX_ROWS][MAX_COLUMS];

	public int checkSlot(int move) {
		int i = 5;
		while (gameField[i][move] != FIELD_SIGN) {
			i--;
		}
		return i;
	}

	public void printingField() {
		System.out.println(" 1  2  3  4  5  6  7");
		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMS; j++) {
				if (i == 0) {
				}
				System.out.print(" " + gameField[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public void addingHit(int i, int y, String figure) {
		gameField[i][y] = figure;
	}

	public boolean isFieldfull() {
		boolean result = true;

		for (int i = 0; i < MAX_ROWS; i++) {
			for (int j = 0; j < MAX_COLUMS; j++) {
				if (gameField[i][j].equals(FIELD_SIGN)) {
					result = false;
				}

			}
		}
		if (result == true) {
			System.out.println("The Game Has ended, no more free slots!!");

		}
		return result;
	}

	public boolean outOfBounds(int choice){
		boolean result = false;
		if(gameField[0][choice] != FIELD_SIGN){
			result = true;
			System.out.println("Oops it is already full, try another column!");

		}
			return result;
	}
	
}
