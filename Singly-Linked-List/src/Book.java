/**
 * An instantiable class representing data for a book entity.
 * Implements custom comparison logic based on dynamic attributes.
 * @author Bill Lee
 */
public class Book {

  private static int idGenerator = 0;
  private String authorLastname;
  private String authorFirstname;
  private String title;
  private int pageCount;
  
  public final int ID;
  
  /**
   * Constructs a Book with no recorded author.
   * @param title the title of the Book
   * @param pageCount the number of pages in the Book
   */
  public Book(String title, int pageCount) {
    if (pageCount <= 0) throw new IllegalArgumentException("Invalid page count");
    this.title = title;
    this.pageCount = pageCount;
    this.ID = idGenerator++;
    
    this.authorFirstname = "";
    this.authorLastname = "";
  }
  
  /**
   * Constructs a Book with a specific author.
   * @param title the title of the Book
   * @param pageCount the number of pages in the Book
   * @param last the author's last name
   * @param first the author's first name
   */
  public Book(String title, int pageCount, String last, String first) {
    this(title, pageCount);
    this.authorFirstname = first;
    this.authorLastname = last;
  }
  
  public String getAuthor() {
    return authorLastname + ", " + authorFirstname;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public int getPageCount() {
    return this.pageCount;
  }
  
  /**
   * Compares this Book to another Book based on a specified attribute.
   * @param otherBook the Book to compare this one to
   * @param a the attribute on which to compare them
   * @return negative if this Book is less, positive if greater, 0 if equal.
   */
  public int compareTo(Book otherBook, Attribute a) {
    switch(a) {
      case ID:
        return this.ID - otherBook.ID;
      case TITLE:
        return this.title.compareTo(otherBook.title);
      case AUTHOR:
        return this.getAuthor().compareTo(otherBook.getAuthor());
      case PAGECOUNT:
        return this.pageCount - otherBook.pageCount;
      default: return 0;
    }
  }
  
  @Override
  public String toString() {
    return this.ID + ": \"" + this.title + "\", " + this.getAuthor() + " (" + this.pageCount + ")";
  }
  
  public static void resetGenerator() {
    idGenerator = 0;
  }
}