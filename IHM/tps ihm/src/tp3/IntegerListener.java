package tp3;

public abstract class IntegerListener {

	/**
	 * @param integer
	 *            The integer model being updated.
	 * @param caller
	 *            The object updating the integer.
	 */
	public abstract void wasUpdated(IntegerModel integer, Object caller);

}
