package tp4;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

/**
 * @author Nicolas Roussel (roussel@lri.fr)
 * 
 */
class EllipseItem extends CanvasItem {

	Point firstpoint;

	public EllipseItem(PersistentCanvas c, Color o, Color f, Point p) {
		super(c, o, f);
		shape = new Ellipse2D.Double(p.x, p.y, 0, 0);
		firstpoint = p;
	}

	public EllipseItem(EllipseItem other) {
		super(other.canvas, other.outline, other.fill);
		Ellipse2D.Double s = (Ellipse2D.Double) other.shape;
		shape = new Ellipse2D.Double(s.getX(), s.getY(), s.getWidth(),
				s.getHeight());
		isSelected = false;
		firstpoint = other.firstpoint;
	}

	public CanvasItem duplicate() {
		return canvas.addItem(new EllipseItem(this));
	}

	public void update(Point p) {
		((Ellipse2D.Double) shape).setFrameFromDiagonal(firstpoint, p);
		canvas.repaint();
	}

	public void move(int dx, int dy) {
		((Ellipse2D.Double) shape).x += dx;
		((Ellipse2D.Double) shape).y += dy;
		canvas.repaint();
	}

}