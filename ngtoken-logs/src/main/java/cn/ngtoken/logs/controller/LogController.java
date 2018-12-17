package cn.ngtoken.logs.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
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
    Logger logger = LoggerFactory.getLogger(LogController.class);

    private volatile int count = 0;

    @GetMapping("/log")
    public String logMessage(){
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return "log controller";
    }

    @GetMapping("/index")
    public String index(){
        logger.info("start count {}",count);
        synchronized (this){
            count++;
        }
        logger.info("end count {}",count);
        return "hello";
    }

    @GetMapping("/index2")
    public String index2(){
        logger.info("start count {}",count);
        count++;
        logger.info("end count {}",count);
        return "hello";
    }


}
