package examples.general.threading;

public class ChocolateBoilerThreadUnsafe {
  private static ChocolateBoilerThreadUnsafe instance;
  private boolean empty, boiled;

  public static ChocolateBoilerThreadUnsafe getInstance() {
    if (instance == null) {
      instance = new ChocolateBoilerThreadUnsafe();
    }
    return instance;
  }

  private ChocolateBoilerThreadUnsafe() {
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
