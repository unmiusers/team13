package com.team13.controller;

import com.team13.model.WikiModel;
import com.team13.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wiki")
public class WikiController {

    @Autowired
    private WikiService wikiService;

    @GetMapping
    public List<WikiModel> getAllWikis() {
        return wikiService.getAllWikis();
    }

    @GetMapping("/{id}")
    public WikiModel getWikiById(@PathVariable Long id) {
        return wikiService.getWikiById(id);
    }

    @PostMapping
    public WikiModel createWiki(@RequestBody WikiModel wiki) {
        return wikiService.createWiki(wiki);
    }

    @PutMapping("/{id}")
    public WikiModel updateWiki(@PathVariable Long id, @RequestBody WikiModel wiki) {
        return wikiService.updateWiki(id, wiki);
    }

    @DeleteMapping("/{id}")
    public void deleteWiki(@PathVariable Long id) {
        wikiService.deleteWiki(id);
    }
}
