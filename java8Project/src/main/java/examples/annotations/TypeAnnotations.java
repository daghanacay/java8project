package examples.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TypeAnnotations {
  // The ElementType.TYPE_USE and ElementType.TYPE_PARAMETER are two new element types to describe the applicable
  // annotation context.
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ ElementType.TYPE_USE, ElementType.TYPE_PARAMETER })
  public @interface NonEmpty {
  }
}
