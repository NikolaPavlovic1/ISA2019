package isa.project.repository;

import isa.project.model.Termin;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TerminRepository extends JpaRepository<Termin, Long> {

	 @Query("select termin from Termin termin where termin.termin = ?1")
	 Termin vratiTerminPoDatumu(Date date);
}
