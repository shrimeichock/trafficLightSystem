
package tests;

import org.junit.jupiter.api.Test;

import stateMachine.Context;

import java.util.concurrent.TimeUnit;

/**
 * Test class for traffic lights
 * @author meich
 *
 */
class stateMachineTest {

	private static Context context;

	/**
	 * Click 'Pedestrian waiting' button repeatedly with delays
	 */
	@Test
	void test() throws InterruptedException {
		context = new Context();
		for(int i=0; i<15; i++){
			TimeUnit.SECONDS.sleep(4);
			System.out.printf("-----PEDESTRIAN INPUT[%d]-----%n", i);
			context.pedestrianWaiting();
		}
	}

}
