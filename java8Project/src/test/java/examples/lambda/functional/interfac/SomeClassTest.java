package examples.lambda.functional.interfac;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

public class SomeClassTest {

  static SomeClass classUnderTest;

  @BeforeClass
  public static void setUpTest() {
    classUnderTest = new SomeClass();
  }

  @Test
  public void testLambda() {
    final String result = classUnderTest.collectData((a, b) -> a + "," + b);
    assertEquals(result, "a,b,c");
    System.out.println(result);
  }

  @Test
  public void testLambdaRepo() {
    final String result = classUnderTest.collectData(ConcatFunctions.STRING_COLUMN_CONCATINATOR);
    assertEquals(result, "a:b:c");
    System.out.println(result);
    final String result2 = classUnderTest.collectData(ConcatFunctions.STRING_COMMA_CONCATINATOR);
    assertEquals(result2, "a,b,c");
    System.out.println(result2);
  }

  @Test
  public void testIntLambdaRepo() {
    final Integer result = classUnderTest.collectDataGeneric(Arrays.asList(1, 2, 3),
        ConcatFunctions.INTEGER_TIMES_TEN_CONCATINATOR);
    assertEquals(60, result.intValue());
    System.out.println(result);
  }
}
