package examples.annotations;

import org.junit.Test;

import examples.annotations.RepeatingAnnotations.Filter;

public class RepeatingAnnotationsTest {

  @Test
  public void test() {
    for (final Filter tmp : SomeClassWithAnnotations.class.getAnnotationsByType(Filter.class)) {
      System.out.println(tmp.value());
    }
  }
}
