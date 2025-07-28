package com.lingosphinx.lesson.client;

import com.lingosphinx.lesson.configuration.FeignClientConfiguration;
import com.lingosphinx.lesson.dto.GoalDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "gamification-service",
        url = "${lingosphinx.gamification.client.url}",
        configuration = FeignClientConfiguration.class
)
public interface GamificationClient {
    @GetMapping("/goal")
    List<GoalDto> getGoals(
            @RequestParam("zone") String zone,
            @RequestParam("type") String type
    );
}