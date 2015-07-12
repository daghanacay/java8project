package examples.general.threading.javaconcurrency.lockObject;

import java.util.Random;

public class BowLoop implements Runnable {
	private Friend bower;
	private Friend bowee;
	// use volatile to make sure the setting of this value is done atomically,
	// eg. get value, change value, set value will be done in one step when the
	// value is modified by one thread so two threads will not overide each
	// other's update or read an inconsistent value. NOTE you can use
	// AtomicBoolean if you need functionality other then getting and setting a
	// value
	private volatile boolean continueBow = true;

	public BowLoop(Friend bower, Friend bowee) {
		this.bower = bower;
		this.bowee = bowee;
	}

	public void stopBow() {
		continueBow = false;
	}

	public void run() {
		Random random = new Random();
		while (continueBow) {
			try {
				Thread.sleep(random.nextInt(10));
			} catch (InterruptedException e) {
			}
			bowee.bow(bower);
		}
	}
}
