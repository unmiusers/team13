package com.team13.route;

import com.team13.model.UserModel;
import com.team13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        List<UserModel> users = userService.getAllUsers();
        return ServerResponse.ok().bodyValue(users);
    }

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        UserModel user = userService.getUserById(id);
        return user != null ?
                ServerResponse.ok().bodyValue(user) :
                ServerResponse.notFound().build();
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        Mono<UserModel> userMono = request.bodyToMono(UserModel.class);
        return userMono.flatMap(user -> {
            UserModel createdUser = userService.createUser(user);
            return ServerResponse.ok().bodyValue(createdUser);
        });
    }

    public Mono<ServerResponse> updateUser(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        Mono<UserModel> userMono = request.bodyToMono(UserModel.class);
        return userMono.flatMap(user -> {
            UserModel updatedUser = userService.updateUser(id, user);
            return ServerResponse.ok().bodyValue(updatedUser);
        });
    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));
        userService.deleteUser(id);
        return ServerResponse.ok().build();
    }
}
