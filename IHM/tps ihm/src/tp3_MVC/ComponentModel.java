package tp3_MVC;

public class ComponentModel {

	private Integer value;
	private ColorModel parent;

	public ComponentModel(ColorModel parent, Integer value) {
		this.parent = parent;
		this.value = value;
	}

	void setValue(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public String toHex() {
		return toHex(0);
	}

	public String toHex(Integer minLength) {
		String hex = Integer.toHexString(getValue());
		while (hex.length() < minLength) {
			hex = "0" + hex;
		}
		return hex;
	}

	public ColorModel getParent() {
		return parent;
	}
}
