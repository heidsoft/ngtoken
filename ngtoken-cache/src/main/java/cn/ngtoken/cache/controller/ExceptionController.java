package cn.ngtoken.cache.controller;

import cn.ngtoken.cache.execption.StudentNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ngtoken
 * @description: 异常测试
 * @author: heidsoft
 * @create: 2018-12-24 11:15
 **/
@RestController
@RequestMapping("/test")
public class ExceptionController {

    @RequestMapping("/ex")
    public void restTest() {
        throw new StudentNotFoundException("not student....");
    }
}
