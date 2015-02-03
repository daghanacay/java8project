package examples.exceptions;

import java.rmi.AccessException;

public class SubClassOfExceptionClass extends ClasswithException implements InterfaceWithException {

  // You can throw a subset of exception
  @Override
  public void methodWithException() throws AccessException {
    System.out.println("child class methodWithException");
  }

  // You can just ignore Exception because it is not part of a method signature
  @Override
  public void methodWithException2() {
    System.out.println("child class methodWithException2");
  }

  // Rules are same for interfaces
  @Override
  public void exceptionMethod() {
  }

  // You can throw ANY runtime exception
  @Override
  public void exceptionMethod2() throws RuntimeException {
  }

  // if you have throw A CHECKED exception inside a method you either catch or throw it in the method
  public void newMethod() throws Exception {
    throw new Exception();
  }

  // if you have throw A UNCHECKED exception inside a method you don't need to do anything
  public void newMethod2() {
    throw new RuntimeException();
  }
}
