package com.chenpeixin.service.api.semester;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.chenpeixin.dto.IDSRequest;
import com.chenpeixin.mapper.SemesterMapper;
import com.chenpeixin.model.Semester;
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
public class SemesterServiceImpl implements SemesterService {

    @Autowired
    private SemesterMapper mSemesterMapper;

    @Override
    public Page<Semester> pageSemesters(Pageable pageable) {
        PageRequest page = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
        QueryWrapper<Semester> wrapper = new QueryWrapper<>();
        List<Semester> semesters = mSemesterMapper.selectList(wrapper);
        return new PageImpl<>(semesters.stream()
                .skip((page.getPageNumber()) * page.getPageSize())
                .limit(page.getPageSize())
                .collect(Collectors.toList()), page, semesters.size());
    }

    @Override
    public Semester selectSemester(Long id) {
        return mSemesterMapper.selectById(id);
    }

    @Override
    public void insertSemester(Semester semester) {
        mSemesterMapper.insert(semester);
    }

    @Override
    public void updateSemester(Semester semester) {
        UpdateWrapper<Semester> wrapper = new UpdateWrapper<>();
        wrapper.set(Strings.isNotBlank(semester.getName()), "name", semester.getName());
        semester.setUpdatedAt(Instant.now().getEpochSecond());
        wrapper.eq("id", semester.getId());
        mSemesterMapper.update(semester, wrapper);
    }

    @Override
    public void deleteSemester(Long id) {
        mSemesterMapper.deleteById(id);
    }

    @Override
    public void batchDeleteSemester(IDSRequest request) {
        mSemesterMapper.deleteBatchIds(request.getIds());
    }
}
