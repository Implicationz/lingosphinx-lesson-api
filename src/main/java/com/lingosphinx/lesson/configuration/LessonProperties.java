package com.lingosphinx.lesson.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "lingosphinx.lesson")
public class LessonProperties {
    private List<String> languages;
}