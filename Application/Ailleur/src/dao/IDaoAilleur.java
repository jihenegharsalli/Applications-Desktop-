package dao;
import java.util.List; 
import java.util.Vector;
import entities.voyageur;
import entities.billet;
import entities.vol;
public interface IDaoAilleur {
    public void addVoyageur(voyageur v);
    public void addVol(vol vo);
    public void addBillet(billet b);
    public Vector<voyageur> getAllVoyageurs();
    public Vector<vol> getAllVols();
    public Vector<billet> getAllBillets();
    public void supprimerVoyageur(int idv);
    public void supprimerBillets(int idb);
    public void modifierVoyageur(voyageur v);
    public void modifierBillets(billet b);
    public void supprimerVol(int codevol);
    public void modifierVol(vol v);
    public List<billet> getvolBID(int idv);
    public List<billet> getvoyBID(int codevol);
    
}

