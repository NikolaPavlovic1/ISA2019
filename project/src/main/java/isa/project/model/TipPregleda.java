package isa.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TipPregleda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ime")
	private String ime;

	@Column(name = "cijena")
	private double cijena;

	@Column(name = "trajanje")
	private int trajanje;

	@Column(name = "sala")
	private int sala;

	@ManyToMany(mappedBy = "tipovi")
	@JsonIgnore
	private Set<Ljekar> ljekari = new HashSet<Ljekar>();

	@ManyToMany(mappedBy = "tipovi")
	@JsonIgnore
	private Set<Klinika> klinike = new HashSet<Klinika>();

	public TipPregleda() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	
	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public Set<Ljekar> getLjekari() {
		return ljekari;
	}

	public void setLjekari(Set<Ljekar> ljekari) {
		this.ljekari = ljekari;
	}

	public Set<Klinika> getKlinike() {
		return klinike;
	}

	public void setKlinike(Set<Klinika> klinike) {
		this.klinike = klinike;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

}
