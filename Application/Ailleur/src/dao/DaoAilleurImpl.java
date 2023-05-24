package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import entities.billet;
import entities.vol;
import entities.voyageur;
import java.sql.Date;


public class DaoAilleurImpl implements IDaoAilleur {
 
    private Connection cx=SingletonConnection.getInstance();
   
    @Override
	public Vector<vol> getAllVols() {
		String query = "SELECT * FROM vol";
        Vector<vol> vols = new Vector<>();
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int codevol = rs.getInt("codevol");
                String source = rs.getString("source");
                String destination = rs.getString("destination");
                String datevol = rs.getString("datevol");
                int nbrchaises = rs.getInt("nbrchaises");
                vol vol=new vol(codevol,source,destination,datevol,nbrchaises);
                vols.add(vol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vols;
	}
    @Override
    public Vector<voyageur> getAllVoyageurs() {
        String query = "SELECT * FROM voyageur";
        Vector<voyageur> voyageurs = new Vector<>();
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idv = rs.getInt("idv");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String nationalite = rs.getString("nationalite");
                String sexe = rs.getString("sexe");
                String numpassport = rs.getString("numpassport");
                String adresse = rs.getString("adresse");
                String num_telephone = rs.getString("num_tel");
                voyageur v =new voyageur(idv,nom,prenom,nationalite,sexe,numpassport,adresse,num_telephone);//,b,vol);
                voyageurs.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voyageurs;
    }
	@Override
	public Vector<billet> getAllBillets() {
		 String query = "SELECT * FROM billet";
	        Vector<billet> billets = new Vector<>();
	        try {
	            PreparedStatement ps = cx.prepareStatement(query);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                int idb = rs.getInt("idb");
	              
	                double prix = rs.getDouble("prix");
	                int voyageur_id=rs.getInt("voyageur_id");
	                int vol_id=rs.getInt("vol_id");
	                voyageur v=getVoyageurByCode(voyageur_id);
	                vol vo=getVolByCode(vol_id);
	                billet b=new billet(idb,prix,v,vo);
	                billets.add(b);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return billets;
	}
	
    private vol getVolByCode(int codeVol) {
        String query = "SELECT * FROM vol WHERE codevol = ?";
        vol vol = null;
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, codeVol);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int codevol = rs.getInt("codevol");
                String source = rs.getString("source");
                String destination = rs.getString("destination");
                String datevol=rs.getString("datevol");
                int nbrchaises=rs.getInt("nbrchaises");
                vol=new vol(codevol,source,destination,datevol,nbrchaises);
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vol;
    }
    
    private billet getBilletByCode(int codeBillet) {
        String query = "SELECT * FROM billet WHERE idb = ?";
        billet b = null;
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, codeBillet);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	int idb=rs.getInt("idb");
            	
            	float prix=rs.getFloat("prix");
            	int voyageur_id=rs.getInt("voyageur_id");
            	int vol_id=rs.getInt("vol_id");
            	voyageur v = getVoyageurByCode(voyageur_id);
            	vol vol=getVolByCode(vol_id);
                b = new billet(idb,prix,v,vol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }
    
    private voyageur getVoyageurByCode(int codeVoyageur) {
        String query = "SELECT * FROM voyageur WHERE idv = ?";
        voyageur v = null;
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, codeVoyageur);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idv = rs.getInt("idv");
                String nom = rs.getString("nom");
                String prenom=rs.getString("prenom");
                String nationalite=rs.getString("nationalite");
                String sexe=rs.getString("sexe");
                String numpassport=rs.getString("numpassport");
                String adresse=rs.getString("adresse");
                String num_telephone=rs.getString("num_tel");
               // int billet_id=rs.getInt("billet_id");
               // int vol_id=rs.getInt("vol_id");
              //  billet b = getBilletByCode(billet_id);
               // vol vo=getVolByCode(vol_id);
                v = new voyageur(idv,nom,prenom,nationalite,sexe,numpassport,adresse,num_telephone);//,b,vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }



	@Override
	public void addVoyageur(voyageur v) {
		 String query = "INSERT INTO voyageur (idv, nom, prenom, nationalite, sexe,numpassport,adresse,num_tel) VALUES (?, ?, ?, ?, ?,?,?,?)";
	        try {
	            PreparedStatement ps = cx.prepareStatement(query);
	            ps.setInt(1, v.getIdv());
	            ps.setString(2, v.getNom());
	            ps.setString(3, v.getPrenom());
	            ps.setString(4, v.getNationalite());
	            ps.setString(5, v.getSexe());
	            ps.setString(6, v.getNumPassport());
	            ps.setString(7, v.getAdresse());
	            ps.setString(8, v.getTel());
	            //ps.setInt(9, v.getBillet().getIdb());
	            //ps.setInt(10, v.getVov().getCodevol());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void addVol(vol vo) {
		String query = "INSERT INTO vol (codevol, source, destination, datevol, nbrchaises) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, vo.getCodevol());
            ps.setString(2, vo.getSource());
            ps.setString(3, vo.getDestination());
            ps.setString(4, vo.getDatevol());
            ps.setInt(5, vo.getNbrchaises());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void addBillet(billet b) {
		String query = "INSERT INTO billet (idb,prix, voyageur_id, vol_id) VALUES (?,?, ?, ?)";
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, b.getIdb());
            ps.setDouble(2, b.getPrix());
            ps.setInt(3, b.getVoy().getIdv());
            ps.setInt(4, b.getVob().getCodevol());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	@Override
	public void supprimerVoyageur(int idv) {
		String query = "delete from voyageur where idv=? ";
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, idv);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	public void supprimerVol(int codevol) {
		/*String query = "delete from vol where codevol=? ";
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, codevol);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
		    try {
		 
		        String deleteBilletsQuery = "DELETE FROM billet WHERE vol_id=?";
		        PreparedStatement deleteBilletsStatement = cx.prepareStatement(deleteBilletsQuery);
		        deleteBilletsStatement.setInt(1, codevol);
		        deleteBilletsStatement.executeUpdate();

		        String deleteVolQuery = "DELETE FROM vol WHERE codevol=?";
		        PreparedStatement deleteVolStatement = cx.prepareStatement(deleteVolQuery);
		        deleteVolStatement.setInt(1, codevol);
		        deleteVolStatement.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		

	}
	@Override
	public void modifierVoyageur(voyageur v) {
		String query = "update voyageur set nom=?,prenom=?,nationalite=?,sexe=?,numpassport=?,adresse=?,num_tel=? where idv=? ";
        try {
            PreparedStatement ps = cx.prepareStatement(query);
          
            ps.setString(1,v.getNom());
            ps.setString(2,v.getPrenom());
            ps.setString(3,v.getNationalite());
            ps.setString(4,v.getSexe());
            ps.setString(5,v.getNumPassport());
            ps.setString(6,v.getAdresse());
            ps.setString(7,v.getTel());
            ps.setInt(8,v.getIdv());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	
		
	}
	@Override
	public void modifierVol(vol v) {
		String query = "update vol set source=?,destination=?,datevol=?,nbrchaises=? where codevol=? ";
        try {
            PreparedStatement ps = cx.prepareStatement(query);
           
            ps.setString(1,v.getSource());
            ps.setString(2,v.getDestination());
            ps.setString(3,v.getDatevol());
            ps.setInt(4,v.getNbrchaises());
            ps.setInt(5,v.getCodevol());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	@Override
	public void supprimerBillets(int idb) {
		String query = "delete from billet where idb=? ";
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, idb);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	@Override
	public void modifierBillets(billet b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Vector<billet> getvolBID(int idv) {
		
			Vector<billet>liste=new Vector<>();
			try {
				PreparedStatement ps=cx.prepareStatement("select * from billet where voyageur_id= ?");
				ps.setInt(1,idv);
		        
		        ResultSet rs=ps.executeQuery();
		        while(rs.next())
		        {
		        	
		        	int idb = rs.getInt("idb");
		            
		             double prix = rs.getDouble("prix");
		             int voyageur_id=rs.getInt("voyageur_id");
		             int vol_id=rs.getInt("vol_id");
		             voyageur v=getVoyageurByCode(voyageur_id);
		             vol vo=getVolByCode(vol_id);
		             billet b=new billet(idb,prix,v,vo);
		            liste.add(b);
		        }
		        
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return liste;
		}
	@Override
	public List<billet> getvoyBID(int codevol) {
		Vector<billet>liste=new Vector<>();
		try {
			PreparedStatement ps=cx.prepareStatement("select * from billet where vol_id= ?");
			ps.setInt(1,codevol);
	        
	        ResultSet rs=ps.executeQuery();
	        while(rs.next())
	        {
	        	
	        	int idb = rs.getInt("idb");
	            
	             double prix = rs.getDouble("prix");
	             int voyageur_id=rs.getInt("voyageur_id");
	             int vol_id=rs.getInt("vol_id");
	             voyageur v=getVoyageurByCode(voyageur_id);
	             vol vo=getVolByCode(vol_id);
	             billet b=new billet(idb,prix,v,vo);
	            liste.add(b);
	        }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return liste;
	}
}


