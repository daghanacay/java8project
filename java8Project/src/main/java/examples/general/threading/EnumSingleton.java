package examples.general.threading;

public enum EnumSingleton {
  SingletonChocolateBoiler;

  private boolean empty, boiled;
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
