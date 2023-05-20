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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import presentation.page3;

public class page2 extends JFrame implements ActionListener{
	
	JPanel p1=new JPanel(new BorderLayout());
	JPanel p2=new JPanel(new GridLayout(1,1));
	JPanel p3=new JPanel(new GridLayout(2,2));
	JPanel p31=new JPanel();
	JPanel p32=new JPanel();
	JPanel p4=new JPanel();
	//JPanel pE=new JPanel(new GridLayout(3,1));
	JLabel t1=new JLabel("L'Ailleur");
	
	ImageIcon icon = new ImageIcon("airline.png");
	Image image = icon.getImage(); 
	int newWidth = 200; 
	int newHeight = 200; 
	Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH); // redimensionner l'image avec l'interpolation douce
	ImageIcon newIcon = new ImageIcon(newImage);
	JLabel tu=new JLabel("User Name");
	JTextField tfu=new JTextField(10);
	JLabel tp=new JLabel("Password");
	JPasswordField tfp=new JPasswordField(10);
	JButton login=new JButton("login");
	public page2() {
		t1.setFont(new Font("Arial", Font.PLAIN, 30));
		JLabel imageLabel = new JLabel(newIcon);
		t1.setForeground(Color.BLUE);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//this.add(imageLabel, BorderLayout.CENTER);
		p2.add(imageLabel);
		p2.add(t1);
		p31.add(tu);
		p31.add(tfu);
		p32.add(tp);
		p32.add(tfp);
		p3.add(p31);
		p3.add(p32);
		p1.add(p2,BorderLayout.NORTH);
		p1.add(p3,BorderLayout.CENTER);
		p4.add(login);

		p1.add(p4,BorderLayout.SOUTH);
	
        this.add(p1,BorderLayout.CENTER);
        //this.add(pE,BorderLayout.WEST);
       // this.add(p3,BorderLayout.CENTER);
        setTitle("L'AILLEUR");
        login.addActionListener(this);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(500,400);
		//pack();
	}
	public static void main(String[] args) {
		new page2();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String user=tfu.getText();
		String password=tfp.getText();
		if (user.equals("")||password.equals("")) {
			JOptionPane.showMessageDialog(this, "Veuillez remplir les chapms");
		}
		else if(user.equals("admin")&&password.equals("admin")) {
			
			dispose(); // Fermer la page de connexion
	        new page3(); // Ouvrir la page3
			/*Page3 page3 = new Page3();
	        page3.setVisible(true);
	        setVisible(false);*/
		}
		else {
			JOptionPane.showMessageDialog(this, "user name ou password est incorrecte");
		
	}

}}
