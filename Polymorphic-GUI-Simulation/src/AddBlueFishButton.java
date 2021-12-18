public class AddBlueFishButton extends Button {
	public AddBlueFishButton(float x, float y) { super("Add Blue", x, y); }
	@Override
	public void mousePressed() {
		if(isMouseOver()) tank.objects.add(new BlueFish());
	}
}