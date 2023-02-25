package painting;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToolBar;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Drawing extends JFrame {

	private JPanel contentPane;
	JToggleButton tglbtnPoint;
	JToggleButton tglbtnLine;
	JToggleButton tglbtnRectangle;
	JToggleButton tglbtnCircle;
	JToggleButton tglbtnCirclewithHole;
	JToggleButton tglbtnSelect;
	JToggleButton tglbtnModify;
	JToggleButton tglbtnDelete;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Drawing frame = new Drawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public Drawing() {
		PnlDrawing panel= new PnlDrawing(this); 
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("IT67-2018, Luka Panic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ButtonGroup group=new ButtonGroup();
		JToolBar toolBar = new JToolBar();
		
		tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.setStartPoint(null);
			}
		});
		tglbtnPoint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnPoint);
		group.add(tglbtnPoint);
		
	    tglbtnLine = new JToggleButton("Line");
	    tglbtnLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.setStartPoint(null);
			}
		});
		tglbtnLine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnLine);
		group.add(tglbtnLine);
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setStartPoint(null);
			}
		});
		tglbtnRectangle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnRectangle);
		group.add(tglbtnRectangle);
		
		tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setStartPoint(null);
			}
		});
		tglbtnCircle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnCircle);
		group.add(tglbtnCircle);
		
		tglbtnCirclewithHole = new JToggleButton("Donut");
		tglbtnCirclewithHole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setStartPoint(null);
			}
		});
		tglbtnCirclewithHole.setFont(new Font("Tahoma", Font.PLAIN, 20));
		group.add(tglbtnCirclewithHole);
		toolBar.add(tglbtnCirclewithHole);
		
		tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setStartPoint(null);
			}
		});
		group.add(tglbtnSelect);
		tglbtnSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnSelect);
		
		tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(panel.getTestShape()!=null)
				{
					Shape pomShape=panel.getTestShape();
					ArrayList<Shape> list=panel.getShape();
					int index=list.indexOf(pomShape);
				if(panel.getTestShape() instanceof Point)
				{
		
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
					list.set(index, pomShape);
					panel.setShape(list);
					panel.setTestShape(pomShape);
					panel.repaint();
					}
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error!", JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(panel.getTestShape() instanceof Line)
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
						list.set(index,pomShape);
						panel.setShape(list);
						panel.setTestShape(pomShape);
						panel.repaint();
					}
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(panel.getTestShape() instanceof Rectangle)
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
						list.set(index,pomShape);
						panel.setShape(list);
						panel.setTestShape(pomShape);
						panel.repaint();
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
				else if(panel.getTestShape() instanceof Donut)
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
						list.set(index,pomShape);
						panel.setShape(list);
						panel.setTestShape(pomShape);
						panel.repaint();
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
					
				}else if(panel.getTestShape() instanceof Circle)
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
						list.set(index,pomShape);
						panel.setShape(list);
						panel.setTestShape(pomShape);
						panel.repaint();
						
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
					panel.setStartPoint(null);
					JOptionPane.showMessageDialog(new JFrame(), "No shape selected!", "Error!", JOptionPane.WARNING_MESSAGE);
				}
			}
			});
		group.add(tglbtnModify);
		tglbtnModify.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnModify);
		tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(panel.getTestShape()!=null)
				{
					Shape pomShape=panel.getTestShape();
					ArrayList<Shape> list=panel.getShape();
					int index=list.indexOf(pomShape);
					if(JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to delete selected shape?","Check",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					{
						list.remove(index);
						panel.setShape(list);
						panel.setTestShape(null); 
						panel.repaint();
					}
				}
				else
				{
					panel.setStartPoint(null);
					JOptionPane.showMessageDialog(new JFrame(), "No shape selected", "Error!", JOptionPane.WARNING_MESSAGE);
				}
	
			}
		});
		group.add(tglbtnDelete);
		tglbtnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnDelete);
		
		
		panel.setSize(new Dimension(20, 40));
		panel.setPreferredSize(new Dimension(200, 400));
		contentPane.add(panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(129, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
	}
	
	public boolean getTglbtnPoint() {
		return tglbtnPoint.isSelected();
	}

	public boolean getTglbtnLine() {
		return tglbtnLine.isSelected();
	}

	public boolean getTglbtnRectangle() {
		return tglbtnRectangle.isSelected();
	}

	public boolean getTglbtnCircle() {
		return tglbtnCircle.isSelected();
	}

	public boolean getTglbtnCirclewithHole() {
		return tglbtnCirclewithHole.isSelected();
	}

	public boolean getTglbtnSelect() {
		return tglbtnSelect.isSelected();
	}

	public boolean getTglbtnModify() {
		return tglbtnModify.isSelected();
	}

	public boolean getTglbtnDelete() {
		return tglbtnDelete.isSelected();
	}
	
}
