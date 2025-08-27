package com.lingosphinx.lesson.configuration;

import com.lingosphinx.lesson.client.GamificationClient;
import com.lingosphinx.lesson.configuration.LessonProperties;
import com.lingosphinx.lesson.dto.GoalTypeDto;
import com.lingosphinx.lesson.dto.GoalZoneDto;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class GamificationInit {
    private final LessonProperties lessonProperties;
    private final GamificationClient gamificationClient;

    private static final List<String> TYPES = List.of("course", "unit", "lesson", "material");

    @Async
    @EventListener(ApplicationReadyEvent.class)
    public void initGamification() {
        for (var lang : lessonProperties.getLanguages()) {
            try {
                gamificationClient.createZone(new GoalZoneDto(lang));
            } catch (Exception e) {
                if (e instanceof FeignException.Conflict) {
                    log.info("409 CONFLICT on createZone: {}", lang);
                } else {
                    throw e;
                }
            }
        }
        for (var type : TYPES) {
            try {
                gamificationClient.createType(new GoalTypeDto(type));
            } catch (Exception e) {
                if (e instanceof FeignException.Conflict) {
                    log.info("409 CONFLICT on createType: {}", type);
                } else {
                    throw e;
                }
            }
        }
    }
}