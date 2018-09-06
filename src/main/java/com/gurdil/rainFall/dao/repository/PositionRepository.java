package com.gurdil.rainFall.dao.repository;

import com.gurdil.rainFall.dao.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

}
