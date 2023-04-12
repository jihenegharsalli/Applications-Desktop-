package dao;
import java.util.List;
import java.util.Vector;

import metier.Categorie;
import metier.Produit;
public interface IDaoCatalogue {
    public void addCategorie(Categorie c);
    public void addProduit(Produit p);
    public Vector<Categorie> getAllCategories();
    public List<Produit> getAllProduits();
    public List<Produit> getProduitsByCategorie(int codeCategorie);
}