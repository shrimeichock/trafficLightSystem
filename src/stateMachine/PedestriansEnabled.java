package stateMachine;

public class PedestriansEnabled extends State {

    /**
     * State actions, set light to red and move to walk state
     * @param wrapper
     */
    @Override
    public void stateActions(Context wrapper) {
        //print name
        //set signal vehicles red
        //change to pedestrian walk state

        wrapper.printState();
        wrapper.signalVehicles(VehicleLight.RED);
        wrapper.set_state(new PedestrianWalk());
        //wrapper.getCurrentState().stateActions(wrapper);
    }

    /**
     * Do nothing if pedestrian is waiting
     * @param wrapper
     */
    @Override
    public void pedestrianWaiting(Context wrapper) {
        //do nothing, already allowing them to walk
    }

    /**
     * Name of state
     * @return name
     */
    @Override
    public String name() {
        return "PEDESTRIANS ENABLED";
    }
}
