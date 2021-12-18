import java.util.Random;
import java.util.ArrayList;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Core engine application integrating the PApplet library. 
 * Manages the polymorphic object list and asynchronous user input handlers.
 * @author Bill Lee
 */
public class FishTank extends PApplet {
	private PImage backgroundImage; 
	protected ArrayList<TankListener> objects; 
	protected Random randGen; 

	private TankObject flower;
	private TankObject log;
	private TankObject shell;
	private TankObject ship;

	@Override
	public void settings() {
		size(800, 600);
	}

	@Override
	public void setup() {
		this.getSurface().setTitle("Interactive GUI Simulation");
		this.imageMode(PApplet.CENTER);
		this.rectMode(PApplet.CORNERS);
		this.focused = true; 
		this.textAlign(PApplet.CENTER, PApplet.CENTER);

		backgroundImage = this.loadImage("images" + File.separator + "background.png");
		objects = new ArrayList<>();
		randGen = new Random();

		TankObject.setProcessing(this);

		flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
		log = new TankObject(580, 470, "images" + File.separator + "log.png");
		shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
		ship = new TankObject(280, 535, "images" + File.separator + "ship.png");
		
        BlackFish blackFish1 = new BlackFish(log, flower);
		BlackFish blackFish2 = new BlackFish(shell, flower);

		objects.add(flower);
		objects.add(log);
		objects.add(shell);
		objects.add(ship);
		objects.add(blackFish1);
		objects.add(blackFish2);
		
		Button.setProcessing(this);
		
		objects.add(new AddBlueFishButton(43, 16));
		objects.add(new AddOrangeFishButton(129, 16));
		objects.add(new AddYellowFishButton(215, 16));
		objects.add(new ClearTankButton(301, 16));
	}

	@Override
	public void draw() {
		this.image(backgroundImage, this.width / 2, this.height / 2);
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).draw();
        }
	}

	@Override
	public void mousePressed() {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i).isMouseOver()) {
				objects.get(i).mousePressed();
				return;
			}
		}
	}

	@Override
	public void mouseReleased() {
		for (int i = 0; i < objects.size(); i++) {
			 objects.get(i).mouseReleased();
        }
	}

	public void addObject(TankListener object) {
		this.objects.add(object);
	}

	@Override
	public void keyPressed() {
		switch (Character.toUpperCase(key)) {
		case 'O': 
			objects.add(new Fish());
			break;
		case 'Y':
			objects.add(new Fish(2, "images" + File.separator + "yellow.png"));
			break;
		case 'B':
			objects.add(new BlueFish());
			break;
		case 'R':
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i).isMouseOver()) {
					objects.remove(i);
					break;
				}
			}
			break;
		case 'S':
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i) instanceof Fish) {
					((Fish) objects.get(i)).startSwimming();
				}
			}
			break;
		case 'X':
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i) instanceof Fish) {
					((Fish) objects.get(i)).stopSwimming();
				}
			}
			break;
		case 'C':
			clear();
			break;
		}
	}

	public void clear() {
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) instanceof Fish) {
				objects.remove(i);
				i--;
			}
		}
	}

	public static void main(String[] args) {
		PApplet.main("FishTank"); 
	}
}