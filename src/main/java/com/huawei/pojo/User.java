package com.huawei.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;

    private String userPhone;

    private String userName;

    private String userPassword;

    private String userImg;

    private String userAge;

    private int userSex;
}
