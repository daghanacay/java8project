package examples.lambda.functional.interfac;

import java.util.Arrays;
import java.util.List;

public class SomeClass {
  final List<String> localData = Arrays.asList("a", "b", "c");

  public String collectData(final FIConcatanator<String> visitor) {
    String result = localData.get(0);
    for (int i = 1; i < localData.size(); i++) {
      result = visitor.concat(result, localData.get(i));
    }
    return result;
  }

  public <T> T collectDataGeneric(final List<T> list, final FIGenericConcatinator <T> visitor) {
    return visitor.concatinate(list);
  }
}
