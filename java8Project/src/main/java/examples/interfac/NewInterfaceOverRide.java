package examples.interfac;

public class NewInterfaceOverRide implements INewInterfaceMethods{

  @Override
  public void firstMethod() {
    // Do nothing
  }

  @Override
  public void defaultMethod(){
    System.out.println("Over ride defaultMethod in " + this.getClass().getName());
  }

}
