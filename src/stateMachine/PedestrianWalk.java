package stateMachine;

public class PedestrianWalk extends State {
    @Override
    public String name() {
        return "PEDESTRIAN WALK";
    }

    @Override
    public void stateActions(Context wrapper) {
        //print name
        //set pedestrian signal to walk
        //set timer for 15 seconds & timeout
        //System.out.println("\n" + wrapper.getCurrentState().name());

        wrapper.printState();
        wrapper.signalPedestrians(WalkLight.WALK);
        try {
            System.out.println("Allow pedestrians to walk for 15 seconds");
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wrapper.timeout();
    }

    @Override
    public void timeout(Context wrapper) {
        //move to pedestrians flash state
        wrapper.set_state(new PedestriansFlash());
        wrapper.getCurrentState().stateActions(wrapper);
    }

    @Override
    public void pedestrianWaiting(Context wrapper) {
        //do nothing, already open for pedestrians
    }
}
