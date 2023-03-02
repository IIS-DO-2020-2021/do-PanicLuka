package mvc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import adapter.HexagonAdapter;
import dialogs.DialogCircle;
import dialogs.DialogDonut;
import dialogs.DialogHexagon;
import dialogs.DialogLine;
import dialogs.DialogPoint;
import dialogs.DialogRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingController {
	private DrawingModel model;
    private DrawingFrame frame;
    private ArrayList<Shape> shape=new ArrayList<Shape>();
	private Point startPoint;
	private Shape testShape;
	

    public DrawingController(DrawingModel model, DrawingFrame frame) {
    	
        this.model = model;
        this.frame = frame;
        frame.addMouseListener(new MouseAdapter(){
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
			Iterator<Shape> it=model.getShapes().iterator();
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
			model.add(p);
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
			model.add(l);
			startPoint=null;
			}
		}
		else if(frame.getTglbtnHexagon())
		{
			Point p=new Point(e.getX(),e.getY());
			DialogHexagon dija=new DialogHexagon();
			dija.setTxtCoordX(Integer.toString(p.getX()));
			dija.setTxtCoordY(Integer.toString(p.getY()));
			//dija.setRadius(dija.getTextRadius());
			dija.setTxtCoordXEdt(false);
			dija.setTxtCoordYEdt(false);
			//dija.setEnabled(false);
			dija.setVisible(true);
			if(dija.isOk()) {
			try {
			
			int radius=Integer.parseInt(dija.getTextRadius());
			
			HexagonAdapter h= new HexagonAdapter(new Point(Integer.parseInt(dija.getTxtCoordX()), Integer.parseInt(dija.getTxtCoordY()))
					,Integer.parseInt(dija.getTextRadius()),
					false
					,dija.getColEdge(),
					dija.getColInner());
			h.setHexagonRadius(radius);
			System.out.println(radius);

			h.setHexagonBorderColor(dija.getColEdge());
			h.setHexagonInnerColor(dija.getColInner());
			model.add(h);
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Radius must be positive value!", ex.getMessage(), JOptionPane.WARNING_MESSAGE);
			}
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
			model.add(rct);
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
				model.add(circle);
			
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
				model.add(donut);
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
			frame.repaint();
	}
    protected void modify() {
    	if(getTestShape()!=null)
		{
			Shape pomShape=getTestShape();
			ArrayList<Shape> list=getShape();
			int index=list.indexOf(pomShape);
			//model.add(pomShape);
			//System.out.println(pomShape);
			


		if(getTestShape() instanceof Point)
		{
			//System.out.println(getTestShape() instanceof Point);

			DialogPoint mt=new DialogPoint();
			mt.setTbX(Integer.toString(((Point) pomShape).getX()));
			mt.setTxtY(Integer.toString(((Point) pomShape).getY()));
			mt.setColor(((Point)pomShape).getCol());
			mt.setVisible(true);
			try {
			if(mt.isOk())
			{
				
			((Point) pomShape).setX(Integer.parseInt(mt.getTbX()));
			((Point) pomShape).setY(Integer.parseInt(mt.getTxtY()));
			((Point) pomShape).setCol(mt.getColor());
			
			//breaks here
			model.add(pomShape);
			System.out.println(list.isEmpty() + "executing lines of code");
			
			setShape(list);
			setTestShape(pomShape);
			//frame.repaint();
			
			
			}
			
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage().toString());
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error!", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(getTestShape() instanceof Line)
		{
			DialogLine ml=new DialogLine();
			ml.setTxtStartCoordX(Integer.toString(((Line) pomShape).getStartPoint().getX()));
			ml.setTxtStartCoordY(Integer.toString(((Line) pomShape).getStartPoint().getY()));
			ml.setTxtEndCoordX(Integer.toString(((Line) pomShape).getEndPoint().getX()));
			ml.setTxtEndCoordY(Integer.toString(((Line) pomShape).getEndPoint().getY()));
			ml.setCol(((Line) pomShape).getCol());
			ml.setVisible(true);
			try
			{
			if(ml.isOk())
			{
				((Line)pomShape).setStartPoint(new Point((Integer.parseInt(ml.getTxtStartCoordX())),(Integer.parseInt(ml.getTxtStartCoordY()))));
				((Line)pomShape).setEndPoint(new Point((Integer.parseInt(ml.getTxtEndCoordX())),(Integer.parseInt(ml.getTxtEndCoordY()))));
				((Line)pomShape).setCol(ml.getCol());
				model.add(pomShape);
				//list.set(index,pomShape);
				setShape(list);
				setTestShape(pomShape);
				frame.repaint();
			}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(getTestShape() instanceof Rectangle)
		{
			DialogRectangle dp=new DialogRectangle();
			dp.setTxtXCoordinate(Integer.toString(((Rectangle)pomShape).getUpperLeftPoint().getX()));
			dp.setTxtYCoordinate(Integer.toString(((Rectangle)pomShape).getUpperLeftPoint().getY()));
			dp.setTxtWidth(Integer.toString(((Rectangle)pomShape).getWidth()));
			dp.setTxtHeight(Integer.toString(((Rectangle)pomShape).getHeight()));
			dp.setInnerColor(((Rectangle)pomShape).getInnerColor());
			dp.setEdgeColor(((Rectangle)pomShape).getEdgeColor());
			dp.setVisible(true);
			try
			{
			if(dp.isOk())
			{
				((Rectangle)pomShape).setUpperLeftPoint(new Point(Integer.parseInt(dp.getTxtXCoordinate()),Integer.parseInt(dp.getTxtYCoordinate())));
				((Rectangle)pomShape).setHeight(Integer.parseInt(dp.getTxtHeight()));
				((Rectangle)pomShape).setWidth(Integer.parseInt(dp.getTxtWidth()));
				((Rectangle)pomShape).setEdgeColor(dp.getEdgeColor());
				((Rectangle)pomShape).setInnerColor(dp.getInnerColor());
				//list.set(index,pomShape);
				model.add(pomShape);
				setShape(list);
				setTestShape(pomShape);
				frame.repaint();
			}
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Height and width must be positive values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else if(getTestShape() instanceof HexagonAdapter)
		{
			DialogHexagon dh=new DialogHexagon();
			dh.setTxtCoordX(Integer.toString(((HexagonAdapter)pomShape).getHexagonCenter().getX()));
			dh.setTxtCoordY(Integer.toString(((HexagonAdapter)pomShape).getHexagonCenter().getY()));
			dh.setRadius(Integer.toString(((HexagonAdapter)pomShape).getHexagonRadius()));
			dh.setColInner(((HexagonAdapter)pomShape).getHexagonInnerColor());
			dh.setColEdge(((HexagonAdapter)pomShape).getHexagonBorderColor());
			dh.setVisible(true);
			//System.out.println("this is length" + dh.getTextRadius());
			try
			{
			if(dh.isOk())
			{
				((HexagonAdapter)pomShape).setHexagonCenter(new Point(Integer.parseInt(dh.getTxtCoordX()), Integer.parseInt(dh.getTxtCoordY())));
				((HexagonAdapter)pomShape).setHexagonRadius(Integer.parseInt(dh.getTextRadius()));
				((HexagonAdapter)pomShape).setHexagonBorderColor(dh.getColEdge());
				((HexagonAdapter)pomShape).setHexagonInnerColor(dh.getColInner());
				//list.set(index,pomShape);
				model.add(pomShape);
				setShape(list);
				setTestShape(pomShape);
				
				frame.repaint();
				
			}
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			catch(Exception e)
			{
				System.out.println("this" + e.getMessage());

				JOptionPane.showMessageDialog(new JFrame(), "Value of radius must be positive!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		else if(getTestShape() instanceof Donut)
		{
			DialogDonut dk=new DialogDonut();
			dk.setTxtCoordX(Integer.toString(((Donut)pomShape).getCenter().getX()));
			dk.setTxtCoordY(Integer.toString(((Donut)pomShape).getCenter().getY()));
			dk.setTxtInner(Integer.toString(((Donut)pomShape).getInnerRadius()));
			dk.setTxtEdge(Integer.toString(((Donut)pomShape).getRadius()));
			dk.setColEdge((((Donut)pomShape).getColEdge()));
			dk.setColInner((((Donut)pomShape).getColInner()));
			dk.setVisible(true);
			try {
			if(dk.isOk())
			{
				((Donut)pomShape).setCenter(new Point(Integer.parseInt(dk.getTxtCoordX()),Integer.parseInt(dk.getTxtCoordY())));
				((Donut)pomShape).setInnerRadius(Integer.parseInt(dk.getTxtInner()));
				((Donut)pomShape).setRadius(Integer.parseInt(dk.getTxtEdge()));
				((Donut)pomShape).setColEdge(dk.getColEdge());
				((Donut)pomShape).setColSmallerEdge(dk.getColEdge());
				((Donut)pomShape).setColInner(dk.getColInner());
				//list.set(index,pomShape);
				model.add(pomShape);
				setShape(list);
				setTestShape(pomShape);
				frame.repaint();
			}
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Diametars must be greater then null and inner diametar of the circle must be less then diametar of the bigger circle!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
		}else if(getTestShape() instanceof Circle)
		{
			DialogCircle dk=new DialogCircle();
			dk.setTxtCoordX(Integer.toString(((Circle)pomShape).getCenter().getX()));
			dk.setTxtCoordY(Integer.toString(((Circle)pomShape).getCenter().getY()));
			dk.setDiametar(Integer.toString(((Circle)pomShape).getRadius()));
			dk.setColInner(((Circle)pomShape).getColInner());
			dk.setColEdge(((Circle)pomShape).getColEdge());
			dk.setVisible(true);
			try
			{
			if(dk.isOk())
			{
				((Circle)pomShape).setCenter(new Point(Integer.parseInt(dk.getTxtCoordX()),Integer.parseInt(dk.getTxtCoordY())));
				((Circle)pomShape).setRadius(Integer.parseInt(dk.getTextDiametar()));
				((Circle)pomShape).setColEdge(dk.getColEdge());
				((Circle)pomShape).setColInner(dk.getColInner());
				//list.set(index,pomShape);
				model.add(pomShape);
				setShape(list);
				setTestShape(pomShape);
				//System.out.println("this is length" + list.isEmpty());
				frame.repaint();
				
			}
			}
			catch(NumberFormatException ex)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(new JFrame(), "Value of diameter must be positive!", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		}
		else
		{
			setStartPoint(null);
			JOptionPane.showMessageDialog(new JFrame(), "No shape selected!", "Error!", JOptionPane.WARNING_MESSAGE);
		}
	}
    
    protected void delete() { 
    	if(getTestShape()!=null)
		{
			Shape pomShape=getTestShape();
			ArrayList<Shape> list=getShape();
			//int index=list.indexOf(pomShape);
			//System.out.println("this is length" + list.isEmpty());
			if(JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to delete selected shape?","Check",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			{
				model.remove(pomShape);
				setTestShape(null); 
				setShape(list);
				
				frame.repaint();
			}
		}
		else
		{
			setStartPoint(null);
			JOptionPane.showMessageDialog(new JFrame(), "No shape selected", "Error!", JOptionPane.WARNING_MESSAGE);
		}

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
