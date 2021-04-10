package com.chenpeixin.service.api.speciality;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.mapper.SpecialityMapper;
import com.chenpeixin.model.Speciality;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenpeixin
 * 2021-04-03
 */
@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityMapper mSpecialityMapper;

    @Override
    public Page<Speciality> pageSpecialities(Pageable pageable) {
        PageRequest page = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
        QueryWrapper<Speciality> wrapper = new QueryWrapper<>();
        List<Speciality> specialities = mSpecialityMapper.selectList(wrapper);
        return new PageImpl<>(specialities.stream()
                .skip((page.getPageNumber()) * page.getPageSize())
                .limit(page.getPageSize())
                .collect(Collectors.toList()), page, specialities.size());
    }

    @Override
    public List<Speciality> getSpeciality() {
        QueryWrapper<Speciality> wrapper = new QueryWrapper<>();
        return mSpecialityMapper.selectList(wrapper);
    }

    @Override
    public Speciality selectSpeciality(Long id) {
        return mSpecialityMapper.selectById(id);
    }

    @Override
    public void insertSpeciality(Speciality speciality) {
        mSpecialityMapper.insert(speciality);
    }

    @Override
    public void updateSpeciality(Speciality speciality) {
        UpdateWrapper<Speciality> wrapper = new UpdateWrapper<>();
        wrapper.set(Strings.isNotBlank(speciality.getName()), "name", speciality.getName());
        speciality.setUpdatedAt(Instant.now().getEpochSecond());
        wrapper.eq("id", speciality.getId());
        mSpecialityMapper.update(speciality, wrapper);
    }

    @Override
    public void deleteSpeciality(Long id) {
        mSpecialityMapper.deleteById(id);
    }

    @Override
    public void batchDeleteSpecialities(IDSRequest request) {
        mSpecialityMapper.deleteBatchIds(request.getIds());
    }
}
