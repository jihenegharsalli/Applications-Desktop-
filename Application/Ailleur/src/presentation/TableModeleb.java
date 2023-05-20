package presentation;
import java.util.ArrayList; 
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.billet;

public class TableModeleb extends AbstractTableModel{
	
	private List<billet>liste=new ArrayList<>();
	private String titres[]= {"id_billet","nom","prenom","nationalite","Num_pass","Prix","code_vol","sexe","source","destination","date_vol"};

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
		case 0:return liste.get(l).getIdb();
		case 1:return liste.get(l).getVoy().getNom();
		case 2:return liste.get(l).getVoy().getPrenom();
		case 3:return liste.get(l).getVoy().getSexe();
		case 4:return liste.get(l).getVoy().getNumPassport();
		case 5:return liste.get(l).getPrix();
		case 6:return liste.get(l).getVob().getCodevol();
		case 7:return liste.get(l).getVoy().getNationalite();
		case 8:return liste.get(l).getVob().getSource();
		case 9:return liste.get(l).getVob().getDestination();
		case 10:return liste.get(l).getVob().getDatevol();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titres[column];
	}
	public void charger(List<billet>l)
	{
		this.liste=l;
		fireTableDataChanged();
	}

}
