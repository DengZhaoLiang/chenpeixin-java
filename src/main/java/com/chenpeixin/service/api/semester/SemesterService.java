package com.chenpeixin.service.api.semester;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.model.Semester;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author chenpeixin
 * 2021-04-03
 */
public interface SemesterService {

    /**
     * 分页获取学期
     */
    Page<Semester> pageSemesters(Pageable pageable);

    /**
     * 获取学期详情
     */
    Semester selectSemester(Long id);

    /**
     * 新增学期
     */
    void insertSemester(Semester semester);

    /**
     * 修改学期
     */
    void updateSemester(Semester semester);

    /**
     * 删除学期
     */
    void deleteSemester(Long id);

    /**
     * 批量删除学期
     */
    void batchDeleteSemester(IDSRequest request);
}
