package com.lingosphinx.lesson.dto;

import com.lingosphinx.lesson.domain.LanguageCode;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class SubjectDto {
    private Long id;
    private String name;
    private LanguageCode language;
}