package examples.general.threading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GuardedBlock {
	private boolean joy = false;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	// All the threads are going to take the lock as GuardedBlock instance
	// object and will wait in which case the thread will release the lock
	// (GuardedBlock instance
	// object). if you do not use synchronized keyword here then you will get
	// java.lang.IllegalMonitorStateException at runtime since wait needs a lock
	// to monitor the waiting thread. That is, Object.wait() can only be called
	// if the
	// thread has the Object as lock from which the wait is called. In this case
	// thread is synchronized on the instance of Guardblock (due to synchronized
	// keyword on the guardedJoy method) and the wait method is called
	// on the GuardBlock instance as is done below.
	public synchronized void guardedJoy() {
		// This guard only loops once for each special event, which may not
		// be the event we're waiting for.
		while (!joy) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Joy and efficiency have been achieved!");
	}

	public synchronized void notifyJoy() {
		joy = true;
		notifyAll();
	}

	public void guardedJoyWithReantrantLockAndCondition() {
		lock.lock();
		try {
			condition.await();
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}

		System.out.println("Joy and efficiency have been achieved!");
	}

	public void notifyJoyUseCondition() {
		lock.lock();
		condition.signalAll();
		lock.unlock();
	}

}
