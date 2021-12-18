public class ClearTankButton extends Button {
	public ClearTankButton(float x, float y) { super("clear", x, y); }
	@Override
	public void mousePressed() {
		if(isMouseOver()) tank.clear();
	}
}