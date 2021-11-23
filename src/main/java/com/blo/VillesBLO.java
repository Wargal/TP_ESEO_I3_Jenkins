package com.blo;

import java.util.List;

import com.dto.Ville;

public interface VillesBLO {
	
	public List<Ville> getInfoVilles(
			String code_commune_INSEE,
			String nom_commune,
			String code_postal,
			String libelle_acheminement,
			Integer limit,
			Integer offset
			);
	
	public void addVille(Ville ville);

	public void updateVille(Ville ville);

	void deleteVille(String codeCommune);

}
