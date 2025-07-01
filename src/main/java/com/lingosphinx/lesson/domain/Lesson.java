package com.lingosphinx.lesson.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lesson {

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