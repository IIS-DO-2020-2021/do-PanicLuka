package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private Point startPoint = new Point();
	private Point endPoint = new Point();
	private Color col;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		setEndPoint(endPoint);
	}
	
	public Line(Point startPoint, Point endPoint, Color color) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		setCol(color);
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		setSelected(selected);
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected, Color color) {
		this(startPoint, endPoint, selected);
		setCol(color);
	}

	@Override
	public void draw(Graphics g) {
		if(this.col!=null)
			g.setColor(this.col);
		else
			g.setColor(Color.BLACK);
		g.drawLine(this.getStartPoint().getX(), getStartPoint().getY(), this.getEndPoint().getX(), this.getEndPoint().getY());
		g.setColor(Color.BLACK);
		
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getStartPoint().getX()  - 3, getStartPoint().getY() - 3, 6, 6);
			g.drawRect(getEndPoint().getX() - 3, getEndPoint().getY() - 3, 6, 6);
			g.drawRect(middleOfLine().getX() - 3, middleOfLine().getY() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
		
	}

	public Point middleOfLine() {
		int middleByX = (this.getStartPoint().getX() + this.getEndPoint().getX()) / 2;
		int middleByY = (this.getStartPoint().getY() + this.getEndPoint().getY()) / 2;
		Point p = new Point(middleByX, middleByY);
		return p;
	}
	
	@Override
	public boolean contains(Point p) {
		if((startPoint.distance(p.getX(), p.getY()) + endPoint.distance(p.getX(), p.getY())) - length() <= 0.05)
			return true;
		return false;
	}
	
	public Line clone(Line l) {
		//System.out.println("sdgsdg" + l.toString());
		
		l.getStartPoint().setX(this.getStartPoint().getX());
		l.getStartPoint().setY(this.getStartPoint().getY());
		l.getEndPoint().setX(this.getEndPoint().getX());
		l.getEndPoint().setY(this.getEndPoint().getY());
		l.setCol(this.getCol());

		return l;
	}
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Color getCol() {
		return col;
	}

	public void setCol(Color col) {
		this.col = col;
	}

	@Override
	public String toString() {
		return startPoint + "-->" + endPoint + col;
	}
}
