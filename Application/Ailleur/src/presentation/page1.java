package presentation;

import javax.swing.JFrame; 

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
public class page1 extends JFrame implements ActionListener{
	ImageIcon icon = new ImageIcon("airline.png");
	Image image = icon.getImage(); 
	int newWidth = 200; 
	int newHeight = 200; 
	
	Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH); // redimensionner l'image avec l'interpolation douce
	ImageIcon newIcon = new ImageIcon(newImage);
	JButton start= new JButton("Start");
	public page1() {
		JLabel l1=new JLabel("L'ailleur");
		JLabel ll=new JLabel();
		//JLabel l=new JLabel();
		//l.add(start);
		this.add(l1,BorderLayout.NORTH);
		JLabel imageLabel = new JLabel(newIcon);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(imageLabel, BorderLayout.CENTER);
		this.add(start,BorderLayout.SOUTH);
		l1.setFont(new Font("Arial", Font.PLAIN, 30));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setForeground(Color.BLUE);
		start.addActionListener(this);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(500,300);
		setTitle("L'AILLEUR");
	}
	
	public static void main(String[] args) {
		new page1();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose(); 
        new page2();
		
	}
}
