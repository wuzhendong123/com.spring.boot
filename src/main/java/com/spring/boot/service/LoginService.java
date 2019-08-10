package com.spring.boot.service;

import com.spring.boot.entity.Operator;

public interface LoginService {
    Operator login(String username, String password);
}
