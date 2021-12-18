import java.io.File;
public class AddYellowFishButton extends Button {
	public AddYellowFishButton(float x, float y) { super("Add Yellow", x, y); }
	@Override
	public void mousePressed() {
		if(isMouseOver()) tank.objects.add(new Fish(2,"images" + File.separator + "yellow.png"));
	}
}