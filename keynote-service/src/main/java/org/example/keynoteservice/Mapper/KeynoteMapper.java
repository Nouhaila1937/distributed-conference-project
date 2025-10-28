package org.example.keynoteservice.Mapper;

import org.example.keynoteservice.DTO.KeynoteDTO;
import org.example.keynoteservice.Entities.Keynote;

import java.time.LocalDateTime;

public class KeynoteMapper {

    public static KeynoteDTO toDto(Keynote keynote) {
        if (keynote == null) return null;
        return new KeynoteDTO(
                keynote.getId(),
                keynote.getTitle(),
                keynote.getDescription(),
                keynote.getDateTime() != null ? keynote.getDateTime().toString() : null,
                keynote.getDuration(),
                keynote.getLocation()
        );
    }

    public static Keynote toEntity(KeynoteDTO dto) {
        if (dto == null) return null;
        Keynote keynote = new Keynote();
        keynote.setId(dto.getId());
        keynote.setTitle(dto.getTitle());
        keynote.setDescription(dto.getDescription());
        keynote.setDateTime(dto.getDateTime() != null ? LocalDateTime.parse(dto.getDateTime()) : null);
        keynote.setDuration(dto.getDuration());
        keynote.setLocation(dto.getLocation());
        return keynote;
    }
}
