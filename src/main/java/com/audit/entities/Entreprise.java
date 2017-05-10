package com.audit.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="COMPANYS")
public class Entreprise implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
@NotNull
 private String name;
 private String activite;
 @NotNull
private String pays;
 private String ville;
 private String addres;
 @NotNull
 private String numerotel;
 @OneToMany(mappedBy="entreprise",fetch=FetchType.LAZY)
 private Collection<Site> site;
 @OneToMany(mappedBy="entreprize",fetch=FetchType.LAZY)
 private Collection<Responsable> responsable;
 
 public Collection<Site> getSite() {
	return site;
}
public void setSite(Collection<Site> site) {
	this.site = site;
}
public Collection<Responsable> getResponsable() {
	return responsable;
}
public void setResponsable(Collection<Responsable> responsable) {
	this.responsable = responsable;
}
public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}
	public String getAddres() {
		return addres;
	}
	public void setAddres(String addres) {
		this.addres = addres;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public String getNumerotel() {
	return numerotel;
}
public void setNumerotel(String numerotel) {
	this.numerotel = numerotel;
}


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Entreprise(String name, String activite, String pays, String ville, String addres, String numerotel) {
	super();
	this.name = name;
	this.activite = activite;
	this.pays = pays;
	this.ville = ville;
	this.addres = addres;
	this.numerotel = numerotel;
}
public Entreprise() {
	super();
}
 
}
