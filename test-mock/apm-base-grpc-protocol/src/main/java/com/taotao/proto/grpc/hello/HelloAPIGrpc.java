package com.taotao.proto.grpc.hello;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.44.0)",
    comments = "Source: hello.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HelloAPIGrpc {

  private HelloAPIGrpc() {}

  public static final String SERVICE_NAME = "hello.HelloAPI";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.taotao.proto.grpc.hello.HelloRequest,
      com.taotao.proto.grpc.hello.HelloResponse> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = com.taotao.proto.grpc.hello.HelloRequest.class,
      responseType = com.taotao.proto.grpc.hello.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.taotao.proto.grpc.hello.HelloRequest,
      com.taotao.proto.grpc.hello.HelloResponse> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.taotao.proto.grpc.hello.HelloRequest, com.taotao.proto.grpc.hello.HelloResponse> getSayHelloMethod;
    if ((getSayHelloMethod = HelloAPIGrpc.getSayHelloMethod) == null) {
      synchronized (HelloAPIGrpc.class) {
        if ((getSayHelloMethod = HelloAPIGrpc.getSayHelloMethod) == null) {
          HelloAPIGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<com.taotao.proto.grpc.hello.HelloRequest, com.taotao.proto.grpc.hello.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.taotao.proto.grpc.hello.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.taotao.proto.grpc.hello.HelloResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HelloAPIMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloAPIStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloAPIStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloAPIStub>() {
        @java.lang.Override
        public HelloAPIStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloAPIStub(channel, callOptions);
        }
      };
    return HelloAPIStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloAPIBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloAPIBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloAPIBlockingStub>() {
        @java.lang.Override
        public HelloAPIBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloAPIBlockingStub(channel, callOptions);
        }
      };
    return HelloAPIBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloAPIFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HelloAPIFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HelloAPIFutureStub>() {
        @java.lang.Override
        public HelloAPIFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HelloAPIFutureStub(channel, callOptions);
        }
      };
    return HelloAPIFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HelloAPIImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(com.taotao.proto.grpc.hello.HelloRequest request,
        io.grpc.stub.StreamObserver<com.taotao.proto.grpc.hello.HelloResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.taotao.proto.grpc.hello.HelloRequest,
                com.taotao.proto.grpc.hello.HelloResponse>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class HelloAPIStub extends io.grpc.stub.AbstractAsyncStub<HelloAPIStub> {
    private HelloAPIStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloAPIStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloAPIStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(com.taotao.proto.grpc.hello.HelloRequest request,
        io.grpc.stub.StreamObserver<com.taotao.proto.grpc.hello.HelloResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HelloAPIBlockingStub extends io.grpc.stub.AbstractBlockingStub<HelloAPIBlockingStub> {
    private HelloAPIBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloAPIBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloAPIBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.taotao.proto.grpc.hello.HelloResponse sayHello(com.taotao.proto.grpc.hello.HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HelloAPIFutureStub extends io.grpc.stub.AbstractFutureStub<HelloAPIFutureStub> {
    private HelloAPIFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloAPIFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HelloAPIFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.taotao.proto.grpc.hello.HelloResponse> sayHello(
        com.taotao.proto.grpc.hello.HelloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloAPIImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloAPIImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.taotao.proto.grpc.hello.HelloRequest) request,
              (io.grpc.stub.StreamObserver<com.taotao.proto.grpc.hello.HelloResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HelloAPIBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloAPIBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.taotao.proto.grpc.hello.HelloWorldServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HelloAPI");
    }
  }

  private static final class HelloAPIFileDescriptorSupplier
      extends HelloAPIBaseDescriptorSupplier {
    HelloAPIFileDescriptorSupplier() {}
  }

  private static final class HelloAPIMethodDescriptorSupplier
      extends HelloAPIBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloAPIMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HelloAPIGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloAPIFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
