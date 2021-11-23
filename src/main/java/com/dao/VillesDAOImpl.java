package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dto.Ville;
import com.dto.Ville.Coordonnees;

@Repository
public class VillesDAOImpl extends Dao<Ville> implements VillesDAO {

	/**
	 * Dans la DAO on récupère juste les données
	 */
	@Override
	public Ville findVille(String code_commune_INSEE, String nom_commune, String code_postal,
			String libelle_acheminement, Integer limit, Integer offset) {
		Ville ville = null;
		try {
			Statement statement = this.connect.createStatement();
			SQLSelectForger query = new SQLSelectForger("ville_france");
			ResultSet result = statement.executeQuery(query.toString());
			result.first();

			String Code_commune_INSEE = result.getString("Code_commune_INSEE");
			String Nom_commune = result.getString("Nom_commune");
			String Code_postal = result.getString("Code_postal");
			String Libelle_acheminement = result.getString("Libelle_acheminement");
			String Ligne_5 = result.getString("Ligne_5");

			String Latitude = result.getString("Latitude");
			String Longitude = result.getString("Longitude");
			Coordonnees coordonnees = new Coordonnees(Latitude, Longitude);

			ville = new Ville(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, coordonnees);

		} catch (SQLException e) {
			// LoggerSystem log = new LoggerSystem(LOGGER_NAME);
			// log.addLog(e.getMessage(), "info");
			e.printStackTrace();
		}
		return ville;
	}

	@Override
	public List<Ville> findVilles(String code_commune_INSEE, String nom_commune, String code_postal,
			String libelle_acheminement, Integer limit, Integer offset) {
		List<Ville> villes = new ArrayList<Ville>();
		try {
			Statement statement = this.connect.createStatement();
			SQLSelectForger query = new SQLSelectForger("ville_france");

			if (code_commune_INSEE != null) {
				query.addValueWhereClause("ville_france", "code_commune_INSEE", code_commune_INSEE);
			}
			if (nom_commune != null) {
				query.addValueWhereClause("ville_france", "nom_commune", nom_commune);
			}
			if (code_postal != null) {
				query.addValueWhereClause("ville_france", "code_postal", code_postal);
			}
			if (libelle_acheminement != null) {
				query.addValueWhereClause("ville_france", "libelle_acheminement", libelle_acheminement);
			}

			if (limit != null) {
				query.setLimit(limit);
			}

			if (offset != null) {
				query.setOffset(offset);
			}

			ResultSet result = statement.executeQuery(query.toString());
			while (result.next()) {

				String Code_commune_INSEE = result.getString("Code_commune_INSEE");
				String Nom_commune = result.getString("Nom_commune");
				String Code_postal = result.getString("Code_postal");
				String Libelle_acheminement = result.getString("Libelle_acheminement");
				String Ligne_5 = result.getString("Ligne_5");

				String Latitude = result.getString("Latitude");
				String Longitude = result.getString("Longitude");
				Coordonnees coordonnees = new Coordonnees(Latitude, Longitude);

				villes.add(new Ville(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5,
						coordonnees));
			}
		} catch (SQLException e) {
			// LoggerSystem log = new LoggerSystem(LOGGER_NAME);
			// log.addLog(e.getMessage(), "info");
			e.printStackTrace();
		}
		return villes;
	}

	@Override
	public void addVille(String code_commune_INSEE, String nom_commune, String code_postal, String libelle_acheminement,
			String ligne_5, String latitude, String longitude) {
		try {
			Statement statement = this.connect.createStatement();
			SQLInsertForger query = new SQLInsertForger("ville_france");

			if (code_commune_INSEE != null) {
				query.addInsertionValue("code_commune_INSEE", "\""+code_commune_INSEE+"\"");
			}
			if (nom_commune != null) {
				query.addInsertionValue("nom_commune", "\""+nom_commune+"\"");
			}
			if (code_postal != null) {
				query.addInsertionValue("code_postal", "\""+code_postal+"\"");
			}
			if (libelle_acheminement != null) {
				query.addInsertionValue("libelle_acheminement", "\""+libelle_acheminement+"\"");
			}
			if (ligne_5 != null) {
				query.addInsertionValue("Ligne_5", "\""+ligne_5+"\"");
			}
			if (latitude != null) {
				query.addInsertionValue("Latitude", "\""+latitude+"\"");
			}
			if (longitude != null) {
				query.addInsertionValue("Longitude", "\""+longitude+"\"");
			}

			ResultSet result = statement.executeQuery(query.toString());
			
		} catch (SQLException e) {
			// LoggerSystem log = new LoggerSystem(LOGGER_NAME);
			// log.addLog(e.getMessage(), "info");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateVille(String code_commune_INSEE, String nom_commune, String code_postal, String libelle_acheminement,
			String ligne_5, String latitude, String longitude) {
		try {
			Statement statement = this.connect.createStatement();
			SQLUpdateForger query = new SQLUpdateForger("ville_france");

			if (code_commune_INSEE != null) {
				query.setCondition("code_commune_INSEE", "\""+code_commune_INSEE+"\"");
			}
			if (nom_commune != null) {
				query.addUpdatedValue("nom_commune", "\""+nom_commune+"\"");
			}
			if (code_postal != null) {
				query.addUpdatedValue("code_postal", "\""+code_postal+"\"");
			}
			if (libelle_acheminement != null) {
				query.addUpdatedValue("libelle_acheminement", "\""+libelle_acheminement+"\"");
			}
			if (ligne_5 != null) {
				query.addUpdatedValue("Ligne_5", "\""+ligne_5+"\"");
			}
			if (latitude != null) {
				query.addUpdatedValue("Latitude", "\""+latitude+"\"");
			}
			if (longitude != null) {
				query.addUpdatedValue("Longitude", "\""+longitude+"\"");
			}

			ResultSet result = statement.executeQuery(query.toString());
			
		} catch (SQLException e) {
			// LoggerSystem log = new LoggerSystem(LOGGER_NAME);
			// log.addLog(e.getMessage(), "info");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deleteVille(String code_commune_INSEE) {
		try {
			Statement statement = this.connect.createStatement();
			SQLDeleteForger query = new SQLDeleteForger("ville_france");

			if (code_commune_INSEE != null) {
				query.setCondition("code_commune_INSEE", "\""+code_commune_INSEE+"\"");
			}
			
			ResultSet result = statement.executeQuery(query.toString());
			
		} catch (SQLException e) {
			// LoggerSystem log = new LoggerSystem(LOGGER_NAME);
			// log.addLog(e.getMessage(), "info");
			e.printStackTrace();
		}
		
	}

}
