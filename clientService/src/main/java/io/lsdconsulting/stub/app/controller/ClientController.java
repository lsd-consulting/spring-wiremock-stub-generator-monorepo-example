package io.lsdconsulting.stub.app.controller;

import io.lsdconsulting.stub.api.response.Response;
import io.lsdconsulting.stub.api.response.ServerResponse;
import io.lsdconsulting.stub.client.JavaServerClient;
import io.lsdconsulting.stub.client.KotlinServerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(path = "/resource")
@RequiredArgsConstructor
public class ClientController {

    private final KotlinServerClient kotlinServerClient;
    private final JavaServerClient javaServerClient;

    @GetMapping("/v1/{id}")
    public Response getData1(@PathVariable final String id) {
        ServerResponse serverResponse = kotlinServerClient.getServerData();
        return Response.builder()
                .id(serverResponse.getId())
                .name(serverResponse.getAuthor().getName())
                .build();
    }

    @GetMapping("/v2/{id}")
    public Response getData2(@PathVariable final String id) {
        ServerResponse serverResponse = javaServerClient.getServerData();
        return Response.builder()
                .id(serverResponse.getId())
                .name(serverResponse.getAuthor().getName())
                .build();
    }

}
