package com.lingosphinx.lesson.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MaterialType type = MaterialType.TEXT;

    @ManyToOne
    private Lesson lesson;
    
    private String quiz;
    
    private String summary;

    private int questionCount = 0;
    private int wordCount = 0;
    
    private String artifact;

    private String goal;
}