/**
 * Interface representing interactive graphical objects within the display window.
 * @author Bill Lee
 */
public interface TankListener {
    public void draw();
    public void mousePressed();
    public void mouseReleased();
    public boolean isMouseOver();
}