package presentation;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.voyageur;

public class TableModelev extends AbstractTableModel{
	
	private List<voyageur>liste=new ArrayList<>();
	private String titres[]= {"id","nom","prenom","nationalité","sexe","Num_pass","Adresse","Telephone"};

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
		case 0:return liste.get(l).getIdv();
		case 1:return liste.get(l).getNom();
		case 2:return liste.get(l).getPrenom();
		case 3:return liste.get(l).getNationalite();
		case 4:return liste.get(l).getSexe();
		case 5:return liste.get(l).getNumPassport();
		case 6:return liste.get(l).getAdresse();
		case 7:return liste.get(l).getTel();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titres[column];
	}
	public void charger(List<voyageur>l)
	{
		this.liste=l;
		fireTableDataChanged();
	}

}
