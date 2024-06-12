package com.huawei.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.mapper.UserMapper;
import com.huawei.pojo.User;
import com.huawei.service.UserService;
import com.huawei.utils.AjaxResult;
import com.huawei.utils.CryptoUtils;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/huawei")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;
    @GetMapping("/admin/user")
    public AjaxResult selectAll(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize ,User user){
        System.out.println(pageNumber+pageSize);
        PageHelper.startPage(pageNumber,pageSize);
        List<User> users = userService.selectAllUser(user);
        PageInfo<User> objectPageInfo = new PageInfo<>(users);

        return AjaxResult.success(objectPageInfo);
    }
    @GetMapping("/admin/user/{uid}")
    public AjaxResult selectOne(@PathVariable("uid") int uid){
        User user = userService.selectOneById(uid);
        return AjaxResult.success(user);
    }
    @PostMapping("/admin/user")
    public AjaxResult insert(@RequestBody User user){
        return toAjax(userService.insertUser(user));
    }
    @PutMapping("/admin/user")
    public AjaxResult update(@RequestBody User user){
        return toAjax(userService.updateUser(user));
    }
    @DeleteMapping("/admin/user/{uid}")
    public AjaxResult delect(@PathVariable("uid") int uid){
        return toAjax(userService.deleteUser(uid));
    }

    @PostMapping("/user/login")
    public AjaxResult login(@RequestBody User user){
        AjaxResult ajaxResult;
        String login = userService.login(user);
        if(login!=null){
           ajaxResult=AjaxResult.success("登录成功",login);
        }else {
            ajaxResult=AjaxResult.error("登录失败");
        }

        return ajaxResult;
    }


    @PostMapping("/user/register")
    public AjaxResult register(@RequestBody User user){
        int i = userService.insertUser(user);
        return AjaxResult.success("注册成功，3秒自动跳往登录页");
    }

    @GetMapping("/user/one")
    public AjaxResult selectOne(@RequestHeader("Token") String userId){
        Integer uid = CryptoUtils.decryptByUid(userId);
        User user = userService.selectOneById(uid);
        return AjaxResult.success(user);
    }
    @PutMapping("/user/one")
    public AjaxResult updateOne(@RequestHeader("Token") String userId ,@RequestBody User user){
        Integer uid = CryptoUtils.decryptByUid(userId);
        user.setUid(uid);
        int i = userService.updateUser(user);
        return AjaxResult.success();
    }
    @GetMapping("/admin/test")
    public void test(){
        System.out.println("hoeeo");
    }

}
