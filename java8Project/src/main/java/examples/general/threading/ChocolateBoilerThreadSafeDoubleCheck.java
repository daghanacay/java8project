package examples.general.threading;

public class ChocolateBoilerThreadSafeDoubleCheck {
  // Makes sure the changes made to this field is reflected in other threads
  private static volatile ChocolateBoilerThreadSafeDoubleCheck instance;
  private boolean empty, boiled;

  public static ChocolateBoilerThreadSafeDoubleCheck getInstance() {
    if (instance == null) {
      // synchronizes threads also updates any changes made to 'instance' by other threads due to volatile
      synchronized (ChocolateBoilerThreadSafeDoubleCheck.class) {
        if (instance == null) { // check again after update to instance variable
          instance = new ChocolateBoilerThreadSafeDoubleCheck();
        }
      }

    }
    return instance;
  }

  private ChocolateBoilerThreadSafeDoubleCheck() {
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
