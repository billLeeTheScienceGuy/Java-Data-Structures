/**
 * Models a linked node carrying an instance of a Tile for stack allocation.
 */
public class Node {
  private Tile tile; 
  private Node next; 

  public Node(Tile tile) {
    this.tile = tile;
  }
  
  public Node(Tile tile, Node next) {
    this.tile = tile;
    this.next = next;
  }

  public Tile getTile() {
    return tile;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}