package org.example.conferenceservice.feign;
import org.example.conferenceservice.feign.dto.keynoteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "keynote-service")
public interface KeynoteClient {
    @GetMapping("/api/keynotes/{id}")
    keynoteDTO getKeynote(@PathVariable("id") UUID id);
}
