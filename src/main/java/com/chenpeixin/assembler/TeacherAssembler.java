package com.chenpeixin.assembler;

import com.chenpeixin.model.Teacher;
import com.chenpeixin.model.User;
import org.mapstruct.Mapper;

/**
 * @author chenpeixin
 * 2021-01-31
 */
@Mapper(componentModel = "spring")
public interface TeacherAssembler {

    User toUser(Teacher teacher);
}
