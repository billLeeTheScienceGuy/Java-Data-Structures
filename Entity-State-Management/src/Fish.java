import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents an independent graphical entity within the simulation.
 * Encapsulates state data such as position, speed, and interaction status.
 * @author Bill Lee
 */
public class Fish {
  private static PApplet processing;
  private PImage image;
  private float x;
  private float y;
  private int speed;
  private boolean isDragging;
  private boolean isSwimming;
  private static int oldMouseX;
  private static int oldMouseY;

  public Fish(PApplet processing, float x, float y, int speed, String fishImageFileName) {
    Fish.processing = processing;
    this.x = x;
    this.y = y;
    this.speed = speed;
    this.isDragging = false;
    this.isSwimming = false;
    this.image = processing.loadImage(fishImageFileName);
  }

  public Fish(PApplet processing) {
    Fish.processing = processing;
    this.image = processing.loadImage("images" + File.separator + "orange.png");
    this.speed = 5; 
    this.x = processing.width / 2;
    this.y = processing.height / 2;
    this.isDragging = false;
    this.isSwimming = false;
  }

  public PImage getImage() {
    return this.image;
  }

  public float getPositionX() {
    return this.x;
  }

  public float getPositionY() {
    return this.y;
  }

  public void move(int dx, int dy) {
    this.x += dx;
    this.y += dy;
  }

  public boolean isDragging() {
    return this.isDragging;
  }

  public void startDragging() {
    oldMouseX = (int) processing.mouseX;
    oldMouseY = (int) processing.mouseY;
    this.isDragging = true;
  }

  public void stopDragging() {
    this.isDragging = false;
  }

  public void draw() {
    if (this.isSwimming) {
      this.swim();
    }
    if (this.isDragging) {
      move(processing.mouseX - oldMouseX, processing.mouseY - oldMouseY);
      oldMouseX = (int) processing.mouseX;
      oldMouseY = (int) processing.mouseY;
    }
    processing.image(this.image, this.x, this.y);
  }

  public boolean isMouseOver() {
    int fishWidth = this.getImage().width;
    int fishHeight = this.getImage().height;

    return processing.mouseX >= this.getPositionX() - fishWidth / 2
        && processing.mouseX <= this.getPositionX() + fishWidth / 2
        && processing.mouseY >= this.getPositionY() - fishHeight / 2
        && processing.mouseY <= this.getPositionY() + fishHeight / 2;
  }

  public void startSwimming() {
    this.isSwimming = true;
    this.stopDragging();
  }

  public void stopSwimming() {
    this.isSwimming = false;
  }

  public void swim() {
    this.move(this.speed, 0);
    if (this.x > processing.width) {
      this.x = 0;
    }
  }
}