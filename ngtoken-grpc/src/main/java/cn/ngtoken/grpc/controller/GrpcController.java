package cn.ngtoken.grpc.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ngtoken
 * @description: test grpc service
 * @author: heidsoft
 * @create: 2018-12-21 14:31
 **/
@RestController
public class GrpcController {

    @GetMapping("/grpc")
    public String restGrpc() throws InvalidProtocolBufferException {
        //转为json数据
        return "";
    }

}
