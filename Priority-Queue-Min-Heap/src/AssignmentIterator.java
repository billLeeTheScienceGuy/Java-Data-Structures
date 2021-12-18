import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements an iterator for Assignments, returning them in order from earliest to
 * latest based on their order in a priority queue.
 * @author Bill Lee
 */
public class AssignmentIterator implements Iterator<Assignment> {
  private AssignmentQueue queue; 

  public AssignmentIterator(AssignmentQueue queue) {
    this.queue = queue.deepCopy(); 
  }

  @Override
  public boolean hasNext() {
    return !queue.isEmpty();
  }

  @Override
  public Assignment next() {
    if (!hasNext())
      throw new NoSuchElementException("No more assignments in this iteration");
    return queue.dequeue();
  }
}