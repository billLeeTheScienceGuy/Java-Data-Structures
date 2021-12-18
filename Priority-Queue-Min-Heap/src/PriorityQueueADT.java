import java.util.NoSuchElementException;

/**
 * This interface models the priority queue abstract data type.
 * @param <T> type parameter bounded by the Comparable interface.
 */
public interface PriorityQueueADT<T extends Comparable<T>> {
  public boolean isEmpty();
  public int size();
  public void enqueue(T element);
  public T dequeue();
  public T peek();
  public void clear();
}