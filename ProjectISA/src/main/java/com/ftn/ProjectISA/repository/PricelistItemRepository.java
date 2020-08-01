package com.ftn.ProjectISA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.ProjectISA.model.PricelistItem;

@Repository
public interface PricelistItemRepository extends JpaRepository<PricelistItem,Long>{

}
