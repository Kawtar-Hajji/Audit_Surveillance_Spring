package com.audit.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="WebSite")
public class Site implements Serializable{
	@Id @GeneratedValue
private Long id;
	@NotNull
private String url;
	@NotNull
private String nom;
private String categorie;
@ManyToOne
@JoinColumn(name="CODE_ENTR")
private Entreprise entreprise;

public Entreprise getEntreprise() {
	return entreprise;
}
public void setEntreprise(Entreprise entreprise) {
	this.entreprise = entreprise;
}

public Site(String url, String nom, String categorie, Entreprise entreprise) {
	super();
	this.url = url;
	this.nom = nom;
	this.categorie = categorie;
	this.entreprise = entreprise;
}
public Site(String url, String nom, String categorie) {
		super();
		this.url = url;
		this.nom = nom;
		this.categorie = categorie;
	}

	public Long getId() {
	return id;
}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

public Site() {
	super();
}


}
