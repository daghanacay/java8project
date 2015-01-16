package examples.annotations;

import examples.annotations.RepeatingAnnotations.Filter;

@Filter("filter1 Value")
@Filter(value = "filter2 value")
public class SomeClassWithAnnotations {

}
