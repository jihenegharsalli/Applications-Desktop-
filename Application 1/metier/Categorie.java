package metier;
import java.util.List;

import java.util.List;

public class Categorie {
    private int code;
    private String nomc;
    private List<Produit> produits;
    

    public Categorie() {}
    

    public Categorie(int code, String nomc) {
        this.code = code;
        this.nomc = nomc;
    }
    

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getNomc() {
        return nomc;
    }
    public void setNomc(String nomc) {
        this.nomc = nomc;
    }
    public List<Produit> getProduits() {
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
	}
    
}