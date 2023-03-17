/**
 * Basic state interface, handles default behavior
 */
package stateMachine;

/**
 * @author meich
 *
 */
public abstract class State {
	void timeout(Context wrapper){System.out.println("ERROR");}
	void pedestrianWaiting(Context wrapper){System.out.println("ERROR");}
	abstract String name();
	abstract void stateActions(Context wrapper);
}
