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
 * Define the JVM metrics report service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: language-agent/JVMMetric.proto")
public final class JVMMetricReportServiceGrpc {

  private JVMMetricReportServiceGrpc() {}

  public static final String SERVICE_NAME = "skywalking.v3.JVMMetricReportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collect",
      requestType = org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection, org.apache.skywalking.apm.network.common.v3.Commands> getCollectMethod;
    if ((getCollectMethod = JVMMetricReportServiceGrpc.getCollectMethod) == null) {
      synchronized (JVMMetricReportServiceGrpc.class) {
        if ((getCollectMethod = JVMMetricReportServiceGrpc.getCollectMethod) == null) {
          JVMMetricReportServiceGrpc.getCollectMethod = getCollectMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "collect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new JVMMetricReportServiceMethodDescriptorSupplier("collect"))
              .build();
        }
      }
    }
    return getCollectMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JVMMetricReportServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JVMMetricReportServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JVMMetricReportServiceStub>() {
        @java.lang.Override
        public JVMMetricReportServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JVMMetricReportServiceStub(channel, callOptions);
        }
      };
    return JVMMetricReportServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JVMMetricReportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JVMMetricReportServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JVMMetricReportServiceBlockingStub>() {
        @java.lang.Override
        public JVMMetricReportServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JVMMetricReportServiceBlockingStub(channel, callOptions);
        }
      };
    return JVMMetricReportServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JVMMetricReportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JVMMetricReportServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JVMMetricReportServiceFutureStub>() {
        @java.lang.Override
        public JVMMetricReportServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JVMMetricReportServiceFutureStub(channel, callOptions);
        }
      };
    return JVMMetricReportServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Define the JVM metrics report service.
   * </pre>
   */
  public static abstract class JVMMetricReportServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void collect(org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnimplementedUnaryCall(getCollectMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCollectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_COLLECT)))
          .build();
    }
  }

  /**
   * <pre>
   * Define the JVM metrics report service.
   * </pre>
   */
  public static final class JVMMetricReportServiceStub extends io.grpc.stub.AbstractAsyncStub<JVMMetricReportServiceStub> {
    private JVMMetricReportServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JVMMetricReportServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JVMMetricReportServiceStub(channel, callOptions);
    }

    /**
     */
    public void collect(org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCollectMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Define the JVM metrics report service.
   * </pre>
   */
  public static final class JVMMetricReportServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<JVMMetricReportServiceBlockingStub> {
    private JVMMetricReportServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JVMMetricReportServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JVMMetricReportServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.apache.skywalking.apm.network.common.v3.Commands collect(org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection request) {
      return blockingUnaryCall(
          getChannel(), getCollectMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Define the JVM metrics report service.
   * </pre>
   */
  public static final class JVMMetricReportServiceFutureStub extends io.grpc.stub.AbstractFutureStub<JVMMetricReportServiceFutureStub> {
    private JVMMetricReportServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JVMMetricReportServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JVMMetricReportServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.skywalking.apm.network.common.v3.Commands> collect(
        org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection request) {
      return futureUnaryCall(
          getChannel().newCall(getCollectMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COLLECT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JVMMetricReportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JVMMetricReportServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COLLECT:
          serviceImpl.collect((org.apache.skywalking.apm.network.language.agent.v3.JVMMetricCollection) request,
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

  private static abstract class JVMMetricReportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JVMMetricReportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.apm.network.language.agent.v3.JVMMetricOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JVMMetricReportService");
    }
  }

  private static final class JVMMetricReportServiceFileDescriptorSupplier
      extends JVMMetricReportServiceBaseDescriptorSupplier {
    JVMMetricReportServiceFileDescriptorSupplier() {}
  }

  private static final class JVMMetricReportServiceMethodDescriptorSupplier
      extends JVMMetricReportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JVMMetricReportServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (JVMMetricReportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JVMMetricReportServiceFileDescriptorSupplier())
              .addMethod(getCollectMethod())
              .build();
        }
      }
    }
    return result;
  }
}
