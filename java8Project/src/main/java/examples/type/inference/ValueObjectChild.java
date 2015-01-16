package examples.type.inference;

public class ValueObjectChild extends ValueObject {
  double val;

  public ValueObjectChild(final double val) {
    super((int) val);
  }
}
