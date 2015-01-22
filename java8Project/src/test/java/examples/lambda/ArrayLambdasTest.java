package examples.lambda;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class ArrayLambdasTest {

  static ArrayLambdas classUnderTest;

  @BeforeClass
  public static void setUpTest() {
    classUnderTest = new ArrayLambdas();
  }

  @Test
  public void test() {
    classUnderTest.printArray();
  }

  @Test
  public void interestingCase_coordianateRunnablesWithStreams() {
    // we create a list of two runnables in a list and use stream to create threads
    final List<Runnable> runnables = Arrays.asList(() -> System.out.println("running first thread"),
        () -> System.out.println("running second thread"));
    System.out.println("staring ordered run");
    runnables.parallelStream().forEachOrdered(r -> r.run());
    System.out.println("staring random run");
    runnables.parallelStream().forEach(r -> r.run());
  }

}
