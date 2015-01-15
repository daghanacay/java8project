package examples.lambda.functional.interfac;

@FunctionalInterface
public interface FIConcatanator<T> {
  public String concat(final T a, final T b);

  // static method does not brake the Functional interface
  static String trial() {
    return "sa";
  };

  // default method does not break the functional interface
  default String defaultMethod() {
    return "sa";
  };
}
