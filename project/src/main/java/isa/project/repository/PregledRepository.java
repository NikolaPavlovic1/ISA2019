package isa.project.repository;

import java.util.List;

import isa.project.model.Pregled;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PregledRepository extends JpaRepository<Pregled, Long> {

	List<Pregled> findAll();

	@Query("select pregled from Pregled pregled where pregled.stanje = isa.project.model.StanjePregleda.ZAKAZAN ")
	List<Pregled> getZakazaniPregledi();

	@Query("select pregled from Pregled pregled where pregled.stanje = isa.project.model.StanjePregleda.ZAKAZAN or pregled.stanje = isa.project.model.StanjePregleda.OTKAZAN")
	List<Pregled> getIstorijaPregleda();

	@Query("select pregled from Pregled pregled where pregled.stanje = isa.project.model.StanjePregleda.SLOBODAN")
	List<Pregled> getDostupniPregledi();

	@Query("select pregled from Pregled pregled where pregled.tip = ?1")
	List<Pregled> getPregledPoTipu(String tip);

}
