package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VillesBLO;
import com.dto.Ville;
/**
 * Routeur, detecte les appels et redirige vers les BLO appropriés
 * @author bastien
 *
 */

@RestController
public class VilleController {
	
	@Autowired
	private VillesBLO villeService;
	
	@RequestMapping(value="/ville",method = RequestMethod.GET)
	@ResponseBody
	public List<Ville> appelGet(
			@RequestParam(required = false,value = "code_insee") String code_commune_INSEE,
			@RequestParam(required = false,value = "nom_commune") String nom_commune,
			@RequestParam(required = false,value = "code_postal") String code_postal,
			@RequestParam(required = false,value = "libelle_acheminement") String libelle_acheminement,
			@RequestParam(required = false,value = "limit") Integer limit,
			@RequestParam(required = false,value = "offset") Integer offset
			) {
		List<Ville> ville = villeService.getInfoVilles(
				code_commune_INSEE,
				nom_commune,
				code_postal,
				libelle_acheminement,
				limit,
				offset
				);
		return ville;
	}
	
	@RequestMapping(value="/ville",method = RequestMethod.POST)
	@ResponseBody
	public String appelPost(@RequestBody Ville villeDTO) {
		villeService.addVille(villeDTO);
		return "Created";
	}
	
	@RequestMapping(value="/ville",method = RequestMethod.PUT)
	@ResponseBody
	public String appelPut(@RequestBody Ville villeDTO) {
		villeService.updateVille(villeDTO);
		return "Updated";
	}
	
	@RequestMapping(value="/ville/{codeCommune}",method = RequestMethod.DELETE)
	@ResponseBody
	public String appelDelete(@PathVariable String codeCommune) {
		villeService.deleteVille(codeCommune);
		return "Deleted";
	}
	
}
