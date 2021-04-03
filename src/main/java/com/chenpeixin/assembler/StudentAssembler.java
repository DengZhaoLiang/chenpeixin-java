package com.chenpeixin.assembler;

import com.chenpeixin.model.Portfolio;
import com.chenpeixin.model.Student;
import com.chenpeixin.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author chenpeixin
 * 2021-01-31
 */
@Mapper(componentModel = "spring")
public interface StudentAssembler {

    User toUser(Student student);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "grade", ignore = true)
    @Mapping(target = "specialityId", ignore = true)
    @Mapping(target = "clbum", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Student toStudent(Portfolio portfolio, Student student);
}
