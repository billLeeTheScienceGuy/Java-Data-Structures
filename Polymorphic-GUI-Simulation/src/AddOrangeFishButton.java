public class AddOrangeFishButton extends Button {
	public AddOrangeFishButton(float x, float y) { super("Add Orange", x, y); }
	@Override
	public void mousePressed() {
		if(isMouseOver()) tank.objects.add(new Fish());
	}
}