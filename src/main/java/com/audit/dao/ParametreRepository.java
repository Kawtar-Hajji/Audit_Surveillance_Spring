package com.audit.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.audit.entities.Parametre;

public interface ParametreRepository extends JpaRepository<Parametre, Long>{

	@Query("select p from Parametre p where p.mesure.id = :x")
	public List<Parametre> ListOfDifferentParam(@Param("x")Long idMesure);
}
