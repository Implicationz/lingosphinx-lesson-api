package com.lingosphinx.lesson.dto;

import com.lingosphinx.lesson.domain.LanguageCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummaryTranslationDto {

    private Long id;
    private SummaryDto summary;
    private LanguageCode language;
    private String text;
}