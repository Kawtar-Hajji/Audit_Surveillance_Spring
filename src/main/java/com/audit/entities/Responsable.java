package com.audit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
public class Responsable implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeRespo;
	private String username;
	private String password;
	private String email;
	private int active;
	@ManyToOne
	@JoinColumn(name="CODE_ENTR")
	private Entreprise entreprize;
	
	public Entreprise getEntreprize() {
		return entreprize;
	}
	public void setEntreprize(Entreprise entreprize) {
		this.entreprize = entreprize;
	}
	public Long getCodeRespo() {
		return codeRespo;
	}
	public void setCodeRespo(Long codeRespo) {
		this.codeRespo = codeRespo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Responsable() {
		super();
	}
	public Responsable(String username, String password, String email, int active, Entreprise entreprize) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
		this.entreprize = entreprize;
	}
	public Responsable(String username, String password, String email, int active) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
	}
	
}
