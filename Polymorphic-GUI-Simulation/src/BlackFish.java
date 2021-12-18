import java.io.File;

/**
 * Specialized entity implementing tracking logic to navigate between dynamic targets.
 * @author Bill Lee
 */
public class BlackFish extends Fish {
	private TankObject source; 
	private TankObject destination; 

	public BlackFish(TankObject source, TankObject destination) {
		super(2, "images" + File.separator + "black.png");
		this.source = source;
		this.destination = destination;
	}

	public void moveTowardsDestination() {
		float dx = destination.getX() - this.getX();
		float dy = destination.getY() - this.getY();
		int d = (int) Math.sqrt(dx * dx + dy * dy);

		this.setX(this.getX() + (this.speed() * dx) / d);
		this.setY(this.getY() + (this.speed() * dy) / d);
	}

	public boolean isOver(TankObject other) {
		return ((this.getX() - this.image.width / 2) <= other.getX() + other.image.width / 2
				&& (this.getX() + this.image.width / 2) >= other.getX() - other.image.width / 2)
				&& ((this.getY() - this.image.height / 2) <= other.getY() + other.image.height / 2
				&& (this.getY() + this.image.height / 2) >= other.getY() - other.image.height / 2);
	}

	@Override
	public void swim() {
		moveTowardsDestination();
		if (isOver(destination)) {
			TankObject temp = source;
			this.source = destination;
			this.destination = temp;
		}
	}
}