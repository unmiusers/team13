package com.team13.repository;

import com.team13.model.MilestoneModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MilestoneRepository extends JpaRepository<MilestoneModel, Long> {
}
