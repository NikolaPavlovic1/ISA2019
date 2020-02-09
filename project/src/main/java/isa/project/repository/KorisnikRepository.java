package isa.project.repository;

import isa.project.model.Korisnik;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	public Korisnik findByUsername(String username);

	@Query("select korisnik from Korisnik korisnik where korisnik.email = :email")
	public Korisnik findOneByEmail(@Param("email") String email);

}
