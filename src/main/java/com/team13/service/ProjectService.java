package com.team13.service;

import com.team13.model.ProjectModel;
import com.team13.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectModel> getAllProjects() {
        return projectRepository.findAll();
    }

    public ProjectModel getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public ProjectModel createProject(ProjectModel project) {
        return projectRepository.save(project);
    }

    public ProjectModel updateProject(Long id, ProjectModel project) {
        ProjectModel existingProject = getProjectById(id);
        if (existingProject != null) {
            existingProject.setName(project.getName());
            existingProject.setDescription(project.getDescription());
            return projectRepository.save(existingProject);
        }
        return null;
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
