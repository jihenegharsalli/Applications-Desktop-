package presentation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import com.toedter.calendar.*;
import javax.swing.JComboBox;
public class page_annulation extends JFrame {//implements ActionListener {
    JLabel l1 = new JLabel("Billets annulées");
    JLabel lid = new JLabel("Id Billet:");
    JComboBox<String> tid = new JComboBox<>(new String[] { "9", "8","tansech"," bech"," tbadalha"," vector"});
    JLabel code = new JLabel("Code vol");
    JTextField code_Vol = new JTextField(10);
    //JLabel date_vol = new JLabel("Date vol");
    //JButton date_picker = new JButton("Choisir date");
    //JLabel date_label = new JLabel();
    JButton bannuler = new JButton("Annuler");
	JButton breset = new JButton("Renitialiser");
	JButton bsretour = new JButton("Retour");
    JPanel p1 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel pb = new JPanel();
    JPanel pa = new JPanel();
    JPanel pp = new JPanel(new BorderLayout());
    //JDateChooser d=new JDateChooser();
    //TableModelevol tm=new TableModelevol();
    //JTable table=new JTable(tm);
    //JScrollPane jsp=new JScrollPane(table);
    public page_annulation() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(800, 500);
        //d.setBounds(320,90,200,30);
        p5.add(lid);
        p5.add(tid);
        p5.add(code);
        p5.add(code_Vol);
        //p5.add(date_vol);
        //p5.add(date_label);
        //p5.add(d);
        p3.add(bannuler);
        p3.add(breset);
        p3.add(bsretour);
        pa.add(p2);
        pa.add(p3);
        pp.add(p5, BorderLayout.NORTH);
        pp.add(pa, BorderLayout.CENTER);
        l1.setFont(new Font("Arial", Font.PLAIN, 20));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setForeground(Color.BLUE);
        this.add(l1, BorderLayout.NORTH);
        this.add(pp, BorderLayout.CENTER);

        
        
        
        //this.add(jsp, BorderLayout.CENTER);
        //tm.charger(gestion.getAllProduits());
        
        
       
    }
    public static void main(String[] args) {
		new page_annulation();

	}

  }
