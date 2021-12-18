import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;

/**
 * Models a school assignment with a name and chronologically sortable due date.
 * @author Bill Lee
 */
public class Assignment implements Comparable<Assignment> {
  private static int idGenerator = 1; 
  private final int ID; 
  private final String name; 
  private final Date dueDate; 

  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd ha"); 
  private static final String TO_STRING_FORMAT = "%s (Due %s)"; 

  public Assignment(String name, int month, int dayOfMonth, int hour) {
    this.ID = idGenerator;
    idGenerator++;
    this.name = name;
    try {
      Calendar calendar = Calendar.getInstance();
      calendar.set(Calendar.MONTH, month - 1);
      calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
      calendar.set(Calendar.HOUR_OF_DAY, hour);
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      this.dueDate = calendar.getTime();
    } catch (DateTimeException e) {
      throw new IllegalArgumentException("Invalid date format");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Assignment)) {
      return false;
    }
    Assignment other = (Assignment) o;
    return other.name.equals(this.name) && other.dueDate.equals(this.dueDate);
  }

  @Override
  public int compareTo(Assignment o) {
    if(this.dueDate.equals(o.dueDate))
      return this.ID - o.ID;
    return this.dueDate.compareTo(o.dueDate);
  }

  @Override
  public String toString() {
    return String.format(TO_STRING_FORMAT, name, DATE_FORMAT.format(dueDate));
  }

  public static void resetGenerator() {
    idGenerator = 1;
  }
}