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
 * Define a trace segment report service.
 * All language agents or any trace collecting component, could use this service to send span collection to the SkyWalking OAP backend.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.32.1)",
    comments = "Source: language-agent/Tracing.proto")
public final class TraceSegmentReportServiceGrpc {

  private TraceSegmentReportServiceGrpc() {}

  public static final String SERVICE_NAME = "skywalking.v3.TraceSegmentReportService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.SegmentObject,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collect",
      requestType = org.apache.skywalking.apm.network.language.agent.v3.SegmentObject.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.SegmentObject,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.SegmentObject, org.apache.skywalking.apm.network.common.v3.Commands> getCollectMethod;
    if ((getCollectMethod = TraceSegmentReportServiceGrpc.getCollectMethod) == null) {
      synchronized (TraceSegmentReportServiceGrpc.class) {
        if ((getCollectMethod = TraceSegmentReportServiceGrpc.getCollectMethod) == null) {
          TraceSegmentReportServiceGrpc.getCollectMethod = getCollectMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.language.agent.v3.SegmentObject, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "collect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.language.agent.v3.SegmentObject.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new TraceSegmentReportServiceMethodDescriptorSupplier("collect"))
              .build();
        }
      }
    }
    return getCollectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectInSyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collectInSync",
      requestType = org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection.class,
      responseType = org.apache.skywalking.apm.network.common.v3.Commands.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection,
      org.apache.skywalking.apm.network.common.v3.Commands> getCollectInSyncMethod() {
    io.grpc.MethodDescriptor<org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection, org.apache.skywalking.apm.network.common.v3.Commands> getCollectInSyncMethod;
    if ((getCollectInSyncMethod = TraceSegmentReportServiceGrpc.getCollectInSyncMethod) == null) {
      synchronized (TraceSegmentReportServiceGrpc.class) {
        if ((getCollectInSyncMethod = TraceSegmentReportServiceGrpc.getCollectInSyncMethod) == null) {
          TraceSegmentReportServiceGrpc.getCollectInSyncMethod = getCollectInSyncMethod =
              io.grpc.MethodDescriptor.<org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection, org.apache.skywalking.apm.network.common.v3.Commands>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "collectInSync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.skywalking.apm.network.common.v3.Commands.getDefaultInstance()))
              .setSchemaDescriptor(new TraceSegmentReportServiceMethodDescriptorSupplier("collectInSync"))
              .build();
        }
      }
    }
    return getCollectInSyncMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TraceSegmentReportServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TraceSegmentReportServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TraceSegmentReportServiceStub>() {
        @java.lang.Override
        public TraceSegmentReportServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TraceSegmentReportServiceStub(channel, callOptions);
        }
      };
    return TraceSegmentReportServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TraceSegmentReportServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TraceSegmentReportServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TraceSegmentReportServiceBlockingStub>() {
        @java.lang.Override
        public TraceSegmentReportServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TraceSegmentReportServiceBlockingStub(channel, callOptions);
        }
      };
    return TraceSegmentReportServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TraceSegmentReportServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TraceSegmentReportServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TraceSegmentReportServiceFutureStub>() {
        @java.lang.Override
        public TraceSegmentReportServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TraceSegmentReportServiceFutureStub(channel, callOptions);
        }
      };
    return TraceSegmentReportServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Define a trace segment report service.
   * All language agents or any trace collecting component, could use this service to send span collection to the SkyWalking OAP backend.
   * </pre>
   */
  public static abstract class TraceSegmentReportServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Recommended trace segment report channel.
     * gRPC streaming provides better performance.
     * All language agents should choose this.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.language.agent.v3.SegmentObject> collect(
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      return asyncUnimplementedStreamingCall(getCollectMethod(), responseObserver);
    }

    /**
     * <pre>
     * An alternative for trace report by using gRPC unary
     * This is provided for some 3rd-party integration, if and only if they prefer the unary mode somehow.
     * The performance of SkyWalking OAP server would be very similar with streaming report,
     * the performance of the network and client side are affected
     * </pre>
     */
    public void collectInSync(org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnimplementedUnaryCall(getCollectInSyncMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCollectMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.language.agent.v3.SegmentObject,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_COLLECT)))
          .addMethod(
            getCollectInSyncMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection,
                org.apache.skywalking.apm.network.common.v3.Commands>(
                  this, METHODID_COLLECT_IN_SYNC)))
          .build();
    }
  }

  /**
   * <pre>
   * Define a trace segment report service.
   * All language agents or any trace collecting component, could use this service to send span collection to the SkyWalking OAP backend.
   * </pre>
   */
  public static final class TraceSegmentReportServiceStub extends io.grpc.stub.AbstractAsyncStub<TraceSegmentReportServiceStub> {
    private TraceSegmentReportServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceSegmentReportServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceSegmentReportServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Recommended trace segment report channel.
     * gRPC streaming provides better performance.
     * All language agents should choose this.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.language.agent.v3.SegmentObject> collect(
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCollectMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * An alternative for trace report by using gRPC unary
     * This is provided for some 3rd-party integration, if and only if they prefer the unary mode somehow.
     * The performance of SkyWalking OAP server would be very similar with streaming report,
     * the performance of the network and client side are affected
     * </pre>
     */
    public void collectInSync(org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection request,
        io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCollectInSyncMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Define a trace segment report service.
   * All language agents or any trace collecting component, could use this service to send span collection to the SkyWalking OAP backend.
   * </pre>
   */
  public static final class TraceSegmentReportServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TraceSegmentReportServiceBlockingStub> {
    private TraceSegmentReportServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceSegmentReportServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceSegmentReportServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * An alternative for trace report by using gRPC unary
     * This is provided for some 3rd-party integration, if and only if they prefer the unary mode somehow.
     * The performance of SkyWalking OAP server would be very similar with streaming report,
     * the performance of the network and client side are affected
     * </pre>
     */
    public org.apache.skywalking.apm.network.common.v3.Commands collectInSync(org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection request) {
      return blockingUnaryCall(
          getChannel(), getCollectInSyncMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Define a trace segment report service.
   * All language agents or any trace collecting component, could use this service to send span collection to the SkyWalking OAP backend.
   * </pre>
   */
  public static final class TraceSegmentReportServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TraceSegmentReportServiceFutureStub> {
    private TraceSegmentReportServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TraceSegmentReportServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TraceSegmentReportServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * An alternative for trace report by using gRPC unary
     * This is provided for some 3rd-party integration, if and only if they prefer the unary mode somehow.
     * The performance of SkyWalking OAP server would be very similar with streaming report,
     * the performance of the network and client side are affected
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.skywalking.apm.network.common.v3.Commands> collectInSync(
        org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection request) {
      return futureUnaryCall(
          getChannel().newCall(getCollectInSyncMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COLLECT_IN_SYNC = 0;
  private static final int METHODID_COLLECT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TraceSegmentReportServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TraceSegmentReportServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COLLECT_IN_SYNC:
          serviceImpl.collectInSync((org.apache.skywalking.apm.network.language.agent.v3.SegmentCollection) request,
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
        case METHODID_COLLECT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.collect(
              (io.grpc.stub.StreamObserver<org.apache.skywalking.apm.network.common.v3.Commands>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TraceSegmentReportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TraceSegmentReportServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.skywalking.apm.network.language.agent.v3.Tracing.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TraceSegmentReportService");
    }
  }

  private static final class TraceSegmentReportServiceFileDescriptorSupplier
      extends TraceSegmentReportServiceBaseDescriptorSupplier {
    TraceSegmentReportServiceFileDescriptorSupplier() {}
  }

  private static final class TraceSegmentReportServiceMethodDescriptorSupplier
      extends TraceSegmentReportServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TraceSegmentReportServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TraceSegmentReportServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TraceSegmentReportServiceFileDescriptorSupplier())
              .addMethod(getCollectMethod())
              .addMethod(getCollectInSyncMethod())
              .build();
        }
      }
    }
    return result;
  }
}
