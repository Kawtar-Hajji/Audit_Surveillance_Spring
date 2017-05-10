package com.audit.metier;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.audit.entities.Entreprise;
import com.audit.entities.Mesure;
import com.audit.entities.Parametre;
import com.audit.entities.Responsable;
import com.audit.entities.Site;

public interface IAuditMetier {

	public Responsable addRespo(Responsable r);
	public Site addSite(Site s);
	public Site consulterSite(Long codeSite);
	public Entreprise consulterEntreprise(Long codeEntr);
	public void performance(Long codeMesure,Date heuredebut,Long codeRespo);
	public Page<Mesure> listeMesure(Long idSite,int page,int size);
	
	
}
