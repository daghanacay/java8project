package examples.general.threading;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample {
	int counter = 0;
	// We could also use AtomicInteger class, but below is more generic
	AtomicReference<Integer> threadSafeCounter = new AtomicReference<>(0);

	public void increment() {
		counter++;
	}

	public void decrement() {
		counter--;
	}

	public int value() {
		return counter;
	}

	public void incrementThreadSafe() {
		threadSafeCounter.getAndUpdate(x -> x + 1);
	}

	public void decrementThreadSafe() {
		threadSafeCounter.getAndUpdate(x -> x - 1);
	}

	public int valueThreadSafe() {
		return threadSafeCounter.get();
	}

}
