package stateMachine;

public class VehiclesYellow extends State {
    @Override
    String name() {
        return "VEHICLES YELLOW";
    }

    @Override
    void stateActions(Context wrapper) {
        //print name
        //change signal to yellow
        //sleep 3 seconds
        System.out.println("\n" + wrapper.getCurrentState().name());
        wrapper.signalVehicles(VehicleLight.YELLOW);
        try {
            //System.out.println(Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wrapper.timeout();
    }

    @Override
    void timeout(Context wrapper) {
        //move to pedestrians enabled state
        wrapper.set_state(new pedestriansEnabled());
        wrapper.getCurrentState().stateActions(wrapper);
    }

    @Override
    void pedestrianWaiting(Context wrapper) {
        //do nothing, pedestrian already enabled
        //System.out.println("Pedestrian detected IN YELLOW");

    }
}
