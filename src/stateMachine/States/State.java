package stateMachine.States;

import stateMachine.Context;

/**
 * Basic state interface, handles default behavior
 * @author meich
 *
 */
public abstract class State {
	public void timeout(Context wrapper){System.out.println("TIMEOUT NOT PERMITTED FOR THIS STATE"); System.exit(0);}
	public void pedestrianWaiting(Context wrapper){System.out.println("PEDESTRIAN WAITING NOT PERMITTED FOR THIS STATE"); System.exit(0);}
	abstract String name();
	public abstract void stateActions(Context wrapper);
}
