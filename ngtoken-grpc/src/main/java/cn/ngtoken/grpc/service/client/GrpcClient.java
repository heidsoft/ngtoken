package cn.ngtoken.grpc.service.client;

import cn.ngtoken.grpc.service.HelloRequest;
import cn.ngtoken.grpc.service.HelloResponse;
import cn.ngtoken.grpc.service.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 18888)
          .usePlaintext()
          .build();
 
        HelloServiceGrpc.HelloServiceBlockingStub stub
          = HelloServiceGrpc.newBlockingStub(channel);
 
        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
          .setFirstName("Baeldung")
          .setLastName("gRPC")
          .build());
        System.out.println(helloResponse.getGreeting());
        channel.shutdown();
    }
}