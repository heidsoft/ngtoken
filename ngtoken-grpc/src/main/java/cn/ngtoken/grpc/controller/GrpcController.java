package cn.ngtoken.grpc.controller;

import cn.ngtoken.grpc.service.UserServiceImpl;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
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
        UserServiceImpl.UserRequest.Builder userRequestBuilder = UserServiceImpl.UserRequest.newBuilder();
        userRequestBuilder.setAge(20);
        userRequestBuilder.setName("jake");

        UserServiceImpl.UserRequest userRequest = userRequestBuilder.build();

        System.out.println(userRequest.toString());

        //转为json数据
        return JsonFormat.printer().print(userRequest);
    }
}
