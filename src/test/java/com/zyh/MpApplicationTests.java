package com.zyh;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    void testGetByPage(){
        IPage page=new Page(1,3);
        empDao.selectPage(page,null);
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("一共多少页："+page.getPages());
        System.out.println("一共多少条数据："+page.getTotal());
        System.out.println("数据："+page.getRecords());

    }

    @Test
    void testgetAll() {
        List<emp> userList = empDao.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void testgetAll1() {
        //方式一：按条件查询
//        QueryWrapper wrapper = new QueryWrapper();
//        wrapper.gt("age",33);
//        List<emp> userList = empDao.selectList(wrapper);
//        userList.forEach(System.out::println);

        //方式二：Lambda格式按条件查询
//        QueryWrapper<emp> wrapper = new QueryWrapper();
//        wrapper.lambda().gt(emp::getAge,33);
//        List<emp> userList = empDao.selectList(wrapper);
//        userList.forEach(System.out::println);

        //方式三：Lambda格式按条件查询（推荐使用这种）
        LambdaQueryWrapper<emp> wrapper=new LambdaQueryWrapper<>();
//        wrapper.gt(emp::getAge,33).lt(emp::getAge,60);//多条件查询and关系
        wrapper.gt(emp::getAge,33).or().lt(emp::getAge,60);//多条件查询or关系
        List<emp> emps = empDao.selectList(wrapper);
        System.out.println(emps);
    }

    @Test
    void testgetAll2() {
        //查询投影
        LambdaQueryWrapper<emp> wrapper=new LambdaQueryWrapper<>();
        wrapper.select(emp::getId,emp::getName,emp::getAge,emp::getJob);
        List<emp> emps = empDao.selectList(wrapper);
        System.out.println(emps);
    }

}
