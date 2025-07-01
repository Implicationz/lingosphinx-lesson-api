package com.lingosphinx.lesson.dto;

import com.lingosphinx.lesson.domain.Material;
import com.lingosphinx.lesson.domain.Unit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonDto extends ContentItemDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Unit unit;

    private int position;

    private String title;
    private String titleTranslation;
    private String titleTranscription;


    @OneToMany(mappedBy = "lesson_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Material> materials;

}