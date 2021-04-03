package com.chenpeixin.assembler;

import com.chenpeixin.dto.api.teacher.CourseResponse;
import com.chenpeixin.model.CourseInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Mapper(componentModel = "spring")
public interface CourseAssembler {

    @Mapping(target = "name", ignore = true)
    CourseResponse toResponse(CourseInfo info);
}
