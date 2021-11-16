package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Ville appelGet(@RequestParam(required = false,value = "codePostal") String codePostal) {
		Ville ville = villeService.getInfoVilles();
		return ville;
	}
	
	@RequestMapping(value="/ville",method = RequestMethod.POST)
	@ResponseBody
	public String appelPost(@RequestBody Ville villeDTO) {
		System.out.println("Code : "+villeDTO.getCodeCommune() + " Nom : "+villeDTO.getNomCommune());
		return "Hello World POST";
	}
	
}
