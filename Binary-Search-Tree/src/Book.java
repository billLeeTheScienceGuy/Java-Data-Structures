/**
 * An instantiable class representing information about a Book.
 * Implements customized comparison logic based on dynamic attributes.
 * @author Bill Lee
 */
public class Book {

  private static int idGenerator = 0;
  private String authorLastname;
  private String authorFirstname;
  private String title;
  private int pageCount;
  
  public final int ID;
  
  public Book(String title, int pageCount) {
    if (pageCount <= 0) throw new IllegalArgumentException("Invalid page count");
    this.title = title;
    this.pageCount = pageCount;
    this.ID = idGenerator++;
    
    this.authorFirstname = "";
    this.authorLastname = "";
  }
  
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
   * A nonstandard compareTo - based on the attribute argument, returns a comparison of this Book
   * to otherBook based on one of four possible pieces of data.
   * @param otherBook the Book to compare this one to
   * @param a the attribute on which to compare them
   * @return negative if this Book is greater, positive if less, 0 if equal.
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
  public boolean equals(Object o) {
	  Book book = (Book)o;
	  if((!book.toString().equals(o.toString())) || (!(o instanceof Book))) {
		  return false;
	  }
	  return true;
  }

  @Override
  public String toString() {
    return this.ID + ": \"" + this.title + "\", " + this.getAuthor() + " (" + this.pageCount + ")";
  }
  
  public static void resetGenerator() {
    idGenerator = 0;
  }
}