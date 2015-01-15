package examples.lambda;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLambdas {

  public void printArray() {
    // Creating array list from varrags and array
    Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
    Arrays.asList(new String[] { "a", "b", "c" }).forEach(e -> System.out.println(e));

    // Creating List with different object types and adding local var into lambda expression
    final String val = "    ";
    Arrays.asList("a", 1, "c", new ArrayList<String>()).forEach(e -> {
      System.out.print(e + val);
      System.out.println(e.getClass().getName());
    });

    // Lambda with return value
    Arrays.asList("a", "c").sort((e1, e2) -> {
      final int result = e1.compareTo(e2);
      return result;
    });
  }
}
