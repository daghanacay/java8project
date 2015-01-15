package examples.lambda.functional.interfac;

import java.util.List;

@FunctionalInterface
public interface FIGenericConcatinator <T>{
  public T concatinate(final List<T> list);
}
