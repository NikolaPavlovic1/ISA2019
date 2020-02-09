package isa.project.repository;

import isa.project.model.Ljekar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LjekarRepository extends JpaRepository<Ljekar, Long> {
	
	@Query("select l from Ljekar l where l.id = ?1")
	public Ljekar findOneById(long id);
}
