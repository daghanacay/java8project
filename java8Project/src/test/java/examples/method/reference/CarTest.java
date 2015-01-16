package examples.method.reference;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class CarTest {

  static Car car;

  @BeforeClass
  public static void setUpTest() {
    car = Car.create(Car::new);
  }

  @Test
  public void testUseNewReference() {
    car.repair();
    System.out.println("--------------");
  }

  @Test
  public void testStaticReference() {
    final List<Car> cars = Arrays.asList(car);
    cars.forEach(Car::collide);
    cars.forEach((c) -> Car.collide(c));
    System.out.println("--------------");
  }

  @Test
  public void testObjectReference() {
    final List<Car> cars = Arrays.asList(car);
    cars.forEach(Car::repair);
    cars.forEach((c) -> c.repair());
    // It has to be no parameter
    cars.forEach(Car::repair);
    cars.forEach((c) -> c.repairOther(c));
    System.out.println("--------------");
  }

  @Test
  public void testInstanceReference() {
    final List<Car> cars = Arrays.asList(car);
    final Car police = Car.create(Car::new);
    System.out.println("Police is: " + police.toString());
    cars.forEach(police::follow);
    cars.forEach((c) -> police.follow(c));
    System.out.println("--------------");
  }

}
