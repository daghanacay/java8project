package examples.annotations;

import examples.annotations.TypeAnnotations.NonEmpty;

public class ClassWithTypeAnnotations<@NonEmpty T> extends @NonEmpty Object {
  public void method() throws @NonEmpty Exception {
  }
}
