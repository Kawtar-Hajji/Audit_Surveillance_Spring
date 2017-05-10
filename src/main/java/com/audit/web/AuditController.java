package com.audit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.audit.entities.Site;
import com.audit.metier.IAuditMetier;

@Controller
public class AuditController {
	@Autowired
	private IAuditMetier AuditMetier;
	@RequestMapping("/acceuil")
	public String index(){
		return"acceuil";
	}
	@RequestMapping("/signin")
	public String connexion(){
		return"signin";
	}
	@RequestMapping("/signup")
	public String nouveauClient(){
		return"signup";
	}
	@RequestMapping("/compte")
	public String compteEntreprise(Model model,Long codeSite){
		try{
			Site s=AuditMetier.consulterSite(codeSite);
			model.addAttribute("site",s);
		}catch(Exception e){
			model.addAttribute("exception",e);
		}
		
		return"compte";
	}
	
}
