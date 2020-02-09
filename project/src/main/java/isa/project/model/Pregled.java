package isa.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pregled {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date termin;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm:ss", timezone="Europe/Belgrade")
	private Date vrijeme;

	@Column(name = "sala")
	private int sala;

	@Column(name = "cijena")
	private int cijena;

	@Column(name = "popust")
	private int popust;

	@Column(name = "tip")
	private String tip;

	@Column(name = "trajanje")
	private String trajanje;

	@Enumerated(EnumType.STRING)
	@Column(name = "stanje")
	private StanjePregleda stanje;

	@ManyToOne
	@JoinColumn(name = "ljekar_id")
	private Ljekar ljekar;

	@ManyToOne
	@JoinColumn(name = "klinika_id")
	private Klinika klinika;

	@ManyToOne
	@JoinColumn(name = "korisnik_id")
	private Korisnik korisnik;

	@OneToOne
	private TipPregleda tipPregleda;
	
	@OneToOne
	private Termin vrijemepom;

	public Pregled() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Ljekar getLjekar() {
		return ljekar;
	}

	public void setLjekar(Ljekar ljekar) {
		this.ljekar = ljekar;
	}

	public Klinika getKlinika() {
		return klinika;
	}

	public void setKlinika(Klinika klinika) {
		this.klinika = klinika;
	}

	public StanjePregleda getStanje() {
		return stanje;
	}

	public void setStanje(StanjePregleda stanje) {
		this.stanje = stanje;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public TipPregleda getTipPregleda() {
		return tipPregleda;
	}

	public void setTipPregleda(TipPregleda tipPregleda) {
		this.tipPregleda = tipPregleda;
	}

	public Date getVrijeme() {
		return vrijeme;
	}

	public void setVrijeme(Date vrijeme) {
		this.vrijeme = vrijeme;
	}

	public Termin getVrijemepom() {
		return vrijemepom;
	}

	public void setVrijemepom(Termin vrijemepom) {
		this.vrijemepom = vrijemepom;
	}
	

}
