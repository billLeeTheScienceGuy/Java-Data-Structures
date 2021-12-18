import java.io.File;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Main graphical application class for the simulation engine.
 * Manages the rendering loop, global state, and user input events.
 * @author Bill Lee
 */
public class FishTank {
  private static PApplet processing; 
  private static PImage backgroundImage; 
  private static Fish[] fishes; 
  private static Random randGen; 
  
  private static String[] images = new String[] {"orange.png", "blue.png", "yellow.png", "black.png"};
  private static int nextImageIndex;

  public static void setup(PApplet processingObj) {
    processing = processingObj;
    backgroundImage = processing.loadImage("images" + File.separator + "background.png");
    fishes = new Fish[8];
    randGen = new Random();
  }

  public static void draw() {
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);

    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] != null) {
        fishes[i].draw();
      }
    }
  }

  public static void mousePressed() {
    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] != null && fishes[i].isMouseOver()) {
        fishes[i].startDragging();
        break; 
      }
    }
  }

  public static void mouseReleased() {
    for (int i = 0; i < fishes.length; i++) {
      if (fishes[i] != null) {
        fishes[i].stopDragging();
      }
    }
  }

  public static void keyPressed() {
    switch (Character.toUpperCase(processing.key)) {
      case 'F': 
        for (int i = 0; i < fishes.length; i++) {
          if (fishes[i] == null) {
            fishes[i] = new Fish(processing, (float) randGen.nextInt(processing.width),
                (float) randGen.nextInt(processing.height), 5,
                "images" + File.separator + images[nextImageIndex]);
            nextImageIndex = (nextImageIndex + 1) % images.length;
            break;
          }
        }
        break;
      case 'R': 
        for (int i = 0; i < fishes.length; i++) {
          if (fishes[i] != null && fishes[i].isMouseOver()) {
            fishes[i] = null;
            break;
          }
        }
        break;
      case 'S': 
        for (int i = 0; i < fishes.length; i++) {
          if (fishes[i] != null) {
            fishes[i].startSwimming();
          }
        }
        break;
      case 'X': 
        for (int i = 0; i < fishes.length; i++) {
          if (fishes[i] != null) {
            fishes[i].stopSwimming();
          }
        }
        break;
    }
  }

  public static void main(String[] args) {
    Utility.startApplication();
  }
}