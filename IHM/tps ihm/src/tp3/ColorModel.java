package tp3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColorModel {

	public IntegerModel red;
	public IntegerModel green;
	public IntegerModel blue;

	ColorModel(Integer red, Integer green, Integer blue) {
		this.red = new IntegerModel(red);
		this.green = new IntegerModel(green);
		this.blue = new IntegerModel(blue);
		set(red, green, blue, null);
	}

	public void set(Integer red, Integer green, Integer blue, Object caller) {
		setRed(red, caller);
		setGreen(green, caller);
		setBlue(blue, caller);
	}

	public void setRed(Integer value, Object caller) {
		red.setValue(value, caller);
	}

	public void setGreen(Integer value, Object caller) {
		green.setValue(value, caller);
	}

	public void setBlue(Integer value, Object caller) {
		blue.setValue(value, caller);
	}

	public Integer getRed() {
		return red.getValue();
	}

	public Integer getGreen() {
		return green.getValue();
	}

	public Integer getBlue() {
		return blue.getValue();
	}

	public String toHex() {
		return red.toHex(2) + green.toHex(2) + blue.toHex(2);
	}

	/**
	 * Binds a text field to this color model. The text field receives the hex
	 * value of the color.
	 */
	public void bind(final JTextField textField) {
		// Listener for color changes
		IntegerListener listener = new IntegerListener() {
			JTextField that = textField;

			@Override
			public void wasUpdated(IntegerModel integer, Object caller) {
				if (!that.equals(caller)) {
					that.setText(ColorModel.this.toHex());
				}
			}
		};
		red.addListener(listener);
		green.addListener(listener);
		blue.addListener(listener);

		// Listener for text field changes
		textField.addActionListener(new ActionListener() {
			JTextField that = textField;

			public void actionPerformed(ActionEvent event) {
				String value = that.getText();
				System.out.println(value);
				switch (value.length()) {
				// Support hex color format with only 3 digits by converting it
				// to
				// a 6 digit hex color format
				case 3:
					value = "" + value.charAt(0) + value.charAt(0)
							+ value.charAt(1) + value.charAt(1)
							+ value.charAt(2) + value.charAt(2);
					// Parse a regular 6 digit hex color format
				case 6:
					try {
						Integer r = Integer.parseInt(value.substring(0, 2), 16);
						Integer g = Integer.parseInt(value.substring(2, 4), 16);
						Integer b = Integer.parseInt(value.substring(4, 6), 16);
						red.setValue(r, that);
						green.setValue(g, that);
						blue.setValue(b, that);
					} catch (NumberFormatException e) {
						// Abord in case there is a parsing error
					}
					break;
				}
			}
		});
		// Update the text field to the current color value
		textField.setText(this.toHex());
	}

	/**
	 * Binds a panel to this color model. The panel's background color is set to
	 * the components of this color model.
	 */
	public void bind(final JPanel panel) {
		// Listener for color changes
		IntegerListener listener = new IntegerListener() {
			JPanel that = panel;

			@Override
			public void wasUpdated(IntegerModel integer, Object caller) {
				Color color = new Color(red.getValue(), green.getValue(),
						blue.getValue());
				that.setBackground(color);
			}
		};
		red.addListener(listener);
		green.addListener(listener);
		blue.addListener(listener);
		// Update the panel to the current color value
		Color color = new Color(red.getValue(), green.getValue(),
				blue.getValue());
		panel.setBackground(color);
	}

}
