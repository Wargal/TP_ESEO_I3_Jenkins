package com.dto;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dto.Ville.Coordonnees;

public class VilleTest {

	@Test
	public void test() {
		String Code_commune_INSEE ="code";
		String Nom_commune = "nom";
		String Code_postal = "cp";
		String Libelle_acheminement = "libelle";
		String Ligne_5 ="l5";
		Coordonnees coordonnees = new Coordonnees("lat", "lng");
		Ville ville = new Ville(Code_commune_INSEE, Nom_commune, Code_postal, Libelle_acheminement, Ligne_5, coordonnees);
		assertNotNull(ville);
	}

}
