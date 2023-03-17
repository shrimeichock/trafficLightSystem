package stateMachine;

/**
 * Behavior for when vehicles are enabled
 * @author meich
 *
 */
public class VehiclesEnabled extends State {
//
//	public vehiclesEnabled(Context wrapper){
//		this.stateActions(wrapper);
//	}

	public void stateActions(Context wrapper) {
		//print state name
		//signal pedestrians DON'T WALK
		//move to vehicles green state

		System.out.println("\n" + wrapper.getCurrentState().name());
		wrapper.signalPedestrians(WalkLight.DONT_WALK);
		wrapper.set_state(new VehiclesGreen());
		wrapper.getCurrentState().stateActions(wrapper);
	}

	@Override
	String name() {
		return "VEHICLES ENABLED";
	}
}
