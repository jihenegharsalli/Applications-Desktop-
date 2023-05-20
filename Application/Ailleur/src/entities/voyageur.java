package entities;
import java.util.List;

import java.util.List;

public class voyageur {
    private int idv;
    private String nom;
    private String prenom;
    private String nationalite;
    private String sexe;
    private String numpassport;
    private String adresse;
    private String tel;
    //private billet b;
    //private vol vov;
    //private List<voyageurs> produits;
    

    public voyageur(String nom,String prenom,String nationalite,String sexe,String numpassport,String adresse,String tel) {//,billet b,vol vov) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.sexe = sexe;
        this.numpassport = numpassport;
        this.adresse = adresse;
        this.tel = tel;
    
    }
    
    public voyageur(int idv, String nom,String prenom,String nationalite,String sexe,String numpassport,String adresse,String tel) {//,billet b,vol vov) {
        this.idv = idv;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.sexe = sexe;
        this.numpassport = numpassport;
        this.adresse = adresse;
        this.tel = tel;
        //this.b = b;
        //this.vov = vov;
    }
    

    public int getIdv() {
        return idv;
    }
    public void setIdv(int idv) {
        this.idv = idv;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNationalite() {
        return nationalite;
    }
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getNumPassport() {
        return numpassport;
    }
    public void setNumpassport(String numpassport) {
        this.numpassport = numpassport;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    @Override
	public String toString() {
    	return String.valueOf(idv);
	}
  /*  public billet getBillet() {
        return b;
    }
    public void setBillet(billet b) {
        this.b = b;
    }
    public vol getVov() {
        return vov;
    }
    public void setVov(vol vov) {
        this.vov = vov;
    }*/
    
    
    
    
    
    
    
    
    
    
    
    
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

