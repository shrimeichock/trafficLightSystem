package stateMachine;

public class VehiclesGreenInt extends State {
    @Override
    public String name() {
        return "VEHICLES GREEN INT";
    }

    @Override
    public void stateActions(Context wrapper) {
        //System.out.println("\n" + wrapper.getCurrentState().name());
        wrapper.printState();
    }

    @Override
    public void pedestrianWaiting(Context wrapper) {
        System.out.println("  * Pedestrian detected, going to yellow");
        wrapper.setPedestrianWaiting(true);
        wrapper.set_state(new VehiclesYellow());
        //wrapper.getCurrentState().stateActions(wrapper);
    }
}
