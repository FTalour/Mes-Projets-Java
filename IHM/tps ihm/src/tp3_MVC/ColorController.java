package tp3_MVC;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ColorController {

	private ColorModel model;
	public ComponentController red;
	public ComponentController green;
	public ComponentController blue;

	public ColorController(Integer red, Integer green, Integer blue) {
		model = new ColorModel(red, green, blue);
		this.red = new ComponentController(model.getRed());
		this.green = new ComponentController(model.getGreen());
		this.blue = new ComponentController(model.getBlue());

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

	public ColorModel getModel() {
		return model;
	}

	/**
	 * Binds a text field to this color model. The text field receives the hex
	 * value of the color.
	 */
	public void bind(final JTextField textField) {
		// view for each color
		ComponentView view = new ComponentView() {
			JTextField that = textField;

			@Override
			public void update(ComponentModel model, Object caller) {
				if (!that.equals(caller)) {
					that.setText(model.getParent().toHex());
				}
			}
		};
		red.addView(view);
		green.addView(view);
		blue.addView(view);

		// Listener for text field changes
		textField.addActionListener(new ActionListener() {
			JTextField that = textField;

			public void actionPerformed(ActionEvent event) {
				String value = that.getText();
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
		textField.setText(model.toHex());
	}

	/**
	 * Binds a panel to this color model. The panel's background color is set to
	 * the components of this color model.
	 */
	public void bind(final JPanel panel) {
		// view for each color
		ComponentView view = new ComponentView() {
			JPanel that = panel;

			@Override
			public void update(ComponentModel model, Object caller) {
				ColorModel tmp = model.getParent();
				Color color = new Color(tmp.getRed().getValue(), tmp.getGreen()
						.getValue(), tmp.getBlue().getValue());
				that.setBackground(color);
			}
		};
		red.addView(view);
		green.addView(view);
		blue.addView(view);

		// Update the panel to the current color value
		Color color = new Color(red.getModel().getValue(), green.getModel()
				.getValue(), blue.getModel().getValue());
		panel.setBackground(color);
	}

}
