package examples.lambda;

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

}
