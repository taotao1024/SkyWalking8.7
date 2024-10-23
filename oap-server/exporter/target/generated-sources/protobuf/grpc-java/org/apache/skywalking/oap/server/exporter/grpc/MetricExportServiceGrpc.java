package org.apache.skywalking.oap.server.exporter.grpc;

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
    comments = "Source: metric-exporter.proto")
public final class MetricExportServiceGrpc {

  private MetricExportServiceGrpc() {}

  public static final String SERVICE_NAME = "MetricExportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.exporter.grpc.ExportMetricValue,
      org.apache.skywalking.oap.server.exporter.grpc.ExportResponse> getExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "export",
      requestType = org.apache.skywalking.oap.server.exporter.grpc.ExportMetricValue.class,
      responseType = org.apache.skywalking.oap.server.exporter.grpc.ExportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.exporter.grpc.ExportMetricValue,
      org.apache.skywalking.oap.server.exporter.grpc.ExportResponse> getExportMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.exporter.grpc.ExportMetricValue, org.apache.skywalking.oap.server.exporter.grpc.ExportResponse> getExportMethod;
    if ((getExportMethod = MetricExportServiceGrpc.getExportMethod) == null) {
      synchronized (MetricExportServiceGrpc.class) {
        if ((getExportMethod = MetricExportServiceGrpc.getExportMethod) == null) {
          MetricExportServiceGrpc.getExportMethod = getExportMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.oap.server.exporter.grpc.ExportMetricValue, org.apache.skywalking.oap.server.exporter.grpc.ExportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "export"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.oap.server.exporter.grpc.ExportMetricValue.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.oap.server.exporter.grpc.ExportResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MetricExportServiceMethodDescriptorSupplier("export"))
              .build();
        }
      }
    }
    return getExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq,
      org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp> getSubscriptionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscription",
      requestType = org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq.class,
      responseType = org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq,
      org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp> getSubscriptionMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq, org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp> getSubscriptionMethod;
    if ((getSubscriptionMethod = MetricExportServiceGrpc.getSubscriptionMethod) == null) {
      synchronized (MetricExportServiceGrpc.class) {
        if ((getSubscriptionMethod = MetricExportServiceGrpc.getSubscriptionMethod) == null) {
          MetricExportServiceGrpc.getSubscriptionMethod = getSubscriptionMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq, org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscription"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp.getDefaultInstance()))
              .setSchemaDescriptor(new MetricExportServiceMethodDescriptorSupplier("subscription"))
              .build();
        }
      }
    }
    return getSubscriptionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MetricExportServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricExportServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetricExportServiceStub>() {
        @java.lang.Override
        public MetricExportServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetricExportServiceStub(channel, callOptions);
        }
      };
    return MetricExportServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MetricExportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricExportServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetricExportServiceBlockingStub>() {
        @java.lang.Override
        public MetricExportServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetricExportServiceBlockingStub(channel, callOptions);
        }
      };
    return MetricExportServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MetricExportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MetricExportServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MetricExportServiceFutureStub>() {
        @java.lang.Override
        public MetricExportServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MetricExportServiceFutureStub(channel, callOptions);
        }
      };
    return MetricExportServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MetricExportServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.exporter.grpc.ExportMetricValue> export(
        io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.exporter.grpc.ExportResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getExportMethod(), responseObserver);
    }

    /**
     */
    public void subscription(org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscriptionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExportMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                org.apache.skywalking.oap.server.exporter.grpc.ExportMetricValue,
                org.apache.skywalking.oap.server.exporter.grpc.ExportResponse>(
                  this, METHODID_EXPORT)))
          .addMethod(
            getSubscriptionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq,
                org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp>(
                  this, METHODID_SUBSCRIPTION)))
          .build();
    }
  }

  /**
   */
  public static final class MetricExportServiceStub extends io.grpc.stub.AbstractAsyncStub<MetricExportServiceStub> {
    private MetricExportServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricExportServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricExportServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.exporter.grpc.ExportMetricValue> export(
        io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.exporter.grpc.ExportResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getExportMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void subscription(org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSubscriptionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MetricExportServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MetricExportServiceBlockingStub> {
    private MetricExportServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricExportServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricExportServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp subscription(org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq request) {
      return blockingUnaryCall(
          getChannel(), getSubscriptionMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MetricExportServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MetricExportServiceFutureStub> {
    private MetricExportServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MetricExportServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MetricExportServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp> subscription(
        org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq request) {
      return futureUnaryCall(
          getChannel().newCall(getSubscriptionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIPTION = 0;
  private static final int METHODID_EXPORT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MetricExportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MetricExportServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIPTION:
          serviceImpl.subscription((org.apache.skywalking.oap.server.exporter.grpc.SubscriptionReq) request,
              (io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.exporter.grpc.SubscriptionsResp>) responseObserver);
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
        case METHODID_EXPORT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.export(
              (io.grpc.stub.StreamObserver<org.apache.skywalking.oap.server.exporter.grpc.ExportResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MetricExportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MetricExportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.oap.server.exporter.grpc.MetricExporter.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MetricExportService");
    }
  }

  private static final class MetricExportServiceFileDescriptorSupplier
      extends MetricExportServiceBaseDescriptorSupplier {
    MetricExportServiceFileDescriptorSupplier() {}
  }

  private static final class MetricExportServiceMethodDescriptorSupplier
      extends MetricExportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MetricExportServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MetricExportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MetricExportServiceFileDescriptorSupplier())
              .addMethod(getExportMethod())
              .addMethod(getSubscriptionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
