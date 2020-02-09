package isa.project.dto;

import isa.project.model.Ljekar;

import java.util.ArrayList;

public class PretragaLjekaraDTO {
	
	private String ime;
	private String prezime;
	private double ocjena;
	private ArrayList<Ljekar> ljekari;
	
	public PretragaLjekaraDTO() {
		// TODO Auto-generated constructor stub
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

	public double getOcjena() {
		return ocjena;
	}

	public void setOcjena(double ocjena) {
		this.ocjena = ocjena;
	}

	public ArrayList<Ljekar> getLjekari() {
		return ljekari;
	}

	public void setLjekari(ArrayList<Ljekar> ljekari) {
		this.ljekari = ljekari;
	}
	
	
}
