package painting;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PnlDrawing extends JPanel {

	private Drawing frame;
	private ArrayList<Shape> shape=new ArrayList<Shape>();
	private Point startPoint;
	private Shape testShape;
	
	
	/**
	 * Create the panel.
	 */
	
	public PnlDrawing() {
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				thisMouseClicked(e);
			}
		});
	
	}
	public PnlDrawing(Drawing frame) {
		this.frame=frame;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			thisMouseClicked(e);
			}
		});
	}
	
	
	
	protected void thisMouseClicked(MouseEvent e) {
		if(frame.getTglbtnSelect())
		{
			
			testShape=null;
			Point p=new Point(e.getX(),e.getY());
			Iterator<Shape> it=shape.iterator();
			while(it.hasNext())
			{
				Shape geo=it.next();
				geo.setSelected(false);
				if((geo.contains(p)) && geo.isSelected()==false)
				{
					testShape=geo;
				}
				
			}
			
		}
		if(frame.getTglbtnPoint()) {
			Point p=new Point(e.getX(),e.getY());
			DialogPoint dp=new DialogPoint();
			dp.setTbXEdt(false);
			dp.setTxtYEdt(false);
			dp.setTbX(Integer.toString(p.getX()));
			dp.setTxtY(Integer.toString(p.getY()));
			dp.setVisible(true);
			p.setCol(dp.getColor());
			shape.add(p);
		}
		else if(frame.getTglbtnLine())
		{
			if(startPoint==null)
			startPoint=new Point(e.getX(),e.getY());
			else {
			Line l=new Line(startPoint,new Point(e.getX(),e.getY()));
			DialogLine dl=new DialogLine();
			dl.setTxtEndCoordXEdt(false);
			dl.setTxtEndCoordYEdt(false);
			dl.setTxtStartCoordXEdt(false);
			dl.setTxtStartCoordYEdt(false);
			dl.setTxtStartCoordX(Integer.toString(l.getStartPoint().getX()));
			dl.setTxtStartCoordY(Integer.toString(l.getStartPoint().getY()));
			dl.setTxtEndCoordX(Integer.toString(l.getEndPoint().getX()));
			dl.setTxtEndCoordY(Integer.toString(l.getEndPoint().getY()));
			dl.setVisible(true);
			l.setCol(dl.getCol());
			shape.add(l);
			startPoint=null;
			}
		}
		else if(frame.getTglbtnRectangle())
		{
			Point p=new Point(e.getX(),e.getY());
			DialogRectangle dija=new DialogRectangle();
			dija.setTxtXCoordinate(Integer.toString(p.getX()));
			dija.setTxtYCoordinate(Integer.toString(p.getY()));
			dija.setTxtXCoordinateEnabled(false);
			dija.setTxtYCoordinateEnabled(false);
			dija.setVisible(true);
			if(dija.isOk()) {
			try {
			int width=Integer.parseInt(dija.getTxtWidth());
			int height=Integer.parseInt(dija.getTxtHeight());
			Rectangle rct=new Rectangle(p,width,height);
			rct.setEdgeColor(dija.getEdgeColor());
			rct.setInnerColor(dija.getEdgeColor());
			shape.add(rct);
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "height and width must be positive values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			}
		}
		else if(frame.getTglbtnCircle())
		{
			Point center=new Point(e.getX(),e.getY());
			DialogCircle dija=new DialogCircle();
			dija.setTxtCoordXEdt(false);
			dija.setTxtCoordYEdt(false);
			dija.setTxtCoordX(Integer.toString(center.getX()));
			dija.setTxtCoordY(Integer.toString(center.getY()));
			dija.setVisible(true);
			try
			{
			if(dija.isOk())
			{
				int radius=Integer.parseInt(dija.getTextDiametar());
				Circle circle=new Circle(center,radius);
				circle.setColEdge(dija.getColEdge());
				circle.setColInner(dija.getColInner());
				shape.add(circle);
			
			}
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry. Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Diameter value must be positive!", "Error", JOptionPane.WARNING_MESSAGE);	
			}
		}
		else if(frame.getTglbtnCirclewithHole())
		{
			Point center=new Point(e.getX(),e.getY());
			DialogDonut dija=new DialogDonut();
			dija.setTxtCoordX(Integer.toString(center.getX()));
			dija.setTxtCoordY(Integer.toString(center.getY()));
			dija.setTxtCoordXEditable(false);
			dija.setTxtCoordYEditable(false);			dija.setVisible(true);
			try
			{
			if(dija.isOk())
			{
				int innerRadius=Integer.parseInt(dija.getTxtInner());
				int outerRadius=Integer.parseInt(dija.getTxtEdge());
				Donut donut=new Donut(center,outerRadius,innerRadius);
				donut.setColEdge(dija.getColEdge());
				donut.setColSmallerEdge(dija.getColEdge());
				donut.setColInner(dija.getColInner());
				shape.add(donut);
			}
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry. Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Diametars must be greater then null and inner diametar of the circle must be less then diametar of the bigger circle!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else if(testShape!=null)
		{
			testShape.setSelected(true);
		}
		if(shape!=null) 
			repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator it=shape.iterator();
		while(it.hasNext())
			((Shape) it.next()).draw(g);
        }
	
	public ArrayList<Shape> getShape() {
		return shape;
	}

	public void setShape(ArrayList<Shape> shape) {
		this.shape = shape;
	}

	public Shape getTestShape() {
		return testShape;
	}

	public void setTestShape(Shape testshape) {
		this.testShape = testshape;
	}
	
	public void setStartPoint(Point p)
	{
		this.startPoint=p;
	}

}
