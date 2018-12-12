package cn.ngtoken.kong.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ngtoken
 * @description: 测试kong
 * @author: heidsoft
 * @create: 2018-12-10 12:59
 **/
@RestController
@RequestMapping("/api")
public class KongController {

//    @GetMapping("/")
//    public void handleRequest() {
//        throw new RuntimeException("test exception");
//    }

    /**
     * https://stackoverflow.com/questions/44839753/returning-json-object-as-response-in-spring-boot
     * @return
     */
    @GetMapping("/json")
    public ResponseEntity<Object> getJsonResponseEntity() {

        List<JSONObject> entities = new ArrayList<>();
        JSONObject entity = new JSONObject();
        entity.put("aa", "bb");
        entities.add(entity);

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }

}
