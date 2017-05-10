package com.audit.metier;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.audit.dao.EntrepriseRepository;
import com.audit.dao.MesureRepository;
import com.audit.dao.ResponsableRepository;
import com.audit.dao.SiteRepository;
import com.audit.entities.Entreprise;
import com.audit.entities.Mesure;
import com.audit.entities.Responsable;
import com.audit.entities.Site;

@Service
@Transactional
public class AuditMetierImpl implements IAuditMetier {

	@Autowired
	private EntrepriseRepository entrepriseRepo;
	@Autowired
	private SiteRepository siteRepository;
	@Autowired 
	private ResponsableRepository responsableRepository;
	@Autowired
	private MesureRepository mesureRepository;
	
	@Override
	public Responsable addRespo(Responsable r) {
		responsableRepository.save(r);
		return r;
	}
	
	@Override
	public Site consulterSite(Long codeSite) {
		Site s=siteRepository.findOne(codeSite);
		if(s==null) throw new RuntimeException("Site Web Introuvable");
		return s;
	}
	
	@Override
	public Entreprise consulterEntreprise(Long codeEntr) {
		Entreprise en=entrepriseRepo.findOne(codeEntr);
		if(en==null) throw new RuntimeException("Entreprise Introuvable");
		return en;
	}
	
	@Override
	public Site addSite(Site s) {
		siteRepository.save(s);
		return s;
	}


	@Override
	public Page<Mesure> listeMesure(Long idSite, int page, int size) {
		return mesureRepository.listeMesure(idSite, new PageRequest(page, size));
	}


	@Override
	public void performance(Long codeMesure, Date heuredebut, Long codeRespo) {
		// TODO Auto-generated method stub
		
	}



	
}
