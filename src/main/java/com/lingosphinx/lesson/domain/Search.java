package com.lingosphinx.lesson.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Search<T> {
    private Optional<Subject> subject = Optional.empty();
    private Optional<Topic> topic = Optional.empty();
    private List<T> items;
}
