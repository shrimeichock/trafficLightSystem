package stateMachine.States;

import stateMachine.Context;
import stateMachine.WalkLight;

/**
 * Behavior for when vehicles are enabled
 * @author meich
 *
 */
public class VehiclesEnabled extends State {

	public void stateActions(Context wrapper) {
		//print state name
		//signal pedestrians DON'T WALK
		//move to vehicles green state

		System.out.println("\n" + wrapper.getCurrentState().name());
		wrapper.signalPedestrians(WalkLight.DONT_WALK);
		wrapper.setPedestrianFlashCtr(7);
		wrapper.set_state(new VehiclesGreen());
		wrapper.getCurrentState().stateActions(wrapper);

	}

	@Override
	String name() {
		return "VEHICLES ENABLED";
	}
}
