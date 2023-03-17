package stateMachine;

public class VehiclesGreenInt extends State {
    @Override
    String name() {
        return "VEHICLES GREEN INT";
    }

    @Override
    void stateActions(Context wrapper) {
        System.out.println("\n" + wrapper.getCurrentState().name());
    }

    @Override
    public void pedestrianWaiting(Context wrapper) {
        System.out.println("Pedestrian detected, going to yellow");
        wrapper.set_state(new VehiclesYellow());
        wrapper.getCurrentState().stateActions(wrapper);
    }
}
