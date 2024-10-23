package io.envoyproxy.envoy.service.metrics.v2;

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
 * Service for streaming metrics to server that consumes the metrics data. It uses Prometheus metric
 * data model as a standard to represent metrics information.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: envoy/service/metrics/v2/metrics_service.proto")
public final class MetricsServiceGrpc {

  private MetricsServiceGrpc() {}

  public static final String SERVICE_NAME = "envoy.service.metrics.v2.MetricsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.envoyproxy.envoy.service.metrics.v3.StreamMetricsMessage,
      io.envoyproxy.envoy.service.metrics.v3.StreamMetricsResponse> getStreamMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamMetrics",
      requestType = io.envoyproxy.envoy.service.metrics.v3.StreamMetricsMessage.class,
      responseType = io.envoyproxy.envoy.service.metrics.v3.StreamMetricsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<io.envoyproxy.envoy.service.metrics.v3.StreamMetricsMessage,
      io.envoyproxy.envoy.service.metrics.v3.StreamMetricsResponse> getStreamMetricsMethod() {
    io.grpc.MethodDescriptor<io.envoyproxy.envoy.service.metrics.v3.StreamMetricsMessage, io.envoyproxy.envoy.service.metrics.v3.StreamMetricsResponse> getStreamMetricsMethod;
    if ((getStreamMetricsMethod = MetricsServiceGrpc.getStreamMetricsMethod) == null) {
      synchronized (MetricsServiceGrpc.class) {
        if ((getStreamMetricsMethod = MetricsServiceGrpc.getStreamMetricsMethod) == null) {
          MetricsServiceGrpc.getStreamMetricsMethod = getStreamMetricsMethod =
              io.grpc.MethodDescriptor.<io.envoyproxy.envoy.service.metrics.v3.StreamMetricsMessage, io.envoyproxy.envoy.service.metrics.v3.StreamMetricsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamMetrics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.envoyproxy.envoy.service.metrics.v3.StreamMetricsMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.envoyproxy.envoy.service.metrics.v3.StreamMetricsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MetricsServiceMethodDescriptorSupplier("StreamMetrics"))
              .build();
        }
      }
    }
    return getStreamMetricsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MetricsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetricsServiceStub>() {
        @java.lang.Override
        public MetricsServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetricsServiceStub(channel, callOptions);
        }
      };
    return MetricsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MetricsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetricsServiceBlockingStub>() {
        @java.lang.Override
        public MetricsServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetricsServiceBlockingStub(channel, callOptions);
        }
      };
    return MetricsServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MetricsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricsServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetricsServiceFutureStub>() {
        @java.lang.Override
        public MetricsServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetricsServiceFutureStub(channel, callOptions);
        }
      };
    return MetricsServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Service for streaming metrics to server that consumes the metrics data. It uses Prometheus metric
   * data model as a standard to represent metrics information.
   * </pre>
   */
  public static abstract class MetricsServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * In order to simultaneously support Envoy MetricsService V2 and V3 without duplicating too many codes,
     * we combine the V2 service definition and V3 message protobuf and delegate the V2 service handler to V3,
     * this is only feasible when the message protobuf of V3 is compatible with V2 (i.e. backward compatibility).
     * For more about MetricsService, read envoy/service/metrics/v3/metrics_service.proto
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.envoyproxy.envoy.service.metrics.v3.StreamMetricsMessage> streamMetrics(
        io.grpc.stub.StreamObserver<io.envoyproxy.envoy.service.metrics.v3.StreamMetricsResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getStreamMetricsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamMetricsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                io.envoyproxy.envoy.service.metrics.v3.StreamMetricsMessage,
                io.envoyproxy.envoy.service.metrics.v3.StreamMetricsResponse>(
                  this, METHODID_STREAM_METRICS)))
          .build();
    }
  }

  /**
   * <pre>
   * Service for streaming metrics to server that consumes the metrics data. It uses Prometheus metric
   * data model as a standard to represent metrics information.
   * </pre>
   */
  public static final class MetricsServiceStub extends io.grpc.stub.AbstractAsyncStub<MetricsServiceStub> {
    private MetricsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * In order to simultaneously support Envoy MetricsService V2 and V3 without duplicating too many codes,
     * we combine the V2 service definition and V3 message protobuf and delegate the V2 service handler to V3,
     * this is only feasible when the message protobuf of V3 is compatible with V2 (i.e. backward compatibility).
     * For more about MetricsService, read envoy/service/metrics/v3/metrics_service.proto
     * </pre>
     */
    public io.grpc.stub.StreamObserver<io.envoyproxy.envoy.service.metrics.v3.StreamMetricsMessage> streamMetrics(
        io.grpc.stub.StreamObserver<io.envoyproxy.envoy.service.metrics.v3.StreamMetricsResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getStreamMetricsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service for streaming metrics to server that consumes the metrics data. It uses Prometheus metric
   * data model as a standard to represent metrics information.
   * </pre>
   */
  public static final class MetricsServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MetricsServiceBlockingStub> {
    private MetricsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Service for streaming metrics to server that consumes the metrics data. It uses Prometheus metric
   * data model as a standard to represent metrics information.
   * </pre>
   */
  public static final class MetricsServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MetricsServiceFutureStub> {
    private MetricsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricsServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_METRICS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MetricsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MetricsServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_STREAM_METRICS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamMetrics(
              (io.grpc.stub.StreamObserver<io.envoyproxy.envoy.service.metrics.v3.StreamMetricsResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MetricsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MetricsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.envoyproxy.envoy.service.metrics.v2.MetricsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MetricsService");
    }
  }

  private static final class MetricsServiceFileDescriptorSupplier
      extends MetricsServiceBaseDescriptorSupplier {
    MetricsServiceFileDescriptorSupplier() {}
  }

  private static final class MetricsServiceMethodDescriptorSupplier
      extends MetricsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MetricsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MetricsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MetricsServiceFileDescriptorSupplier())
              .addMethod(getStreamMetricsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
