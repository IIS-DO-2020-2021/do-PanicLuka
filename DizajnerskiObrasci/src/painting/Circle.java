package painting;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	private Point center;
	private int radius;
	private Color colInner;
	private Color colEdge;

	
	
	public Circle() {

	}

	public Circle(Point center, int radius) throws Exception {
		setCenter(center);
		setRadius(radius);
	}

	public Circle(Point center, int radius, boolean selected) throws Exception {
		this(center, radius);
		setSelected(selected);
	}

	@Override
	public void draw(Graphics g) {
		
		if(colInner!=null)
		{
			g.setColor(colInner);
			g.fillOval(this.getCenter().getX() - this.radius, getCenter().getY() - getRadius(), this.getRadius()*2, this.getRadius()*2);
		}
		if(colEdge!=null)
		g.setColor(colEdge);
		else
			g.setColor(Color.BLACK);
		g.drawOval(this.getCenter().getX() - this.radius, getCenter().getY() - getRadius(), this.getRadius()*2, this.getRadius()*2);
		g.setColor(Color.BLACK);
		
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getRadius() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getRadius() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}
		
	@Override
	public boolean contains(Point p) {
		return center.distance(p.getX(), p.getY()) <= radius;
	}

	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) throws Exception{
		if(radius>=0)
			this.radius = radius;
		else
			throw new Exception();
	}
	
	public Color getColInner() {
		return colInner;
	}

	public void setColInner(Color colInner) {
		this.colInner = colInner;
	}

	public Color getColEdge() {
		return colEdge;
	}

	public void setColEdge(Color colEdge) {
		this.colEdge = colEdge;
	}
	
	@Override
	public String toString() {
		return "Center=" + center + ", radius=" + radius; 
	}
}
