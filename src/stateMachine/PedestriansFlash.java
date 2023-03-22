package stateMachine;

public class PedestriansFlash extends State {


    /**
     * State actions, call timeout every other second
     * @param wrapper
     */
    @Override
    public void stateActions(Context wrapper) {
        //print name
        //1-second timer, call timeout

        wrapper.printState();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wrapper.timeout();
    }

    /**
     * Alternate the signal between blank and don't walk
     * @param wrapper
     */
    @Override
    public void timeout(Context wrapper) {
        //decrement flash counter
        int ctr = wrapper.getPedestrianFlashCtr();
        wrapper.setPedestrianFlashCtr(ctr-1);

        //if counter = 0, move to vehicles enabled
        if(ctr == 0){
            wrapper.set_state(new VehiclesEnabled());
            System.out.println("  * Pedestrian crossing completed, allow cars to pass");
        }else if((ctr & 1) == 0){ //if counter even, flash DON'T_WALK
            wrapper.signalPedestrians(WalkLight.DONT_WALK);
            wrapper.getCurrentState().stateActions(wrapper);
        }else{ //if counter off, flash BLANK
            wrapper.signalPedestrians(WalkLight.BLANK);
            wrapper.getCurrentState().stateActions(wrapper);
        }
    }

    /**
     * Set pedestrian waiting to true
     * @param wrapper
     */
    @Override
    public void pedestrianWaiting(Context wrapper) {
        //do nothing, already allowing them to walk
        wrapper.setPedestrianWaiting(true);
    }

    /**
     * Name of state
     * @return name
     */
    @Override
    public String name() {
        return "PEDESTRIANS FLASH";
    }
}
