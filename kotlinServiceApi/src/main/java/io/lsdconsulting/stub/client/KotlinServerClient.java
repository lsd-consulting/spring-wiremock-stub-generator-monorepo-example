package io.lsdconsulting.stub.client;

import io.lsdconsulting.stub.api.response.ServerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "kotlinServerClient", url = "${server.url}")
public interface KotlinServerClient {

    @GetMapping("/kotlinServerResource/123")
    ServerResponse getServerData();

}
