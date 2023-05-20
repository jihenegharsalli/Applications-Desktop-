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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.DaoAilleurImpl;
import dao.IDaoAilleur;
import entities.vol;
import entities.voyageur;



public class page_voyageurs extends JFrame implements ActionListener {
	JLabel l1=new JLabel("Gestion des voyageurs");
 	JLabel lid = new JLabel("Id à modifier:");
 	JTextField tid = new JTextField(10);
	JLabel lnom = new JLabel("Nom:");
	JLabel lprenom = new JLabel("Prenom:");
	JTextField tnom = new JTextField(10);
	JTextField tprenom = new JTextField(10);
	JLabel Nation=new JLabel("Nationalité");
	JComboBox<String> Natio = new JComboBox<>(new String[] { "Tunisien", "Americain", "Marrocain","Algérien","Européen" });
	//JTextField nation = new JTextField(10);
	JLabel lsexe=new JLabel("Sexe");
	JComboBox<String> sexe = new JComboBox<>(new String[] { "Male", "Femelle"});
	JLabel pass = new JLabel("Numero du Passport:");
	JTextField tpass = new JTextField(10);
	JLabel adr = new JLabel("Adresse:");
	JTextField tadr = new JTextField(10);
	JLabel tel = new JLabel("Telephone:");
	JTextField ttel = new JTextField(10);
	JButton bajouter = new JButton("Ajouter");
	JButton bmodifier = new JButton("Modifier");
	JButton bsupprimer = new JButton("Supprimer");
	JButton bretour = new JButton("Retour");
	JPanel p1=new JPanel();
	JPanel p5=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel pb=new JPanel();
	JPanel pa=new JPanel();
	JPanel pp=new JPanel(new BorderLayout());
    TableModelev tm=new TableModelev();
    JTable table=new JTable(tm);
    JScrollPane jsp=new JScrollPane(table);
    IDaoAilleur gestion=new DaoAilleurImpl();
	public page_voyageurs() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("L'AILLEUR");
		setSize(900,600);
		p5.add(lid);
		p5.add(tid);
		p5.add(lnom);
		p5.add(tnom);
		p5.add(lprenom);
		p5.add(tprenom);
		p5.add(lsexe);
		p5.add(sexe);
		p5.add(Nation);
		p5.add(Natio);
		p2.add(pass);
		p2.add(tpass);
		p2.add(adr);
		p2.add(tadr);
		p2.add(tel);
		p2.add(ttel);
		p3.add(bajouter);
		p3.add(bmodifier);
		p3.add(bsupprimer);
		p3.add(bretour);
		pa.add(p2);
		pa.add(p3);
		//p3.add(p2,BorderLayout.CENTER);
		//p3.add(p2,BorderLayout.CENTER);
		pp.add(p5,BorderLayout.NORTH);
		pp.add(pa,BorderLayout.CENTER);
		//pp.add(p,BorderLayout.SOUTH);
		l1.setFont(new Font("Arial", Font.PLAIN, 20));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		l1.setForeground(Color.BLUE);
		this.add(l1,BorderLayout.NORTH);
		this.add(pp,BorderLayout.CENTER);
		this.add(jsp,BorderLayout.SOUTH);
        tm.charger(gestion.getAllVoyageurs());
		bajouter.addActionListener(e->{
			String nom=tnom.getText();
			String prenom=tprenom.getText();
			String nationalite=(String)Natio.getSelectedItem();
			String sexee=(String)sexe.getSelectedItem();
			String nump=tpass.getText();
			String adresse=tadr.getText();
			String telephone=ttel.getText();
			if(nom.equals("")||prenom.equals("")||nump.equals("")||adresse.equals("")||telephone.equals(""))
				JOptionPane.showMessageDialog(this, "erreur de saisie");
			else
			{
				voyageur v=new voyageur(nom,prenom,sexee,nationalite,nump,adresse,telephone);
				
				gestion.addVoyageur(v);
				tm.charger(gestion.getAllVoyageurs());
			}
			
			
			
		});
		bmodifier.addActionListener(e->{
			int ida = Integer.parseInt(tid.getText());
			String nom=tnom.getText();
			String prenom=tprenom.getText();
			String nationalite=(String)Natio.getSelectedItem();
			String sexee=(String)sexe.getSelectedItem();
			String nump=tpass.getText();
			String adresse=tadr.getText();
			String telephone=ttel.getText();
			voyageur v=new voyageur(ida,nom,prenom,sexee,nationalite,nump,adresse,telephone);
    		gestion.modifierVoyageur(v);
    		tm.charger(gestion.getAllVoyageurs());
		});
		bsupprimer.addActionListener(e->{
			int ida = Integer.parseInt(tid.getText());
    		gestion.supprimerVoyageur(ida);
    		tm.charger(gestion.getAllVoyageurs());
			
			
		});
		
		bretour.addActionListener(e->{
			dispose(); 
			new page3();
		});
		
		
    	
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if (table.getSelectedRow() != -1 && !event.getValueIsAdjusting()) {
                    Object idd = table.getValueAt(table.getSelectedRow(), 0);
                    Object nomm = table.getValueAt(table.getSelectedRow(), 1);
                    Object prenomm = table.getValueAt(table.getSelectedRow(), 2);
                    Object nationalitee = table.getValueAt(table.getSelectedRow(), 3);
                    Object sexxee = table.getValueAt(table.getSelectedRow(), 4);
                    Object numpassportt = table.getValueAt(table.getSelectedRow(), 5);
                    Object adressee = table.getValueAt(table.getSelectedRow(), 6);
                    Object telephonee = table.getValueAt(table.getSelectedRow(), 7);
                    tid.setText(idd.toString());
                    tnom.setText(nomm.toString());
                    tprenom.setText(prenomm.toString());
                    Natio.setSelectedItem(nationalitee.toString());
                    sexe.setSelectedItem(nationalitee.toString());
                    tpass.setText(numpassportt.toString());
                    tadr.setText(adressee.toString());
                    ttel.setText(telephonee.toString());
                }
            }
        });
        
		
	}
	

	public static void main(String[] args) {
		new page_voyageurs();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
