package examples.exceptions;

import java.rmi.RemoteException;

public class ClasswithException {
  public void methodWithException () throws RemoteException { System.out.println("parent class methodWithException");}
  public void methodWithException2 () throws Exception { System.out.println("parent class methodWithException2");}
}
