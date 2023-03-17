package stateMachine;

/**
 * Basic state interface, handles default behavior
 * @author meich
 *
 */
public abstract class State {
	void timeout(Context wrapper){System.out.println("TIMEOUT NOT PERMITTED FOR THIS STATE"); System.exit(0);}
	void pedestrianWaiting(Context wrapper){System.out.println("PEDESTRIAN WAITING NOT PERMITTED FOR THIS STATE"); System.exit(0);}
	abstract String name();
	abstract void stateActions(Context wrapper);
}
