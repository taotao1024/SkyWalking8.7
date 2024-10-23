package io.opencensus.proto.agent.trace.v1;

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
 * Service that can be used to push spans and configs between one Application
 * instrumented with OpenCensus and an agent, or between an agent and a
 * central collector or config service (in this case spans and configs are
 * sent/received to/from multiple Applications).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: opencensus/proto/agent/trace/v1/trace_service.proto")
public final class TraceServiceGrpc {

  private TraceServiceGrpc() {}

  public static final String SERVICE_NAME = "opencensus.proto.agent.trace.v1.TraceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.opencensus.proto.agent.trace.v1.CurrentLibraryConfig,
      io.opencensus.proto.agent.trace.v1.UpdatedLibraryConfig> getConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Config",
      requestType = io.opencensus.proto.agent.trace.v1.CurrentLibraryConfig.class,
      responseType = io.opencensus.proto.agent.trace.v1.UpdatedLibraryConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.opencensus.proto.agent.trace.v1.CurrentLibraryConfig,
      io.opencensus.proto.agent.trace.v1.UpdatedLibraryConfig> getConfigMethod() {
    io.grpc.MethodDescriptor<io.opencensus.proto.agent.trace.v1.CurrentLibraryConfig, io.opencensus.proto.agent.trace.v1.UpdatedLibraryConfig> getConfigMethod;
    if ((getConfigMethod = TraceServiceGrpc.getConfigMethod) == null) {
      synchronized (TraceServiceGrpc.class) {
        if ((getConfigMethod = TraceServiceGrpc.getConfigMethod) == null) {
          TraceServiceGrpc.getConfigMethod = getConfigMethod =
              io.grpc.MethodDescriptor.<io.opencensus.proto.agent.trace.v1.CurrentLibraryConfig, io.opencensus.proto.agent.trace.v1.UpdatedLibraryConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Config"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.opencensus.proto.agent.trace.v1.CurrentLibraryConfig.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.opencensus.proto.agent.trace.v1.UpdatedLibraryConfig.getDefaultInstance()))
              .setSchemaDescriptor(new TraceServiceMethodDescriptorSupplier("Config"))
              .build();
        }
      }
    }
    return getConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.opencensus.proto.agent.trace.v1.ExportTraceServiceRequest,
      io.opencensus.proto.agent.trace.v1.ExportTraceServiceResponse> getExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Export",
      requestType = io.opencensus.proto.agent.trace.v1.ExportTraceServiceRequest.class,
      responseType = io.opencensus.proto.agent.trace.v1.ExportTraceServiceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.opencensus.proto.agent.trace.v1.ExportTraceServiceRequest,
      io.opencensus.proto.agent.trace.v1.ExportTraceServiceResponse> getExportMethod() {
    io.grpc.MethodDescriptor<io.opencensus.proto.agent.trace.v1.ExportTraceServiceRequest, io.opencensus.proto.agent.trace.v1.ExportTraceServiceResponse> getExportMethod;
    if ((getExportMethod = TraceServiceGrpc.getExportMethod) == null) {
      synchronized (TraceServiceGrpc.class) {
        if ((getExportMethod = TraceServiceGrpc.getExportMethod) == null) {
          TraceServiceGrpc.getExportMethod = getExportMethod =
              io.grpc.MethodDescriptor.<io.opencensus.proto.agent.trace.v1.ExportTraceServiceRequest, io.opencensus.proto.agent.trace.v1.ExportTraceServiceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Export"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.opencensus.proto.agent.trace.v1.ExportTraceServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.opencensus.proto.agent.trace.v1.ExportTraceServiceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TraceServiceMethodDescriptorSupplier("Export"))
              .build();
        }
      }
    }
    return getExportMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TraceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TraceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TraceServiceStub>() {
        @java.lang.Override
        public TraceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TraceServiceStub(channel, callOptions);
        }
      };
    return TraceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TraceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TraceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TraceServiceBlockingStub>() {
        @java.lang.Override
        public TraceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TraceServiceBlockingStub(channel, callOptions);
        }
      };
    return TraceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TraceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TraceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TraceServiceFutureStub>() {
        @java.lang.Override
        public TraceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TraceServiceFutureStub(channel, callOptions);
        }
      };
    return TraceServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service that can be used to push spans and configs between one Application
   * instrumented with OpenCensus and an agent, or between an agent and a
   * central collector or config service (in this case spans and configs are
   * sent/received to/from multiple Applications).
   * </pre>
   */
  public static abstract class TraceServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * After initialization, this RPC must be kept alive for the entire life of
     * the application. The agent pushes configs down to applications via a
     * stream.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.opencensus.proto.agent.trace.v1.CurrentLibraryConfig> config(
        io.grpc.stub.StreamObserver<io.opencensus.proto.agent.trace.v1.UpdatedLibraryConfig> responseObserver) {
      return asyncUnimplementedStreamingCall(getConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * For performance reasons, it is recommended to keep this RPC
     * alive for the entire life of the application.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.opencensus.proto.agent.trace.v1.ExportTraceServiceRequest> export(
        io.grpc.stub.StreamObserver<io.opencensus.proto.agent.trace.v1.ExportTraceServiceResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getExportMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getConfigMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.opencensus.proto.agent.trace.v1.CurrentLibraryConfig,
                io.opencensus.proto.agent.trace.v1.UpdatedLibraryConfig>(
                  this, METHODID_CONFIG)))
          .addMethod(
            getExportMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                io.opencensus.proto.agent.trace.v1.ExportTraceServiceRequest,
                io.opencensus.proto.agent.trace.v1.ExportTraceServiceResponse>(
                  this, METHODID_EXPORT)))
          .build();
    }
  }

  /**
   * <pre>
   * Service that can be used to push spans and configs between one Application
   * instrumented with OpenCensus and an agent, or between an agent and a
   * central collector or config service (in this case spans and configs are
   * sent/received to/from multiple Applications).
   * </pre>
   */
  public static final class TraceServiceStub extends io.grpc.stub.AbstractAsyncStub<TraceServiceStub> {
    private TraceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * After initialization, this RPC must be kept alive for the entire life of
     * the application. The agent pushes configs down to applications via a
     * stream.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.opencensus.proto.agent.trace.v1.CurrentLibraryConfig> config(
        io.grpc.stub.StreamObserver<io.opencensus.proto.agent.trace.v1.UpdatedLibraryConfig> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getConfigMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * For performance reasons, it is recommended to keep this RPC
     * alive for the entire life of the application.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.opencensus.proto.agent.trace.v1.ExportTraceServiceRequest> export(
        io.grpc.stub.StreamObserver<io.opencensus.proto.agent.trace.v1.ExportTraceServiceResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getExportMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service that can be used to push spans and configs between one Application
   * instrumented with OpenCensus and an agent, or between an agent and a
   * central collector or config service (in this case spans and configs are
   * sent/received to/from multiple Applications).
   * </pre>
   */
  public static final class TraceServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TraceServiceBlockingStub> {
    private TraceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Service that can be used to push spans and configs between one Application
   * instrumented with OpenCensus and an agent, or between an agent and a
   * central collector or config service (in this case spans and configs are
   * sent/received to/from multiple Applications).
   * </pre>
   */
  public static final class TraceServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TraceServiceFutureStub> {
    private TraceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CONFIG = 0;
  private static final int METHODID_EXPORT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TraceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TraceServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_CONFIG:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.config(
              (io.grpc.stub.StreamObserver<io.opencensus.proto.agent.trace.v1.UpdatedLibraryConfig>) responseObserver);
        case METHODID_EXPORT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.export(
              (io.grpc.stub.StreamObserver<io.opencensus.proto.agent.trace.v1.ExportTraceServiceResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TraceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TraceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.opencensus.proto.agent.trace.v1.TraceServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TraceService");
    }
  }

  private static final class TraceServiceFileDescriptorSupplier
      extends TraceServiceBaseDescriptorSupplier {
    TraceServiceFileDescriptorSupplier() {}
  }

  private static final class TraceServiceMethodDescriptorSupplier
      extends TraceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TraceServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TraceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TraceServiceFileDescriptorSupplier())
              .addMethod(getConfigMethod())
              .addMethod(getExportMethod())
              .build();
        }
      }
    }
    return result;
  }
}
