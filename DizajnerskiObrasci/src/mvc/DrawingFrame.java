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
	
	private Color innerColor = Color.WHITE;
	private Color edgeColor = Color.BLACK;
	
	private JPanel upperPanel;
	private JPanel lowerPanel;
	private JPanel pnlLog;
	private JPanel pnlMiddle;
	
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

	
	private ButtonGroup group;
	
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		upperPanel = new JPanel();
		contentPane.add(upperPanel, BorderLayout.NORTH);
		pnlMiddle = new JPanel();
		contentPane.add(pnlMiddle, BorderLayout.SOUTH);
		lowerPanel = new JPanel();
		pnlMiddle.add(lowerPanel, BorderLayout.NORTH);
		pnlLog = new JPanel();
		pnlLog.setBackground(Color.WHITE);
		pnlMiddle.add(pnlLog, BorderLayout.SOUTH);
		

		
		group = new ButtonGroup();
		
		
		

		
		
		tglbtnHexagon = new JToggleButton();
		tglbtnHexagon.setToolTipText("Hexagon");
		tglbtnHexagon.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/hexagon.png")));
		tglbtnHexagon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.setStartPoint(null);
			}
		});
		tglbtnHexagon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		upperPanel.add(tglbtnHexagon);
		group.add(tglbtnHexagon);
		
		tglbtnPoint = new JToggleButton();
		tglbtnPoint.setToolTipText("Point");
		tglbtnPoint.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/point.png")));
		tglbtnPoint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.setStartPoint(null);
			}
		});
		tglbtnPoint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		upperPanel.add(tglbtnPoint);
		group.add(tglbtnPoint);
		
	    tglbtnLine = new JToggleButton();
	    tglbtnLine.setToolTipText("Line");
	    tglbtnLine.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/line.png")));
	    tglbtnLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.setStartPoint(null);
			}
		});
		tglbtnLine.setFont(new Font("Tahoma", Font.PLAIN, 20));
		upperPanel.add(tglbtnLine);
		group.add(tglbtnLine);
		
		tglbtnRectangle = new JToggleButton();
		tglbtnRectangle.setToolTipText("Rectangle");
		tglbtnRectangle.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/rectangle.png")));
		tglbtnRectangle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.setStartPoint(null);
			}
		});
		tglbtnRectangle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		upperPanel.add(tglbtnRectangle);
		group.add(tglbtnRectangle);
		
		tglbtnCircle = new JToggleButton();
		tglbtnCircle.setToolTipText("Circle");
		tglbtnCircle.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/circle.png")));
		tglbtnCircle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.setStartPoint(null);
			}
		});
		tglbtnCircle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		upperPanel.add(tglbtnCircle);
		group.add(tglbtnCircle);
		
		tglbtnCirclewithHole = new JToggleButton();
		//tglbtnCirclewithHole.setBackground(Color.WHITE);
		tglbtnCirclewithHole.setToolTipText("Donut");

		
		tglbtnCirclewithHole.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/donut.png")));
		tglbtnCirclewithHole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.setStartPoint(null);
			}
		});
		tglbtnCirclewithHole.setFont(new Font("Tahoma", Font.PLAIN, 20));
		upperPanel.add(tglbtnCirclewithHole);
		group.add(tglbtnCirclewithHole);
		
		tglbtnSelect = new JToggleButton();
		tglbtnSelect.setToolTipText("Select");
		tglbtnSelect.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/select.png")));


		tglbtnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.setStartPoint(null);
			}
		});
		upperPanel.add(tglbtnSelect);
		group.add(tglbtnSelect);
		tglbtnSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		this.getContentPane().add(view, BorderLayout.CENTER);
		
		tglbtnModify = new JToggleButton();
		tglbtnModify.setToolTipText("Modify");
		tglbtnModify.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/modify.png")));


		tglbtnModify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.modify();
				repaint();

                
            }
        });
		lowerPanel.add(tglbtnModify);
		group.add(tglbtnModify);
		tglbtnModify.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		tglbtnDelete = new JToggleButton();
		tglbtnDelete.setToolTipText("Delete");
		tglbtnDelete.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/delete.png")));


		tglbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.delete();
				repaint();
			}
		});
		lowerPanel.add(tglbtnDelete);
		group.add(tglbtnDelete);
		tglbtnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		tglbtnUndo = new JToggleButton();
		tglbtnUndo.setToolTipText("Undo");

		tglbtnUndo.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/undo.png")));
	

		tglbtnUndo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.undo();
			}
		});
		lowerPanel.add(tglbtnUndo);
		group.add(tglbtnUndo);
		tglbtnUndo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		tglbtnRedo = new JToggleButton();
		tglbtnRedo.setToolTipText("Redo");

	
		tglbtnRedo.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/redo.png")));
		tglbtnRedo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.redo();
			}
		});
		lowerPanel.add(tglbtnRedo);
		group.add(tglbtnRedo);
		tglbtnRedo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		btnSavePainting = new JButton();
		btnSavePainting.setToolTipText("Save Painting");

		
		btnSavePainting.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/savePainting.png")));

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
		lowerPanel.add(btnSavePainting);
		group.add(btnSavePainting);
		btnSavePainting.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		btnSaveLog = new JButton();
		btnSaveLog.setToolTipText("Save Log");

		btnSaveLog.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/saveLog.png")));

		btnSaveLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.saveLog();
			}
		});
		lowerPanel.add(btnSaveLog);
		group.add(btnSaveLog);
		btnSaveLog.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		btnLoadNext = new JButton();
		btnLoadNext.setToolTipText("Load Next");
		
		btnLoadNext.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/loadNext.png")));
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
		lowerPanel.add(btnLoadNext);
		group.add(btnLoadNext);
		btnLoadNext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		btnOpenLog = new JButton();
		btnOpenLog.setToolTipText("Open Log");

		
		btnOpenLog.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/openLog.png")));
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
		lowerPanel.add(btnOpenLog);
		group.add(btnOpenLog);
		btnOpenLog.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		btnOpenPainting = new JButton();
		btnOpenPainting.setToolTipText("Open Painting");

		
		btnOpenPainting.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/openPainting.png")));
		btnOpenPainting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					controller.openPainting();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		lowerPanel.add(btnOpenPainting);
		group.add(btnOpenPainting);
		btnOpenPainting.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		

		btnToFront = new JButton();
		btnToFront.setToolTipText("To Front");

		
		btnToFront.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/toFront.png")));
		btnToFront.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					controller.toFront();
				
			}
		});
		lowerPanel.add(btnToFront);
		group.add(btnToFront);
		btnToFront.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		btnToBack = new JButton();
		btnToBack.setToolTipText("To Back");

		btnToBack.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/toBack.png")));

		btnToBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					controller.toBack();
				
			}
		});
		lowerPanel.add(btnToBack);
		group.add(btnToBack);
		btnToBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		btnBringToFront = new JButton();
		btnBringToFront.setToolTipText("Bring To Front");

		
		btnBringToFront.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/bringToFront.png")));
		btnBringToFront.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					controller.bringToFront();
				
			}
		});
		lowerPanel.add(btnBringToFront);
		group.add(btnBringToFront);
		btnBringToFront.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		btnBringToBack = new JButton();
		btnBringToBack.setToolTipText("Bring To Back");

		btnBringToBack.setIcon(new ImageIcon(DrawingFrame.class.getResource("/logos/sendToBack.png")));

		btnBringToBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					controller.bringToBack();
				
			}
		});
		lowerPanel.add(btnBringToBack);
		group.add(btnBringToBack);
		btnBringToBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		
		btnInnerColor = new JButton("   ");
		btnInnerColor.setToolTipText("Inner Color");
		btnInnerColor.setBackground(Color.WHITE);

		


		btnInnerColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Color temp = JColorChooser.showDialog(null, "Choose Color", Color.WHITE);
				if (temp != null) {
					innerColor = temp;
					btnInnerColor.setBackground(innerColor);
					
				}
				
			}
		});
		upperPanel.add(btnInnerColor);
		group.add(btnInnerColor);
		btnInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
		btnEdgeColor = new JButton("   ");
		btnEdgeColor.setToolTipText("Edge Color");
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
		upperPanel.add(btnEdgeColor);
		group.add(btnEdgeColor);
		btnEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		scrollPane = new JScrollPane();
		
		GroupLayout gl_PanelLog = new GroupLayout(pnlLog);
		gl_PanelLog.setHorizontalGroup(gl_PanelLog.createParallelGroup()
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE));
		gl_PanelLog.setVerticalGroup(gl_PanelLog.createParallelGroup()
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE));
				
		
		
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		pnlLog.setLayout(gl_PanelLog);
		
		
		
		
	
		
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
	
	public JToggleButton getBtnSelect() {
		return tglbtnSelect;
	}
	
	public JToggleButton getBtnModify() {
		return tglbtnModify;
	}
	
	public JToggleButton getBtnDelete() {
		return tglbtnDelete;
	}
	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}
	
	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}
	
	public JButton getBtnToFront() {
		return btnToFront;
	}
	
	public JButton getBtnToBack() {
		return btnToBack;
	}
	

	

	
	
	
	
	
	
}
