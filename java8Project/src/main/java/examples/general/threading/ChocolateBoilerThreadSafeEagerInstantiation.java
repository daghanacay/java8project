package examples.general.threading;

public class ChocolateBoilerThreadSafeEagerInstantiation {
  private static ChocolateBoilerThreadSafeEagerInstantiation instance = new ChocolateBoilerThreadSafeEagerInstantiation();
  // Makes sure the changes made to this field is reflected in other threads
  private boolean empty, boiled;

  public static ChocolateBoilerThreadSafeEagerInstantiation getInstance() {
    return instance;
  }

  private ChocolateBoilerThreadSafeEagerInstantiation() {
    empty = true;
    boiled = false;
  }

  public void fill() {
    if (isEmpty()) {
      empty = false;
      boiled = false;
      System.out.println("-------\nFilling...\n");
    } else {
      System.err.println("reject filling. wrong state\n");
    }
  }

  public void drain() {
    if (!isEmpty() && isBoiled()) {
      empty = true;
      System.out.println("Draining...\n------------\n");
    } else {
      System.err.println("reject draining. wrong state\n");
    }
  }

  public void boil() {
    if (!isEmpty() && !isBoiled()) {
      boiled = true;
      System.out.println("Boiling...\n");
    } else {
      System.err.println("reject boiling. wrong state\n");
    }
  }

  public boolean isEmpty() {
    return empty;
  }

  public boolean isBoiled() {
    return boiled;
  }
}
