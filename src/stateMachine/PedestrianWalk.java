package stateMachine;

public class PedestrianWalk extends State {
    @Override
    String name() {
        return "PEDESTRIAN WALK";
    }

    @Override
    void stateActions(Context wrapper) {
        //print name
        //set pedestrian signal to walk
        //set timer for 15 seconds & timeout
        System.out.println("\n" + wrapper.getCurrentState().name());
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
    void timeout(Context wrapper) {
        //move to pedestrians flash state
        wrapper.set_state(new PedestriansFlash());
        wrapper.getCurrentState().stateActions(wrapper);
    }

    @Override
    void pedestrianWaiting(Context wrapper) {
        //do nothing, already open for pedestrians
    }
}
