/**
 * State where light is green for vehicles
 */
package stateMachine;

/**
 * @author meich
 *
 */
public class VehiclesGreen extends State {

	@Override
	public void stateActions(Context wrapper) {
		//print state
		//set vehicle signal to green
		//set ispedestrianwaiting to false
		//run timer for 10 seconds

		System.out.println("\n" + wrapper.getCurrentState().name());
//		wrapper.signalVehicles(VehicleLight.GREEN);
//		wrapper.setPedestrianWaiting(false);
	}

	@Override
	public void timeout(Context wrapper) {
		System.out.println("check after green light");
		// TODO Auto-generated method stub
	}

	@Override
	public void pedestrianWaiting(Context wrapper) {
		//set is pedestrian waiting to true, should be able to handle while sleeping
		//wrapper.setPedestrianWaiting(true);
	}

	@Override
	String name() {
		return "VEHICLES GREEN";
	}
}
