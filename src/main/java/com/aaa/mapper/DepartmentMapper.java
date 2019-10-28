package com.aaa.mapper;

import com.aaa.entity.Departments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<Departments> departmentList(Departments departments);
    int deleteDepartment(Integer departmentId);
    int addDepartment(Departments departments);
    int edit(Departments departments);
}