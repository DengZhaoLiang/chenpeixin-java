package com.chenpeixin.assembler;

import com.chenpeixin.model.Teacher;
import com.chenpeixin.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author chenpeixin
 * 2021-01-31
 */
@Mapper(componentModel = "spring")
public interface TeacherAssembler {

    @Mapping(target = "number", ignore = true)
    @Mapping(target = "specialityId", ignore = true)
    @Mapping(target = "portfolioId", ignore = true)
    User toUser(Teacher teacher);
}
