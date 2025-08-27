import com.lingosphinx.lesson.client.GamificationClient;
import com.lingosphinx.lesson.configuration.LessonProperties;
import com.lingosphinx.lesson.dto.GoalTypeDto;
import com.lingosphinx.lesson.dto.GoalZoneDto;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
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
                createZoneWithRetry(new GoalZoneDto(lang));
            } catch (FeignException.Conflict e) {
                log.info("409 CONFLICT on createZone: {}", lang);
            } catch (Exception e) {
                log.warn("Error on createZone für {}: {}", lang, e.toString());
            }
        }
        for (var type : TYPES) {
            try {
                createTypeWithRetry(new GoalTypeDto(type));
            } catch (FeignException.Conflict e) {
                log.info("409 CONFLICT on createType: {}", type);
            } catch (Exception e) {
                log.warn("Error on createType für {}: {}", type, e.toString());
            }
        }
    }

    @Retryable(
            value = {FeignException.TooManyRequests.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 10_000, multiplier = 2)
    )
    public void createZoneWithRetry(GoalZoneDto dto) {
        gamificationClient.createZone(dto);
    }

    @Retryable(
            value = {FeignException.TooManyRequests.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 10_000, multiplier = 2)
    )
    public void createTypeWithRetry(GoalTypeDto dto) {
        gamificationClient.createType(dto);
    }
}