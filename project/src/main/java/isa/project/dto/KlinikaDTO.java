package isa.project.dto;

import isa.project.model.Ljekar;

import java.util.List;


public class KlinikaDTO {
	
	private String ime;
	private String adresa;
	private String opis;
	private String grad;
	private int cijenaPregleda;
	private double ocjena;
	private List<Ljekar> ljekari;

	public KlinikaDTO() {
		// TODO Auto-generated constructor stub
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

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public int getCijenaPregleda() {
		return cijenaPregleda;
	}

	public void setCijenaPregleda(int cijenaPregleda) {
		this.cijenaPregleda = cijenaPregleda;
	}

	public double getOcjena() {
		return ocjena;
	}

	public void setOcjena(double ocjena) {
		this.ocjena = ocjena;
	}

	public List<Ljekar> getLjekari() {
		return ljekari;
	}

	public void setLjekari(List<Ljekar> ljekari) {
		this.ljekari = ljekari;
	}
	

}
