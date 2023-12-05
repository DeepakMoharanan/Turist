package com.WanderHub.repository;

import com.WanderHub.entity.Plase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaseRepository extends JpaRepository<Plase, Long> {
}
