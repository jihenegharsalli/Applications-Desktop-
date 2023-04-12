package dao;

import java.util.List;

import dao.entities.Etudiant;

public interface IGestionEtudiant {

	public void addEtudiant(Etudiant e);
	public List<Etudiant> getAllEtudiants();
	public List<Etudiant> getEtudiantsBMC(String mc);
	public void deleteEtudiant(int id);
}
