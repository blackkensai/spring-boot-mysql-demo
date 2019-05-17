package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    private String getRandomString(int length) {
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        //长度为几就循环几次
        for (int i = 0; i < length; ++i) {
            //产生0-61的数字
            int number = random.nextInt(str.length());
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

    public User getById(String id) {
        return userMapper.getById(id);
    }

    public void create(User user) {
        userMapper.create(user);
    }

    public User createRandomUser() {
        User user = new User(UUID.randomUUID().toString(), getRandomString(8), getRandomString(2), getRandomString(16));
        userMapper.create(user);
        return user;
    }
}
