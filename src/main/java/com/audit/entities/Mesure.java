package com.audit.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="MESURE")
public class Mesure implements Serializable{
	@Id @GeneratedValue
private Long id;
	@NotNull
private Date dateDebut;
private Date dateFin;
@OneToMany(mappedBy="mesure",fetch=FetchType.LAZY)
private Collection<Parametre> parametres;
@ManyToOne
@JoinColumn(name="CODE_SITE")
private Site siteweb;

public Mesure(Date dateDebut, Date dateFin, Site siteweb, Responsable respo) {
	super();
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.siteweb = siteweb;
	this.respo = respo;
}


@ManyToOne
@JoinColumn(name="CODE_RESPON")
private Responsable respo;

public Site getSiteweb() {
	return siteweb;
}


public void setSiteweb(Site siteweb) {
	this.siteweb = siteweb;
}


public Responsable getRespo() {
	return respo;
}


public void setRespo(Responsable respo) {
	this.respo = respo;
}


public Collection<Parametre> getParametres() {
	return parametres;
}


public void setParametres(Collection<Parametre> parametres) {
	this.parametres = parametres;
}


public Mesure(Date dateDebut, Date dateFin) {
	super();
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
}


public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


public Mesure() {
	super();
}

}
