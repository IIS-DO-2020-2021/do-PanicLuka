package painting;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{

	private Point upperLeftPoint;
	private int width;
	private int height;
	private Color innerColor;
	private Color edgeColor;
	
	

	public Rectangle() {

	}

	public Rectangle(Point upperLeftPoint, int height, int width) throws Exception {
		this.upperLeftPoint = upperLeftPoint;
		setHeight(height);
		setWidth(width);
	}

	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected) throws Exception {
		this(upperLeftPoint, height, width);
		setSelected(selected);
	}

	@Override
	public void draw(Graphics g) {
		if(innerColor!=null)
		{
		g.setColor(innerColor);
		g.fillRect(this.getUpperLeftPoint().getX(), this.getUpperLeftPoint().getY(), this.getWidth(), this.height);
		}
		if(edgeColor!=null)
		g.setColor(edgeColor);
		g.drawRect(this.getUpperLeftPoint().getX(), this.getUpperLeftPoint().getY(), this.getWidth(), this.height);
		g.setColor(Color.BLACK);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() - 3 + getWidth(), this.getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() - 3, this.getUpperLeftPoint().getY() - 3 + getHeight(), 6, 6);
			g.drawRect(this.getUpperLeftPoint().getX() + getWidth() - 3, this.getUpperLeftPoint().getY() + getHeight() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}

	@Override
	public boolean contains(Point p) {
		if (this.getUpperLeftPoint().getX() <= p.getX() 
				&& p.getX()<= this.getUpperLeftPoint().getX() + width
				&& this.getUpperLeftPoint().getY() <= p.getY()
				&& p.getY() <= this.getUpperLeftPoint().getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	public int area() {
		return width * height;
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) throws Exception {
		if(width>=0)
		this.width = width;
		else
			throw new Exception();
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) throws Exception {
		if(height>=0)
		this.height = height;
		else
			throw new Exception();
		
	}
	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	
	@Override
	public String toString() {
		return "Upper left point=" + upperLeftPoint + ", height=" + height + ", width=" + width;
	}
}
