package com.chenpeixin.service.api.speciality;

import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.model.Speciality;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author chenpeixin
 * 2021-04-03
 */
public interface SpecialityService {

    /**
     * 分页获取专业列表
     */
    Page<Speciality> pageSpecialities(Pageable pageable);

    /**
     * 专业下拉值
     */
    List<Speciality> getSpeciality();

    /**
     * 获取专业详情
     */
    Speciality selectSpeciality(Long id);

    /**
     * 新增专业
     */
    void insertSpeciality(Speciality speciality);

    /**
     * 修改专业
     */
    void updateSpeciality(Speciality speciality);

    /**
     * 删除专业
     */
    void deleteSpeciality(Long id);

    /**
     * 批量删除专业
     */
    void batchDeleteSpecialities(IDSRequest request);

}
