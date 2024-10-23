package org.apache.skywalking.oap.server.core.alarm.grpc;

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
    comments = "Source: alarm-hook.proto")
public final class AlarmServiceGrpc {

  private AlarmServiceGrpc() {}

  public static final String SERVICE_NAME = "AlarmService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.core.alarm.grpc.AlarmMessage,
      org.apache.skywalking.oap.server.core.alarm.grpc.Response> getDoAlarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "doAlarm",
      requestType = org.apache.skywalking.oap.server.core.alarm.grpc.AlarmMessage.class,
      responseType = org.apache.skywalking.oap.server.core.alarm.grpc.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.core.alarm.grpc.AlarmMessage,
      org.apache.skywalking.oap.server.core.alarm.grpc.Response> getDoAlarmMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.core.alarm.grpc.AlarmMessage, org.apache.skywalking.oap.server.core.alarm.grpc.Response> getDoAlarmMethod;
    if ((getDoAlarmMethod = AlarmServiceGrpc.getDoAlarmMethod) == null) {
      synchronized (AlarmServiceGrpc.class) {
        if ((getDoAlarmMethod = AlarmServiceGrpc.getDoAlarmMethod) == null) {
          AlarmServiceGrpc.getDoAlarmMethod = getDoAlarmMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.oap.server.core.alarm.grpc.AlarmMessage, org.apache.skywalking.oap.server.core.alarm.grpc.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "doAlarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.oap.server.core.alarm.grpc.AlarmMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.oap.server.core.alarm.grpc.Response.getDefaultInstance()))
              .setSchemaDescriptor(new AlarmServiceMethodDescriptorSupplier("doAlarm"))
              .build();
        }
      }
    }
    return getDoAlarmMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AlarmServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlarmServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlarmServiceStub>() {
        @java.lang.Override
        public AlarmServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlarmServiceStub(channel, callOptions);
        }
      };
    return AlarmServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlarmServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlarmServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlarmServiceBlockingStub>() {
        @java.lang.Override
        public AlarmServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlarmServiceBlockingStub(channel, callOptions);
        }
      };
    return AlarmServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AlarmServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlarmServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AlarmServiceFutureStub>() {
        @java.lang.Override
        public AlarmServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AlarmServiceFutureStub(channel, callOptions);
        }
      };
    return AlarmServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AlarmServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.core.alarm.grpc.AlarmMessage> doAlarm(
        io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.core.alarm.grpc.Response> responseObserver) {
      return asyncUnimplementedStreamingCall(getDoAlarmMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDoAlarmMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                org.apache.skywalking.oap.server.core.alarm.grpc.AlarmMessage,
                org.apache.skywalking.oap.server.core.alarm.grpc.Response>(
                  this, METHODID_DO_ALARM)))
          .build();
    }
  }

  /**
   */
  public static final class AlarmServiceStub extends io.grpc.stub.AbstractAsyncStub<AlarmServiceStub> {
    private AlarmServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlarmServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlarmServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.core.alarm.grpc.AlarmMessage> doAlarm(
        io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.core.alarm.grpc.Response> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getDoAlarmMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class AlarmServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AlarmServiceBlockingStub> {
    private AlarmServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlarmServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlarmServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class AlarmServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AlarmServiceFutureStub> {
    private AlarmServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlarmServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlarmServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_DO_ALARM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AlarmServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AlarmServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_DO_ALARM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.doAlarm(
              (io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.core.alarm.grpc.Response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AlarmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlarmServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.oap.server.core.alarm.grpc.AlarmHook.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlarmService");
    }
  }

  private static final class AlarmServiceFileDescriptorSupplier
      extends AlarmServiceBaseDescriptorSupplier {
    AlarmServiceFileDescriptorSupplier() {}
  }

  private static final class AlarmServiceMethodDescriptorSupplier
      extends AlarmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AlarmServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AlarmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AlarmServiceFileDescriptorSupplier())
              .addMethod(getDoAlarmMethod())
              .build();
        }
      }
    }
    return result;
  }
}
