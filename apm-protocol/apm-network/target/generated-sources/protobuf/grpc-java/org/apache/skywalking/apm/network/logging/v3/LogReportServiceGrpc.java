package org.apache.skywalking.apm.network.logging.v3;

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
 * <pre>
 * Report collected logs into the OAP backend
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: logging/Logging.proto")
public final class LogReportServiceGrpc {

  private LogReportServiceGrpc() {}

  public static final String SERVICE_NAME = "skywalking.v3.LogReportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.logging.v3.LogData,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collect",
      requestType = org.apache.skywalking.apm.network.logging.v3.LogData.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.logging.v3.LogData,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.logging.v3.LogData, org.apache.skywalking.apm.network.common.v3.Commands> getCollectMethod;
    if ((getCollectMethod = LogReportServiceGrpc.getCollectMethod) == null) {
      synchronized (LogReportServiceGrpc.class) {
        if ((getCollectMethod = LogReportServiceGrpc.getCollectMethod) == null) {
          LogReportServiceGrpc.getCollectMethod = getCollectMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.logging.v3.LogData, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "collect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.logging.v3.LogData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new LogReportServiceMethodDescriptorSupplier("collect"))
              .build();
        }
      }
    }
    return getCollectMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LogReportServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogReportServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogReportServiceStub>() {
        @java.lang.Override
        public LogReportServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogReportServiceStub(channel, callOptions);
        }
      };
    return LogReportServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LogReportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogReportServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogReportServiceBlockingStub>() {
        @java.lang.Override
        public LogReportServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogReportServiceBlockingStub(channel, callOptions);
        }
      };
    return LogReportServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LogReportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LogReportServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<LogReportServiceFutureStub>() {
        @java.lang.Override
        public LogReportServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new LogReportServiceFutureStub(channel, callOptions);
        }
      };
    return LogReportServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Report collected logs into the OAP backend
   * </pre>
   */
  public static abstract class LogReportServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Recommend to report log data in a stream mode.
     * The service/instance/endpoint of the log could share the previous value if they are not set.
     * Reporting the logs of same service in the batch mode could reduce the network cost.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.logging.v3.LogData> collect(
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      return asyncUnimplementedStreamingCall(getCollectMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCollectMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.logging.v3.LogData,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_COLLECT)))
          .build();
    }
  }

  /**
   * <pre>
   * Report collected logs into the OAP backend
   * </pre>
   */
  public static final class LogReportServiceStub extends io.grpc.stub.AbstractAsyncStub<LogReportServiceStub> {
    private LogReportServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogReportServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogReportServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Recommend to report log data in a stream mode.
     * The service/instance/endpoint of the log could share the previous value if they are not set.
     * Reporting the logs of same service in the batch mode could reduce the network cost.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.logging.v3.LogData> collect(
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCollectMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Report collected logs into the OAP backend
   * </pre>
   */
  public static final class LogReportServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<LogReportServiceBlockingStub> {
    private LogReportServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogReportServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogReportServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Report collected logs into the OAP backend
   * </pre>
   */
  public static final class LogReportServiceFutureStub extends io.grpc.stub.AbstractFutureStub<LogReportServiceFutureStub> {
    private LogReportServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LogReportServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LogReportServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_COLLECT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LogReportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LogReportServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_COLLECT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.collect(
              (io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LogReportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LogReportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.apm.network.logging.v3.Logging.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LogReportService");
    }
  }

  private static final class LogReportServiceFileDescriptorSupplier
      extends LogReportServiceBaseDescriptorSupplier {
    LogReportServiceFileDescriptorSupplier() {}
  }

  private static final class LogReportServiceMethodDescriptorSupplier
      extends LogReportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LogReportServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LogReportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LogReportServiceFileDescriptorSupplier())
              .addMethod(getCollectMethod())
              .build();
        }
      }
    }
    return result;
  }
}
