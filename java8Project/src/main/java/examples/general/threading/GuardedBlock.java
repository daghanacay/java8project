package examples.general.threading;

public class GuardedBlock {
	private boolean joy = false;

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
}
