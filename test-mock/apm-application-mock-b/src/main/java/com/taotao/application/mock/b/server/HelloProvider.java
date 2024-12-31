package com.taotao.application.mock.b.server;

import com.taotao.proto.grpc.hello.HelloAPIGrpc;
import com.taotao.proto.grpc.hello.HelloRequest;
import com.taotao.proto.grpc.hello.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloProvider extends HelloAPIGrpc.HelloAPIImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String message = "Hello, " + request.getName();
        System.out.println("我被调用了: " + message);
        HelloResponse build = HelloResponse.newBuilder()
                .setMessage(message)
                .build();
        responseObserver.onNext(build);
        responseObserver.onCompleted();
    }
}
