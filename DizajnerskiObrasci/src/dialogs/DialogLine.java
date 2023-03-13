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

public class DialogLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStartCoordX;
	private JTextField txtStartCoordY;
	private JTextField txtEndCoordX;
	private JTextField txtEndCoordY;
	private boolean ok;
	private Color col;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogLine dialog = new DialogLine();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogLine() {
		setBounds(100, 100, 638, 477);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblStartPoint = new JLabel("Start Point");
		lblStartPoint.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JLabel lblStartCoordX = new JLabel("Coordinate X");
		lblStartCoordX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblStartCoordY = new JLabel("Coordinate Y");
		lblStartCoordY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblEndPoint = new JLabel("End point");
		lblEndPoint.setFont(new Font("Tahoma", Font.PLAIN, 21));
		JLabel lblEndCoordX = new JLabel("Coordinata X");
		lblEndCoordX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel lblEndCoordY = new JLabel("Coordinata Y");
		lblEndCoordY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtStartCoordX = new JTextField();
		txtStartCoordX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtStartCoordX.setColumns(10);
		
		txtStartCoordX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		txtStartCoordY = new JTextField();
		txtStartCoordY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtStartCoordY.setColumns(10);
		
		txtStartCoordY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		txtEndCoordX = new JTextField();
		txtEndCoordX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEndCoordX.setColumns(10);
		
		txtEndCoordX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		txtEndCoordY = new JTextField();
		txtEndCoordY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtEndCoordY.setColumns(10);
		
		txtEndCoordY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
					if (c=='-') {
						e.consume();
						getToolkit().beep();
					}
			}
		});
		
		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				col=JColorChooser.showDialog(null, "Pick your color", null);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStartPoint)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblStartCoordY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblStartCoordX, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblEndCoordX, Alignment.LEADING)
								.addComponent(lblEndPoint, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addComponent(lblEndCoordY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(38)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtEndCoordY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtStartCoordY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtStartCoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEndCoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(98)
							.addComponent(btnColor)))
					.addGap(72))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblStartPoint)
							.addGap(29)
							.addComponent(lblStartCoordX))
						.addComponent(txtStartCoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblStartCoordY)
						.addComponent(txtStartCoordY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtEndCoordX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEndPoint, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnColor))
							.addGap(18)
							.addComponent(lblEndCoordX)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndCoordY)
						.addComponent(txtEndCoordY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(68, Short.MAX_VALUE))
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
					public void actionPerformed(ActionEvent arg0) {
						try
						{
				
						setOk(true);
						dispose();
						}
						catch(NumberFormatException e)
						{
							JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry. Check that all fields are filled with numeric values!", "Error", JOptionPane.WARNING_MESSAGE);
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
	public String getTxtStartCoordX() {
		return txtStartCoordX.getText();
	}

	public void setTxtStartCoordX(String txtStartCoordX) {
		this.txtStartCoordX.setText(txtStartCoordX);
	}

	public String getTxtStartCoordY() {
		return txtStartCoordY.getText();
	}

	public void setTxtStartCoordY(String txtStartCoordY) {
		this.txtStartCoordY.setText(txtStartCoordY);
	}

	public String getTxtEndCoordX() {
		return txtEndCoordX.getText();
	}

	public void setTxtEndCoordX(String txtEndCoordX) {
		this.txtEndCoordX.setText(txtEndCoordX);
	}

	public String getTxtEndCoordY() {
		return txtEndCoordY.getText();
	}

	public void setTxtEndCoordY(String txtEndCoordY) {
		this.txtEndCoordY.setText(txtEndCoordY);
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public Color getCol() {
		return col;
	}

	public void setCol(Color col) {
		this.col = col;
	}
	
	public void setTxtStartCoordXEdt(boolean b)
	{
		this.txtStartCoordX.setEditable(b);
	}
	
	public void setTxtStartCoordYEdt(boolean b)
	{
		this.txtStartCoordY.setEditable(b);
	}
	
	public void setTxtEndCoordXEdt(boolean b)
	{
		this.txtEndCoordX.setEditable(b);
	}
	
	public void setTxtEndCoordYEdt(boolean b)
	{
		this.txtEndCoordY.setEditable(b);
	}
	

}
