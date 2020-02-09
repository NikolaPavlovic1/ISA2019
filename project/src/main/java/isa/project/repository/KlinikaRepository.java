package isa.project.repository;

import java.util.List;

import isa.project.model.Klinika;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KlinikaRepository extends JpaRepository<Klinika, Long> {
	
	List<Klinika> findAll();
	
	@Query("select k from Klinika k where k.id = ?1")
	public Klinika findOneById(long id);
}
