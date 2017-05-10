package com.audit.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.audit.entities.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
	@Query("select e from Entreprise e where e.name like :x")

	public List<Entreprise> getEntrepriseByMC(@Param("x")String mc);
	
	
}
