package org.apache.skywalking.apm.network.management.v3;

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
 * Define the service reporting the extra information of the instance.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: management/Management.proto")
public final class ManagementServiceGrpc {

  private ManagementServiceGrpc() {}

  public static final String SERVICE_NAME = "skywalking.v3.ManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.management.v3.InstanceProperties,
      org.apache.skywalking.apm.network.common.v3.Commands> getReportInstancePropertiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "reportInstanceProperties",
      requestType = org.apache.skywalking.apm.network.management.v3.InstanceProperties.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.management.v3.InstanceProperties,
      org.apache.skywalking.apm.network.common.v3.Commands> getReportInstancePropertiesMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.management.v3.InstanceProperties, org.apache.skywalking.apm.network.common.v3.Commands> getReportInstancePropertiesMethod;
    if ((getReportInstancePropertiesMethod = ManagementServiceGrpc.getReportInstancePropertiesMethod) == null) {
      synchronized (ManagementServiceGrpc.class) {
        if ((getReportInstancePropertiesMethod = ManagementServiceGrpc.getReportInstancePropertiesMethod) == null) {
          ManagementServiceGrpc.getReportInstancePropertiesMethod = getReportInstancePropertiesMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.management.v3.InstanceProperties, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "reportInstanceProperties"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.management.v3.InstanceProperties.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new ManagementServiceMethodDescriptorSupplier("reportInstanceProperties"))
              .build();
        }
      }
    }
    return getReportInstancePropertiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.management.v3.InstancePingPkg,
      org.apache.skywalking.apm.network.common.v3.Commands> getKeepAliveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "keepAlive",
      requestType = org.apache.skywalking.apm.network.management.v3.InstancePingPkg.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.management.v3.InstancePingPkg,
      org.apache.skywalking.apm.network.common.v3.Commands> getKeepAliveMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.management.v3.InstancePingPkg, org.apache.skywalking.apm.network.common.v3.Commands> getKeepAliveMethod;
    if ((getKeepAliveMethod = ManagementServiceGrpc.getKeepAliveMethod) == null) {
      synchronized (ManagementServiceGrpc.class) {
        if ((getKeepAliveMethod = ManagementServiceGrpc.getKeepAliveMethod) == null) {
          ManagementServiceGrpc.getKeepAliveMethod = getKeepAliveMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.management.v3.InstancePingPkg, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "keepAlive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.management.v3.InstancePingPkg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new ManagementServiceMethodDescriptorSupplier("keepAlive"))
              .build();
        }
      }
    }
    return getKeepAliveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ManagementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagementServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagementServiceStub>() {
        @java.lang.Override
        public ManagementServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagementServiceStub(channel, callOptions);
        }
      };
    return ManagementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagementServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagementServiceBlockingStub>() {
        @java.lang.Override
        public ManagementServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagementServiceBlockingStub(channel, callOptions);
        }
      };
    return ManagementServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagementServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ManagementServiceFutureStub>() {
        @java.lang.Override
        public ManagementServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ManagementServiceFutureStub(channel, callOptions);
        }
      };
    return ManagementServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Define the service reporting the extra information of the instance.
   * </pre>
   */
  public static abstract class ManagementServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Report custom properties of a service instance.
     * </pre>
     */
    public void reportInstanceProperties(org.apache.skywalking.apm.network.management.v3.InstanceProperties request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnimplementedUnaryCall(getReportInstancePropertiesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Keep the instance alive in the backend analysis.
     * Only recommend to do separate keepAlive report when no trace and metrics needs to be reported.
     * Otherwise, it is duplicated.
     * </pre>
     */
    public void keepAlive(org.apache.skywalking.apm.network.management.v3.InstancePingPkg request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnimplementedUnaryCall(getKeepAliveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReportInstancePropertiesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.management.v3.InstanceProperties,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_REPORT_INSTANCE_PROPERTIES)))
          .addMethod(
            getKeepAliveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.management.v3.InstancePingPkg,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_KEEP_ALIVE)))
          .build();
    }
  }

  /**
   * <pre>
   * Define the service reporting the extra information of the instance.
   * </pre>
   */
  public static final class ManagementServiceStub extends io.grpc.stub.AbstractAsyncStub<ManagementServiceStub> {
    private ManagementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagementServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Report custom properties of a service instance.
     * </pre>
     */
    public void reportInstanceProperties(org.apache.skywalking.apm.network.management.v3.InstanceProperties request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReportInstancePropertiesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Keep the instance alive in the backend analysis.
     * Only recommend to do separate keepAlive report when no trace and metrics needs to be reported.
     * Otherwise, it is duplicated.
     * </pre>
     */
    public void keepAlive(org.apache.skywalking.apm.network.management.v3.InstancePingPkg request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getKeepAliveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Define the service reporting the extra information of the instance.
   * </pre>
   */
  public static final class ManagementServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ManagementServiceBlockingStub> {
    private ManagementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Report custom properties of a service instance.
     * </pre>
     */
    public org.apache.skywalking.apm.network.common.v3.Commands reportInstanceProperties(org.apache.skywalking.apm.network.management.v3.InstanceProperties request) {
      return blockingUnaryCall(
          getChannel(), getReportInstancePropertiesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Keep the instance alive in the backend analysis.
     * Only recommend to do separate keepAlive report when no trace and metrics needs to be reported.
     * Otherwise, it is duplicated.
     * </pre>
     */
    public org.apache.skywalking.apm.network.common.v3.Commands keepAlive(org.apache.skywalking.apm.network.management.v3.InstancePingPkg request) {
      return blockingUnaryCall(
          getChannel(), getKeepAliveMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Define the service reporting the extra information of the instance.
   * </pre>
   */
  public static final class ManagementServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ManagementServiceFutureStub> {
    private ManagementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagementServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Report custom properties of a service instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.skywalking.apm.network.common.v3.Commands> reportInstanceProperties(
        org.apache.skywalking.apm.network.management.v3.InstanceProperties request) {
      return futureUnaryCall(
          getChannel().newCall(getReportInstancePropertiesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Keep the instance alive in the backend analysis.
     * Only recommend to do separate keepAlive report when no trace and metrics needs to be reported.
     * Otherwise, it is duplicated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.skywalking.apm.network.common.v3.Commands> keepAlive(
        org.apache.skywalking.apm.network.management.v3.InstancePingPkg request) {
      return futureUnaryCall(
          getChannel().newCall(getKeepAliveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPORT_INSTANCE_PROPERTIES = 0;
  private static final int METHODID_KEEP_ALIVE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ManagementServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ManagementServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REPORT_INSTANCE_PROPERTIES:
          serviceImpl.reportInstanceProperties((org.apache.skywalking.apm.network.management.v3.InstanceProperties) request,
              (io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands>) responseObserver);
          break;
        case METHODID_KEEP_ALIVE:
          serviceImpl.keepAlive((org.apache.skywalking.apm.network.management.v3.InstancePingPkg) request,
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.apm.network.management.v3.Management.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ManagementService");
    }
  }

  private static final class ManagementServiceFileDescriptorSupplier
      extends ManagementServiceBaseDescriptorSupplier {
    ManagementServiceFileDescriptorSupplier() {}
  }

  private static final class ManagementServiceMethodDescriptorSupplier
      extends ManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ManagementServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ManagementServiceFileDescriptorSupplier())
              .addMethod(getReportInstancePropertiesMethod())
              .addMethod(getKeepAliveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
