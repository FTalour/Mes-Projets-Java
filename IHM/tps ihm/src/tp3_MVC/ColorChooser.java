package tp3_MVC;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 * @author Nicolas Roussel (edited by David Bonnet)
 */
@SuppressWarnings("serial")
public class ColorChooser extends JDialog {

	private ColorController controller; // Color model
	private JPanel sample; // Color preview box
	private JTextField colorCode; // Text field containing the color in hex
									// format

	/**
	 * Creates a modal window containing a basic RGB color chooser.
	 * 
	 * @param owner
	 *            The parent window.
	 * @param red
	 *            Red component of the RGB color.
	 * @param green
	 *            Green component of the RGB color.
	 * @param blue
	 *            Blue component of the RGB color.
	 */
	public ColorChooser(JFrame owner, Integer red, Integer green, Integer blue) {
		super(owner, "Color Chooser", true);
		// Create the color model
		controller = new ColorController(red, green, blue);
		init();
	}

	/**
	 * Initialize the color selector window
	 */
	public void init() {
		Container pane = getContentPane();
		pane.setLayout(new FlowLayout());

		// Column 1: Sliders
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		// Red
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
		panel.add(slider);
		controller.red.bind(slider);
		// Green
		slider = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
		panel.add(slider);
		controller.green.bind(slider);
		// Blue
		slider = new JSlider(JSlider.HORIZONTAL, 0, 255, 127);
		panel.add(slider);
		controller.blue.bind(slider);
		// Add to window
		pane.add(panel);

		// Column 2: Text fields (next to the sliders)
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		// Red
		JTextField textField = new JTextField(3);
		panel.add(textField);
		controller.red.bind(textField);
		// Green
		textField = new JTextField(3);
		panel.add(textField);
		controller.green.bind(textField);
		// Blue
		textField = new JTextField(3);
		panel.add(textField);
		controller.blue.bind(textField);
		// Add to window
		pane.add(panel);

		// Column 3: Hex color field and color sample
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		// Color in hex format
		colorCode = new JTextField();
		panel.add(colorCode);
		controller.bind(colorCode);
		// Color preview
		sample = new JPanel();
		Dimension dimensions = new Dimension(100, 100);
		sample.setPreferredSize(dimensions);
		sample.setMinimumSize(dimensions);
		sample.setOpaque(true);
		panel.add(sample);
		controller.bind(sample);
		// Add to window
		pane.add(panel);

		// Resize window and make it visible
		pack();
		setVisible(true);
	}

	public ColorController getController() {
		return controller;
	}

	static public void main(String args[]) {
		ColorChooser rgb = new ColorChooser(null, 79, 178, 255);
		System.out.println("Selected color is: "
				+ rgb.getController().getModel().toHex());
		System.exit(1);
	}

}
