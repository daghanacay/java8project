package examples.lambda.functional.interfac;

public interface ConcatFunctions {
  final static FIConcatanator<String> STRING_COMMA_CONCATINATOR = (a, b) -> a + "," + b;
  final static FIConcatanator<String> STRING_COLUMN_CONCATINATOR = (a, b) -> a + ":" + b;
}
