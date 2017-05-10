
package com.audit.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="PARAMETERS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PARAM_MESURER",discriminatorType=DiscriminatorType.STRING,length=3)
public abstract class Parametre implements Serializable{
	@Id @GeneratedValue
	  private Long id;
	@NotNull
	  private Date heureDebut;
	
	  @ManyToOne
	  @JoinColumn(name="CODE_MESURE")
	  private Mesure mesure;
	
	public Parametre(Date heureDebut, Mesure mesure) {
		super();
		this.heureDebut = heureDebut;
		this.mesure = mesure;
	}
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Mesure getMesure() {
		return mesure;
	}
	public void setMesure(Mesure mesure) {
		this.mesure = mesure;
	}
		
	public Parametre() {
		super();
	}
		
}
