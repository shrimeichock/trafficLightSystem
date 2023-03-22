
package tests;

import org.junit.jupiter.api.Test;

import stateMachine.Context;
import stateMachine.VehicleLight;
import stateMachine.VehiclesGreenInt;
import stateMachine.WalkLight;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for traffic lights
 * @author meich
 *
 */
class stateMachineTest {


	//TODO test where we check that eac state is traversed and entry actions are correct

	/**
	 * Click 'Pedestrian waiting' button repeatedly with 5 second delays. Skips VEHICLE GREEN INT state
	 */
	@Test
	void test() throws InterruptedException {
		Context context = new Context();
		for(int i=0; i<15; i++){
			Thread.sleep(5000);
			System.out.printf("-----PEDESTRIAN INPUT[%d]-----%n", i);
			context.pedestrianWaiting();
		}
	}

	//TODO another test where it is spaced out (goes to Green Int)
	/**
	 * Check that if pedestrian waiting after first 10 seconds of GREEN, moves to GREEN_INT
	 */
	@Test
	void testWaitingGreenInt() throws InterruptedException {
		Context context = new Context();
		Thread.sleep(5000);
		assertEquals("VEHICLES GREEN", context.getCurrentState().name());
		Thread.sleep(10000);
		assertEquals("VEHICLES GREEN INT", context.getCurrentState().name());
		assertFalse(context.isPedestrianWaiting());
	}

	/**
	 * Check that initial states are traversed
	 */
	@Test
	void testInitialStates() throws InterruptedException {
		Context context = new Context();
		Thread.sleep(1);
		assertEquals("OPERATIONAL", context.getCurrentState().name());
		Thread.sleep(9);
		assertEquals("VEHICLES ENABLED", context.getCurrentState().name());
		Thread.sleep(5);
		assertEquals("VEHICLES GREEN", context.getCurrentState().name());
//		//assertEquals(VehicleLight.GREEN, context.getVehicleLight());
//		//assertFalse(context.isPedestrianWaiting());
//		//context.pedestrianWaiting();
//		//assertTrue(context.isPedestrianWaiting());
//		Thread.sleep(11000);
//
//		assertEquals("VEHICLES GREEN INT", context.getCurrentState().name());
//		context.pedestrianWaiting();
//		Thread.sleep(10);
//		System.out.println("PASSED GREEN INT---------------");
//
//		assertEquals("VEHICLES YELLOW", context.getCurrentState().name());
//		//assertEquals(VehicleLight.YELLOW, context.getVehicleLight());
//		Thread.sleep(3000);
//		System.out.println("PASSED YELLOW ---------------");
//
//		assertEquals("PEDESTRIANS ENABLED", context.getCurrentState().name());
//		//assertEquals(VehicleLight.RED, context.getVehicleLight());
//		Thread.sleep(10);
//
//		assertEquals("PEDESTRIANS WALK", context.getCurrentState().name());
//		//assertEquals(WalkLight.WALK, context.getVehicleLight());
//		Thread.sleep(15000);
//
//		assertEquals("PEDESTRIANS FLASH", context.getCurrentState().name());
//		Thread.sleep(10000);
//
//		assertEquals("VEHICLE GREEN", context.getCurrentState().name());
	}

	/**
	 * Check that when pedestrian clicks button in PEDESTRIAN FLASH state, it holds the request until next GREEN LIGHT
	 */
	@Test
	void testWaitingInFlash() throws InterruptedException {
		Context context = new Context();
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
