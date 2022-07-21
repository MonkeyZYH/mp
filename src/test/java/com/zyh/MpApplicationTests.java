package com.zyh;

import com.zyh.dao.EmpDao;
import com.zyh.domain.emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MpApplicationTests {
    @Autowired
    private EmpDao empDao;

    @Test
    void testgetAll() {
        List<emp> userList = empDao.selectList(null);
        userList.forEach(System.out::println);
    }

}
