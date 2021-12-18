/**
 * Base UI class managing the rendering, hit-boxes, and state of interactive screen elements.
 * @author Bill Lee
 */
public class Button implements TankListener {
	private static final int WIDTH = 85; 
	private static final int HEIGHT = 32; 
	protected static FishTank tank; 
	private float x; 
	private float y; 
	protected String label; 

	public Button(String label, float x, float y) {
		this.x = x;
		this.y = y;
		this.label = label;
	}

	public static void setProcessing(FishTank tank) {
		Button.tank = tank;
	}

	@Override
	public boolean isMouseOver() {
		return tank.mouseX >= x - WIDTH / 2 && tank.mouseX <= x + WIDTH / 2 && 
               tank.mouseY >= y - HEIGHT / 2 && tank.mouseY <= y + HEIGHT / 2;
	}

	@Override
	public void draw() {
		tank.stroke(0);
		if(isMouseOver()) {
			tank.fill(100);
        } else {
            tank.fill(200);
        }

		tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f, x + WIDTH / 2.0f, y + HEIGHT / 2.0f);
		tank.fill(0); 
		tank.text(label, x, y); 
	}

	@Override
	public void mousePressed() {
		if(isMouseOver()) {
			System.out.println("A button was pressed.");
        }
	}

	@Override
	public void mouseReleased() {}
}