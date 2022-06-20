package net.biancheng.c.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.biancheng.c.entity.Dept;
import net.biancheng.c.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务提供者的控制层
 * author:c语言中文网 c.biancheng.net
 */
@RestController
@Slf4j
public class DeptController {
    @Autowired
    private DeptService deptService;


    @Value("${server.port}")
    private String serverPort;

    @ApiOperation(value="people's id",notes = "Find a member by its deptNo")
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") int id) {
        return deptService.get(id);
    }

    @ApiOperation(value = "list all members",notes = "Display all s")
    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.selectAll();
    }
    @ApiOperation(value="add new member",notes = "Add a new member by inputting deptNo, deptName and dbSource")
    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public void addNewMember(Integer deptNo, String deptName, String dbSource) {
        deptService.addNewMember(deptNo, deptName, dbSource);
    }

}