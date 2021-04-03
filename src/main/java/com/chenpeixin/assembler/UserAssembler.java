package com.chenpeixin.assembler;

import com.chenpeixin.model.Student;
import com.chenpeixin.model.Teacher;
import com.chenpeixin.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author chenpeixin
 * 2021-01-31
 */
@Mapper(componentModel = "spring")
public interface UserAssembler {

    @Mapping(target = "speciality", ignore = true)
    Teacher toTeacher(User user);

    @Mapping(target = "speciality", ignore = true)
    @Mapping(target = "grade", ignore = true)
    @Mapping(target = "clbum", ignore = true)
    Student toStudent(User user);
}
