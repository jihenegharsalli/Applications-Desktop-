package presentation;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

import dao.GestionEtudiantImpl;
import dao.IGestionEtudiant;
import dao.entities.Etudiant;



public class GUIGestionEtudiants extends JFrame {

	JLabel lnom = new JLabel("Nom:");
	JLabel lprenom = new JLabel("Prenom:");
	JLabel lfiliere = new JLabel("Filiere:");
	JLabel lsexe = new JLabel("Sexe:");
	JLabel lrecherche = new JLabel("Recherche:");
	JTextField tnom = new JTextField(10);
	JTextField tprenom = new JTextField(10);
	JTextField tRecherche = new JTextField(10);
	JButton bajouter = new JButton("Ajouter");
	JButton bannuler = new JButton("Annuler");
	JButton bsupprimer = new JButton("Supprimer");
	JButton bRechercher = new JButton("Rechercher");
	JComboBox<String> filiere = new JComboBox<>(new String[] { "Informatique", "electronique", "Mecanique" });
	JRadioButton bm = new JRadioButton("M");
	JRadioButton bf = new JRadioButton("F");
	JPanel pnom = new JPanel();
	JPanel pprenom = new JPanel();
	JPanel pfiliere = new JPanel();
	JPanel psexe = new JPanel();
	JPanel p1 = new JPanel(new BorderLayout());
	JPanel p11 = new JPanel(new GridLayout(2, 2));
	JPanel p12 = new JPanel();
	JPanel p2 = new JPanel(new BorderLayout());
	JPanel p21 = new JPanel();
	JPanel p22 = new JPanel(new GridLayout(1, 1));
    TableModele tm=new TableModele();
    JTable table=new JTable(tm);
    JScrollPane jsp=new JScrollPane(table);
    
    IGestionEtudiant gestion=new GestionEtudiantImpl();
	public GUIGestionEtudiants() {
		super("Gestion Etudiants");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	
		// setSize(500,300);
		pnom.add(lnom);
		pnom.add(tnom);

		pprenom.add(lprenom);
		pprenom.add(tprenom);

		pfiliere.add(lfiliere);
		pfiliere.add(filiere);

		psexe.add(lsexe);
		psexe.add(bf);
		psexe.add(bm);

		ButtonGroup bg = new ButtonGroup();
		bg.add(bf);
		bg.add(bm);

		p11.add(pnom);
		p11.add(pprenom);
		p11.add(pfiliere);
		p11.add(psexe);

		p12.add(bajouter);
		p12.add(bannuler);
		p12.add(bsupprimer);

		p1.add(p11, BorderLayout.CENTER);
		p1.add(p12, BorderLayout.SOUTH);

		this.add(p1, BorderLayout.NORTH);

		p21.add(lrecherche);
		p21.add(tRecherche);
		p21.add(bRechercher);
		p2.add(p21, BorderLayout.NORTH);

		p22.add(jsp);
		p2.add(p22, BorderLayout.CENTER);
		this.add(p2, BorderLayout.CENTER);

		tm.charger(gestion.getAllEtudiants());
		bajouter.addActionListener(e->{
			
			String nom=tnom.getText();
			String prenom=tprenom.getText();
			String fil=(String)filiere.getSelectedItem();
			String sexe="";
			if(bf.isSelected())
				sexe="F";
			else
				sexe="M";
			if(nom.equals("")||prenom.equals("")||sexe.equals(""))
				JOptionPane.showMessageDialog(this, "erreur de saisie");
			else
			{
				
				Etudiant et=new Etudiant(nom, prenom, fil, sexe);
				gestion.addEtudiant(et);
				tm.charger(gestion.getAllEtudiants());
			}
			
			
			
		});
		
		bRechercher.addActionListener(e->{
			
			tm.charger(gestion.getEtudiantsBMC(tRecherche.getText()));
		});
		
		pack();

	}

	public static void main(String[] args) {
		new GUIGestionEtudiants();
	}
	
	

		
		
	

}
