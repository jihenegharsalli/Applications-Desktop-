package metier;
public class Produit {
    private int reference;
    private String nomp;
    private double prix;
    private int quantite;
    private Categorie categorie;
    
    public Produit() {}
    
    public Produit(int reference, String nomp, double prix, int quantite, Categorie categorie) {
        this.reference = reference;
        this.nomp = nomp;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = categorie;
    }
    

    public int getReference() {
        return reference;
    }
    public void setReference(int reference) {
        this.reference = reference;
    }
    public String getNomp() {
        return nomp;
    }
    public void setNomp(String nomp) {
        this.nomp = nomp;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}