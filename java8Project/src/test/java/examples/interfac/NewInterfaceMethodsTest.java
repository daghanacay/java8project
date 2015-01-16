package examples.interfac;

import org.junit.Test;

public class NewInterfaceMethodsTest {

  INewInterfaceMethods classUnderTest = new NewInterfaceImp();

  @Test
  public void test() {
    classUnderTest.firstMethod();
    classUnderTest.defaultMethod();
    INewInterfaceMethods.staticInterfaceMethod();
  }

}
