package com.audit.entities;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("PER")
public class Performance extends Parametre {
	@NotNull
	private float TempChargement;

	public float getTempChargement() {
		return TempChargement;
	}

	public void setTempChargement(float tempChargement) {
		TempChargement = tempChargement;
	}

	
	public Performance() {
		super();
	}

	public Performance(Date heureDebut, Mesure mesure, float tempChargement) {
		super(heureDebut, mesure);
		TempChargement = tempChargement;
	}

	public Performance(Date heureDebut, Mesure mesure) {
		super(heureDebut, mesure);
	}

	

	

	

	
	

}
