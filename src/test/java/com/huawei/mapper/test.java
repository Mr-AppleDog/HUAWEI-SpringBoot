package com.huawei.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.pojo.User;
import com.huawei.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class test {
    @Autowired
    private UserService userService;
    @Test
    public void te(){
        List<User> users = userService.selectAllUser(new User());
        PageHelper.startPage(1,3);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        System.out.println(userPageInfo);
    }

}
