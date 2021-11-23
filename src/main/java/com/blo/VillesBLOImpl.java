package com.blo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VillesDAO;
import com.dto.Ville;

@Service
public class VillesBLOImpl implements VillesBLO{
	
	@Autowired
	private VillesDAO villeDAO;
	
	@Override
	public List<Ville> getInfoVilles(
			String code_commune_INSEE,
			String nom_commune,
			String code_postal,
			String libelle_acheminement,
			Integer limit,
			Integer offset
			) {
		/**
		 * On y retrouve un code métier, croiser avec des APIs, traitement etc
		 */
		List<Ville> villes = villeDAO.findVilles(
				code_commune_INSEE,
				nom_commune,
				code_postal,
				libelle_acheminement,
				limit,
				offset);
		return villes;
	}

	@Override
	public void addVille(Ville ville) {
		// TODO Auto-generated method stub
		villeDAO.addVille(
				ville.getCode_commune_INSEE(),
				ville.getNom_commune(),
				ville.getCode_postal(),
				ville.getLibelle_acheminement(),
				ville.getLigne_5(),
				ville.getCoordonnees().getLatitude(),
				ville.getCoordonnees().getLongitude()
				);
	}
	
	@Override
	public void updateVille(Ville ville) {
		// TODO Auto-generated method stub
		villeDAO.updateVille(
				ville.getCode_commune_INSEE(),
				ville.getNom_commune(),
				ville.getCode_postal(),
				ville.getLibelle_acheminement(),
				ville.getLigne_5(),
				ville.getCoordonnees().getLatitude(),
				ville.getCoordonnees().getLongitude()
				);
	}
	
	@Override
	public void deleteVille(String codeCommune) {
		// TODO Auto-generated method stub
		villeDAO.deleteVille(codeCommune);
	}


	
}
