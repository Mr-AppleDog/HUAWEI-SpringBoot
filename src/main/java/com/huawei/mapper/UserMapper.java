package com.huawei.mapper;

import com.huawei.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAllUser(User user);

    /**
     * 根据手机号查询
     * @param userPhone
     * @return
     */
    User selectUserOne(String userPhone);

    /**
     * 根据id查
     * @param uid
     * @return
     */
    User selectUserById(Integer uid);

    /**
     * 根据id删除
     * @param uid
     * @return
     */
    int deleteUser(int uid);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);

}
