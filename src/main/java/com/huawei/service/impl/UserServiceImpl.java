package com.huawei.service.impl;

import com.huawei.pojo.User;

import java.util.List;

public interface UserServiceImpl {
    /**
     * 查询所有用户
     * 动态sql
     * @return
     */
    List<User> selectAllUser(User user);

    /**
     * 根据手机号查询一个
     * @param userPhone
     * @return
     */
    User selectOneUser(String userPhone);

    /**
     * 根据id查
     * @param uid
     * @return
     */
    User selectOneById(Integer uid);

    /**
     * 根据手机号删除
     * @param uid
     * @return
     */
    int deleteUser(int uid);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    String login(User user) throws Exception;

    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);
}
