package com.spring.boot.config.exception.user;


import com.spring.boot.config.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author ruoyi
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("operator", code, args, null);
    }
}
