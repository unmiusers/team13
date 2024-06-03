package com.team13.service;

import com.team13.model.WikiModel;
import com.team13.repository.WikiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WikiService {

    @Autowired
    private WikiRepository wikiRepository;

    public List<WikiModel> getAllWikis() {
        return wikiRepository.findAll();
    }

    public WikiModel getWikiById(Long id) {
        return wikiRepository.findById(id).orElse(null);
    }

    public WikiModel createWiki(WikiModel wiki) {
        return wikiRepository.save(wiki);
    }

    public WikiModel updateWiki(Long id, WikiModel wiki) {
        WikiModel existingWiki = getWikiById(id);
        if (existingWiki != null) {
            existingWiki.setTitle(wiki.getTitle());
            existingWiki.setContent(wiki.getContent());
            return wikiRepository.save(existingWiki);
        }
        return null;
    }

    public void deleteWiki(Long id) {
        wikiRepository.deleteById(id);
    }
}
