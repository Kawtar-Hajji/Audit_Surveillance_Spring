package com.audit.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.audit.entities.Mesure;

public interface MesureRepository  extends JpaRepository<Mesure, Long>{
	@Query("select m from Mesure m where m.siteweb.id=:x order by m.dateDebut desc")
	public Page<Mesure> listeMesure(@Param("x")Long idSite,Pageable pageable);

	
	

}
