package examples.exceptions;

public class ClientClass {
  void doSomething() {
    final SubClassOfExceptionClass testClass = new SubClassOfExceptionClass();
    // Overridden method DOES NOT need to catch exception
    System.out.println("entering child method with no cast");
    testClass.methodWithException2();
    // casted class has to catch the exception ALTHOUGH the subclass method is called by the vm
    try {
      System.out.println("entering child method with parent cast");
      ((ClasswithException) testClass).methodWithException2();
    } catch (final Exception e1) {
      e1.printStackTrace();
    }

    final ClasswithException testClassParent = new ClasswithException();

    try {
      System.out.println("entering parent method with no cast");
      testClassParent.methodWithException2();
    } catch (final Exception e) {
      e.printStackTrace();
    }

    // Reverse of above using polymorpism.
    final ClasswithException testClassPoly = new SubClassOfExceptionClass();

    // You need to catch exteption because the type is parent class althought the instance is the child and the subclass
    // method is called by the vm
    try {
      System.out.println("entering parent Type with child instance");
      testClassPoly.methodWithException2();
    } catch (final Exception e) {
      e.printStackTrace();
    }
    System.out.println("entering parent type with child cast");
    // if you cast it then there is no exception to be thrown
    ((SubClassOfExceptionClass) testClassPoly).methodWithException2();

  }
}
