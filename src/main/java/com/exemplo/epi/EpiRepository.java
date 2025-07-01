package com.exemplo.epi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EPIRepository extends JpaRepository<Epi, Integer> {}
