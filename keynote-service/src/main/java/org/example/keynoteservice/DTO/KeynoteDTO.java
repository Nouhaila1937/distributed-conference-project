package org.example.keynoteservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeynoteDTO {
    public Long id;
    public String title;
    public String description;
    public String dateTime; // en String pour faciliter le JSON
    public int duration;
    public String location;
}
