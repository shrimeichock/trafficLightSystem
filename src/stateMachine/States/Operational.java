
package stateMachine.States;

import stateMachine.Context;

import java.time.LocalTime;

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
		wrapper.getCurrentState().stateActions(wrapper);
	}

	@Override
	public String name() {
		return "OPERATIONAL";
	}
}
