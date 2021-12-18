import processing.core.PImage;

/**
 * Base class managing the background objects, their rendering, 
 * spatial positioning, and drag-and-drop mechanics.
 * @author Bill Lee
 */
public class TankObject implements TankListener {
	protected static FishTank tank; 
	protected PImage image; 
	private float x; 
	private float y; 
	private boolean isDragging; 
	private static int oldMouseX; 
	private static int oldMouseY; 

	public TankObject(float x, float y, String imageFileName) {
		this.x = x;
		this.y = y;
		this.image = tank.loadImage(imageFileName);
	}

	public static void setProcessing(FishTank tank) {
		TankObject.tank = tank;
	}

	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public float getX() { return x; }
	public float getY() { return y; }
	public void setX(float x) { this.x = x; }
	public void setY(float y) { this.y = y; }
	public PImage getImage() { return image; }
	public boolean isDragging() { return isDragging; }

	public void startDragging() {
		oldMouseX = tank.mouseX;
		oldMouseY = tank.mouseY;
		this.isDragging = true;
	}

	public void stopDragging() {
		isDragging = false;
	}

	@Override
	public void draw() {
		if (this.isDragging) {
			int dx = tank.mouseX - oldMouseX;
			int dy = tank.mouseY - oldMouseY;
			move(dx, dy);
			oldMouseX = tank.mouseX;
			oldMouseY = tank.mouseY;
		}
		tank.image(this.image, this.x, this.y);
	}

	@Override
	public void mousePressed() {
		startDragging();
	}

	@Override
	public void mouseReleased() {
		stopDragging();
	}

	@Override
	public boolean isMouseOver() {
		int width = image.width;
		int height = image.height;
		return tank.mouseX >= x - width / 2 && tank.mouseX <= x + width / 2 && 
               tank.mouseY >= y - height / 2 && tank.mouseY <= y + height / 2;
	}
}