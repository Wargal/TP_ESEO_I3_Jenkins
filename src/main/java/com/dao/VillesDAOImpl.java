package com.dao;

import org.springframework.stereotype.Repository;

import com.dto.Ville;

@Repository
public class VillesDAOImpl implements VillesDAO{
	
	/**
	 * Dans la DAO on récupère juste les données
	 */
	@Override
	public Ville findVille() {
		Ville ville = new Ville();
		ville.setCodeCommune("codeVille");
		ville.setNomCommune("nomVille");
		return ville;
	}

}
