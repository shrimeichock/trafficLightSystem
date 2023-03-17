package stateMachine.States;

import stateMachine.Context;
import stateMachine.VehicleLight;

public class PedestriansEnabled extends State {
    @Override
    String name() {
        return "PEDESTRIANS ENABLED";
    }

    @Override
    public void stateActions(Context wrapper) {
        //print name
        //set signal vehicles red
        //change to pedestrian walk state

        System.out.println("\n" + wrapper.getCurrentState().name());
        wrapper.signalVehicles(VehicleLight.RED);
        wrapper.set_state(new PedestrianWalk());
        wrapper.getCurrentState().stateActions(wrapper);
    }

    @Override
    public void pedestrianWaiting(Context wrapper) {
        //do nothing, already allowing them to walk
    }
}
