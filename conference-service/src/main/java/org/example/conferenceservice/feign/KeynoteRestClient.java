package org.example.conferenceservice.feign;

import org.example.conferenceservice.feign.dto.keynoteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// Le nom du service doit correspondre à celui déclaré dans application.yml de keynote-service
@FeignClient(name = "KEYNOTE-SERVICE")
public interface KeynoteRestClient {

    @GetMapping("/api/keynotes")
    List<keynoteDTO> getAllKeynotes();
}
