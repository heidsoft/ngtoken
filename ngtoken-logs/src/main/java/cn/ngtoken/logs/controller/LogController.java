package cn.ngtoken.logs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ngtoken
 * @description: 日志测试
 * @author: heidsoft
 * @create: 2018-12-12 16:12
 **/
@RestController
@Slf4j
public class LogController {

    @RequestMapping("/")
    public String log(){
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
        return "log controller";
    }
}
