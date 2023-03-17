package stateMachine;

import stateMachine.States.Operational;
import stateMachine.States.State;

/**
 * Wrapper for traffic light system
 * @author meich
 */
public class Context implements Runnable{
	private State currentState;
	private VehicleLight vehicleLight;
	private WalkLight walkLight;
	private boolean isPedestrianWaiting;
    private int pedestrianFlashCtr;
    public Thread wrapper;

    public Context() {
        this.currentState = null;
        this.vehicleLight = null;
        this.walkLight = WalkLight.BLANK;
        this.isPedestrianWaiting = false;
        this.pedestrianFlashCtr = 0;

        wrapper = new Thread(this, "Wrapper");
        wrapper.start();
    }

    public int getPedestrianFlashCtr() {
        return pedestrianFlashCtr;
    }

    public void setPedestrianFlashCtr(int pedestrianFlashCtr) {
        this.pedestrianFlashCtr = pedestrianFlashCtr;
    }

    public void set_state(State s) {
        currentState = s;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setPedestrianWaiting(boolean pedestrianWaiting) {
        isPedestrianWaiting = pedestrianWaiting;
        if (pedestrianWaiting){
            System.out.println("Pedestrians are waiting");
        } else {
            System.out.println("No pedestrians waiting");
        }
    }

    public boolean isPedestrianWaiting() {
        return isPedestrianWaiting;
    }

    public void timeout() {
        currentState.timeout(this);
    }
	
	public void pedestrianWaiting() {
        currentState.pedestrianWaiting(this);
    }

    public void signalVehicles(VehicleLight vehicleLight) {
        this.vehicleLight = vehicleLight;
        System.out.println(this.vehicleLight.getColour() + "Vehicle light: " + vehicleLight + VehicleLight.reset);
    }

    public void signalPedestrians(WalkLight walkLight) {
        this.walkLight = walkLight;
        System.out.println(this.walkLight.getColour() + "Pedestrian signal: " + walkLight + WalkLight.reset);
    }

    @Override
    public void run() {
        this.set_state(new Operational());
        this.currentState.stateActions(this);
    }
}
