package stateMachine;

/**
 * Represents the vehicle traffic lights (red, yellow, green)
 * @author meich
 *
 */
public enum VehicleLight {
	GREEN("\u001b[32m"),
	YELLOW ("\u001b[33m"),
	RED("\u001b[31m");

	private final String colour;
	public static String reset = "\u001b[0m";

	VehicleLight(String s) {
		this.colour = s;
	}

	public String getColour() {
		return colour;
	}
}
