package com.chenpeixin.assembler;

import com.chenpeixin.model.Student;
import com.chenpeixin.model.User;
import org.mapstruct.Mapper;

/**
 * @author chenpeixin
 * 2021-01-31
 */
@Mapper(componentModel = "spring")
public interface StudentAssembler {

    User toUser(Student student);
}
