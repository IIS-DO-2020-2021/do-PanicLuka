package geometry;

import java.awt.Color;
import java.awt.Graphics;

import mvc.DrawingFrame;
import mvc.DrawingView;


public class Donut extends Circle {
private int innerRadius;
private Color colSmallerEdge;


	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) throws Exception {
		super(center, radius);
			setInnerRadius(innerRadius);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) throws Exception {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		DrawingView pn=new DrawingView();
		g.setColor(pn.getBackground());
		g.fillOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.innerRadius*2);
		if(colSmallerEdge!=null)
		{
			g.setColor(colSmallerEdge);
		}
		else
			g.setColor(Color.BLACK);
		g.drawOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.innerRadius*2);
		g.setColor(Color.BLACK);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + getInnerRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - getInnerRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getInnerRadius() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getInnerRadius() - 3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}
	
	@Override
	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return dFromCenter > innerRadius &&
				super.contains(p);
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) throws Exception {
		if(innerRadius>=0 && innerRadius<this.getRadius())
		{
		this.innerRadius = innerRadius;
		}
		else
			throw new Exception();
	}
	
	public Color getColSmallerEdge() {
		return colSmallerEdge;
	}

	public void setColSmallerEdge(Color colSmallerEdge) {
		this.colSmallerEdge = colSmallerEdge;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", inner radius=" + innerRadius ;
	}
}
