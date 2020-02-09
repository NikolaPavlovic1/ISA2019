package isa.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ljekar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ime")
	private String ime;

	@Column(name = "prezime")
	private String prezime;

	@Column(name = "ocjena")
	private double ocjena;

	@Temporal(TemporalType.DATE)
	private Date godisnji_od;

	@Temporal(TemporalType.DATE)
	private Date godisnji_do;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm:ss", timezone="Europe/Belgrade")
	private Date radno_vrijeme_od;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm:ss", timezone="Europe/Belgrade")
	private Date radno_vrijeme_do;

	@OneToMany(mappedBy = "ljekar", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Pregled> pregledi = new ArrayList<>();
	
	@OneToMany(mappedBy = "ljekar", cascade = CascadeType.ALL)
	private List<Termin> termini = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "klinika_id")
	private Klinika klinika;

	@ManyToMany
	@JoinTable(name = "ljekar_tip_pregleda", joinColumns = @JoinColumn(name = "ljekar_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tip_pregleda_id", referencedColumnName = "id"))
	private Set<TipPregleda> tipovi = new HashSet<TipPregleda>();
	
	private double brojOcena;
	
	private double zbirOcena;

	public Ljekar() {
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

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(List<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	public Set<TipPregleda> getTipovi() {
		return tipovi;
	}

	public void setTipovi(Set<TipPregleda> tipovi) {
		this.tipovi = tipovi;
	}

	public Date getGodisnji_od() {
		return godisnji_od;
	}

	public void setGodisnji_od(Date godisnji_od) {
		this.godisnji_od = godisnji_od;
	}

	public Date getGodisnji_do() {
		return godisnji_do;
	}

	public void setGodisnji_do(Date godisnji_do) {
		this.godisnji_do = godisnji_do;
	}

	public double getOcjena() {
		return ocjena;
	}

	public void setOcjena(double ocjena) {
		this.ocjena = ocjena;
	}

	public Date getRadno_vrijeme_od() {
		return radno_vrijeme_od;
	}

	public void setRadno_vrijeme_od(Date radno_vrijeme_od) {
		this.radno_vrijeme_od = radno_vrijeme_od;
	}

	public Date getRadno_vrijeme_do() {
		return radno_vrijeme_do;
	}

	public void setRadno_vrijeme_do(Date radno_vrijeme_do) {
		this.radno_vrijeme_do = radno_vrijeme_do;
	}

	public List<Termin> getTermini() {
		return termini;
	}

	public void setTermini(List<Termin> termini) {
		this.termini = termini;
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
	
	public void povecajBrojOcena() {
		this.brojOcena++;
	}
	
	public void dodajOcenu(double ocena) {
		this.zbirOcena += ocena;
	}

}
