package com.ngtoken.dubbo.provider;

import com.ngtoken.dubbo.api.IUserService;

import java.util.Date;

public class UserService implements IUserService {
    @Override
    public String sayHi(String name) {
        return "Hi " + name + " this dubbo service impl "+ new Date();
    }
}
