package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class DialogDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCoordX;
	private JTextField txtCoordY;
	private JTextField txtInner;
	private JTextField txtEdge;
	private Color ColInner;
	private Color ColEdge;
	private boolean ok;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogDonut dialog = new DialogDonut();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogDonut() {
		setBounds(100, 100, 730, 492);
		setTitle("Donut");
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCenter = new JLabel("Center");
		lblCenter.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JLabel lblCoordinateX = new JLabel("Coordinate X");
		lblCoordinateX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblCoordinateY = new JLabel("Coordinate Y");
		lblCoordinateY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCoordX = new JTextField();
		txtCoordX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCoordX.setColumns(10);
		
		txtCoordX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		
		txtCoordY = new JTextField();
		txtCoordY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCoordY.setColumns(10);
		
		txtCoordY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		
		JLabel lblRadius = new JLabel("Diametars");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JLabel lblInnerr = new JLabel("Inner radius");
		lblInnerr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblEdge = new JLabel("Edge");
		lblEdge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtInner = new JTextField();
		txtInner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtInner.setColumns(10);
		txtEdge = new JTextField();
		txtEdge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEdge.setColumns(10);
		
		JButton btnColInnerr = new JButton("Inner color");
		btnColInnerr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ColInner=JColorChooser.showDialog(null, "Pick your color", Color.WHITE);
			}
		});
		
		JButton btnColEdge = new JButton("Col edge");
		btnColEdge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ColEdge=JColorChooser.showDialog(null, "Pick your color", Color.BLACK);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblRadius, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblCoordinateX, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblCoordinateY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblEdge, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInnerr, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(40)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(txtCoordY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
											.addComponent(btnColInnerr)
											.addGap(82))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtInner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtEdge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtCoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addContainerGap(334, Short.MAX_VALUE))))
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnColEdge)
									.addGap(115))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblCenter)
							.addContainerGap(603, Short.MAX_VALUE))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(31)
							.addComponent(lblCenter)
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCoordinateX)
								.addComponent(txtCoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCoordinateY)
								.addComponent(txtCoordY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(43)
							.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblInnerr, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEdge, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEdge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(112)
							.addComponent(btnColInnerr)
							.addGap(66)
							.addComponent(btnColEdge)))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try
						{
						//int i=Integer.parseInt(getTxtCoordX());
						//int j=Integer.parseInt(getTxtCoordY());
						//Point p=new Point(i,j);
						//Donut d=new Donut(p,Integer.parseInt(getTxtEdge()),Integer.parseInt(getTxtInner()));
						setOk(true);
						dispose();
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
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public Color getColInner() {
		return ColInner;
	}

	public void setColInner(Color ColInner) {
		this.ColInner = ColInner;
	}

	public Color getColEdge() {
		return ColEdge;
	}

	public void setColEdge(Color ColEdge) {
		this.ColEdge = ColEdge;
	}


	
	public void setTxtCoordXEditable(boolean b)
	{
		this.txtCoordX.setEditable(b);
	}
	
	public void setTxtCoordYEditable(boolean b)
	{
		this.txtCoordY.setEditable(b);
	}
	
	public void setTxtInnerEditable(boolean b)
	{
		this.txtInner.setEditable(b);
	}
	
	public void setTxtEdgeEditable(boolean b)
	{
		this.txtEdge.setEditable(b);
	}
	

	public String getTxtInner() {
		return txtInner.getText();
	}

	public void setTxtInner(String txtInner) {
		this.txtInner.setText(txtInner);
	}

	public String getTxtEdge() {
		return txtEdge.getText();
	}

	public void setTxtEdge(String txtEdge) {
		this.txtEdge.setText(txtEdge);
	}

	public String getTxtCoordX() {
		return txtCoordX.getText();
	}

	public void setTxtCoordX(String txtCoordX) {
		this.txtCoordX.setText(txtCoordX);
	}

	public String getTxtCoordY() {
		return txtCoordY.getText();
	}

	public void setTxtCoordY(String txtCoordY) {
		this.txtCoordY.setText(txtCoordY);
	}
	
	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
