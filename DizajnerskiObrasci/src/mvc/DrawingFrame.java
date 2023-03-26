package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JColorChooser;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
	
	private Color innerColor = new Color(0, 0, 0);
	private Color edgeColor = new Color(255, 255, 255);
	
	
	private JPanel contentPane;
	JToggleButton tglbtnHexagon;
	JToggleButton tglbtnPoint;
	JToggleButton tglbtnLine;
	JToggleButton tglbtnRectangle;
	JToggleButton tglbtnCircle;
	JToggleButton tglbtnCirclewithHole;
	JToggleButton tglbtnSelect;
	JToggleButton tglbtnModify;
	JToggleButton tglbtnDelete;
	JToggleButton tglbtnRedo;
	JToggleButton tglbtnUndo;
	JButton btnSavePainting;
	JButton btnSaveLog;
	JButton btnLoadNext;
	JButton btnOpenPainting;
	JButton btnOpenLog;
	JButton btnToFront;
	JButton btnToBack;
	JButton btnBringToFront;
	JButton btnBringToBack;
	JButton btnInnerColor;
	JButton btnEdgeColor;

	
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	


	
	
	public DrawingFrame() {
		view.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            controller.thisMouseClicked(e);
	        }
	    });
	    getContentPane().add(view, BorderLayout.CENTER);
		
		
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("IT67-2018, Luka Panic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ButtonGroup group=new ButtonGroup();
		//ButtonGroup groupVertical=new ButtonGroup();

		

		JToolBar toolBar = new JToolBar();
		 //JToolBar toolbarVertical = new JToolBar(null, JToolBar.VERTICAL);
		

		
		
		tglbtnHexagon = new JToggleButton("Hexagon");
		tglbtnHexagon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.setStartPoint(null);
			}
		});
		tglbtnHexagon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		toolBar.add(tglbtnHexagon);
		group.add(tglbtnHexagon);
		
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
				repaint();
			}
		});
		
		group.add(tglbtnDelete);
		tglbtnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnDelete);
		
		tglbtnUndo = new JToggleButton("Undo");
	

		tglbtnUndo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.undo();
			}
		});
		group.add(tglbtnUndo);
		tglbtnUndo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnUndo);
		
		tglbtnRedo = new JToggleButton("Redo");
	

		tglbtnRedo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.redo();
			}
		});
		group.add(tglbtnRedo);
		tglbtnRedo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(tglbtnRedo);
		
		
		btnSavePainting = new JButton("Save Painting");
		

		btnSavePainting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					controller.savePainting();
				
				} catch (IOException e1) {
				
					e1.printStackTrace();
				}
			}
		});
		group.add(btnSavePainting);
		btnSavePainting.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnSavePainting);
		
		
		btnSaveLog = new JButton("Save Log");
	

		btnSaveLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.saveLog();
			}
		});
		group.add(btnSaveLog);
		btnSaveLog.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnSaveLog);
		
		
		btnLoadNext = new JButton("Load Next");
		

		btnLoadNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					controller.loadNext();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		group.add(btnLoadNext);
		btnLoadNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnLoadNext);
		
		
		btnOpenLog = new JButton("Open Log");
		

		btnOpenLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					controller.openLog();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		group.add(btnOpenLog);
		btnOpenLog.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnOpenLog);
		
		
		btnOpenPainting = new JButton("Open Painting");
		

		btnOpenPainting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					controller.openPainting();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		group.add(btnOpenPainting);
		btnOpenPainting.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnOpenPainting);
		
		// to front

		btnToFront = new JButton("To Front");
		

		btnToFront.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					controller.toFront();
				
			}
		});
		group.add(btnToFront);
		btnToFront.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnToFront);
		
		
		btnToBack = new JButton("To Back");
		

		btnToBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					controller.toBack();
				
			}
		});
		group.add(btnToBack);
		btnToBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnToBack);
		
		btnBringToFront = new JButton("Bring To Front");
		

		btnBringToFront.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					controller.bringToFront();
				
			}
		});
		group.add(btnBringToFront);
		btnBringToFront.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnBringToFront);
		
		btnBringToBack = new JButton("Bring To Back");
		

		btnBringToBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					controller.bringToBack();
				
			}
		});
		group.add(btnBringToBack);
		btnBringToBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnBringToBack);

		
		btnInnerColor = new JButton("");
		//btnInnerColor.setBounds(95, 30);
		btnInnerColor.setBackground(Color.WHITE);

		

//		btnInnerColor.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Color temp = JColorChooser.showDialog(null, "Choose Color", innerColor);
//				if (temp != null) {
//					innerColor = temp;
//					btnInnerColor.setBackground(innerColor);
//					controller.modifyInnerColor(temp);
//				}
//			}
//		});
		
		btnInnerColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Color temp = JColorChooser.showDialog(null, "Choose Color", Color.WHITE);
				if (temp != null) {
					innerColor = temp;
					btnInnerColor.setBackground(innerColor);
					//controller.modifyInnerColor(temp);
					//repaint();
				}
				
			}
		});
		group.add(btnInnerColor);
		btnInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnInnerColor);
		
		
		btnEdgeColor = new JButton("");
		
		btnEdgeColor.setBackground(Color.BLACK);
		

		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Color temp = JColorChooser.showDialog(null, "Choose Color", Color.BLACK);
				if (temp != null) {
					edgeColor = temp;
					btnEdgeColor.setBackground(edgeColor);
				}
			}
		});
		group.add(btnEdgeColor);
		btnEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		toolBar.add(btnEdgeColor);
		
		
		
		
		JPanel panelLog = new JPanel();
		panelLog.setBackground(Color.WHITE);
		//panelLog.setLayout(null);
		
		
		
		
		
		
		
		
		//panelLog.setLocation(500, 250);
		
		
		
		//view.setSize(new Dimension(20, 40));
		//view.setPreferredSize(new Dimension(200, 400));
		
		//contentPane.add(view);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(view, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(129, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						//.addComponent(toolbarVertical, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(800, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelLog, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
				
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					//.addComponent(toolbarVertical, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(view, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
				.addComponent(panelLog, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
		);
		
	
		
		scrollPane = new JScrollPane();
		
		GroupLayout gl_PanelLog = new GroupLayout(panelLog);
		gl_PanelLog.setHorizontalGroup(gl_PanelLog.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE));
		gl_PanelLog.setVerticalGroup(gl_PanelLog.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE));
	
		
		
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		//scrollPane.setBounds(50, 50, 50, 50);
		scrollPane.setViewportView(textArea);
		
		panelLog.setLayout(gl_PanelLog);
		panelLog.setBounds(120, 110, 100, 120);
		
		
		
		
		view.add(panelLog);
		
		
		contentPane.setLayout(gl_contentPane);
		
		
		view.setPreferredSize(new Dimension(200, 400));
		
		contentPane.add(view);
	
		
	}
	
	public DrawingView getView() {
		return view;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}
	
	public boolean getTglbtnHexagon() {
		return tglbtnHexagon.isSelected();
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
	
	public JToggleButton getBtnUndo() {
		return tglbtnUndo;
	}
	
	public JToggleButton getBtnRedo() {
		return tglbtnRedo;
	}
	public void setTglBtnPoint() {
		
	}
	
	public void setBtnRedo(JToggleButton tglbtnRedo) {
		this.tglbtnRedo = tglbtnRedo; 
	}
	
	public void setBtnUndo(JToggleButton tglbtnUndo) {
		this.tglbtnUndo = tglbtnUndo;
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}
	
	
	public JToggleButton getTglBtnPoint() {
		return tglbtnPoint;
	}

	public void setTglBtnPoint(JToggleButton tglBtnPoint) {
		this.tglbtnPoint = tglBtnPoint;
	}

	public JToggleButton getTglBtnLine() {
		return tglbtnLine;
	}

	public void setTglBtnLine(JToggleButton tglBtnLine) {
		this.tglbtnLine = tglBtnLine;
	}

	public JToggleButton getTglBtnCircle() {
		return tglbtnCircle;
	}

	public void setTglBtnCircle(JToggleButton tglBtnCircle) {
		this.tglbtnCircle = tglBtnCircle;
	}

	public JToggleButton getTglBtnDonut() {
		return tglbtnCirclewithHole;
	}

	public void setTglBtnDonut(JToggleButton tglBtnDonut) {
		this.tglbtnCirclewithHole = tglBtnDonut;
	}

	public JToggleButton getTglBtnRectangle() {
		return tglbtnRectangle;
	}

	public void setTglBtnRectangle(JToggleButton tglBtnRectangle) {
		this.tglbtnRectangle = tglBtnRectangle;
	}

	public JToggleButton getTglBtnHexagon() {
		return tglbtnHexagon;
	}

	public void setTglBtnHexagon(JToggleButton tglBtnHexagon) {
		this.tglbtnHexagon = tglBtnHexagon;
	}
	
	public JButton getBtnLoadNext() {
		return btnLoadNext;
	}

	public boolean getBtnInnerColorSelected() {
		return btnInnerColor.isSelected();
	}
	
	public boolean getBtnEdgeColorSelected() {
		return btnEdgeColor.isSelected();
	}
	
	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}
	
	public JButton getBtnEdgeColor() {
		return btnEdgeColor;
	}

	public void setBtnEdgeColor(JButton btnEdgeColor) {
		this.btnEdgeColor = btnEdgeColor;
	}
	
	
}
