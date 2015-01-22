package examples.general.threading;

import org.testng.annotations.Test;

public class ChocolateBoilerTest {

  @Test(threadPoolSize = 5, invocationCount = 5)
  public void testThreadUnsafe() {
    final ChocolateBoilerThreadUnsafe instance = ChocolateBoilerThreadUnsafe.getInstance();
    //this might return multiple instances
    System.out.println(instance);
  }


  @Test(threadPoolSize = 5, invocationCount = 5)
  public void testThreadSafeSynchronized() {
    final ChocolateBoilerThreadSafeSynchronize instance = ChocolateBoilerThreadSafeSynchronize.getInstance();
    //this might return multiple instances
    System.out.println(instance);
  }

  @Test(threadPoolSize = 5, invocationCount = 5)
  public void testThreadSafeDoubleCheck() {
    final ChocolateBoilerThreadSafeDoubleCheck instance = ChocolateBoilerThreadSafeDoubleCheck.getInstance();
    //this might return multiple instances
    System.out.println(instance);
  }

  @Test(threadPoolSize = 5, invocationCount = 5)
  public void testThreadSafeEagerInstantiation() {
    final ChocolateBoilerThreadSafeEagerInstantiation instance = ChocolateBoilerThreadSafeEagerInstantiation.getInstance();
    //this might return multiple instances
    System.out.println(instance);
  }

  @Test(threadPoolSize = 5, invocationCount = 5)
  public void testThreadSafeEnum() {
    //this might return multiple instances
    System.out.println(EnumSingleton.SingletonChocolateBoiler);
  }
}
