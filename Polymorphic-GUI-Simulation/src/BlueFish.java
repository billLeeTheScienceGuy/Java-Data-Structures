import java.io.File;

/**
 * Specialized entity class implementing custom directional movement logic.
 * @author Bill Lee
 */
public class BlueFish extends Fish {
	public BlueFish() {
		super(2, "images" + File.separator + "blue.png");
	}

	@Override
	public void swim() {
		setX((getX() - speed()) % tank.width); 
		if (getX() <= 0) {
			setX(tank.width);
        }
	}
}