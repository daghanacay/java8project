package examples.stream;

public class Streams {
  protected enum Status {
    OPEN, CLOSED
  };

  protected static final class Task {
    private final Status status;
    private final Integer points;

    Task(final Status status, final Integer points) {
      this.status = status;
      this.points = points;
    }

    public Integer getPoints() {
      return points;
    }

    public Status getStatus() {
      return status;
    }

    @Override
    public String toString() {
      return String.format("[%s, %d]", status, points);
    }
  }
}
