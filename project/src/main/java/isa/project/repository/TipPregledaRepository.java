package isa.project.repository;

import isa.project.model.TipPregleda;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipPregledaRepository extends JpaRepository<TipPregleda, Long> {
	
	Page<TipPregleda> findAll(Pageable pageable);

}
