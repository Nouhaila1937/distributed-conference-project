package org.example.conferenceservice.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class keynoteDTO {
    public Long id;
    public String title;
    public String description;
    public String dateTime; // en String pour faciliter le JSON
    public int duration;
    public String location;
}
