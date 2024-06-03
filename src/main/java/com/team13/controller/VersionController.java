package com.team13.controller;

import com.team13.model.VersionModel;
import com.team13.service.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/versions")
public class VersionController {

    @Autowired
    private VersionService versionService;

    @GetMapping
    public List<VersionModel> getAllVersions() {
        return versionService.getAllVersions();
    }

    @GetMapping("/{id}")
    public VersionModel getVersionById(@PathVariable Long id) {
        return versionService.getVersionById(id);
    }

    @PostMapping
    public VersionModel createVersion(@RequestBody VersionModel version) {
        return versionService.createVersion(version);
    }

    @PutMapping("/{id}")
    public VersionModel updateVersion(@PathVariable Long id, @RequestBody VersionModel version) {
        return versionService.updateVersion(id, version);
    }

    @DeleteMapping("/{id}")
    public void deleteVersion(@PathVariable Long id) {
        versionService.deleteVersion(id);
    }
}
