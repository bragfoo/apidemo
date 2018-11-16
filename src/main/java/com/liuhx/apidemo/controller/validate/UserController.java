package com.liuhx.apidemo.controller.validate;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuhx.apidemo.model.form.UserAddForm;
import com.liuhx.apidemo.model.form.UserEditForm;
import com.liuhx.apidemo.model.po.User;
import com.liuhx.apidemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("save")
    public User add(@Validated UserAddForm userAddForm) {
        log.info("参数内容：{}", userAddForm);

        // 转换成User对象，保存到数据库
        User user = new User();
        BeanUtils.copyProperties(userAddForm, user);
        user.setUserNo(RandomStringUtils.randomAlphanumeric(16));
        // 保存到数据库
        userService.save(user);
        // 返回
        return user;
    }

    /**
     * 用户信息修改（普通），根据不同的组进行不同的数据验证
     *
     * @param userEditForm 表单信息
     */
    @PatchMapping("custom")
    public void customEdit(@Validated(UserEditForm.CustomUserEditGroup.class) UserEditForm userEditForm) {

    }

    /**
     * 用户信息修改（管理员），根据不同的组进行不同的数据验证
     *
     * @param userEditForm 表单信息
     */
    @PatchMapping("manager")
    public void managerEdit(@Validated(UserEditForm.ManagerUserEditGroup.class) UserEditForm userEditForm) {

    }

    @GetMapping("findAll")
    public List<User> findAllUser() {
        return userService.list(new QueryWrapper<>());
    }

    @GetMapping("findById")
    public User findById(String userId) {
        return userService.getOne(new QueryWrapper<User>().eq("userId", userId));
    }

}
