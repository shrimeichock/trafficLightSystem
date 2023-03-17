package stateMachine;

/**
 * State where light is green for vehicles
 * @author meich
 *
 */
public class VehiclesGreen extends State {

	@Override
	public void stateActions(Context wrapper) {
		//print state
		//set vehicle signal to green
		//set ispedestrianwaiting to false
		//run timer for 10 seconds and call timeout

		System.out.println("\n" + wrapper.getCurrentState().name());
		wrapper.signalVehicles(VehicleLight.GREEN);
		wrapper.setPedestrianWaiting(false);
//		synchronized(this) {
//			while (wrapper.running) {
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}

			try {
				//System.out.println(Thread.currentThread().getName());
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//notifyAll();
		//}
		System.out.println("Light was GREEN for 10 seconds");
		wrapper.timeout();
	}

	@Override
	public void timeout(Context wrapper) {
		if(wrapper.isPedestrianWaiting()){
			System.out.println("Pedestrian detected, change light to yellow");
			wrapper.set_state(new VehiclesYellow());
		}else{
			System.out.println("Timed out, no pedestrian waiting, continue green");
			wrapper.set_state(new VehiclesGreenInt());
		}
		wrapper.getCurrentState().stateActions(wrapper);
	}

	@Override
	public void pedestrianWaiting(Context wrapper) {
		//set is pedestrian waiting to true, should be able to handle while sleeping
		wrapper.setPedestrianWaiting(true);
	}

	@Override
	String name() {
		return "VEHICLES GREEN";
	}
}
