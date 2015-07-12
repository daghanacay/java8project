package examples.general.threading.javaconcurrency.lockObject;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * use of tryLock method on an ReentrantLock. Famous bow example, getting locks
 * on multiple objects before entering execution
 * 
 * @author daghan
 *
 */
public class Friend {
	private final String name;
	private final Lock lock = new ReentrantLock();

	public Friend(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public boolean impendingBow(Friend bower) {
		Boolean myLock = false;
		Boolean yourLock = false;
		// try to get lock on both Friend objects before executing a state
		try {
			myLock = lock.tryLock();
			// !!!we can access the private field of another instance of the
			// same object
			yourLock = bower.lock.tryLock();
		} finally {
			// If we cannot get lock on both objects than release whichever we
			// are holding
			if (!(myLock && yourLock)) {
				if (myLock) {
					lock.unlock();
				}
				if (yourLock) {
					bower.lock.unlock();
				}
			}
		}
		return myLock && yourLock;
	}

	public void bow(Friend bower) {
		if (impendingBow(bower)) {
			// we have both locks at this point
			try {
				System.out.format("%s: %s has" + " bowed to me!%n", this.name,
						bower.getName());
				bower.bowBack(this);
			} finally {
				// release all locks after done
				lock.unlock();
				bower.lock.unlock();
			}
		} else {
			System.out.format("%s: %s started" + " to bow to me, but saw that"
					+ " I was already bowing to" + " him.%n", this.name,
					bower.getName());
		}
	}

	public void bowBack(Friend bower) {
		System.out.format("%s: %s has" + " bowed back to me!%n", this.name,
				bower.getName());
	}
}
