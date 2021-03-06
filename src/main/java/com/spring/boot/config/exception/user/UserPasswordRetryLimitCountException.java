package com.spring.boot.config.exception.user;

/**
 * 用户错误记数异常类
 * 
 * @author ruoyi
 */
public class UserPasswordRetryLimitCountException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitCountException(int retryLimitCount)
    {
        super("operator.password.retry.limit.count", new Object[] { retryLimitCount });
    }
}
