package com.audit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.audit.entities.Responsable;

public interface ResponsableRepository extends JpaRepository<Responsable,Long>{

	@Query("select r from  Responsable r where r.entreprize.name like :x")

	public List<Responsable> getResponsableByEntreprise(@Param("x")String mc);
}
