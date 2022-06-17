package net.biancheng.c.service;

import net.biancheng.c.entity.Dept;
import java.util.List;

public interface DeptService {

    Dept get(Integer deptNo);

    List<Dept> selectAll();

    void addNewMember(Integer deptNo, String deptName, String dbSource);

}