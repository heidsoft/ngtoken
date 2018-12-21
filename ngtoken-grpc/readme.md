# 通过protoc-gen-grpc-java 生产类型服务类 与 原生生成服务类 不一样
```
https://mvnrepository.com/artifact/io.grpc/protoc-gen-grpc-java/1.17.1
```

# 原生编译类
```
export DST_DIR=//Users/heidsoft/research/ngtoken/ngtoken-grpc/src/main/java
export SRC_DIR=/Users/heidsoft/research/ngtoken/ngtoken-grpc/src/main/proto
protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/User.proto
```