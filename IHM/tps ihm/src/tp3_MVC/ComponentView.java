package tp3_MVC;

public abstract class ComponentView {

	/**
	 * @param controller
	 *            The color controller being updated.
	 * @param caller
	 *            The object updating the color.
	 */
	public abstract void update(ComponentModel model, Object caller);

}
