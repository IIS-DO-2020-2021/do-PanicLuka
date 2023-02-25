package sorting;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Sort extends JFrame {

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
					Sort frame = new Sort();
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
	public Sort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("IT67-2018, Luka Panic");
		setBounds(100, 100, 686, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Rectangle rectangle=new Rectangle();
				DialogRectangle dija= new DialogRectangle();
				dija.setLblOptionalTxt("Insert rectangle parameteres?");
				dija.setVisible(true);
				if(dija.isOk())
				{
				try {
				rectangle.setUpperLeftPoint(new Point(Integer.parseInt((dija.getTxtXCoordinate())),Integer.parseInt(dija.getTxtYCoordinate())));
				rectangle.setWidth(Integer.parseInt(dija.getTxtWidth()));
				rectangle.setHeight(Integer.parseInt(dija.getTxtWidth()));
				dlm.addElement(rectangle);
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(new JFrame(),"Incorrect data entry.Check that all fields are filled with numeric values!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(new JFrame(),"height and width must be positive!", "Error!", JOptionPane.ERROR_MESSAGE);
				}
				}
			}
		});
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Rectangle> pomList=new ArrayList<Rectangle>();
				for(int i=0;i<dlm.size();i++)
				{
					pomList.add(i,dlm.getElementAt(i));
				}
				for(int i=1;i<=pomList.size()-1;i++) {
					for(int j=0;j<pomList.size()-1;j++) {
						if(pomList.get(j).area()>pomList.get(j+1).area()) {
							Rectangle pom=pomList.get(j);
							pomList.set(j, pomList.get(j+1));
							pomList.set(j+1, pom);
						}
					}
				}
				dlm.removeAllElements();
				for(Rectangle i:pomList) {
					dlm.addElement(i);
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSort, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(106)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(btnSort, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		
		JList list = new JList();
		list.setModel(dlm);
		scrollPane.setViewportView(list);
		contentPane.setLayout(gl_contentPane);
	}
}
