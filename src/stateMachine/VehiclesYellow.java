package stateMachine;

public class VehiclesYellow extends State {
    @Override
    public String name() {
        return "VEHICLES YELLOW";
    }

    @Override
    public void stateActions(Context wrapper) {
        //print name
        //change signal to yellow
        //sleep 3 seconds

        //System.out.println("\n" + wrapper.getCurrentState().name());
        wrapper.printState();
        wrapper.setPedestrianWaiting(false);
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
    public void timeout(Context wrapper) {
        //move to pedestrians enabled state
        wrapper.set_state(new PedestriansEnabled());
        wrapper.getCurrentState().stateActions(wrapper);
    }

    @Override
    public void pedestrianWaiting(Context wrapper) {
        //do nothing, pedestrian already enabled
        //System.out.println("Pedestrian detected IN YELLOW");

    }
}
