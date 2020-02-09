package isa.project.dto;

import isa.project.model.Klinika;


import isa.project.model.Ljekar;
import isa.project.model.Pregled;

import java.util.Date;
import java.util.List;

public class PretragaKlinikaDTO {
	
	private String tipPregleda;
	
	private Date datumPregleda;
	
	private String lokacijaKlinike;
	
	private double ocjenaKlinike;
	
	private List<Klinika> klinike;
	
	private List<KlinikaDTO> klinikeDTO;
	
	private Pregled pregled;
	
	private List<Ljekar> ljekari;
	
	private double cijenaPregleda;
	
	public PretragaKlinikaDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getTipPregleda() {
		return tipPregleda;
	}

	public void setTipPregleda(String tipPregleda) {
		this.tipPregleda = tipPregleda;
	}

	public Date getDatumPregleda() {
		return datumPregleda;
	}

	public void setDatumPregleda(Date datumPregleda) {
		this.datumPregleda = datumPregleda;
	}

	public String getLokacijaKlinike() {
		return lokacijaKlinike;
	}

	public void setLokacijaKlinike(String lokacijaKlinike) {
		this.lokacijaKlinike = lokacijaKlinike;
	}


	public double getOcjenaKlinike() {
		return ocjenaKlinike;
	}

	public void setOcjenaKlinike(double ocjenaKlinike) {
		this.ocjenaKlinike = ocjenaKlinike;
	}

	public List<Klinika> getKlinike() {
		return klinike;
	}

	public void setKlinike(List<Klinika> klinike) {
		this.klinike = klinike;
	}
	
	public double getCijenaPregleda() {
		return cijenaPregleda;
	}

	public void setCijenaPregleda(double cijenaPregleda) {
		this.cijenaPregleda = cijenaPregleda;
	}

	public Pregled getPregled() {
		return pregled;
	}

	public void setPregled(Pregled pregled) {
		this.pregled = pregled;
	}

	public List<Ljekar> getLjekari() {
		return ljekari;
	}

	public void setLjekari(List<Ljekar> ljekari) {
		this.ljekari = ljekari;
	}

	public List<KlinikaDTO> getKlinikeDTO() {
		return klinikeDTO;
	}

	public void setKlinikeDTO(List<KlinikaDTO> klinikeDTO) {
		this.klinikeDTO = klinikeDTO;
	}
	
	
	

}
