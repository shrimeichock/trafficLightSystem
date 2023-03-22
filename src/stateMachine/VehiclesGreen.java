package stateMachine;

/**
 * State where light is green for vehicles
 * @author meich
 *
 */
public class VehiclesGreen extends State {

	/**
	 * state actions, set light to green for 10 seconds
	 * @param wrapper
	 */
	@Override
	public void stateActions(Context wrapper) {
		//print state
		//set vehicle signal to green
		//set ispedestrianwaiting to false
		//run timer for 10 seconds and call timeout

		wrapper.printState();
		wrapper.signalVehicles(VehicleLight.GREEN);
		System.out.println("  * Light will stay GREEN for 10 seconds");
		//wrapper.setPedestrianWaiting(false);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wrapper.timeout();
	}

	@Override
	public void timeout(Context wrapper) {
		if(wrapper.isPedestrianWaiting()){
			System.out.println("  * Pedestrian detected, change light to yellow");
			wrapper.set_state(new VehiclesYellow());
		}else{
			System.out.println("  * Timed out, no pedestrian waiting, continue green");
			wrapper.set_state(new VehiclesGreenInt());
		}
	}

	@Override
	public void pedestrianWaiting(Context wrapper) {
		//set is pedestrian waiting to true, should be able to handle while sleeping
		wrapper.setPedestrianWaiting(true);
	}

	@Override
	public String name() {
		return "VEHICLES GREEN";
	}
}
