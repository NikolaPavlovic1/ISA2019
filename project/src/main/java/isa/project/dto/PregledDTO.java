package isa.project.dto;

import isa.project.model.StanjePregleda;

import java.util.Date;

public class PregledDTO {
	
	private Date termin;
	private int sala;
	private int cijena;
	private int popust;
	private String tip;
	private String trajanje;
	private StanjePregleda stanje;
	
	public PregledDTO() {
		// TODO Auto-generated constructor stub
	}

	public Date getTermin() {
		return termin;
	}

	public void setTermin(Date termin) {
		this.termin = termin;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public int getCijena() {
		return cijena;
	}

	public void setCijena(int cijena) {
		this.cijena = cijena;
	}

	public int getPopust() {
		return popust;
	}

	public void setPopust(int popust) {
		this.popust = popust;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}

	public StanjePregleda getStanje() {
		return stanje;
	}

	public void setStanje(StanjePregleda stanje) {
		this.stanje = stanje;
	} 
	
	

}
