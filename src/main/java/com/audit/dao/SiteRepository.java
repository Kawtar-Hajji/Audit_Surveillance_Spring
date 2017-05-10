package com.audit.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.audit.entities.Site;

public interface SiteRepository extends JpaRepository<Site, Long> {
	@Query("select s from Site s where s.entreprise.id = :x")
	public List<Site> getSitesByEntreprise(@Param("x")Long codeEntr); 
}
