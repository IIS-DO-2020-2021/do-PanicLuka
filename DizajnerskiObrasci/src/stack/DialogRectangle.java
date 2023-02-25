package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class DialogRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCoordX;
	private JTextField textCoordY;
	private JTextField textHeight;
	private JTextField textWidth;
	JLabel lblInsertWidth;
	private boolean ok;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogRectangle dialog = new DialogRectangle();
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
		setBounds(100, 100, 640, 408);
		getContentPane().setLayout(new BorderLayout());
		this.setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblCoordinateX = new JLabel("Coordinate X");
		lblCoordinateX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCoordinateY = new JLabel("Coordinate Y");
		lblCoordinateY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblWidth = new JLabel("Width");
		lblWidth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textCoordX = new JTextField();
		textCoordX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCoordX.setColumns(10);
		
		textCoordX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		
		textCoordY = new JTextField();
		textCoordY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textCoordY.setColumns(10);
		
		textCoordY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		
		textHeight = new JTextField();
		textHeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textHeight.setColumns(10);
		
		textWidth = new JTextField();
		textWidth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textWidth.setColumns(10);
		
		lblInsertWidth = new JLabel("Insert width and height of the rectangle");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInsertWidth)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCoordinateX)
								.addComponent(lblCoordinateY)
								.addComponent(lblHeight)
								.addComponent(lblWidth))
							.addGap(65)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCoordY, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(textCoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(199, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInsertWidth)
					.addGap(22)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCoordinateX)
						.addComponent(textCoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCoordinateY)
						.addComponent(textCoordY, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(94, Short.MAX_VALUE))
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
						try {
						Rectangle r=new Rectangle();
						r.setUpperLeftPoint(new Point(Integer.parseInt(getTextCoordX()),Integer.parseInt(getTextCoordY())));
						r.setWidth(Integer.parseInt(getTextWidth()));
						r.setHeight(Integer.parseInt(getTextHeight()));
						int i=Integer.parseInt(getTextCoordX());
						int j=Integer.parseInt(getTextCoordY());
						setOk(true);
						dispose();
						}
						catch(NumberFormatException ex) {
							JOptionPane.showMessageDialog(new JFrame(),"Incorrect data entry.Check that all fields are filled with numeric values!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(new JFrame(),"Height and width must be positive values!", "Error!", JOptionPane.ERROR_MESSAGE);
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void setLblInsertWidth(String lblInsertWidth) {
		this.lblInsertWidth.setText(lblInsertWidth);
	}

	public void setTextHeight(String textHeight) {
		this.textHeight.setText(textHeight);
	}

	public void setTextWidth(String textWidth) {
		this.textWidth.setText(textWidth);
	}

	public String getTextCoordX() {
		return textCoordX.getText();
	}

	public void setTextCoordX(String textCoordX) {
		this.textCoordX.setText(textCoordX);
	}

	public String getTextCoordY() {
		return textCoordY.getText();
	}

	public void setTextCoordY(String textCoordY) {
		this.textCoordY.setText(textCoordY);
	}

	public String getTextHeight() {
		return textHeight.getText();
	}

	public String getTextWidth() {
		return textWidth.getText();
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	public void setTextCoordXEditable(boolean b)
	{
		this.textCoordX.setEditable(b);
	}
	
	public void setTextCoordYEditable(boolean b)
	{
		this.textCoordY.setEditable(b);
	}
	
	public void setTextHeightEditable(boolean b)
	{
		this.textHeight.setEditable(b);
	}
	
	public void setTextWidthEditable(boolean b)
	{
		this.textWidth.setEditable(b);
	}

}
