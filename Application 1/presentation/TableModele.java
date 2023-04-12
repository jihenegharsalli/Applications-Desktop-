package presentation;
import java.util.ArrayList;  
import java.util.List;

import javax.swing.table.AbstractTableModel;
import metier.Categorie;
import metier.Produit;
import dao.DaoCatalogueImpl;


public class TableModele extends AbstractTableModel{
	
	private List<Produit>liste=new ArrayList<>();

	private String titres[]= {"id","nom","prix","quantite","categorie"};

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return liste.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titres.length;
	}

	@Override
	public Object getValueAt(int l, int c) {
		switch(c)
		{
		case 0:return liste.get(l).getReference();
		case 1:return liste.get(l).getNomp();
		case 2:return liste.get(l).getPrix();
		case 3:return liste.get(l).getQuantite();
		case 4:return liste.get(l).getCategorie().getNomc();

		}
		return null;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titres[column];
	}
	public void charger(List<Produit>l)
	{
		this.liste=l;
		fireTableDataChanged();
	}

}


