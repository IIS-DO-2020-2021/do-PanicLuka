package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import adapter.HexagonAdapter;
import geometry.Point;



public class DialogHexagon extends JDialog{
	private final JPanel contentPanel = new JPanel();
	private JTextField txtRadius;
	private boolean ok;
	private JTextField txtCoordY;
	private JTextField txtCoordX;
	private Color colInner;
	private Color colEdge;
	private JColorChooser edgeColorChooser = new JColorChooser();
	private JColorChooser innerColorChooser = new JColorChooser();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogHexagon dialog = new DialogHexagon();
			dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogHexagon() {
		setTitle("Hexagon");
		setBounds(100, 100, 568, 391);
		getContentPane().setLayout(new BorderLayout());
		this.setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblRadius = new JLabel("Radius");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRadius = new JTextField();
		txtRadius.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtRadius.setColumns(10);
		
		JLabel lblCoordinateX = new JLabel("Coordinate X");
		lblCoordinateX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblCenter = new JLabel("Center");
		lblCenter.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblCoordinateY = new JLabel("Coordinate Y");
		lblCoordinateY.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
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
		
		JButton btnColInnerr = new JButton("Inner color");
		btnColInnerr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				 colInner=JColorChooser.showDialog(null, "Pick your color", getColorChooserInner().getColor());
				 
			}
		});
		
		JButton btnColEdge = new JButton("Edge color");
		btnColEdge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colEdge=JColorChooser.showDialog(null, "Pick your color", getColorChooserEdge().getColor());
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
								.addComponent(lblCoordinateY, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRadius))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
									.addComponent(txtCoordY, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
									.addComponent(btnColInnerr)))
							.addContainerGap())
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCenter, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblCoordinateX)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtCoordX, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(198, Short.MAX_VALUE))))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(389, Short.MAX_VALUE)
					.addComponent(btnColEdge)
					.addGap(48))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblCenter, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(lblCoordinateX, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtCoordX, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCoordinateY, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCoordY, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(43)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRadius)
								.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(106)
							.addComponent(btnColInnerr)
							.addGap(34)
							.addComponent(btnColEdge)))
					.addContainerGap(52, Short.MAX_VALUE))
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
					public void actionPerformed(ActionEvent e)
					{
						try
						{
						

						setOk(true);

						dispose();
						}
						catch(NumberFormatException ex)
						{
							JOptionPane.showMessageDialog(new JFrame(), "Incorrect data entry. Check that all fields are filled with numeric values!!", "Error", JOptionPane.WARNING_MESSAGE);
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(new JFrame(), "Value of diametar must be positive number!", "error", JOptionPane.WARNING_MESSAGE);
							//System.out.println("this" + ex.getMessage());

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
	public Color getColEdge() {
		return colEdge;
	}

	public void setColEdge(Color colEdge) {
		this.colEdge = colEdge;
	}

	public Color getColInner() {
		return colInner;
	}

	public void setColInner(Color colInner) {
		this.colInner = colInner;
	}

	public String getTxtCoordY() {
		return txtCoordY.getText();
	}

	public void setTxtCoordY(String txtCoordY) {
		this.txtCoordY.setText(txtCoordY);
	}

	public String getTxtCoordX() {
		return txtCoordX.getText();
	}

	public void setTxtCoordX(String txtCoordX) {
		this.txtCoordX.setText(txtCoordX);
	}
	
	public void setTxtCoordXEdt(boolean b)
	{
		this.txtCoordX.setEditable(b);
	}
	
	public void setTxtCoordYEdt(boolean b)
	{
		this.txtCoordY.setEditable(b);
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getTextRadius() {
		return txtRadius.getText();
	}

	public void setRadius(String textField) {
		this.txtRadius.setText(textField);
		}

	public void setColorChooserInner(JColorChooser chooser)
	{
		this.innerColorChooser=chooser;
	}
	public JColorChooser getColorChooserInner() {
		return innerColorChooser;
	}
	
	public void setColorChooserEdge(JColorChooser chooser)
	{
		this.edgeColorChooser=chooser;
	}
	public JColorChooser getColorChooserEdge() {
		return edgeColorChooser;
	}
}
