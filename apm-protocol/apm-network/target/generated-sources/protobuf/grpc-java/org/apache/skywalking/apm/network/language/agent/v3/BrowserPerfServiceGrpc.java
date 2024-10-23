package org.apache.skywalking.apm.network.language.agent.v3;

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
 * Collect performance raw data from browser.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: browser/BrowserPerf.proto")
public final class BrowserPerfServiceGrpc {

  private BrowserPerfServiceGrpc() {}

  public static final String SERVICE_NAME = "skywalking.v3.BrowserPerfService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectPerfDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collectPerfData",
      requestType = org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectPerfDataMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData, org.apache.skywalking.apm.network.common.v3.Commands> getCollectPerfDataMethod;
    if ((getCollectPerfDataMethod = BrowserPerfServiceGrpc.getCollectPerfDataMethod) == null) {
      synchronized (BrowserPerfServiceGrpc.class) {
        if ((getCollectPerfDataMethod = BrowserPerfServiceGrpc.getCollectPerfDataMethod) == null) {
          BrowserPerfServiceGrpc.getCollectPerfDataMethod = getCollectPerfDataMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "collectPerfData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new BrowserPerfServiceMethodDescriptorSupplier("collectPerfData"))
              .build();
        }
      }
    }
    return getCollectPerfDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.BrowserErrorLog,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectErrorLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collectErrorLogs",
      requestType = org.apache.skywalking.apm.network.language.agent.v3.BrowserErrorLog.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.BrowserErrorLog,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectErrorLogsMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.BrowserErrorLog, org.apache.skywalking.apm.network.common.v3.Commands> getCollectErrorLogsMethod;
    if ((getCollectErrorLogsMethod = BrowserPerfServiceGrpc.getCollectErrorLogsMethod) == null) {
      synchronized (BrowserPerfServiceGrpc.class) {
        if ((getCollectErrorLogsMethod = BrowserPerfServiceGrpc.getCollectErrorLogsMethod) == null) {
          BrowserPerfServiceGrpc.getCollectErrorLogsMethod = getCollectErrorLogsMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.language.agent.v3.BrowserErrorLog, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "collectErrorLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.language.agent.v3.BrowserErrorLog.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new BrowserPerfServiceMethodDescriptorSupplier("collectErrorLogs"))
              .build();
        }
      }
    }
    return getCollectErrorLogsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BrowserPerfServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BrowserPerfServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BrowserPerfServiceStub>() {
        @java.lang.Override
        public BrowserPerfServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BrowserPerfServiceStub(channel, callOptions);
        }
      };
    return BrowserPerfServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BrowserPerfServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BrowserPerfServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BrowserPerfServiceBlockingStub>() {
        @java.lang.Override
        public BrowserPerfServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BrowserPerfServiceBlockingStub(channel, callOptions);
        }
      };
    return BrowserPerfServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BrowserPerfServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BrowserPerfServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BrowserPerfServiceFutureStub>() {
        @java.lang.Override
        public BrowserPerfServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BrowserPerfServiceFutureStub(channel, callOptions);
        }
      };
    return BrowserPerfServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Collect performance raw data from browser.
   * </pre>
   */
  public static abstract class BrowserPerfServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * report once per page
     * </pre>
     */
    public void collectPerfData(org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnimplementedUnaryCall(getCollectPerfDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * report one or more error logs for pages, could report multiple times.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.language.agent.v3.BrowserErrorLog> collectErrorLogs(
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      return asyncUnimplementedStreamingCall(getCollectErrorLogsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCollectPerfDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_COLLECT_PERF_DATA)))
          .addMethod(
            getCollectErrorLogsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.language.agent.v3.BrowserErrorLog,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_COLLECT_ERROR_LOGS)))
          .build();
    }
  }

  /**
   * <pre>
   * Collect performance raw data from browser.
   * </pre>
   */
  public static final class BrowserPerfServiceStub extends io.grpc.stub.AbstractAsyncStub<BrowserPerfServiceStub> {
    private BrowserPerfServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrowserPerfServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BrowserPerfServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * report once per page
     * </pre>
     */
    public void collectPerfData(org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCollectPerfDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * report one or more error logs for pages, could report multiple times.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.language.agent.v3.BrowserErrorLog> collectErrorLogs(
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCollectErrorLogsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Collect performance raw data from browser.
   * </pre>
   */
  public static final class BrowserPerfServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<BrowserPerfServiceBlockingStub> {
    private BrowserPerfServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrowserPerfServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BrowserPerfServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * report once per page
     * </pre>
     */
    public org.apache.skywalking.apm.network.common.v3.Commands collectPerfData(org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData request) {
      return blockingUnaryCall(
          getChannel(), getCollectPerfDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Collect performance raw data from browser.
   * </pre>
   */
  public static final class BrowserPerfServiceFutureStub extends io.grpc.stub.AbstractFutureStub<BrowserPerfServiceFutureStub> {
    private BrowserPerfServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrowserPerfServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BrowserPerfServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * report once per page
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.skywalking.apm.network.common.v3.Commands> collectPerfData(
        org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData request) {
      return futureUnaryCall(
          getChannel().newCall(getCollectPerfDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COLLECT_PERF_DATA = 0;
  private static final int METHODID_COLLECT_ERROR_LOGS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BrowserPerfServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BrowserPerfServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COLLECT_PERF_DATA:
          serviceImpl.collectPerfData((org.apache.skywalking.apm.network.language.agent.v3.BrowserPerfData) request,
              (io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands>) responseObserver);
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
        case METHODID_COLLECT_ERROR_LOGS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.collectErrorLogs(
              (io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BrowserPerfServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BrowserPerfServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.apm.network.language.agent.v3.BrowserPerf.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BrowserPerfService");
    }
  }

  private static final class BrowserPerfServiceFileDescriptorSupplier
      extends BrowserPerfServiceBaseDescriptorSupplier {
    BrowserPerfServiceFileDescriptorSupplier() {}
  }

  private static final class BrowserPerfServiceMethodDescriptorSupplier
      extends BrowserPerfServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BrowserPerfServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BrowserPerfServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BrowserPerfServiceFileDescriptorSupplier())
              .addMethod(getCollectPerfDataMethod())
              .addMethod(getCollectErrorLogsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
