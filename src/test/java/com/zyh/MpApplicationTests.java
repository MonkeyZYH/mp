package com.zyh;

import com.zyh.dao.EmpDao;
import com.zyh.domain.emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class MpApplicationTests {
    @Autowired
    private EmpDao empDao;

    @Test
    void testSave(){
        emp emp = new emp();
        emp.setId(18);
        emp.setName("东方不败");
        emp.setAge(24);
        emp.setJob("职员");
        emp.setSalary(12000);
        emp.setEntrydate(new Date(System.currentTimeMillis()));
        emp.setManagerid(10);
        emp.setDeptId(4);
        empDao.insert(emp);
    }
    @Test
    void testDelete(){
        empDao.deleteById(18);
    }

    @Test
    void testGetById() {
        emp emp = empDao.selectById(3);
        System.out.println(emp);
    }

    @Test
    void testgetAll() {
        List<emp> userList = empDao.selectList(null);
        userList.forEach(System.out::println);
    }

}
