
package tests;

import org.junit.jupiter.api.Test;

import stateMachine.Context;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for traffic lights
 * @author meich
 *
 */
class stateMachineTest {

	private static Context context;
	//TODO another test where it is spaced out (goes to Green Int)

	/**
	 * Click 'Pedestrian waiting' button repeatedly with 5 second delays. Skips VEHICLE GREEN INT state
	 */
	@Test
	void test() throws InterruptedException {
		context = new Context();
		for(int i=0; i<15; i++){
			Thread.sleep(5000);
			System.out.printf("-----PEDESTRIAN INPUT[%d]-----%n", i);
			context.pedestrianWaiting();
		}
	}

	/**
	 * Check that traffic lights move through initial states
	 */
	@Test
	void testInitialStates() throws InterruptedException {
		context = new Context();
		Thread.sleep(1);
		assertEquals("OPERATIONAL", context.getCurrentState().name());
		Thread.sleep(1);
		assertEquals("VEHICLES ENABLED", context.getCurrentState().name());
		Thread.sleep(5);
		assertEquals("VEHICLES GREEN", context.getCurrentState().name());
	}


	/**
	 * Check that when pedestrian clicks button in PEDESTRIAN FLASH state, it holds the request until next GREEN LIGHT
	 */
	@Test
	void testWaitingInFlash() throws InterruptedException {
		context = new Context();
		Thread.sleep(50);
		assertFalse(context.isPedestrianWaiting());
		context.pedestrianWaiting();
		System.out.println("-----PEDESTRIAN INPUT[before flash]-----"); //get to flash state
		assertTrue(context.isPedestrianWaiting());

		Thread.sleep(10000); //move to yellow, pedestrian waiting should be cleared
		assertEquals("VEHICLES YELLOW", context.getCurrentState().name());
		assertFalse(context.isPedestrianWaiting());

		Thread.sleep(20000); //press button in flash state, sets is waiting to true
		assertEquals("PEDESTRIANS FLASH", context.getCurrentState().name());
		context.pedestrianWaiting();
		System.out.println("-----PEDESTRIAN INPUT[during flash]-----");
		assertTrue(context.isPedestrianWaiting());

		Thread.sleep(10000); //should skip VEHICLES GREEN INT state and go straight to yellow after GREEN
		assertEquals("VEHICLES GREEN", context.getCurrentState().name());
		Thread.sleep(7000);
		assertEquals("VEHICLES YELLOW", context.getCurrentState().name());
		assertFalse(context.isPedestrianWaiting());
	}

}
