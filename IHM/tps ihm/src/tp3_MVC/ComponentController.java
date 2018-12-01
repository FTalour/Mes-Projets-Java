package tp3_MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ComponentController {

	private ComponentModel model;
	private ArrayList<ComponentView> views;

	public ComponentController(ComponentModel model) {
		this.model = model;
		this.views = new ArrayList<ComponentView>();
	}

	void setValue(Integer value, Object caller) {
		model.setValue(value);
		for (ComponentView view : views) {
			view.update(model, caller);
		}
	}

	void setValue(String value, Object caller) {
		try {
			this.setValue(Integer.parseInt(value), caller);
		} catch (NumberFormatException e) {

		}
	}

	public ComponentModel getModel() {
		return model;
	}

	public void addView(ComponentView view) {
		views.add(view);
	}

	public void removeView(ComponentView view) {
		views.remove(view);
	}

	/**
	 * Binds a slider to the integer.
	 */
	public void bind(final JSlider slider) {
		// view for the color
		this.addView(new ComponentView() {
			JSlider that = slider;

			@Override
			public void update(ComponentModel model, Object caller) {
				if (!that.equals(caller)) {
					that.setValue(model.getValue());
				}
			}
		});
		// Listener for slider changes
		slider.addChangeListener(new ChangeListener() {
			JSlider that = slider;

			public void stateChanged(ChangeEvent event) {
				ComponentController.this.setValue(that.getValue(), that);
			}
		});
		// Update the slider to the integer value
		slider.setValue(model.getValue());
	}

	/**
	 * Binds a text field to the integer.
	 */
	public void bind(final JTextField textField) {
		// view for the color
		this.addView(new ComponentView() {
			JTextField that = textField;

			@Override
			public void update(ComponentModel model, Object caller) {
				if (!that.equals(caller)) {
					that.setText(model.getValue().toString());
				}
			}
		});
		// Listener for text field input
		textField.addActionListener(new ActionListener() {
			JTextField that = textField;

			public void actionPerformed(ActionEvent arg0) {
				ComponentController.this.setValue(that.getText(), that);
			}
		});
		// Update the text field to the integer value
		textField.setText(model.getValue().toString());
	}

}
