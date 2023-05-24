package presentation;
import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import com.toedter.calendar.*;
import javax.swing.JComboBox;
import dao.DaoAilleurImpl;
import dao.IDaoAilleur;
import entities.voyageur;
import entities.vol;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class page_vols extends JFrame implements ActionListener {
    JLabel l1 = new JLabel("Gestion des vols");
    JLabel code = new JLabel("Code vol à supprimer");
    JTextField code_Vol = new JTextField(10);
    JLabel source = new JLabel("Source :");
    JTextField tsource = new JTextField(10);
    JLabel destination = new JLabel("Destination :");
    JTextField tdestination = new JTextField(10);
    JLabel dal = new JLabel("Date vol");
    JTextField tdate=new JTextField(10);
    JLabel nbr = new JLabel("nombre des chaises");
    JTextField tnbr = new JTextField(10);
    JButton bajouter = new JButton("Ajouter");
    JButton bmodifier = new JButton("Modifier");
	JButton bsupprimer = new JButton("Supprimer");
	JButton bsretour = new JButton("Retour");
    JPanel p1 = new JPanel();
    JPanel p5 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel pb = new JPanel();
    JPanel pa = new JPanel();
    JPanel pp = new JPanel(new BorderLayout());
    JDateChooser d=new JDateChooser();
    TableModelevol tm=new TableModelevol();
    JTable table=new JTable(tm);
    JScrollPane jsp=new JScrollPane(table);
    IDaoAilleur gestion=new DaoAilleurImpl();
    public page_vols() {
        //setLocationRelativeTo(null);
        setLocation(300, 150);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setSize(1000, 600);
        d.setBounds(320,90,200,30);
        
        p5.add(code);
        p5.add(code_Vol);
        p5.add(source);
        p5.add(tsource);
        p5.add(destination);
        p5.add(tdestination);
        
       // p5.add(date_label);
        p5.add(nbr);
        p5.add(tnbr);
        //p5.add(d);
        p5.add(dal);
        p5.add(tdate);
        p3.add(bajouter);
        p3.add(bmodifier);
        p3.add(bsupprimer);
        p3.add(bsretour);
        pa.add(p2);
        pa.add(p3);
        pp.add(p5, BorderLayout.NORTH);
        pp.add(pa, BorderLayout.CENTER);
        
        setTitle("L'AILLEUR");
        this.add(jsp, BorderLayout.SOUTH);
        tm.charger(gestion.getAllVols());
        
        l1.setFont(new Font("Arial", Font.PLAIN, 20));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setForeground(Color.BLUE);
        this.add(l1, BorderLayout.NORTH);
        this.add(pp, BorderLayout.CENTER);
        bajouter.addActionListener(this);
        bsupprimer.addActionListener(this);
        bmodifier.addActionListener(this);
        bsretour.addActionListener(this);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if (table.getSelectedRow() != -1 && !event.getValueIsAdjusting()) {
                    Object codevoll = table.getValueAt(table.getSelectedRow(), 0);
                    Object sourcee = table.getValueAt(table.getSelectedRow(), 1);
                    Object destinationn = table.getValueAt(table.getSelectedRow(), 2);
                    Object datevoll = table.getValueAt(table.getSelectedRow(), 3);
                    Object nbrechaisess = table.getValueAt(table.getSelectedRow(), 4);
                    code_Vol.setText(codevoll.toString());
                    tsource.setText(sourcee.toString());
                    tdestination.setText(destinationn.toString());
                    tdate.setText(datevoll.toString());
                    tnbr.setText(nbrechaisess.toString());
                }
            }
        });
        
    }
    public static void main(String[] args) {
		new page_vols();

	}

    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	JButton buutton=(JButton)e.getSource();
    	if(buutton == bajouter) {
    	    String source = tsource.getText();
    	    String dest = tdestination.getText();
    	    String dateString = tdate.getText();
    	    int nbr = 0;
    	    try {
    	        nbr = Integer.parseInt(tnbr.getText());
    	    } catch (NumberFormatException ee) {
    	       
    	        JOptionPane.showMessageDialog(this, "erreur de saisie");
    	        return;
    	    }
    	    if (source.equals("") || dest.equals("")  ||dateString.equals("") || nbr == 0) {
    	        
    	        JOptionPane.showMessageDialog(this, "erreur de saisie");
    	    } else {
    	       
    	        vol v = new vol(source, dest, dateString, nbr);
    	        gestion.addVol(v);
    	        tm.charger(gestion.getAllVols());
    	    }
    	}
    	else if(buutton==bsupprimer) {
    		int ida = Integer.parseInt(code_Vol.getText());
    		gestion.supprimerVol(ida);
    		tm.charger(gestion.getAllVols());
    	}
    	else if(buutton==bmodifier) {
    		int ida = Integer.parseInt(code_Vol.getText());
    		vol v=new vol(ida,tsource.getText(),tdestination.getText(),tdate.getText(),Integer.parseInt(tnbr.getText()));
    		
    		gestion.modifierVol(v);
    		tm.charger(gestion.getAllVols());
    	}
    	
    	else {
    		dispose(); 
	        new page3();
    	}

}}


