package stateMachine;

import java.time.LocalTime;

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

    /**
     * Set initial state to operational and start thread
     */
    public Context() {
        this.currentState = new Operational();
        this.vehicleLight = null;
        this.walkLight = WalkLight.BLANK;
        this.isPedestrianWaiting = false;
        this.pedestrianFlashCtr = 0;

        wrapper = new Thread(this, "Wrapper");
        wrapper.start();
    }

    /**
     * get current state
     * @return current state
     */
    public State getCurrentState() {
        return this.currentState;
    }

    /**
     * Update current state and call state actions
     * @param s
     */
    public void set_state(State s) {
        this.currentState = s;
        this.currentState.stateActions(this);
    }

    /**
     * Print current state with time to console
     */
    public void printState(){System.out.println("[" + LocalTime.now() + "] " + this.currentState.name());}

    /**
     * Get pedestrian flash counter
     * @return flash counter
     */
    public int getPedestrianFlashCtr() {
        return pedestrianFlashCtr;
    }

    /**
     * Update pedestrian flash counter
     * @param pedestrianFlashCtr
     */
    public void setPedestrianFlashCtr(int pedestrianFlashCtr) {
        this.pedestrianFlashCtr = pedestrianFlashCtr;
    }

    /**
     * Check if pedestrian is waiting or not
     * @return true or false
     */
    public boolean isPedestrianWaiting() {
        return isPedestrianWaiting;
    }

    /**
     * Set pedestrian waiting to true or false
     * @param pedestrianWaiting
     */
    public void setPedestrianWaiting(boolean pedestrianWaiting) {
        isPedestrianWaiting = pedestrianWaiting;
        if (pedestrianWaiting){
            System.out.println("  * Pedestrians are waiting");
        }
    }

    /**
     * Change vehicle light
     * @param vehicleLight
     */
    public void signalVehicles(VehicleLight vehicleLight) {
        this.vehicleLight = vehicleLight;
        System.out.println(this.vehicleLight.getColour() + "Vehicle light: " + vehicleLight + VehicleLight.reset);
    }

    /**
     * Change pedestrian symbol
     * @param walkLight
     */
    public void signalPedestrians(WalkLight walkLight) {
        this.walkLight = walkLight;
        System.out.println(this.walkLight.getColour() + "Pedestrian signal: " + walkLight + WalkLight.reset);
    }

    /**
     * get current pedestrian symbol
     * @return walking symbol
     */
    public WalkLight getWalkLight() {
        return walkLight;
    }

    /**
     * get current vehicle light
     * @return vehicle light
     */
    public VehicleLight getVehicleLight() {
        return vehicleLight;
    }

    /**
     * Call timeout operation of current state
     */
    public void timeout() {
        currentState.timeout(this);
    }

    /**
     * Pedestrian clicks waiting button in current state
     */
	public void pedestrianWaiting() {
        currentState.pedestrianWaiting(this);
    }

    /**
     * Start system
     */
    @Override
    public void run() {
        System.out.println("|| Starting traffic light system ||");
        this.currentState.stateActions(this);
    }
}
