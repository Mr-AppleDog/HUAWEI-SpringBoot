package com.huawei.controller;

import com.huawei.utils.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestsController {
    @RequestMapping("/hello")
    public AjaxResult hello(){
        return AjaxResult.success(AjaxResult.DATA_TAG,"/static/img/matebook-14s.ff0c970f.jpg");
    }
}
