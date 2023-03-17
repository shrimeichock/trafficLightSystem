/**
 * Initial state of traffic light
 */
package stateMachine;

/**
 * @author meich
 *
 */
public class Operational extends State {

	/**
	 * Switch to vehicles enabled state
	 * @param wrapper
	 */
	public void stateActions(Context wrapper) {
		//Print state name
		//Set to vehicles enabled state

		System.out.println("|| Starting traffic light system ||");
		System.out.println("\n" + wrapper.getCurrentState().name());
		wrapper.set_state(new vehiclesEnabled());
		wrapper.getCurrentState().stateActions(wrapper);
	}

	@Override
	String name() {
		return "OPERATIONAL";
	}
}
