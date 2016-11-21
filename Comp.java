import java.util.Random;

public class Comp extends Player {


	Random ran = new Random();

	public int getHit() {

		int pcChoice = 0;
		pcChoice = ran.nextInt(7);
		System.out.println("PC has chosen " + (pcChoice + 1));
		return pcChoice;

	}

}
