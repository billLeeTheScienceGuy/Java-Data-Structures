import java.io.File;

/**
 * Base entity class representing a dynamic, moving object on the screen.
 * @author Bill Lee
 */
public class Fish extends TankObject {
	private int speed;
	private boolean isSwimming;

	public Fish(int speed, String fishImageFileName) throws IllegalArgumentException {
		super((float) tank.randGen.nextInt(tank.width), (float) tank.randGen.nextInt(tank.height), fishImageFileName);
		if (speed <= 0) {
            throw new IllegalArgumentException("Warning: speed cannot be negative");
        }
		this.speed = speed;
	}

	public Fish() {
		this(5, "images" + File.separator + "orange.png");
	}

	@Override
	public void draw() {
		if (isSwimming) {
			swim();
		}
		super.draw();
	}

	public boolean isSwimming() { return isSwimming; }

	public void startSwimming() {
		stopDragging();
		isSwimming = true;
	}

	public void stopSwimming() {
		isSwimming = false;
	}

	public int speed() { return speed; }

	public void swim() {
		setX((getX() + speed) % tank.width);
	}
}