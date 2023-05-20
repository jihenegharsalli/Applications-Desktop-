package presentation;
import java.awt.BorderLayout;    
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.DaoAilleurImpl;
import dao.IDaoAilleur;
import entities.billet;
import entities.voyageur;
import entities.vol;





public class page_billets extends JFrame implements ActionListener{
	JLabel l1=new JLabel("Gestion des billets");
 	
    IDaoAilleur gestion=new DaoAilleurImpl();
	JLabel lid = new JLabel("Id Voyageurs:");
	JComboBox<voyageur> tid = new JComboBox<>(gestion.getAllVoyageurs());
	JLabel lprix=new JLabel("Prix");
	JTextField tprix = new JTextField(10);
	JLabel lvol = new JLabel("Code Vols:");
	JComboBox<vol> tvol = new JComboBox<>(gestion.getAllVols());
	JLabel lb = new JLabel("Id Billet à supprimer:");
	JTextField tb = new JTextField(10);
	JButton breserver = new JButton("Reserver");
	JButton bsupprimer = new JButton("Supprimer");
	JButton bretour = new JButton("Retour");
	JButton brecherchervol = new JButton("Rechercher vols");
	JButton brecherchervoy = new JButton("Rechercher voyageurs");
	JPanel p1=new JPanel();
	JPanel p5=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel pb=new JPanel();
	JPanel pa=new JPanel();
	JPanel pp=new JPanel(new BorderLayout());
    TableModeleb tm=new TableModeleb();
    JTable table=new JTable(tm);
    JScrollPane jsp=new JScrollPane(table);

	public page_billets() {
		//tid.addItem(new voyageur());
		//tvol.addItem(new vol());
		voyageur v = (voyageur)tid.getSelectedItem();
		//int idv = v.getIdv();
		vol vol = (vol)tvol.getSelectedItem();
		//int idvol = vol.getCodevol();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("L'AILLEUR");
		setSize(1000,600);
		p5.add(lid);
		p5.add(tid);
		p5.add(lvol);
		p5.add(tvol);
		p5.add(lprix);
		p5.add(tprix);
		p5.add(lb);
		p5.add(tb);
		p3.add(breserver);
		p3.add(bsupprimer);
        p3.add(brecherchervol);
        p3.add(brecherchervoy);
		p3.add(bretour);
		pa.add(p2);
		pa.add(p3);
		//p3.add(p2,BorderLayout.CENTER);
		//p3.add(p2,BorderLayout.CENTER);
		pp.add(p5,BorderLayout.NORTH);
		pp.add(pa,BorderLayout.CENTER);
		
		
		this.add(jsp, BorderLayout.SOUTH);
        //tm.charger(gestion.getAllProduits());
		
		
		//pp.add(p,BorderLayout.SOUTH);
		l1.setFont(new Font("Arial", Font.PLAIN, 20));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setForeground(Color.BLUE);
		this.add(l1,BorderLayout.NORTH);
		this.add(pp,BorderLayout.CENTER);
		this.add(jsp,BorderLayout.SOUTH);
        tm.charger(gestion.getAllBillets());
        breserver.addActionListener(this);
        bsupprimer.addActionListener(this);
        bretour.addActionListener(this);
        brecherchervol.addActionListener(this);
        brecherchervoy.addActionListener(this);
        

      // this.getContentPane().setBackground(Color.DARK_GRAY);
       //pa.setBackground(Color.DARK_GRAY);
       //pp.setBackground(Color.DARK_GRAY);
	}

	public static void main(String[] args) {
		new page_billets();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buutton=(JButton)e.getSource();
    	if(buutton==breserver) {
    		voyageur lid=(voyageur)tid.getSelectedItem();
    		vol lvol=(vol)tvol.getSelectedItem();
    		Double prix = Double.parseDouble(tprix.getText());
    		String selectedString = tid.getSelectedItem().toString();
    		String selectedStringv = tvol.getSelectedItem().toString();
    		
  
    		if (prix==0) {
    			JOptionPane.showMessageDialog(this, "Veillez saisir prix");
    		} 	
    		else {
    				
    			billet b=new billet(prix,lid,lvol);
    			
    			gestion.addBillet(b);
    			tm.charger(gestion.getAllBillets());
    		}
    	}
    	else if(buutton==bsupprimer) {
    		int ida = Integer.parseInt(tb.getText());
    		gestion.supprimerBillets(ida);
    		tm.charger(gestion.getAllBillets());
    	}
    	else if(buutton==brecherchervol) {
    		voyageur lid=(voyageur)tid.getSelectedItem();
    		int idd=lid.getIdv();
    		tm.charger(gestion.getvolBID(idd));
    	}
    	else if(buutton==brecherchervoy) {
    		vol li=(vol)tvol.getSelectedItem();
    		int idd=li.getCodevol();
    		tm.charger(gestion.getvoyBID(idd));
    	}
    	else {
    		dispose(); 
	        new page3();
    	}
		
	
}
	}


