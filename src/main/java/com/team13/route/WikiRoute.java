package com.team13.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WikiRoute {

    @Bean(name = "WikiRoute")
    public RouterFunction<ServerResponse> route(WikiHandler handler) {
        return RouterFunctions.route()
                .GET("/wiki", handler::getAllWikis)
                .GET("/wiki/{id}", handler::getWikiById)
                .POST("/wiki", handler::createWiki)
                .PUT("/wiki/{id}", handler::updateWiki)
                .DELETE("/wiki/{id}", handler::deleteWiki)
                .build();
    }
}
