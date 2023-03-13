package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;
	private Color col;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		setY(y);
	}
	
	public Point(int x, int y, boolean selected) {
		this(x, y);
		setSelected(selected);
	}
	public Point(int x, int y, boolean selected, Color color) {
		this(x, y, selected);
		setCol(color);
	}

	@Override
	public void draw(Graphics g) {
		if(this.col!=null)
			g.setColor(col);
		else
			g.setColor(Color.BLACK);
		g.drawLine(this.x-2, this.y, this.x+2, this.y);
		g.drawLine(this.x, this.y-2, this.x, this.y+2);
		g.setColor(Color.BLACK);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.x-3, this.y-3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}

	
	public void moveBy(int byX, int byY) {
	    this.x = this.x + byX;
		this.y += byY;
	}

	@Override
	public boolean contains(Point p) {
		return this.distance(p.getX(), p.getY()) <=3;
	}
	
	public Point clone(Point p) {
		p.setX(this.getX());
		p.setY(this.getY());
		p.setCol(this.getCol());

		return p;
	}
	
	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public Color getCol() {
		return col;
	}

	public void setCol(Color col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
