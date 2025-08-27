package com.lingosphinx.lesson.client;

import com.lingosphinx.lesson.configuration.FeignClientConfiguration;
import com.lingosphinx.gamification.dto.GoalDto;
import com.lingosphinx.lesson.dto.GoalTypeDto;
import com.lingosphinx.lesson.dto.GoalZoneDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/goal-type")
    GoalTypeDto createType(@RequestBody GoalTypeDto typeDto);

    @PostMapping("/goal-zone")
    GoalZoneDto createZone(@RequestBody GoalZoneDto zoneDto);
}