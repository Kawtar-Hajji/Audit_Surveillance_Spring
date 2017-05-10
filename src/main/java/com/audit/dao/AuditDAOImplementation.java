package com.audit.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.audit.entities.Entreprise;
import com.audit.entities.Mesure;
import com.audit.entities.Parametre;
import com.audit.entities.Responsable;
import com.audit.entities.Site;

public class AuditDAOImplementation implements IAuditDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Responsable addRespo(Responsable r) {
		em.persist(r);
		return r;
	}
	@Override
	public Site addSite(Site s, Long codeEntr) {
		Entreprise ent=em.find(Entreprise.class, codeEntr);
		s.setEntreprise(ent);
		em.persist(s);
		return s;
	}
	@Override
	public Mesure addMesure(Mesure m, Long codeSite, Long codeRespo) {
		Responsable r=em.find(Responsable.class, codeRespo);
		Site s=em.find(Site.class, codeSite);
		m.setRespo(r);
		m.setSiteweb(s);
		em.persist(m);
		return m;
	}
	

	@Override
	public Site consulterSite(Long codeSite) {
		Site s=em.find(Site.class, codeSite);
		if(s==null) throw new RuntimeException("Site Web Introuvable");
		return s;
	}
	@Override
	public List<Mesure> ensembleDesMesures(Long codeSite) {
		Query req=em.createQuery("select m from Mesure m where m.siteweb.id=:x");
		req.setParameter("x",codeSite);
		return req.getResultList();
	}

	
	@Override
	public void performance(Long codeSite, Date heuredebut, Long codeRespo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Parametre> HistoryOfDifferentParam(Long idMesure) {
		Query req=em.createQuery("select p from Parametre p where p.mesure.id = :x");
		req.setParameter("x",idMesure);
		return req.getResultList();
	}

	@Override
	public List<Site> getSitesByEntreprise(Long codeEntr) {
		Query req=em.createQuery("select s from Site s where s.entreprise.id = :x");
		req.setParameter("x",codeEntr);
		return req.getResultList();
	}
	@Override
	public Entreprise consulterEntreprise(Long codeEntr) {
		Entreprise en=em.find(Entreprise.class, codeEntr);
		if(en==null) throw new RuntimeException("Entreprise Introuvable");
		return en;
	}
	@Override
	public List<Entreprise> getEntrepriseByMC(String mc) {
		Query req=em.createQuery("select e from Entreprise e where e.name like :x");
		req.setParameter("x","%"+mc+"%");
		return req.getResultList();
	}
	@Override
	public List<Mesure> historyOfMesureSite(Long idSite) {
		Query req=em.createQuery("select m from Mesure m where m.siteweb = :x");
		req.setParameter("x",idSite);
		return req.getResultList();
	}
	@Override
	public Parametre addParam(Parametre p, Long codeMesure) {
		// TODO Auto-generated method stub
		Mesure m=em.find(Mesure.class, codeMesure);
		p.setMesure(m);
		em.persist(p);
		return p;
	}

	
	
	
	



	



	
}
