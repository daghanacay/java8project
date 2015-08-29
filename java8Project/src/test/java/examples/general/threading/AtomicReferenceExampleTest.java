package examples.general.threading;

import org.testng.annotations.Test;

public class AtomicReferenceExampleTest {

	AtomicReferenceExample unitUnderTest = new AtomicReferenceExample();

	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testMultipleValue() throws InterruptedException {
		unitUnderTest.increment();
		Thread.sleep(100);
		unitUnderTest.decrement();
		// last number is not 0 sometimes which means the value is overriden at
		// some point
		System.out.println(unitUnderTest.value());
	}
	
	@Test(threadPoolSize = 5, invocationCount = 5)
	public void testMultipleValueThreadSafe() throws InterruptedException {
		unitUnderTest.incrementThreadSafe();
		Thread.sleep(100);
		unitUnderTest.decrementThreadSafe();
		// last number is not 0 sometimes which means the value is overriden at
		// some point
		System.out.println(unitUnderTest.valueThreadSafe());
	}

}
