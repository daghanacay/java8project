package examples.interfac;

public interface INewInterfaceMethods {
  public void firstMethod();
  // Default methods do not affect the implementing classes
  public default void defaultMethod(){
    System.out.println("Hello from new interface method");
  }
  // You can also add static methods
  public static void staticInterfaceMethod(){
    System.out.println("Print a message from from static interface method");
  }

}
