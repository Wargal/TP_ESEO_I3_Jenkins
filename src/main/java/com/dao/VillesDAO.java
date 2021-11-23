package com.dao;

import java.util.List;

import com.dto.Ville;

public interface VillesDAO {
	public Ville findVille(
			String code_commune_INSEE,
			String nom_commune,
			String code_postal,
			String libelle_acheminement,
			Integer limit,
			Integer offset);
	
	public List<Ville> findVilles(
			String code_commune_INSEE,
			String nom_commune,
			String code_postal,
			String libelle_acheminement,
			Integer limit,
			Integer offset);

	public void addVille(String code_commune_INSEE, String nom_commune, String code_postal, String libelle_acheminement,
			String ligne_5, String latitude, String longitude);

	public void updateVille(String code_commune_INSEE, String nom_commune, String code_postal,
			String libelle_acheminement, String ligne_5, String latitude, String longitude);

	void deleteVille(String code_commune_INSEE);
}
