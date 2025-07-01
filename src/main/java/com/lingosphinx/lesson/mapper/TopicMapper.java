package com.lingosphinx.lesson.mapper;

import com.lingosphinx.lesson.domain.Topic;
import com.lingosphinx.lesson.dto.TopicDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface TopicMapper {
    TopicDto toDto(Topic topic);
    Topic toEntity(TopicDto topicDto);

}
