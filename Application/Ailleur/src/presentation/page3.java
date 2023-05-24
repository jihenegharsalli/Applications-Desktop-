package presentation;
import java.awt.Color;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
public class page3 extends JFrame implements ActionListener{
	JLabel l1=new JLabel("L'Ailleur   ");
	JButton b1=new JButton("Vols");
	JButton b2=new JButton("Voyageurs");
	JButton b3=new JButton("Billets");
	//JButton b4=new JButton("Annulation");
	JPanel p=new JPanel(new GridLayout(1,4,9,9));
	ImageIcon icon = new ImageIcon("airline.png");
	Image image = icon.getImage(); 
	int newWidth = 200; 
	int newHeight = 200; 
	Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH); // redimensionner l'image avec l'interpolation douce
	ImageIcon newIcon = new ImageIcon(newImage);
	
	public page3(){
		l1.setFont(new Font("Arial", Font.PLAIN, 40));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setForeground(Color.BLUE);
		this.add(l1,BorderLayout.EAST);
		JLabel imageLabel = new JLabel(newIcon);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		//p.add(b4);
		this.add(imageLabel,BorderLayout.WEST);
		this.add(p,BorderLayout.SOUTH);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		//setLocationRelativeTo(null);
		setLocation(570, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("L'AILLEUR");
		setSize(400,300);
		//pack();
		
	}
	public static void main(String[] args) {
		new page3();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buutton=(JButton)e.getSource();
    	if(buutton==b1) {
    		dispose();
            new page_vols();
    	}
    	else if(buutton==b2) {
    		dispose();
            new page_voyageurs();
    	}
    	else {
        		dispose();
                new page_billets();
        	}
    	
		
	}

}
