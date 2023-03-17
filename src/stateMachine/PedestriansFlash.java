package stateMachine;

public class PedestriansFlash extends State {
    @Override
    String name() {
        return "PEDESTRIANS FLASH";
    }

    @Override
    void stateActions(Context wrapper) {
        //print name
        //1-second timer, call timeout

        System.out.println("\n" + wrapper.getCurrentState().name());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wrapper.timeout();
    }

    @Override
    void timeout(Context wrapper) {
        //decrement flash counter
        int ctr = wrapper.getPedestrianFlashCtr();
        wrapper.setPedestrianFlashCtr(ctr - 1);

        //if counter = 0, move to vehicles enabled
        if(ctr == 0){
            wrapper.set_state(new VehiclesEnabled());
            wrapper.getCurrentState().stateActions(wrapper);
            wrapper.setPedestrianFlashCtr(7);
            System.out.println("Pedestrian crossing completed, allow cars to pass");
        }else if((ctr & 1) == 0){ //if counter even, flash DON'T_WALK
            wrapper.signalPedestrians(WalkLight.DONT_WALK);
            wrapper.set_state(new PedestriansFlash());
            wrapper.getCurrentState().stateActions(wrapper);
        }else{ //if counter off, flash BLANK
            wrapper.signalPedestrians(WalkLight.BLANK);
            wrapper.set_state(new PedestriansFlash());
            wrapper.getCurrentState().stateActions(wrapper);
        }
    }

    @Override
    void pedestrianWaiting(Context wrapper) {
        //do nothing, already allowing them to walk
    }
}
