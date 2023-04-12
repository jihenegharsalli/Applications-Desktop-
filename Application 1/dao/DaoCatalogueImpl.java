package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import metier.Categorie;
import metier.Produit;

public class DaoCatalogueImpl implements IDaoCatalogue {
 
    private Connection cx=SingletonConnection.getInstance();
   
    @Override
    public Vector<Categorie> getAllCategories() {
        String query = "SELECT * FROM categorie";
        Vector<Categorie> categories = new Vector<>();
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("code");
                String nom = rs.getString("nomcat");
                Categorie c = new Categorie(code, nom);
                categories.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Produit> getAllProduits() {
        String query = "SELECT * FROM produit";
        List<Produit> produits = new ArrayList<>();
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int reference = rs.getInt("reference");
                String nom = rs.getString("nom");
                double prix = rs.getDouble("prix");
                int quantite = rs.getInt("quantite");
                int codeCategorie = rs.getInt("code_categorie");

Categorie c = getCategorieByCode(codeCategorie);
                Produit p = new Produit(reference, nom, prix, quantite, c);
                produits.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public List<Produit> getProduitsByCategorie(int codeCategorie) {
        String query = "SELECT * FROM produit WHERE code_categorie = ?";
        List<Produit> produits = new ArrayList<>();
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, codeCategorie);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int reference = rs.getInt("reference");
                String nom = rs.getString("nom");
                double prix = rs.getDouble("prix");
                int quantite = rs.getInt("quantite");
                Categorie c = getCategorieByCode(codeCategorie);
                Produit p = new Produit(reference, nom, prix, quantite, c);
                produits.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }
    
    private Categorie getCategorieByCode(int codeCategorie) {
        String query = "SELECT * FROM categorie WHERE code = ?";
        Categorie c = null;
        try {
            PreparedStatement ps = cx.prepareStatement(query);
            ps.setInt(1, codeCategorie);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int code = rs.getInt("code");
                String nom = rs.getString("nomcat");
                c = new Categorie(code, nom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

	@Override
	public void addCategorie(Categorie c) {
		 String query = "INSERT INTO categorie (nomcat) VALUES (?)";
	        try {
	            PreparedStatement ps = cx.prepareStatement(query);
	            ps.setString(1, c.getNomc());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
	

	@Override
	public void addProduit(Produit p) {
		 String query = "INSERT INTO produit (reference, nom, prix, quantite, code_categorie) VALUES (?, ?, ?, ?, ?)";
	        try {
	            PreparedStatement ps = cx.prepareStatement(query);
	            ps.setInt(1, p.getReference());
	            ps.setString(2, p.getNomp());
	            ps.setDouble(3, p.getPrix());
	            ps.setInt(4, p.getQuantite());
	            ps.setInt(5, p.getCategorie().getCode());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
}