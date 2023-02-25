package stack;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Stack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm=new DefaultListModel<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Stack frame = new Stack();
					frame.setTitle("IT67-2018, Luka Panic");
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
	public Stack() {
		setForeground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrlPaneRectangles = new JScrollPane();
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrlPaneRectangles.setViewportView(list);
		list.setModel(dlm);
		scrlPaneRectangles.setViewportView(list);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Rectangle rectangle=new Rectangle();
				DialogRectangle dija= new DialogRectangle();
				dija.setLblInsertWidth("Insert rectangle parameters:");
				dija.setVisible(true);
				if(dija.isOk())
				{
				try {
				rectangle.setUpperLeftPoint(new Point(Integer.parseInt((dija.getTextCoordX())),Integer.parseInt(dija.getTextCoordY())));
				rectangle.setWidth(Integer.parseInt(dija.getTextWidth()));
				rectangle.setHeight(Integer.parseInt(dija.getTextHeight()));
				dlm.add(0,rectangle);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(new JFrame(),"Incorrect data entry.Check that all fields are filled with numeric values!", "Error!", JOptionPane.ERROR_MESSAGE);
					actionPerformed(arg0);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(new JFrame(),"Height and width must be positive values!", "Error!", JOptionPane.ERROR_MESSAGE);
					actionPerformed(arg0);
				}
				}
				
				}
				
				
			
		});
		
		JButton btnDelete = new JButton("Remove");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
				Rectangle rectangle=dlm.getElementAt(0);
				DialogRectangle dlg=new DialogRectangle();
				dlg.setLblInsertWidth("Are you sure you want to remove selected rectangle?");
				dlg.setTextCoordX(Integer.toString(rectangle.getUpperLeftPoint().getX()));
				dlg.setTextCoordY(Integer.toString(rectangle.getUpperLeftPoint().getY()));
				dlg.setTextHeight(Integer.toString(rectangle.getHeight()));
				dlg.setTextWidth(Integer.toString(rectangle.getWidth()));
				dlg.setTextCoordXEditable(false);
				dlg.setTextCoordYEditable(false);
				dlg.setTextHeightEditable(false);
				dlg.setTextWidthEditable(false);
				dlg.setVisible(true);
				if(dlg.isOk())
				{
					dlm.removeElement(rectangle);
				}
				}
				catch (ArrayIndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(new JFrame(), "Stack is empty!.", "Error", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 17));
        	
		
		
		
		
		JLabel lblAddOrDelete = new JLabel("Add rectangle to stack or remove one");
		lblAddOrDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(lblAddOrDelete))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(scrlPaneRectangles, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addGap(81)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(lblAddOrDelete, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(scrlPaneRectangles, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
