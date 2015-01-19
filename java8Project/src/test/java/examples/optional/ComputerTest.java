package examples.optional;

import java.util.Optional;

import org.junit.Test;

public class ComputerTest {

  @Test
  public void test() {
    final Optional<Computer> computer = Optional.of(new Computer(Optional.of(new Soundcard())));
    computer.flatMap(Computer::getSoundcard).map(Soundcard::getUSB)
    .orElse(Optional.of(new USB("NO version"))).map(USB::getVersion).ifPresent((s)-> System.out.println(s));
  }

}
