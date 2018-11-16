package com.liuhx.apidemo.model.form;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserEditForm {

    // 普通用户修改验证组
    public interface CustomUserEditGroup {
    }

    // 管理员用户修改验证组
    public interface ManagerUserEditGroup {
    }

    @Size(min = 2, max = 50, message = "用户名长度必须为 2-50 个字符")
    private String name;
    @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "手机号不正确")
    private String mobile;
    @Range(min = 18, max = 150)
    private Integer age;
    private String address;
    @Email
    @Null(groups = {CustomUserEditGroup.class}) // 普通用户修改不允许修改邮箱
    private String email;

}
