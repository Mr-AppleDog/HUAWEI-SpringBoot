package com.huawei.service;

import com.huawei.mapper.UserMapper;
import com.huawei.pojo.User;
import com.huawei.service.impl.UserServiceImpl;
import com.huawei.utils.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserServiceImpl {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> selectAllUser(User user) {
        return userMapper.selectAllUser(user);
    }

    @Override
    public User selectOneUser(String userPhone) {
        return userMapper.selectUserOne(userPhone);
    }

    @Override
    public User selectOneById(Integer uid) {
        return userMapper.selectUserById(uid);
    }

    @Override
    public int deleteUser(int  uid) {
        return userMapper.deleteUser(uid);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public String login(User user)  {
        //查询手机号对应的用户
        User user1 = userMapper.selectUserOne(user.getUserPhone());
        if(user.getUserPassword().equals(user1.getUserPassword())){
            //加密返回uid
            try {
                return CryptoUtils.encrypt(String.valueOf(user1.getUid()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int register(User user) {
        return 0;
    }
}
