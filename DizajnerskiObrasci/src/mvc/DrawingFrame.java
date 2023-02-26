package mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import dialogs.DialogCircle;
import dialogs.DialogDonut;
import dialogs.DialogLine;
import dialogs.DialogPoint;
import dialogs.DialogRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;


public class DrawingFrame extends JFrame {
	
	private DrawingView view = new DrawingView();
	private DrawingController controller;
	
	private JPanel contentPane;
	JToggleButton tglbtnPoint;
	JToggleButton tglbtnLine;
	JToggleButton tglbtnRectangle;
	JToggleButton tglbtnCircle;
	JToggleButton tglbtnCirclewithHole;
	JToggleButton tglbtnSelect;
	JToggleButton tglbtnModify;
	JToggleButton tglbtnDelete;


	
	
	public DrawingFrame() {
		view.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            controller.thisMouseClicked(e);
	        }
	    });
	    getContentPane().add(view, BorderLayout.CENTER);
		
		//DrawingView panel= new DrawingView();
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
				controller.setStartPoint(null);
			}
		});
		tglbtnPoint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnPoint);
		group.add(tglbtnPoint);
		
	    tglbtnLine = new JToggleButton("Line");
	    tglbtnLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.setStartPoint(null);
			}
		});
		tglbtnLine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnLine);
		group.add(tglbtnLine);
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.setStartPoint(null);
			}
		});
		tglbtnRectangle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnRectangle);
		group.add(tglbtnRectangle);
		
		tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.setStartPoint(null);
			}
		});
		tglbtnCircle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnCircle);
		group.add(tglbtnCircle);
		
		tglbtnCirclewithHole = new JToggleButton("Donut");
		tglbtnCirclewithHole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.setStartPoint(null);
			}
		});
		tglbtnCirclewithHole.setFont(new Font("Tahoma", Font.PLAIN, 20));
		group.add(tglbtnCirclewithHole);
		toolBar.add(tglbtnCirclewithHole);
		
		tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.setStartPoint(null);
			}
		});
		group.add(tglbtnSelect);
		tglbtnSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnSelect);
		
		tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.modify();
				repaint();

                
            }
        });
			
		group.add(tglbtnModify);
		tglbtnModify.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnModify);
		tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.delete();
			}
		});
		/*tglbtnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(controller.getTestShape()!=null)
				{
					Shape pomShape=controller.getTestShape();
					ArrayList<Shape> list=controller.getShape();
					int index=list.indexOf(pomShape);
					if(JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to delete selected shape?","Check",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					{
						list.remove(index);
						controller.setShape(list);
						controller.setTestShape(null); 
						repaint();
					}
				}
				else
				{
					controller.setStartPoint(null);
					JOptionPane.showMessageDialog(new JFrame(), "No shape selected", "Error!", JOptionPane.WARNING_MESSAGE);
				}
	
			}
		});*/
		group.add(tglbtnDelete);
		tglbtnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnDelete);
		
		
		view.setSize(new Dimension(20, 40));
		view.setPreferredSize(new Dimension(200, 400));
		contentPane.add(view);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(view, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
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
					.addComponent(view, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public DrawingView getView() {
		return view;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
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
