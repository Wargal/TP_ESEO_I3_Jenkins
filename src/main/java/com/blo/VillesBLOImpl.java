package com.blo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VillesDAO;
import com.dto.Ville;

@Service
public class VillesBLOImpl implements VillesBLO{
	
	@Autowired
	private VillesDAO villeDAO;
	
	@Override
	public Ville getInfoVilles() {
		// TODO Auto-generated method stub
		/**
		 * On y retrouve un code métier, croiser avec des APIs, traitement etc
		 */
		Ville ville = villeDAO.findVille();
		return ville;
	}


	
}
