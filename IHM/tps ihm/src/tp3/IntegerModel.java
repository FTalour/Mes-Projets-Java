package tp3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class IntegerModel {

	private Integer value;
	private ArrayList<IntegerListener> listeners;

	IntegerModel(Integer value) {
		listeners = new ArrayList<IntegerListener>();
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

	void setValue(Integer value, Object caller) {
		this.value = value;
		for (IntegerListener listener : listeners) {
			listener.wasUpdated(this, caller);
		}
	}

	void setValue(String value, Object caller) {
		try {
			this.setValue(Integer.parseInt(value), caller);
		} catch (NumberFormatException e) {

		}
	}

	public void addListener(IntegerListener listener) {
		listeners.add(listener);
	}

	public void removeListener(IntegerListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Binds a slider to the integer.
	 */
	public void bind(final JSlider slider) {
		// Listener for color changes
		this.addListener(new IntegerListener() {
			JSlider that = slider;

			@Override
			public void wasUpdated(IntegerModel integer, Object caller) {
				if (!that.equals(caller)) {
					that.setValue(integer.getValue());
				}
			}
		});
		// Listener for slider changes
		slider.addChangeListener(new ChangeListener() {
			JSlider that = slider;

			public void stateChanged(ChangeEvent event) {
				IntegerModel.this.setValue(that.getValue(), that);
			}
		});
		// Update the slider to the integer value
		slider.setValue(getValue());
	}

	/**
	 * Binds a text field to the integer.
	 */
	public void bind(final JTextField textField) {
		// Listener for color changes
		addListener(new IntegerListener() {
			JTextField that = textField;

			@Override
			public void wasUpdated(IntegerModel integer, Object caller) {
				if (!that.equals(caller)) {
					that.setText(integer.getValue().toString());
				}
			}
		});
		// Listener for text field input
		textField.addActionListener(new ActionListener() {
			JTextField that = textField;

			public void actionPerformed(ActionEvent arg0) {
				IntegerModel.this.setValue(that.getText(), that);
			}
		});
		// Update the text field to the integer value
		textField.setText(getValue().toString());
	}

}
