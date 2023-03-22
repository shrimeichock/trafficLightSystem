package stateMachine;

public class PedestrianWalk extends State {

    /**
     * state actions, set the signal to walk for 15 seconds
     * @param wrapper
     */
    @Override
    public void stateActions(Context wrapper) {
        //print name
        //set pedestrian signal to walk
        //set timer for 15 seconds & timeout

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

    /**
     * Change to flash state
     * @param wrapper
     */
    @Override
    public void timeout(Context wrapper) {
        //move to pedestrians flash state
        wrapper.set_state(new PedestriansFlash());
        //wrapper.getCurrentState().stateActions(wrapper);
    }

    /**
     * if pedestrian waiting is called, do nothing
     * @param wrapper
     */
    @Override
    public void pedestrianWaiting(Context wrapper) {
        //do nothing, already open for pedestrians
    }

    /**s
     * State name
     * @return name
     */
    @Override
    public String name() {
        return "PEDESTRIAN WALK";
    }
}
