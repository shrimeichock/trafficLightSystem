/**
 * Test class for traffic lights
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import stateMachine.Context;

import java.util.concurrent.TimeUnit;

/**
 * @author meich
 *
 */
class stateMachineTest {


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	/**
	 * TODO Add javadoc
	 */
	@Test
	void test() throws InterruptedException {
		Context context = new Context();
		//context.pedestrianSignal()
		//TimeUnit.SECONDS.sleep(10);  //delay
	}

}
