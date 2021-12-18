/**
 * This interface models an Iterable Stack Abstract Data Type.
 *
 * @param <T> the type of objects to be stored in this stack
 */
public interface StackADT<T> {
  
  /**
   * Adds an element to this stack.
   * @param element an element to be added
   * @throws java.lang.IllegalArgumentException if the input element is null
   */
  public void push(T element);

  /**
   * Removes the element on the top of this stack and returns it.
   * @return the element removed from the top of the stack
   * @throws java.util.EmptyStackException if the stack is empty
   */
  public T pop();

  /**
   * Gets the element on the top of this stack.
   * @return the element on the stack top
   * @throws java.util.EmptyStackException if the stack is empty
   */
  public T peek();

  /**
   * Checks whether this stack is empty or not.
   * @return true if this stack contains no elements, otherwise false
   */
  public boolean isEmpty();

  /**
   * Gets the number of elements in this stack.
   * @return the size of the stack
   */
  public int size();
}