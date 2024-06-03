package com.team13.service;

import com.team13.model.VersionModel;
import com.team13.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionService {

    @Autowired
    private VersionRepository versionRepository;

    public List<VersionModel> getAllVersions() {
        return versionRepository.findAll();
    }

    public VersionModel getVersionById(Long id) {
        return versionRepository.findById(id).orElse(null);
    }

    public VersionModel createVersion(VersionModel version) {
        return versionRepository.save(version);
    }

    public VersionModel updateVersion(Long id, VersionModel version) {
        if (versionRepository.existsById(id)) {
            version.setId(id);
            return versionRepository.save(version);
        } else {
            return null;
        }
    }

    public void deleteVersion(Long id) {
        versionRepository.deleteById(id);
    }
}
