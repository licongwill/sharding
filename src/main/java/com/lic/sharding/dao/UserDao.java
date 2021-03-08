package com.lic.sharding.dao;

import com.lic.sharding.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author licong
 * @version 1.0
 * @date 2021/3/8 20:30
 */
@Component
public class UserDao {

    @Autowired
    private SqlSession sqlSession;

    public User findById(Long id){
        User user = (User)sqlSession.selectOne("findById", id);
        return user;
    }
}
