package cn.ngtoken.grpc.service.server;

import cn.ngtoken.grpc.service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    public static void main(String[] args) throws Exception{
        Server server = ServerBuilder
          .forPort(18888)
          .addService(new HelloServiceImpl()).build();
 
        server.start();
        server.awaitTermination();
    }
}