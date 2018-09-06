package com.gurdil.rainFall.dao.repository;

import com.gurdil.rainFall.dao.domain.Rainfall;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RainFallRepository extends JpaRepository<Rainfall, Long> {

    Page<Rainfall> findAllByPositionId(Long id, Pageable pageable);

}
