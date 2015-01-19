package examples.optional;

import java.util.Optional;

public class Computer {
  private final Optional<Soundcard> soundCard;

  public Optional<Soundcard> getSoundcard() {
    return soundCard;
  }

  public Computer(final Optional<Soundcard> soundcard2) {
    this.soundCard = soundcard2;
  }
}
