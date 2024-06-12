package com.huawei.controller;

import com.huawei.utils.AjaxResult;
import com.huawei.utils.CryptoUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 通用数据处理层
 */
@Controller
public class BaseController {
    private  String userToken;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    /**
     * 返回成功消息
     * @return
     */
    public AjaxResult success()
    {
        return AjaxResult.success();
    }
    /**
     * 返回失败消息
     */
    public AjaxResult error()
    {
        return AjaxResult.error();
    }
    /**
     * 返回成功消息
     */
    public AjaxResult success(String message)
    {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    public AjaxResult error(String message)
    {
        return AjaxResult.error(message);
    }
    /**
     * 响应返回结果
     *
     * @param rows 影响行数
     * @return 操作结果
     */
    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }
    /**
     * 响应返回结果
     *
     * @param result 结果
     * @return 操作结果
     */
    protected AjaxResult toAjax(boolean result)
    {
        return result ? success() : error();
    }

    /**
     * 获取请求头
     * @param
     * @return
     */
    public  int getUid(){
        return CryptoUtils.decryptByUid(getUserToken());
    }


}
