package com.spring.boot.service.impl;

import com.spring.boot.config.exception.user.UserNotExistsException;
import com.spring.boot.entity.Operator;
import com.spring.boot.service.IOperatorService;
import com.spring.boot.service.LoginService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-30 11:00
 **/
@Service
public class loginServiceImpl implements LoginService {
    static  String salt="123456";

    @Autowired
    private IOperatorService operatorService;
    @Override
    public Operator login(String username, String password) {
        Operator operator= operatorService.findByNameByPass(username,encryptPassword(password));
        if(operator==null){
         throw new UserNotExistsException();
        }
        return operator;

    }
    public String encryptPassword(String username, String password, String salt)
    {
        return new Md5Hash(username + password + salt).toHex().toString();
    }
    public String encryptPassword(String password)
    {
        return new Md5Hash( password + salt).toHex().toString();
    }
}
