package examples.general.threading;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import org.testng.annotations.Test;

public class GuardedBlockTest {
	private final GuardedBlock unitUnderTest = new GuardedBlock();
	private Logger logger = Logger.getLogger(GuardedBlockTest.class.getName());

	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testStartGuardedJoy() {
		// Create a waking thread so after the threads are blocked in the
		// testStartGuardedJoy test we can unblock them
		TimerTask wakingTask = new TimerTask() {
			@Override
			public void run() {
				unitUnderTest.notifyJoy();
			}
		};
		new Timer().schedule(wakingTask, 100);	
		
		logger.info(String.format(
				"Thread %s has called on the object guardedBlock with id %s",
				Thread.currentThread().getId(), unitUnderTest.toString()));

		unitUnderTest.guardedJoy();
		logger.info(String.format(
				"Thread %s has Finished on the object guardedBlock with id %s",
				Thread.currentThread().getName(), unitUnderTest.toString()));
	}
	
	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testStartGuardedJoyWithCondition() {
		// Create a waking thread so after the threads are blocked in the
		// testStartGuardedJoy test we can unblock them
		TimerTask wakingTask = new TimerTask() {
			@Override
			public void run() {
				unitUnderTest.notifyJoyUseCondition();
			}
		};
		new Timer().schedule(wakingTask, 100);	
		logger.info(String.format(
				"Thread %s has called on the object guardedBlock with id %s",
				Thread.currentThread().getId(), unitUnderTest.toString()));

		unitUnderTest.guardedJoyWithReantrantLockAndCondition();
		logger.info(String.format(
				"Thread %s has Finished on the object guardedBlock with id %s",
				Thread.currentThread().getName(), unitUnderTest.toString()));
	}

}
