package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Rectangle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXCoordinate;
	private JTextField txtYCoordinate;
	private JTextField txtHeight;
	private JTextField txtWidth;
	private boolean ok;
	private JLabel lblXCoordinate;
	private JLabel lblYCoordinate;
	private JLabel lblHeight;
	private JLabel lblWidth;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel lblOptional;
	private JButton btnInnerColor;
	private JButton btnEdgeColor;
	private Color innerColor;
	private Color edgeColor;
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogRectangle dialog = new DialogRectangle();
			dialog.setTitle("Rectangle");
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the dialog.
	 */
	public DialogRectangle() {
		setTitle("Rectangle");
		setBounds(100, 100, 802, 508);
		getContentPane().setLayout(new BorderLayout());
		this.setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblXCoordinate = new JLabel("X Coordinate");
			lblXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblXCoordinate.setHorizontalTextPosition(SwingConstants.LEFT);
			lblXCoordinate.setHorizontalAlignment(SwingConstants.LEFT);
		}
		{
			txtXCoordinate = new JTextField();
			txtXCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtXCoordinate.setColumns(10);
		}
		
		txtXCoordinate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		
		{
			lblYCoordinate = new JLabel("Y Coordinate");
			lblYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		{
			txtYCoordinate = new JTextField();
			txtYCoordinate.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtYCoordinate.setColumns(10);
		}
		
		txtYCoordinate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		{
			lblHeight = new JLabel("Height");
			lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		{
			txtHeight = new JTextField();
			txtHeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtHeight.setColumns(10);
		}
		{
			lblWidth = new JLabel("Width");
			lblWidth.setFont(new Font("Tahoma", Font.PLAIN, 20));
			
		}
		{
			txtWidth = new JTextField();
			txtWidth.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtWidth.setText("");
			txtWidth.setColumns(10);
		}
		
		lblOptional = new JLabel("");
		lblOptional.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInnerColor = new JButton("Inner color");
		btnInnerColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				innerColor=JColorChooser.showDialog(null, "Pick your color", Color.WHITE);
			}
		});
		btnEdgeColor = new JButton("Edge color");
		btnEdgeColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				edgeColor=JColorChooser.showDialog(null, "Pick your color", Color.BLACK);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblXCoordinate)
								.addComponent(lblYCoordinate)
								.addComponent(lblHeight)
								.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtWidth)
								.addComponent(txtYCoordinate, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
								.addComponent(txtXCoordinate, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
								.addComponent(txtHeight, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnInnerColor)
								.addComponent(btnEdgeColor))
							.addGap(119))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblOptional)
							.addContainerGap(738, Short.MAX_VALUE))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblOptional)
							.addGap(27)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblXCoordinate)
								.addComponent(txtXCoordinate, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtYCoordinate, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblYCoordinate))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHeight))
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(95)
							.addComponent(btnInnerColor)
							.addGap(62)
							.addComponent(btnEdgeColor)))
					.addContainerGap(125, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						try
						{
						Rectangle r=new Rectangle();
						r.setHeight(Integer.parseInt(getTxtHeight()));
						r.setWidth(Integer.parseInt(getTxtWidth()));
						int i=Integer.parseInt(getTxtXCoordinate());
						int j=Integer.parseInt(getTxtYCoordinate());
						ok=true;
						dispose();
						}
						catch(NumberFormatException ex)
						{
							JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry.Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(new JFrame(), "Height and width must be positive values!", "Error", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						ok=false;
						dispose();
	
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(610)
						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addGap(3)
						.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
			
			
		}
	}
	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public void setTxtXCoordinateEnabled(boolean b)
	{
		this.txtXCoordinate.setEnabled(b);
	}
	
	public void setTxtYCoordinateEnabled(boolean b)
	{
		this.txtYCoordinate.setEnabled(b);
	}
	
	public void setTxtHeightEnabled(boolean b)
	{
		this.txtHeight.setEnabled(b);
	}
	
	public void setTxtWidthEnabled(boolean b)
	{
		this.txtWidth.setEnabled(b);
	}
	public void setLblOpcionoTxt(String text) {
		lblOptional.setText(text);
	}

	public String getTxtXCoordinate() {
		return txtXCoordinate.getText();
	}

	public void setTxtXCoordinate(String s) {
		this.txtXCoordinate.setText(s);
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getTxtYCoordinate() {
		return txtYCoordinate.getText();
	}

	public void setTxtYCoordinate(String s) {
		this.txtYCoordinate.setText(s);;
	}

	public String getTxtHeight() {
		return txtHeight.getText();
	}

	public void setTxtHeight(String broj) {
		this.txtHeight.setText(broj);
	}

	public String getTxtWidth() {
		return txtWidth.getText();
	}

	public void setTxtWidth(String broj) {
		this.txtWidth.setText(broj);;
	}
}
