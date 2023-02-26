package geometry;

import java.awt.Graphics;

public abstract class Shape {

	private boolean selected;

	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(Point p);
	public abstract void draw(Graphics g);
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	
}
