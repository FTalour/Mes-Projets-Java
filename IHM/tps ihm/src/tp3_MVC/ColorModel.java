package tp3_MVC;

public class ColorModel {

	private ComponentModel red;
	private ComponentModel green;
	private ComponentModel blue;

	public ColorModel(Integer red, Integer green, Integer blue) {
		this.red = new ComponentModel(this, red);
		this.green = new ComponentModel(this, green);
		this.blue = new ComponentModel(this, blue);
	}

	public ComponentModel getRed() {
		return red;
	}

	public ComponentModel getGreen() {
		return green;
	}

	public ComponentModel getBlue() {
		return blue;
	}

	public String toHex() {
		return red.toHex(2) + green.toHex(2) + blue.toHex(2);
	}

}
