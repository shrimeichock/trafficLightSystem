package stateMachine;

public class PedestriansEnabled extends State {
    @Override
    String name() {
        return "PEDESTRIANS ENABLED";
    }

    @Override
    void stateActions(Context wrapper) {
        //print name
        //set signal vehicles red
        //change to pedestrian walk state

        System.out.println("\n" + wrapper.getCurrentState().name());
        wrapper.signalVehicles(VehicleLight.RED);
        wrapper.set_state(new PedestrianWalk());
        wrapper.getCurrentState().stateActions(wrapper);
    }
}
