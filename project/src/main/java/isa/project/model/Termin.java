package isa.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Termin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm:ss", timezone="Europe/Belgrade")
	private Date termin;
	
	@Column(name = "zauzet")
	private boolean zauzet;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "ljekar_id")
	private Ljekar ljekar;
	
	
	public Termin() {
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

	public boolean isZauzet() {
		return zauzet;
	}

	public void setZauzet(boolean zauzet) {
		this.zauzet = zauzet;
	}

	public Ljekar getLjekar() {
		return ljekar;
	}

	public void setLjekar(Ljekar ljekar) {
		this.ljekar = ljekar;
	}
	
	

}
