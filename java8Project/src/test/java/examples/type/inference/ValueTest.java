package examples.type.inference;

import org.junit.Test;

public class ValueTest {

  // The type parameter of Value.defaultValue()is inferred and is not required to be provided. In Java 7, the same
  // example will not compile and should be rewritten to Value.< String >defaultValue().
  @Test
  public void test() {
    final Value<String> value = new Value<>();
    value.getOrDefault("22", Value.defaultValue());
  }

  @Test
  public void testGetOrDefault2() {
    final Value<ValueObject> value = new Value<>();
    value.getOrDefault2(new ValueObject(22), new ValueObjectChild(10.5));
  }

}
