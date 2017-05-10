package com.audit.dao;

import java.sql.Date;
import java.util.List;

import com.audit.entities.Entreprise;
import com.audit.entities.Mesure;
import com.audit.entities.Parametre;
import com.audit.entities.Responsable;
import com.audit.entities.Site;

public interface IAuditDao {
	public Responsable addRespo(Responsable r);
	public Site addSite(Site s,Long codeEntr);
	public Mesure addMesure(Mesure m,Long codeSite,Long codeRespo);
	public Site consulterSite(Long codeSite);
	public Entreprise consulterEntreprise(Long codeEntr);
	public List<Mesure> ensembleDesMesures(Long codeSite);
	public void performance(Long codeSite,Date heuredebut,Long codeRespo);
	public List<Mesure> historyOfMesureSite(Long idSite);
	public List<Parametre> HistoryOfDifferentParam(Long idMesure);
	public List<Site> getSitesByEntreprise(Long codeEntr);
	public List<Entreprise> getEntrepriseByMC(String mc);
	public Parametre addParam(Parametre p, Long codeMesure);
	
}
