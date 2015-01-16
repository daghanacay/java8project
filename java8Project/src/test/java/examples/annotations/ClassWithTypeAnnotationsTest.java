package examples.annotations;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import examples.annotations.TypeAnnotations.NonEmpty;

public class ClassWithTypeAnnotationsTest {

  @Test
  public void test() {
    final ClassWithTypeAnnotations<String> holder = new @NonEmpty ClassWithTypeAnnotations<String>();
    @NonEmpty
    final Collection<@NonEmpty String> strings = new ArrayList<>();
  }

}
