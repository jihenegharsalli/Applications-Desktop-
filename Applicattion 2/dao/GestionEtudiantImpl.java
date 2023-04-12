package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import dao.entities.Etudiant;

public class GestionEtudiantImpl implements IGestionEtudiant{
	
	private Connection cx=SingletonConnection.getInstance();

	@Override
	public void addEtudiant(Etudiant e) {
		try {
			PreparedStatement ps=cx.prepareStatement("insert into etudiant(nom,prenom,filiere,sexe) values(?,?,?,?)");
	        ps.setString(1, e.getNom());
	        ps.setString(2, e.getPrenom());
	        ps.setString(3, e.getFiliere());
	        ps.setString(4, e.getSexe());
	        ps.executeUpdate();
	        
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		List<Etudiant>liste=new ArrayList<>();
		try {
			PreparedStatement ps=cx.prepareStatement("select * from etudiant");
	        
	        ResultSet rs=ps.executeQuery();
	        while(rs.next())
	        {
	        	Etudiant e=new Etudiant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
	            liste.add(e);
	        }
	        
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<Etudiant> getEtudiantsBMC(String mc) {
		List<Etudiant>liste=new ArrayList<>();
		try {
			PreparedStatement ps=cx.prepareStatement("select * from etudiant where nom like ?");
			ps.setString(1, "%"+mc+"%");
	        
	        ResultSet rs=ps.executeQuery();
	        while(rs.next())
	        {
	        	Etudiant e=new Etudiant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
	            liste.add(e);
	        }
	        
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return liste;
	}

	@Override
	public void deleteEtudiant(int id) {
		// TODO Auto-generated method stub
		
	}

}
