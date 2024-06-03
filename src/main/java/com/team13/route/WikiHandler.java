package com.team13.route;

import com.team13.model.WikiModel;
import com.team13.service.WikiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class WikiHandler {

    @Autowired
    private WikiService wikiService;

    public Mono<ServerResponse> getAllWikis(ServerRequest request) {
        List<WikiModel> wikis = wikiService.getAllWikis();
        return ServerResponse.ok().bodyValue(wikis);
    }

    public Mono<ServerResponse> getWikiById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        WikiModel wiki = wikiService.getWikiById(id);
        return wiki != null ?
                ServerResponse.ok().bodyValue(wiki) :
                ServerResponse.notFound().build();
    }

    public Mono<ServerResponse> createWiki(ServerRequest request) {
        Mono<WikiModel> wikiMono = request.bodyToMono(WikiModel.class);
        return wikiMono.flatMap(wiki -> {
            WikiModel createdWiki = wikiService.createWiki(wiki);
            return ServerResponse.ok().bodyValue(createdWiki);
        });
    }

    public Mono<ServerResponse> updateWiki(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<WikiModel> wikiMono = request.bodyToMono(WikiModel.class);
        return wikiMono.flatMap(wiki -> {
            WikiModel updatedWiki = wikiService.updateWiki(id, wiki);
            return ServerResponse.ok().bodyValue(updatedWiki);
        });
    }

    public Mono<ServerResponse> deleteWiki(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        wikiService.deleteWiki(id);
        return ServerResponse.ok().build();
    }
}
