
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;

	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}

	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}

	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public boolean overlaps(Plot plot) {
		boolean overlaps = false;
		if (x < plot.x + plot.width && x + width > plot.x && y < plot.y + plot.depth && y + depth > plot.y) {
			overlaps = true;
		}
		return overlaps;
	}

	public boolean encompasses(Plot plot) {
		boolean encompasses = false;
		if (this.x <= plot.getX() && plot.getX() <= (this.x + this.width) && this.y <= plot.getY() && plot.getY() <= this.y + this.depth && this.x <= this.x + this.width && plot.getX() + plot.getWidth() <= this.x + this.width && this.y <= plot.getY() + plot.getDepth() && plot.getY() + plot.getDepth() <= this.y + this.depth) {
			encompasses = true;
		}
		return encompasses;
	}

	public String toString() {
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
}
