package com.team13.repository;

import com.team13.model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {
}
