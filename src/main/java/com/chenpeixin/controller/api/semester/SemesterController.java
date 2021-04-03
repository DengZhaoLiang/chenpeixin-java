package com.chenpeixin.controller.api.semester;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.model.Semester;
import com.chenpeixin.service.api.semester.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Validated
@RestController
@RequestMapping("/api/semester")
public class SemesterController {

    @Autowired
    private SemesterService mSemesterService;

    @GetMapping("")
    public Page<Semester> pageSemesters(Pageable pageable) {
        return mSemesterService.pageSemesters(pageable);
    }

    @GetMapping("/{id}")
    public Semester selectSemester(@PathVariable Long id) {
        return mSemesterService.selectSemester(id);
    }

    @PostMapping("")
    public void insertSemester(@RequestBody @Validated Semester semester) {
        mSemesterService.insertSemester(semester);
    }

    @PutMapping("")
    public void updateSemester(@RequestBody @Validated Semester semester) {
        mSemesterService.updateSemester(semester);
    }

    @DeleteMapping("/{id}")
    public void deleteSemester(@PathVariable Long id) {
        mSemesterService.deleteSemester(id);
    }

    @DeleteMapping("/batch")
    public void batchDeleteSemester(@RequestBody @Validated IDSRequest request) {
        mSemesterService.batchDeleteSemester(request);
    }
}
