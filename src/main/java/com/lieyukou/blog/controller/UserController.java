//package com.lieyukou.blog.controller;
//
//import cn.hutool.core.util.StrUtil;
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.Wrappers;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import com.lieyukou.blog.common.Result;
//import com.lieyukou.blog.mapper.UserMapper;
//import com.lieyukou.blog.pojo.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("user")
//public class UserController {
//    @Autowired
//    private UserMapper userMapper;
//
//    @PostMapping("")
//    public Result<?> save(@RequestBody User user){
//        if (user.getPassword() == null){
//            user.setPassword("123456");
//        }
//        if (user.getId() == null){
//        userMapper.insert(user);
//        }
//        if (user.getId() != null){
//            userMapper.updateById(user);
//
//        }
//
//        return Result.success();
//    }
//    @DeleteMapping("{id}")
//    public Result<?> deleteById(@PathVariable Long id){
//        userMapper.deleteById(id);
//        return Result.success();
//    }
//    @PostMapping("/login")
//    public Result<?> login(@RequestBody User user){
//        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()).eq(User::getPassword, user.getPassword()));
//        if(res == null){
//            return Result.error("-1","用户名或密码错误");
//        }
//        return Result.success();
//    }
//    @PostMapping("/register")
//    public Result<?> register(@RequestBody User user){
//        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
//        if (res != null) {
//            return Result.error("-1","用户名重复");
//        }
//        if (user.getPassword() == null) {
//            user.setPassword("123456");
//        }
//        userMapper.insert(user);
//        System.out.println("....................");
//        return Result.success();
//        }
//
//    @GetMapping("")
//    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
//                              @RequestParam(defaultValue = "10") Integer pageSize,
//                              @RequestParam(defaultValue = "") String search) {
//        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
//        if (StrUtil.isNotBlank(search)){
//            wrapper.like(User::getNickName, search);
//        }
//        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize),wrapper );
//        return Result.success(userPage);
//
//    }
//
//
//}
