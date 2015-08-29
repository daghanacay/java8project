package examples.general.threading;

import org.testng.annotations.Test;

public class ChocolateBoilerTest {

	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testThreadUnsafe() {
		final ChocolateBoilerThreadUnsafe instance = ChocolateBoilerThreadUnsafe
				.getInstance();
		// this might return multiple instances
		System.out.println(instance);
	}

	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testThreadSafeSynchronized() {
		final ChocolateBoilerThreadSafeSynchronize instance = ChocolateBoilerThreadSafeSynchronize
				.getInstance();
		System.out.println(instance);
	}

	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testThreadSafeDoubleCheck() {
		final ChocolateBoilerThreadSafeDoubleCheck instance = ChocolateBoilerThreadSafeDoubleCheck
				.getInstance();
		System.out.println(instance);
	}

	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testThreadSafeEagerInstantiation() {
		final ChocolateBoilerThreadSafeEagerInstantiation instance = ChocolateBoilerThreadSafeEagerInstantiation
				.getInstance();
		System.out.println(instance);
	}

	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testThreadSafeEnum() {
		System.out.println(EnumSingleton.SingletonChocolateBoiler);
	}

	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testThreadSafeEnumMethodCallsSynched() {
		// make sure the threads have the lock while calling the methods so no
		// other thread will call in different order. Using lock in the code
		// will remove this synch block here
		synchronized (EnumSingleton.SingletonChocolateBoiler) {
			EnumSingleton.SingletonChocolateBoiler.fill();
			EnumSingleton.SingletonChocolateBoiler.boil();
			EnumSingleton.SingletonChocolateBoiler.drain();
		}
	}

	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testThreadSafeEnumMethodCalls() {
		// Try this by removing the locking in the code.
		EnumSingleton.SingletonChocolateBoiler.fill();
		EnumSingleton.SingletonChocolateBoiler.boil();
		EnumSingleton.SingletonChocolateBoiler.drain();
	}
}
