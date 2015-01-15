package examples.lambda.functional.interfac;

public interface ConcatFunctions {
  static final FIConcatanator<String> STRING_COMMA_CONCATINATOR = (a, b) -> a + "," + b;
  static final FIConcatanator<String> STRING_COLUMN_CONCATINATOR = (a, b) -> a + ":" + b;
  static final FIGenericConcatinator<Integer> INTEGER_TIMES_TEN_CONCATINATOR = (a) -> {
    Integer val = new Integer(0);
    for (final Integer tmp : a) {
      val += tmp * 10;
    }
    return val;
  };
}
