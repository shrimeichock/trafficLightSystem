
package stateMachine;

import java.util.InvalidPropertiesFormatException;

/**
 * Initial state of traffic light
 * @author meich
 *
 */
public class Operational extends State {

	/**
	 * Switch to vehicles enabled state
	 * @param wrapper the wrapper
	 */
	public void stateActions(Context wrapper) {
		//Print state name
		//Set to vehicles enabled state

		wrapper.printState();
		wrapper.set_state(new VehiclesEnabled());
	}

	/**
	 * Name of state
	 * @return name
	 */
	@Override
	public String name() {
		return "OPERATIONAL";
	}
}
