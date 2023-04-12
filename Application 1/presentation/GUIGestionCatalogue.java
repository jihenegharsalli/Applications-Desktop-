package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.DaoCatalogueImpl;
import dao.IDaoCatalogue;
import metier.Categorie;

//import entities.Etudiant;
public class GUIGestionCatalogue extends JFrame implements ActionListener {
	JLabel cat = new JLabel("Selectionner une categorie:");
	IDaoCatalogue gestion = new DaoCatalogueImpl();
	JComboBox<Categorie> bcat = new JComboBox<>(gestion.getAllCategories());
	JPanel p1 = new JPanel();
	JPanel p3 = new JPanel();
	TableModele tm = new TableModele();
	JTable table = new JTable(tm);
	JScrollPane jsp = new JScrollPane(table);
	JButton quitter = new JButton("Rechercher");
	public GUIGestionCatalogue() {
		bcat.addItem(new Categorie());
		setTitle("Rechercher produits");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		p1.add(cat);
		p1.add(bcat);
		p3.add(quitter);
		this.add(p1, BorderLayout.NORTH);
		this.add(jsp, BorderLayout.CENTER);
		this.add(p3, BorderLayout.SOUTH);
		tm.charger(gestion.getAllProduits());
		quitter.addActionListener(this);
		pack();
	}

	public static void main(String[] args) {
		new GUIGestionCatalogue();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//String selectedString = bcat.getSelectedItem().toString();
		Categorie cat=(Categorie)bcat.getSelectedItem();
		System.out.println(cat);
		if(cat.getNomc()==null) 
			tm.charger(gestion.getAllProduits());
			
		
		else
			tm.charger(gestion.getProduitsByCategorie(cat.getCode()));
	

	
}
}