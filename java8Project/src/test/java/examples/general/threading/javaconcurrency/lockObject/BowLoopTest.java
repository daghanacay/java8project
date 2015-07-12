package examples.general.threading.javaconcurrency.lockObject;

import org.testng.annotations.Test;

public class BowLoopTest {

	final Friend alphonse = new Friend("Alphonse");
	final Friend gaston = new Friend("Gaston");
	
	//@Test(timeOut=110)
	@Test(threadPoolSize = 5, invocationCount = 5)
	public void test() throws InterruptedException {
		BowLoop loop1 = new BowLoop(alphonse, gaston);
		BowLoop loop2 = new BowLoop(gaston, alphonse);
		new Thread(loop1).start();
		new Thread(loop2).start();
		
		Thread.sleep(100);
		
		loop1.stopBow();
		loop2.stopBow();
	}

}
