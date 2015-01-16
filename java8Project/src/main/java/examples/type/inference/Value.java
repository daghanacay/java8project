package examples.type.inference;

public class Value<T> {
  // You need to add type parameter <T> in static method
  public static <T> T defaultValue() {
    return null;
  }

  // Type parameter comes from the class definitions
  public T getOrDefault(final T value, final T defaultValue) {
    return value != null ? value : defaultValue;
  }
  // We need to add additional type parametr
  public <R extends T> T getOrDefault2(final T value, final R defaultValue) {
    return value != null ? value : defaultValue;
  }
}
