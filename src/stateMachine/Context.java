/**
 * Wrapper for traffic light system
 */
package stateMachine;

public class Context {
	private State currentState;
//	private VehicleLight vehicleLight;
//	private WalkLight walkLight;
//	private boolean isPedestrianWaiting;
	
	public Context() {
        this.currentState = new Operational();
        this.currentState.stateActions(this);
//        this.vehicleLight = null;
//        this.walkLight = null;
//        this.isPedestrianWaiting = false;
//        Thread trafficLightWrapper = new Thread(new WrapperThread(), "Wrapper");
//        trafficLightWrapper.start();
    }

	public void set_state(State s) {
        currentState = s;
    }

    public State getCurrentState() {
        return currentState;
    }

//    public void setPedestrianWaiting(boolean pedestrianWaiting) {
//        isPedestrianWaiting = pedestrianWaiting;
//    }

    public void timeout() {
        currentState.timeout(this);
    }
	
	public void pedestrianWaiting() {
        currentState.pedestrianWaiting(this);
    }

//    public void signalVehicles(VehicleLight vehicleLight) {
//        this.vehicleLight = vehicleLight;
//        System.out.println("Vehicle light: " + vehicleLight.toString());
//    }
//
//    public void signalPedestrians(WalkLight walkLight) {
//        this.walkLight = walkLight;
//        System.out.println("Pedestrian signal: " + walkLight.toString());
//    }
}
