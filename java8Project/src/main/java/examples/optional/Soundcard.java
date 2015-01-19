package examples.optional;

import java.util.Optional;

public class Soundcard {
  private Optional<USB> usb;

  public Optional<USB> getUSB() {
    return usb;
  }
}
