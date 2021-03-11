package com.lic.sharding.dao;

import com.lic.sharding.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author licong
 * @version 1.0
 * @date 2021/3/8 20:30
 */
@Mapper
public interface UserMapper {


    User findById(@Param("id") Long id);

}
