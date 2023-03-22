package stateMachine;

/**
 * Behavior for when vehicles are enabled
 * @author meich
 *
 */
public class VehiclesEnabled extends State {

	/**
	 * State actions, signal not to walk, switch back to vehicles green light
	 * @param wrapper
	 */
	@Override
	public void stateActions(Context wrapper) {
		//print state name
		//signal pedestrians DON'T WALK
		//move to vehicles green state

		wrapper.printState();
		wrapper.signalPedestrians(WalkLight.DONT_WALK);
		wrapper.setPedestrianFlashCtr(7);
		wrapper.set_state(new VehiclesGreen());
	}

	/**
	 * State name
	 * @return name
	 */
	@Override
	public String name() {
		return "VEHICLES ENABLED";
	}
}
