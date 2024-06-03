package com.team13.repository;

import com.team13.model.WikiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiRepository extends JpaRepository<WikiModel, Long> {
}
