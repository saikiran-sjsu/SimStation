package SimStation;

import java.util.Random;

public enum Heading {
	NORTH,
	EAST,
	SOUTH,
	WEST;
	
	
	public static Heading getRandomHeading() {
		Random rand = new Random();
		return values()[rand.nextInt(values().length)];
	}
}
