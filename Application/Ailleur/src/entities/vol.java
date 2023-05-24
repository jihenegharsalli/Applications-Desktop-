package entities;

import java.sql.Date;

public class vol {
    private int codevol;
    private String source;
    private String destination;
    private String datevol;
    private int nbrchaises;
    
    public vol() {}
public vol(String source, String destination, String datevol, int nbrchaises) {
    	
        this.codevol = codevol;
        this.source = source;
        this.destination = destination;
        this.datevol = datevol;
        this.nbrchaises = nbrchaises;
    }
    public vol(int codevol, String source, String destination, String datevol, int nbrchaises) {
    	
        this.codevol = codevol;
        this.source = source;
        this.destination = destination;
        this.datevol = datevol;
        this.nbrchaises = nbrchaises;
    }
    

    public int getCodevol() {
        return codevol;
    }
    public void setCodevol(int codevol) {
        this.codevol = codevol;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getDatevol() {
        return datevol;
    }
    public void setDatevol(String datevol) {
        this.datevol = datevol;
    }
    public int getNbrchaises() {
        return nbrchaises;
    }
    public void setNbrchaises(int nbrchaises) {
        this.nbrchaises = nbrchaises;
    }
    @Override
    public String toString() {
    	return String.valueOf(codevol);
		//return codevol ;
	}
}