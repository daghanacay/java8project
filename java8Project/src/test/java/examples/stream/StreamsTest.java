package examples.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import examples.stream.Streams.Status;
import examples.stream.Streams.Task;

public class StreamsTest {

  final Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13), new Task(
      Status.CLOSED, 8));

  @Test
  public void testStream() {
    final long totalPointsOfOpenTasks = tasks.stream().filter(task -> task.getStatus() == Status.OPEN)
        .mapToInt(Task::getPoints).sum();

    System.out.println("Total points: " + totalPointsOfOpenTasks);

    // sum with reduce
    final int sumOfPoints = tasks.stream().reduce(0, (sum, b) -> sum + b.getPoints(), Integer::sum);
    System.out.println("Total points: " + sumOfPoints);
  }

  @Test
  public void testParallelStream() {
    final long totalPointsOfOpenTasks = tasks.parallelStream().filter(task -> task.getStatus() == Status.OPEN)
        .mapToInt(Task::getPoints).sum();

    System.out.println("Total points: " + totalPointsOfOpenTasks);
  }

  @Test
  public void testSideEffect() {
    // NOT Recommended do the side effect
    // http://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#StreamOps Unnecessary use of
    // side-effects!
    final ArrayList<Task> results = new ArrayList<>();
    tasks.parallelStream().filter(task -> task.getStatus() == Status.OPEN).forEach(s -> results.add(s));
    System.out.println("Filtered tasks: " + results);

    final List<Task> pointsOfOpenTasks = tasks.parallelStream().filter(task -> task.getStatus() == Status.OPEN)
        .collect(Collectors.toList());// No side effects Recommended

    System.out.println("Filtered tasks: " + pointsOfOpenTasks);
  }

  @Test
  public void testReductions() {
    // reduce function should be associative, i.e. (a op b) op c == a op (b op c)
    final long totalPointsOfOpenTasks = tasks.parallelStream().filter(task -> task.getStatus() == Status.OPEN)
        .reduce((task1, task2) -> new Task(Status.OPEN, task1.getPoints() + task2.getPoints())).get().getPoints();

    System.out.println("Total points: " + totalPointsOfOpenTasks);
  }

  @Test
  public void testCollectors() {
    // reduce function should be associative, i.e. (a op b) op c == a op (b op c)
    final Map< Status, List< Task > > map  = tasks.parallelStream().collect(Collectors.groupingBy(Task::getStatus));

    System.out.println("Grouping based on status: " + map);
  }
}
