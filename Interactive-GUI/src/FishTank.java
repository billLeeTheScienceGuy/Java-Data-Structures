import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * @author Bill Lee
 * This class implements the main graphical interface and logic for an interactive fish tank simulation.
 * It handles the rendering, state management, and user interactions for an array of graphical objects.
 */
public class FishTank {
	private static PApplet processing; 
	private static PImage backgroundImage; 
	private static Fish[] fishes; 
	private static Random randGen; 

	/**
	* Defines the initial environment properties of the graphical application.
	* @param processingObj a reference to the graphic display window of this application
	*/
	public static void setup(PApplet processingObj) {
		FishTank.processing = processingObj;
		backgroundImage = processing.loadImage("images/background.png");
		processing.image(backgroundImage, processing.width / 2, processing.height / 2);
		
		fishes = new Fish[8];
		randGen = new Random();
	}

	/**
	* Draws and updates the application display window.
	* This callback method is called in an infinite loop by the processing library.
	*/
	public static void draw() {
		processing.image(backgroundImage, processing.width / 2, processing.height / 2);
		for (int i = 0; i < fishes.length; ++i) {
			if (fishes[i] != null) {
				fishes[i].draw();
			}
		}
	}

	/**
	* Checks if the user's mouse is currently hovering over a specific Fish object.
	*
	* @param Fish reference to a specific fish
	* @return true if the mouse is over the specific Fish object's hit box, false otherwise
	*/
	public static boolean isMouseOver(Fish Fish) {
		for(int i = 0; i < fishes.length; ++i) {
			if (Fish != null) {
				float x = Fish.getPositionX();
				float y = Fish.getPositionY();
				float w = (Fish.getImage().width)/2;
				float h = (Fish.getImage().height)/2;
				
				if((x - w) <= processing.mouseX && (x + w) >= processing.mouseX && (y - h)
						<= processing.mouseY && (y + h) >= processing.mouseY) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	* Callback method triggered each time the user presses the mouse button.
	*/
	public static void mousePressed() {
		for(int i = 0; i < fishes.length; ++i) {
			if (fishes[i] != null){
				if(isMouseOver(fishes[i])) {
					fishes[i].setDragging(true);
					break;
				}
			}
		}
	}

	/**
	* Callback method triggered each time the mouse button is released.
	*/
	public static void mouseReleased() {
		for(int i = 0; i < fishes.length; ++i) {
			if (fishes[i] != null){
				fishes[i].setDragging(false);
			}
		}
	}

	/**
	* Callback method triggered each time the user presses a key on the keyboard.
	* 'F' adds a new fish to the tank if space is available.
	* 'R' removes the fish currently being hovered over.
	*/
	public static void keyPressed() {
		for(int i = 0; i < fishes.length; ++i) {
			if(processing.key == 'f' || processing.key == 'F') {
				if(fishes[i] == null) {
					fishes[i] = new Fish(processing, (float)randGen.nextInt(processing.width), (float)randGen.nextInt(processing.height));
					break;
				}
			}	
			if(processing.key == 'r' || processing.key == 'R') {
				if(fishes[i] != null) {
					if(isMouseOver(fishes[i])) {
						fishes[i] = null;
						return;
					}
				}
			}
		}
	}			

	public static void main(String[] args) {
		Utility.startApplication();
	}
}