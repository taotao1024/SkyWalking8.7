package org.apache.skywalking.oap.server.core.remote.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: RemoteService.proto")
public final class RemoteServiceGrpc {

  private RemoteServiceGrpc() {}

  public static final String SERVICE_NAME = "RemoteService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteMessage,
      org.apache.skywalking.oap.server.core.remote.grpc.proto.Empty> getCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "call",
      requestType = org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteMessage.class,
      responseType = org.apache.skywalking.oap.server.core.remote.grpc.proto.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteMessage,
      org.apache.skywalking.oap.server.core.remote.grpc.proto.Empty> getCallMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteMessage, org.apache.skywalking.oap.server.core.remote.grpc.proto.Empty> getCallMethod;
    if ((getCallMethod = RemoteServiceGrpc.getCallMethod) == null) {
      synchronized (RemoteServiceGrpc.class) {
        if ((getCallMethod = RemoteServiceGrpc.getCallMethod) == null) {
          RemoteServiceGrpc.getCallMethod = getCallMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteMessage, org.apache.skywalking.oap.server.core.remote.grpc.proto.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "call"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.oap.server.core.remote.grpc.proto.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new RemoteServiceMethodDescriptorSupplier("call"))
              .build();
        }
      }
    }
    return getCallMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RemoteServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RemoteServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RemoteServiceStub>() {
        @java.lang.Override
        public RemoteServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RemoteServiceStub(channel, callOptions);
        }
      };
    return RemoteServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RemoteServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RemoteServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RemoteServiceBlockingStub>() {
        @java.lang.Override
        public RemoteServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RemoteServiceBlockingStub(channel, callOptions);
        }
      };
    return RemoteServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RemoteServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RemoteServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RemoteServiceFutureStub>() {
        @java.lang.Override
        public RemoteServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RemoteServiceFutureStub(channel, callOptions);
        }
      };
    return RemoteServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RemoteServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteMessage> call(
        io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.core.remote.grpc.proto.Empty> responseObserver) {
      return asyncUnimplementedStreamingCall(getCallMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCallMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteMessage,
                org.apache.skywalking.oap.server.core.remote.grpc.proto.Empty>(
                  this, METHODID_CALL)))
          .build();
    }
  }

  /**
   */
  public static final class RemoteServiceStub extends io.grpc.stub.AbstractAsyncStub<RemoteServiceStub> {
    private RemoteServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RemoteServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RemoteServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteMessage> call(
        io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.core.remote.grpc.proto.Empty> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class RemoteServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RemoteServiceBlockingStub> {
    private RemoteServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RemoteServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RemoteServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class RemoteServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RemoteServiceFutureStub> {
    private RemoteServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RemoteServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RemoteServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CALL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RemoteServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RemoteServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALL:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.call(
              (io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.core.remote.grpc.proto.Empty>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RemoteServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RemoteServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.oap.server.core.remote.grpc.proto.RemoteServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RemoteService");
    }
  }

  private static final class RemoteServiceFileDescriptorSupplier
      extends RemoteServiceBaseDescriptorSupplier {
    RemoteServiceFileDescriptorSupplier() {}
  }

  private static final class RemoteServiceMethodDescriptorSupplier
      extends RemoteServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RemoteServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RemoteServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RemoteServiceFileDescriptorSupplier())
              .addMethod(getCallMethod())
              .build();
        }
      }
    }
    return result;
  }
}
