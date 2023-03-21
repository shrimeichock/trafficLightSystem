package stateMachine;

public class PedestriansEnabled extends State {
    @Override
    public String name() {
        return "PEDESTRIANS ENABLED";
    }

    @Override
    public void stateActions(Context wrapper) {
        //print name
        //set signal vehicles red
        //change to pedestrian walk state

        //System.out.println("\n" + wrapper.getCurrentState().name());
        wrapper.printState();
        wrapper.signalVehicles(VehicleLight.RED);
        wrapper.set_state(new PedestrianWalk());
        wrapper.getCurrentState().stateActions(wrapper);
    }

    @Override
    public void pedestrianWaiting(Context wrapper) {
        //do nothing, already allowing them to walk
    }
}
