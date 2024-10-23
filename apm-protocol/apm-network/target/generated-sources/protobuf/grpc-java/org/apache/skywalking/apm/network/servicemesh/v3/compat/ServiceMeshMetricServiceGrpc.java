package org.apache.skywalking.apm.network.servicemesh.v3.compat;

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
 * Define metrics report service. The metrics format is typically representing the data model collected in the service mesh case.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: service-mesh-probe/service-mesh-compat.proto")
public final class ServiceMeshMetricServiceGrpc {

  private ServiceMeshMetricServiceGrpc() {}

  public static final String SERVICE_NAME = "ServiceMeshMetricService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.servicemesh.v3.ServiceMeshMetric,
      org.apache.skywalking.apm.network.servicemesh.v3.MeshProbeDownstream> getCollectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collect",
      requestType = org.apache.skywalking.apm.network.servicemesh.v3.ServiceMeshMetric.class,
      responseType = org.apache.skywalking.apm.network.servicemesh.v3.MeshProbeDownstream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.servicemesh.v3.ServiceMeshMetric,
      org.apache.skywalking.apm.network.servicemesh.v3.MeshProbeDownstream> getCollectMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.servicemesh.v3.ServiceMeshMetric, org.apache.skywalking.apm.network.servicemesh.v3.MeshProbeDownstream> getCollectMethod;
    if ((getCollectMethod = ServiceMeshMetricServiceGrpc.getCollectMethod) == null) {
      synchronized (ServiceMeshMetricServiceGrpc.class) {
        if ((getCollectMethod = ServiceMeshMetricServiceGrpc.getCollectMethod) == null) {
          ServiceMeshMetricServiceGrpc.getCollectMethod = getCollectMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.servicemesh.v3.ServiceMeshMetric, org.apache.skywalking.apm.network.servicemesh.v3.MeshProbeDownstream>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "collect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.servicemesh.v3.ServiceMeshMetric.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.servicemesh.v3.MeshProbeDownstream.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMeshMetricServiceMethodDescriptorSupplier("collect"))
              .build();
        }
      }
    }
    return getCollectMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceMeshMetricServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceMeshMetricServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceMeshMetricServiceStub>() {
        @java.lang.Override
        public ServiceMeshMetricServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceMeshMetricServiceStub(channel, callOptions);
        }
      };
    return ServiceMeshMetricServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceMeshMetricServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceMeshMetricServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceMeshMetricServiceBlockingStub>() {
        @java.lang.Override
        public ServiceMeshMetricServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceMeshMetricServiceBlockingStub(channel, callOptions);
        }
      };
    return ServiceMeshMetricServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceMeshMetricServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceMeshMetricServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceMeshMetricServiceFutureStub>() {
        @java.lang.Override
        public ServiceMeshMetricServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceMeshMetricServiceFutureStub(channel, callOptions);
        }
      };
    return ServiceMeshMetricServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Define metrics report service. The metrics format is typically representing the data model collected in the service mesh case.
   * </pre>
   */
  public static abstract class ServiceMeshMetricServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.servicemesh.v3.ServiceMeshMetric> collect(
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.servicemesh.v3.MeshProbeDownstream> responseObserver) {
      return asyncUnimplementedStreamingCall(getCollectMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCollectMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.servicemesh.v3.ServiceMeshMetric,
                org.apache.skywalking.apm.network.servicemesh.v3.MeshProbeDownstream>(
                  this, METHODID_COLLECT)))
          .build();
    }
  }

  /**
   * <pre>
   * Define metrics report service. The metrics format is typically representing the data model collected in the service mesh case.
   * </pre>
   */
  public static final class ServiceMeshMetricServiceStub extends io.grpc.stub.AbstractAsyncStub<ServiceMeshMetricServiceStub> {
    private ServiceMeshMetricServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceMeshMetricServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceMeshMetricServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.servicemesh.v3.ServiceMeshMetric> collect(
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.servicemesh.v3.MeshProbeDownstream> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCollectMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Define metrics report service. The metrics format is typically representing the data model collected in the service mesh case.
   * </pre>
   */
  public static final class ServiceMeshMetricServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServiceMeshMetricServiceBlockingStub> {
    private ServiceMeshMetricServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceMeshMetricServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceMeshMetricServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Define metrics report service. The metrics format is typically representing the data model collected in the service mesh case.
   * </pre>
   */
  public static final class ServiceMeshMetricServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ServiceMeshMetricServiceFutureStub> {
    private ServiceMeshMetricServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceMeshMetricServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceMeshMetricServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_COLLECT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceMeshMetricServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceMeshMetricServiceImplBase serviceImpl, int methodId) {
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
              (io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.servicemesh.v3.MeshProbeDownstream>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ServiceMeshMetricServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceMeshMetricServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.apm.network.servicemesh.v3.compat.ServiceMeshCompat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceMeshMetricService");
    }
  }

  private static final class ServiceMeshMetricServiceFileDescriptorSupplier
      extends ServiceMeshMetricServiceBaseDescriptorSupplier {
    ServiceMeshMetricServiceFileDescriptorSupplier() {}
  }

  private static final class ServiceMeshMetricServiceMethodDescriptorSupplier
      extends ServiceMeshMetricServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceMeshMetricServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceMeshMetricServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceMeshMetricServiceFileDescriptorSupplier())
              .addMethod(getCollectMethod())
              .build();
        }
      }
    }
    return result;
  }
}
