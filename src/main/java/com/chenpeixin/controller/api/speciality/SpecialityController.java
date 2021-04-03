package com.chenpeixin.controller.api.speciality;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.model.Speciality;
import com.chenpeixin.service.api.speciality.SpecialityService;
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
@RequestMapping("/api/speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService mSpecialityService;

    @GetMapping("")
    public Page<Speciality> pageSpecialities(Pageable pageable) {
        return mSpecialityService.pageSpecialities(pageable);
    }

    @PostMapping("")
    public void insertSpeciality(@RequestBody @Validated Speciality speciality) {
        mSpecialityService.insertSpeciality(speciality);
    }

    @PutMapping("")
    public void updateSpeciality(@RequestBody @Validated Speciality speciality) {
        mSpecialityService.updateSpeciality(speciality);
    }

    @DeleteMapping("/{id}")
    public void deleteSpeciality(@PathVariable Long id) {
        mSpecialityService.deleteSpeciality(id);
    }

    @DeleteMapping("/batch")
    public void batchDeleteSpecialities(@RequestBody @Validated IDSRequest request) {
        mSpecialityService.batchDeleteSpecialities(request);
    }
}
