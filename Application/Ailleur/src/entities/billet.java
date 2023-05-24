package entities;
import java.util.List;

import java.util.List;

public class billet {
    private int idb; 
    private double prix;
    private vol vob;
    private voyageur v;
    

    public billet() {}
    
    public billet(double prix,voyageur v,vol vob) {
  
        this.prix = prix;
        this.v = v;
        this.vob = vob;
    }
    public billet(int idb,double prix,voyageur v,vol vob) {
        this.idb = idb;
        this.prix = prix;
        this.v = v;
        this.vob = vob;
    }
    

    public int getIdb() {
        return idb;
    }
    public void setIdb(int idb) {
        this.idb = idb;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public voyageur getVoy() {
        return v;
    }
    public void setVoy(voyageur v) {
        this.v = v;
    }
    public vol getVob() {
        return vob;
    }
    public void setVob(vol vob) {
        this.vob = vob;
    }
   /* public List<Produit> getProduits() {
        return produits;
    }
    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }


	@Override
	public String toString() {
		if(nomc==null)
			return "ALL";
		return nomc ;
	}*/
    
}