package isa.project.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Klinika {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ime")
	private String ime;

	@Column(name = "adresa")
	private String adresa;

	@Column(name = "opis")
	private String opis;

	@Column(name = "grad")
	private String grad;

	@Column(name = "ocjena")
	private double ocjena;

	@OneToMany(mappedBy = "klinika", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "klinika" }, allowSetters = true)
	private List<Ljekar> ljekari = new ArrayList<>();

	@OneToMany(mappedBy = "klinika", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Pregled> pregledi = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "klinika_tip_pregleda", joinColumns = @JoinColumn(name = "klinika_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tip_pregleda_id", referencedColumnName = "id"))
	private Set<TipPregleda> tipovi = new HashSet<TipPregleda>();
	
	private double brojOcena;
	
	private double zbirOcena;

	public Klinika() {
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public List<Ljekar> getLjekari() {
		return ljekari;
	}

	public void setLjekari(List<Ljekar> ljekari) {
		this.ljekari = ljekari;
	}

	public List<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(List<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public double getOcjena() {
		return ocjena;
	}

	public void setOcjena(double ocjena) {
		this.ocjena = ocjena;
	}

	public Set<TipPregleda> getTipovi() {
		return tipovi;
	}

	public void setTipovi(Set<TipPregleda> tipovi) {
		this.tipovi = tipovi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Klinika other = (Klinika) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public double getBrojOcena() {
		return brojOcena;
	}

	public void setBrojOcena(double brojOcena) {
		this.brojOcena = brojOcena;
	}

	public double getZbirOcena() {
		return zbirOcena;
	}

	public void setZbirOcena(double zbirOcena) {
		this.zbirOcena = zbirOcena;
	}
	
	public void dodajOcenu(double ocena) {
		this.zbirOcena += ocena;
	}
	
	public void povecajBrojOcena() {
		this.brojOcena++;
	}

}
