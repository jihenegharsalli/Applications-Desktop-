package presentation;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.vol;

public class TableModelea extends AbstractTableModel{
	
	private List<vol>liste=new ArrayList<>();
	private String titres[]= {"Code vol","source","destination","date_vol","nombre_chaises"};

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
		case 0:return liste.get(l).getCodevol();
		case 1:return liste.get(l).getSource();
		case 2:return liste.get(l).getDestination();
		case 3:return liste.get(l).getDatevol();
		case 4:return liste.get(l).getNbrchaises();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titres[column];
	}
	public void charger(List<vol>l)
	{
		this.liste=l;
		fireTableDataChanged();
	}

}
