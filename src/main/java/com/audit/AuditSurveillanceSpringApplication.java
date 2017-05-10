package com.audit;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.query.Param;

import com.audit.dao.EntrepriseRepository;
import com.audit.dao.MesureRepository;
import com.audit.dao.ParametreRepository;
import com.audit.dao.ResponsableRepository;
import com.audit.dao.SiteRepository;
import com.audit.entities.Entreprise;
import com.audit.entities.Jsoup1;
import com.audit.entities.Mesure;
import com.audit.entities.Parametre;
import com.audit.entities.Performance;
import com.audit.entities.Responsable;
import com.audit.entities.Site;
import com.audit.metier.IAuditMetier;

@SpringBootApplication
public class AuditSurveillanceSpringApplication implements CommandLineRunner {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private SiteRepository siteRepository;
	@Autowired 
	private ResponsableRepository responsableRepository;
	@Autowired
	private MesureRepository mesureRepository;
	@Autowired
	private ParametreRepository parametreRepository;
	@Autowired
	private IAuditMetier auditMetier;
	public static void main(String[] args) {
	    SpringApplication.run(AuditSurveillanceSpringApplication.class, args);
		
		Jsoup1 j1=new Jsoup1();
		Jsoup1 j2=new Jsoup1();
		Jsoup1 j3=new Jsoup1();
		j1.start();
		j2.start();
		j3.start();
	}

	@Override
	public void run(String... arg0) throws Exception {
		 Entreprise e1=entrepriseRepository.save(new Entreprise("IGA", "ECOLE", "Maroc", "Casablanca", "Roches noires", "0523545555"));
		 Entreprise e2=entrepriseRepository.save(new Entreprise("AVITO", "ECOMMERCE", "Maroc", "Casablanca", "bd Mohammed 5", "0523545555"));
		 Entreprise e3=entrepriseRepository.save(new Entreprise("Facebook", "Reseau sociau", "USA", "San francisco", "16 strett a", "18614646"));
		 Entreprise e4=entrepriseRepository.save(new Entreprise("AMAZON", "ecommerce", "USA", "aa", "eeeee", "154546"));

		 
		 
		
		 Site s1=siteRepository.save(new Site("www.avito.ma", "Avito Maroc", "Commerce en ligne",e2));
		 Site s2=siteRepository.save(new Site("www.amazon.com", "Amazon", "Commerce en ligne",e4));
		 Site s3=siteRepository.save(new Site("www.facebook.com", "Facebook", "Reseau sociaux",e3));
		 Site s4=siteRepository.save(new Site("www.iga.ma", "IGA Maroc", "Site educatif",e1));
		 
		 
		 Responsable r1=responsableRepository.save(new Responsable("Kawtar-Hajji", "123456789", "khajji@comapany.ma", 1, e1));
		 Responsable r2=responsableRepository.save(new Responsable("Kamal Azzouzi", "987456123", "azzouei@avito.ma", 1, e2));
		 Responsable r3=responsableRepository.save(new Responsable("Hamza aouad", "26684", "hamza@facebook.com", 1, e3));
		 Responsable r4=responsableRepository.save(new Responsable("Marouan Karim", "848461", "kmarouan@amazon.fr", 1, e4));
	
		 Mesure m1=mesureRepository.save(new Mesure(new Date(), new Date(), s3, r3));
		 Mesure m2=mesureRepository.save(new Mesure(new Date(), new Date(), s1, r1));
		 Mesure m3=mesureRepository.save(new Mesure(new Date(), new Date(), s2, r2));
		 Mesure m4=mesureRepository.save(new Mesure(new Date(), new Date(), s4, r4));
		 
		 Parametre p1=parametreRepository.save(new Performance(new Date(), m1));
		 
		 Site s5=new Site("www.cadeau.ma", "Cadeau ", "Site educatif",e4);
		 List<Entreprise> ents=entrepriseRepository.findAll();
		 for(Entreprise e:ents){ System.out.println(e.getName());} 
		 System.out.println("******************");
		 List<Responsable> respos=responsableRepository.findAll();
		 for(Responsable r:respos){ System.out.println(r.getUsername());} 
		 System.out.println("******************");
		 List<Entreprise> entreps=entrepriseRepository.getEntrepriseByMC("%AM%");
		 for(Entreprise e:entreps){ System.out.println(e.getName());} 
		 System.out.println("******************");
		// List<Parametre> params=parametreRepository.ListOfDifferentParam((long) 2);
		 //for(Parametre p:params){ System.out.println(p.getId()); System.out.println(p.getHeureDebut()); System.out.println(p.getMesure());} 
		 //System.out.println("******************");
		 List<Responsable> respoos=responsableRepository.getResponsableByEntreprise("%AM%");
		 for(Responsable r:respoos){ System.out.println(r.getUsername());}
		 auditMetier.addSite(s5);
		 System.out.println("******************");
		 List<Site> sites=siteRepository.findAll();
		 for(Site s:sites){ System.out.println(s.getUrl());} 
		 System.out.println("******************");

	}
}
