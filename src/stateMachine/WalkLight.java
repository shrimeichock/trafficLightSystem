package stateMachine;

/**
 * Represents pedestrian lights (walk, don't walk, blank)
 * @author meich
 *
 */
public enum WalkLight {
	WALK("\u001b[37m"),
	DONT_WALK("\u001b[35m"),
	BLANK("\u001b[30m");

	private final String colour;
	public static String reset = "\u001b[0m";

	WalkLight(String s) {
		this.colour = s;
	}

	public String getColour() {
		return colour;
	}
}
