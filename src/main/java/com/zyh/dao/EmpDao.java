package com.zyh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyh.domain.emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpDao extends BaseMapper<emp> {

}
