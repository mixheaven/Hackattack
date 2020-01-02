package com.stercket.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stercket.entity.Stercket;

@Repository
public interface StercketRepository extends JpaRepository<Stercket, Long> {
	

}
